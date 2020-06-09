package com.cd.shop.localization;

import lombok.Getter;

@Getter
public class LocalizedLabelOutputDto {
    private final long id;
    private final Language lang;
    private final String label;

    public LocalizedLabelOutputDto(LocalizedLabel ll) {
        this.id = ll.getId();
        this.lang = ll.getLang();
        this.label = ll.getLabel();
    }
}
