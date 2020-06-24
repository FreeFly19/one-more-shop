package com.cd.shop.image;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.Md5Utils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final AmazonS3 s3;
    private final String s3BucketName;

    public ImageService(ImageRepository imageRepository,
                        @Value("${S3_BUCKET:not_defined}") String s3Bucket,
                        @Value("${S3_ACCESS_KEY:not_defined}") String s3AccessKey,
                        @Value("${S3_SECRET_KEY:not_defined}") String s3SecretKey,
                        @Value("${S3_ENDPOINT:not_defined}") String s3Endpoint,
                        @Value("${S3_REGION:not_defined}") String s3Region
    ) {
        this.imageRepository = imageRepository;
        this.s3BucketName = s3Bucket;
        AWSCredentialsProvider doCred = new AWSStaticCredentialsProvider(new BasicAWSCredentials(s3AccessKey, s3SecretKey));
        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(doCred)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(s3Endpoint, s3Region))
                .build();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Image save(String base64data, String ext, String alt) {
        byte[] byteimage = Base64.getDecoder().decode(base64data);
        String imageHash = MD5Encoder.encode(Md5Utils.computeMD5Hash(byteimage));

        Optional<Image> imageByHash = imageRepository.findByHash(imageHash);
        if (imageByHash.isPresent()) {
            return imageByHash.get();
        }

        String fileName = "kupec/images/" + imageHash + "." + ext;
        URL fileUrl = s3.getUrl(s3BucketName, fileName);

        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) fileUrl.openConnection();
            if (httpURLConnection.getResponseCode() >= 400) {
                InputStream is = new ByteArrayInputStream(byteimage);
                ObjectMetadata om = new ObjectMetadata();
                om.setContentLength(byteimage.length);
                om.setContentType(Files.probeContentType(new File(fileName).toPath()));
                PutObjectRequest putObjectRequest = new PutObjectRequest(s3BucketName, fileName, is, om)
                        .withCannedAcl(CannedAccessControlList.PublicRead);

                s3.putObject(putObjectRequest);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception ignore) { }
            }
        }

        Image image = new Image();
        image.setAlt(alt);
        image.setPublicUrl(fileUrl.toString());
        image.setHash(imageHash);
        image.setCreatedAt(Instant.now());
        imageRepository.save(image);

        return image;
    }
}
