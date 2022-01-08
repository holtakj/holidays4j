package com.holtak.holidays4j.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Country implements Holiday4jCountry {

    AUSTRIA("Austria", "AT", "Österreich");

    private String name;
    private String twoLetterIsoCode;
    private String localizedName;

}
