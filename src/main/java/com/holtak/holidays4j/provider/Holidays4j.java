package com.holtak.holidays4j.provider;

import com.holtak.holidays4j.exception.Holiday4jException;
import com.holtak.holidays4j.model.Country;
import com.holtak.holidays4j.model.Holiday;
import com.holtak.holidays4j.provider.country.Austria;
import lombok.val;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Holidays4j {

    public static Country[] supportedCountries() {
        return Country.values();
    }

    public static Country locateCountry(String twoLetterIsoCode) {
        return Stream.of(supportedCountries()).filter(country -> country.getTwoLetterIsoCode().equals(twoLetterIsoCode))
                .findAny()
                .orElse(null);
    }

    public static Country locateCountryChecked(String twoLetterIsoCode) throws Holiday4jException {
        val country = locateCountry(twoLetterIsoCode);
        if (country == null) {
            throw new Holiday4jException("Country code " + twoLetterIsoCode + " was not recognized!");
        } else {
            return country;
        }
    }

    public static List<Holiday> holidayInfo(int year, Country country) {
        //noinspection SwitchStatementWithTooFewBranches
        switch (country) {
            case AUSTRIA:
                return new Austria().holidays(year);
            default:
                return Collections.emptyList();
        }
    }

}
