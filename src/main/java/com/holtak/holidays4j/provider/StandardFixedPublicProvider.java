package com.holtak.holidays4j.provider;

import com.holtak.holidays4j.logic.AbstractProvider;
import com.holtak.holidays4j.model.Holiday;
import com.holtak.holidays4j.model.HolidayIdEnum;
import lombok.val;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.holtak.holidays4j.model.StandardHolidayType.PUBLIC;

public class StandardFixedPublicProvider extends AbstractProvider<StandardFixedPublicProvider> {

    protected Function<? super Integer, ? extends List<Holiday>> compute_holidays() {
        return (year) -> {
            val newYear = new Holiday()
                    .id(Id.NEW_YEAR)
                    .name("New Year's Day")
                    .date(LocalDate.of(year, Month.JANUARY, 1))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC));

            return Arrays.asList(
                    newYear
            );
        };
    }


    public enum Id implements HolidayIdEnum {
        NEW_YEAR
    }
}
