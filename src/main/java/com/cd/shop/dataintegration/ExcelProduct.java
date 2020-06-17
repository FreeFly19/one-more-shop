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
    private String category2;
}
