package com.cd.shop.localization;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LocalizedLabelService {
    private final LocalizedLabelRepository localizedLabelRepository;

    @Transactional(propagation = Propagation.MANDATORY)
    public Set<LocalizedLabel> saveLabelsTransactional(Set<LocalizedLabelInputDto> labelInputDtos) {
        return labelInputDtos.stream()
                .map(dto -> {
                    var ll = new LocalizedLabel();
                    ll.setLang(dto.getLang());
                    ll.setLabel(dto.getLabel());
                    return localizedLabelRepository.save(ll);
                })
                .collect(Collectors.toSet());
    }
}
