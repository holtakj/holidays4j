package com.holtak.holidays4j.provider.country;

import com.holtak.holidays4j.logic.AbstractCountryProvider;
import com.holtak.holidays4j.model.*;
import com.holtak.holidays4j.provider.CatholicProvider;
import com.holtak.holidays4j.provider.StandardFixedPublicProvider;
import lombok.val;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static com.holtak.holidays4j.model.StandardHolidayType.NATIONAL;
import static com.holtak.holidays4j.model.StandardHolidayType.PUBLIC;

public class Austria extends AbstractCountryProvider {

    public enum Id implements HolidayIdEnum {
        NATIONAL_FEIERTAG,
    }

    @Override
    protected Country country() {
        return Country.AUSTRIA;
    }

    @Override
    protected HolidayProvider[] providers() {
        return new HolidayProvider[]{
                new CatholicProvider().whitelist(
                        CatholicProvider.Id.EASTER_MONDAY,
                        CatholicProvider.Id.CHRISTMAS_DAY,
                        CatholicProvider.Id.WHIT_MONDAY,
                        CatholicProvider.Id.ASCENSION_DAY
                ),
                new StandardFixedPublicProvider().whitelist(
                        StandardFixedPublicProvider.Id.NEW_YEAR
                )
        };
    }

    @Override
    protected List<Holiday> countryHolidays(int year) {
        val resultList = new ArrayList<Holiday>();

        val nationalFeiertag = new Holiday()
                .id(Id.NATIONAL_FEIERTAG)
                .name("National Holiday")
                .localizedName("Staatsfeiertag")
                .date(LocalDate.of(year, Month.MAY, 1))
                .global(true)
                .fixed(true)
                .types(createSet(PUBLIC, NATIONAL));

        resultList.add(nationalFeiertag);
        return resultList;
    }

    @Override
    protected Translation[] translations() {
        return new Translation[]{
                new Translation(CatholicProvider.Id.CHRISTMAS_DAY, "Weihnachten"),
                new Translation(CatholicProvider.Id.EASTER_MONDAY, "Ostermontag"),
                new Translation(CatholicProvider.Id.ASCENSION_DAY, "Christi Himmelfahrt"),
                new Translation(CatholicProvider.Id.WHIT_MONDAY, "Pfingstmontag"),
                new Translation(StandardFixedPublicProvider.Id.NEW_YEAR, "Neujahr")
        };
    }

    @Override
    protected SinceYear[] sinceYears() {
        return new SinceYear[]{
                new SinceYear(StandardFixedPublicProvider.Id.NEW_YEAR, 1967)
        };
    }

    @Override
    protected HolidayTypeMap[] holidayTypes() {
        return null;
    }

}
