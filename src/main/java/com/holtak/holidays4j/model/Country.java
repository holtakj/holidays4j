package com.holtak.holidays4j.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Country {

    AUSTRIA("AT");

    private String twoLetterIsoCode;

}
