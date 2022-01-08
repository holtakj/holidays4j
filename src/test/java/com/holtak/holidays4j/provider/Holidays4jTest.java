package com.holtak.holidays4j.provider;

import com.holtak.holidays4j.Holidays4j;
import com.holtak.holidays4j.exception.Holiday4jException;
import com.holtak.holidays4j.model.Country;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Holidays4jTest {

    @Test
    void supportedCountries() {
        val actual = Holidays4j.supportedCountries();
        assertEquals(1, actual.length, "not all exposed countries are exposed by the api");
    }

    @Test
    void locateCountry_AUSTRIA() {
        val actual = Holidays4j.locateCountry("AT");
        assertEquals(Country.AUSTRIA, actual);
    }

    @Test
    void locateCountry_TRAMTARIA() {
        val actual = Holidays4j.locateCountry("!!");
        assertNull(actual);
    }

    @Test
    void locateCountryChecked_AUSTRIA() throws Holiday4jException {
        val actual = Holidays4j.locateCountryChecked("AT");
        assertEquals(Country.AUSTRIA, actual);
    }

    @Test
    void locateCountryChecked_TRAMTARIA() throws Holiday4jException {
        val thrown = assertThrows(Holiday4jException.class, () -> {
            Holidays4j.locateCountryChecked("!!");
        });
        assertEquals("Country code !! was not recognized!", thrown.getMessage());
    }

}