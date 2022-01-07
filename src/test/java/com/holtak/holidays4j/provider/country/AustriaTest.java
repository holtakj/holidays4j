package com.holtak.holidays4j.provider.country;

import lombok.val;
import org.junit.jupiter.api.Test;

class AustriaTest {

    private Austria INSTANCE = new Austria();

    @Test
    void bla() {
        val actual = INSTANCE.holidays(2022);
        actual.forEach(System.out::println);
    }

}