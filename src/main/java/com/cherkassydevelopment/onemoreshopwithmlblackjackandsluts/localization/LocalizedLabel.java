package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LocalizedLabel {
    @Id
    @GeneratedValue
    private Long id;
    private String langCode;
    private String label;
}
