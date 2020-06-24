package com.cd.shop.dataintegration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Setter
@Getter
@ToString
public class ExcelProduct {
    private String name;
    private long productCode;
    private BigDecimal priceUah;
    private BigDecimal priceUsd;
    private String category1;
    private Long category1Id;
    private String category2;
    private Long category2Id;
    private String imageData;
    private String imageExt;
}
