package com.cd.shop.localization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LocalizedLabelInputDto {
    private Language lang;
    private String label;
}
