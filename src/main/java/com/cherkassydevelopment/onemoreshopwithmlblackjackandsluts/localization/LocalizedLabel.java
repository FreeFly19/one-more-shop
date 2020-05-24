package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class LocalizedLabel {
    @Id
    @GeneratedValue
    private Long id;
    private Language lang;
    private String label;
}
