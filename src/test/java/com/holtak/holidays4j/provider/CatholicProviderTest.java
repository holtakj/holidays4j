package com.holtak.holidays4j.provider;

import com.holtak.holidays4j.testmodel.YearAndLocalDate;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatholicProviderTest {

    @SuppressWarnings("unused")
    static Stream<YearAndLocalDate> easterSundayParametrized() {
        return Stream.of(
                new YearAndLocalDate(2002, LocalDate.of(2002, Month.MARCH, 31)),
                new YearAndLocalDate(2003, LocalDate.of(2003, Month.APRIL, 20)),
                new YearAndLocalDate(2004, LocalDate.of(2004, Month.APRIL, 11)),
                new YearAndLocalDate(2005, LocalDate.of(2005, Month.MARCH, 27)),
                new YearAndLocalDate(2006, LocalDate.of(2006, Month.APRIL, 16)),
                new YearAndLocalDate(2007, LocalDate.of(2007, Month.APRIL, 8)),
                new YearAndLocalDate(2008, LocalDate.of(2008, Month.MARCH, 23)),
                new YearAndLocalDate(2009, LocalDate.of(2009, Month.APRIL, 12)),
                new YearAndLocalDate(2010, LocalDate.of(2010, Month.APRIL, 4)),
                new YearAndLocalDate(2011, LocalDate.of(2011, Month.APRIL, 24)),
                new YearAndLocalDate(2012, LocalDate.of(2012, Month.APRIL, 8)),
                new YearAndLocalDate(2013, LocalDate.of(2013, Month.MARCH, 31)),
                new YearAndLocalDate(2014, LocalDate.of(2014, Month.APRIL, 20)),
                new YearAndLocalDate(2015, LocalDate.of(2015, Month.APRIL, 5)),
                new YearAndLocalDate(2016, LocalDate.of(2016, Month.MARCH, 27)),
                new YearAndLocalDate(2017, LocalDate.of(2017, Month.APRIL, 16)),
                new YearAndLocalDate(2018, LocalDate.of(2018, Month.APRIL, 1)),
                new YearAndLocalDate(2019, LocalDate.of(2019, Month.APRIL, 21)),
                new YearAndLocalDate(2020, LocalDate.of(2020, Month.APRIL, 12)),
                new YearAndLocalDate(2021, LocalDate.of(2021, Month.APRIL, 4)),
                new YearAndLocalDate(2022, LocalDate.of(2022, Month.APRIL, 17)),
                new YearAndLocalDate(2023, LocalDate.of(2023, Month.APRIL, 9)),
                new YearAndLocalDate(2024, LocalDate.of(2024, Month.MARCH, 31)),
                new YearAndLocalDate(2025, LocalDate.of(2025, Month.APRIL, 20)),
                new YearAndLocalDate(2026, LocalDate.of(2026, Month.APRIL, 5)),
                new YearAndLocalDate(2027, LocalDate.of(2027, Month.MARCH, 28)),
                new YearAndLocalDate(2028, LocalDate.of(2028, Month.APRIL, 16)),
                new YearAndLocalDate(2029, LocalDate.of(2029, Month.APRIL, 1)),
                new YearAndLocalDate(2030, LocalDate.of(2030, Month.APRIL, 21)),
                new YearAndLocalDate(2031, LocalDate.of(2031, Month.APRIL, 13)),
                new YearAndLocalDate(2032, LocalDate.of(2032, Month.MARCH, 28)),
                new YearAndLocalDate(2033, LocalDate.of(2033, Month.APRIL, 17)),
                new YearAndLocalDate(2034, LocalDate.of(2034, Month.APRIL, 9)),
                new YearAndLocalDate(2035, LocalDate.of(2035, Month.MARCH, 25)),
                new YearAndLocalDate(2036, LocalDate.of(2036, Month.APRIL, 13)),
                new YearAndLocalDate(2037, LocalDate.of(2037, Month.APRIL, 5)),
                new YearAndLocalDate(2038, LocalDate.of(2038, Month.APRIL, 25)),
                new YearAndLocalDate(2039, LocalDate.of(2039, Month.APRIL, 10)),
                new YearAndLocalDate(2040, LocalDate.of(2040, Month.APRIL, 1)),
                new YearAndLocalDate(2041, LocalDate.of(2041, Month.APRIL, 21)),
                new YearAndLocalDate(2042, LocalDate.of(2042, Month.APRIL, 6))
        );
    }

    @SuppressWarnings("unused")
    static Stream<YearAndLocalDate> easterMondayParametrized() {
        return Stream.of(
                new YearAndLocalDate(2002, LocalDate.of(2002, Month.APRIL, 1)),
                new YearAndLocalDate(2003, LocalDate.of(2003, Month.APRIL, 21)),
                new YearAndLocalDate(2004, LocalDate.of(2004, Month.APRIL, 12)),
                new YearAndLocalDate(2005, LocalDate.of(2005, Month.MARCH, 28)),
                new YearAndLocalDate(2006, LocalDate.of(2006, Month.APRIL, 17)),
                new YearAndLocalDate(2007, LocalDate.of(2007, Month.APRIL, 9)),
                new YearAndLocalDate(2008, LocalDate.of(2008, Month.MARCH, 24)),
                new YearAndLocalDate(2009, LocalDate.of(2009, Month.APRIL, 13)),
                new YearAndLocalDate(2010, LocalDate.of(2010, Month.APRIL, 5)),
                new YearAndLocalDate(2011, LocalDate.of(2011, Month.APRIL, 25)),
                new YearAndLocalDate(2012, LocalDate.of(2012, Month.APRIL, 9)),
                new YearAndLocalDate(2013, LocalDate.of(2013, Month.APRIL, 1)),
                new YearAndLocalDate(2014, LocalDate.of(2014, Month.APRIL, 21)),
                new YearAndLocalDate(2015, LocalDate.of(2015, Month.APRIL, 6)),
                new YearAndLocalDate(2016, LocalDate.of(2016, Month.MARCH, 28)),
                new YearAndLocalDate(2017, LocalDate.of(2017, Month.APRIL, 17)),
                new YearAndLocalDate(2018, LocalDate.of(2018, Month.APRIL, 2)),
                new YearAndLocalDate(2019, LocalDate.of(2019, Month.APRIL, 22)),
                new YearAndLocalDate(2020, LocalDate.of(2020, Month.APRIL, 13)),
                new YearAndLocalDate(2021, LocalDate.of(2021, Month.APRIL, 5)),
                new YearAndLocalDate(2022, LocalDate.of(2022, Month.APRIL, 18)),
                new YearAndLocalDate(2023, LocalDate.of(2023, Month.APRIL, 10)),
                new YearAndLocalDate(2024, LocalDate.of(2024, Month.APRIL, 1)),
                new YearAndLocalDate(2025, LocalDate.of(2025, Month.APRIL, 21)),
                new YearAndLocalDate(2026, LocalDate.of(2026, Month.APRIL, 6)),
                new YearAndLocalDate(2027, LocalDate.of(2027, Month.MARCH, 29)),
                new YearAndLocalDate(2028, LocalDate.of(2028, Month.APRIL, 17)),
                new YearAndLocalDate(2029, LocalDate.of(2029, Month.APRIL, 2)),
                new YearAndLocalDate(2030, LocalDate.of(2030, Month.APRIL, 22)),
                new YearAndLocalDate(2031, LocalDate.of(2031, Month.APRIL, 14)),
                new YearAndLocalDate(2032, LocalDate.of(2032, Month.MARCH, 29)),
                new YearAndLocalDate(2033, LocalDate.of(2033, Month.APRIL, 18)),
                new YearAndLocalDate(2034, LocalDate.of(2034, Month.APRIL, 10)),
                new YearAndLocalDate(2035, LocalDate.of(2035, Month.MARCH, 26)),
                new YearAndLocalDate(2036, LocalDate.of(2036, Month.APRIL, 14)),
                new YearAndLocalDate(2037, LocalDate.of(2037, Month.APRIL, 6)),
                new YearAndLocalDate(2038, LocalDate.of(2038, Month.APRIL, 26)),
                new YearAndLocalDate(2039, LocalDate.of(2039, Month.APRIL, 11)),
                new YearAndLocalDate(2040, LocalDate.of(2040, Month.APRIL, 2)),
                new YearAndLocalDate(2041, LocalDate.of(2041, Month.APRIL, 22)),
                new YearAndLocalDate(2042, LocalDate.of(2042, Month.APRIL, 7))
        );
    }

    @Test
    void easterSundayOf2022() {
        val expected = LocalDate.of(2022, Month.APRIL, 17);
        val actual = CatholicProvider.easterSunday(2022);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "easterSunday {0}")
    @MethodSource("easterSundayParametrized")
    void easterSundayParametrized(YearAndLocalDate yearAndLocalDate) {
        val actual = CatholicProvider.easterSunday(yearAndLocalDate.getYear());
        assertEquals(yearAndLocalDate.getExpected(), actual);
    }

    @ParameterizedTest(name = "easterSunday {0}")
    @MethodSource("easterMondayParametrized")
    void easterMondayParametrized(YearAndLocalDate yearAndLocalDate) {
        val actual = CatholicProvider.easterMonday(yearAndLocalDate.getYear());
        assertEquals(yearAndLocalDate.getExpected(), actual);
    }


}