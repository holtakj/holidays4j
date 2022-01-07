package com.holtak.holidays4j.model;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryTest {

    @Test
    void allTwoLeterIsoCodesAreUnique() {
        val filteredCount = Arrays.stream(Country.values()).map(Country::getTwoLetterIsoCode).distinct().count();
        assertEquals(Country.values().length, filteredCount);
    }

}