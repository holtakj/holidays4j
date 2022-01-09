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
                        CatholicProvider.Id.CORPUS_CHRISTI,
                        CatholicProvider.Id.ASCENSION_DAY,
                        CatholicProvider.Id.ALL_SAINT_DAY,
                        CatholicProvider.Id.ASSUMPTION_DAY,
                        CatholicProvider.Id.IMMACULATE_CONCEPTION,
                        CatholicProvider.Id.ST_STEPHANS_DAY,
                        CatholicProvider.Id.EPIPHANY
                ),
                new StandardFixedPublicProvider().whitelist(
                        StandardFixedPublicProvider.Id.NEW_YEAR
                )
        };
    }

    @Override
    protected List<Holiday> countryHolidays(int year) {
        val resultList = new ArrayList<Holiday>();

        resultList.add(new Holiday()
                .id(Id.STAATSFEIERTAG)
                .name("National Holiday")
                .localizedName("Staatsfeiertag")
                .date(LocalDate.of(year, Month.MAY, 1))
                .global(true)
                .fixed(true)
                .types(createSet(PUBLIC, NATIONAL))
        );

        resultList.add(new Holiday()
                .id(Id.NATIONALFEIRTAG)
                .name("National Holiday")
                .localizedName("Nationalfeiertag")
                .date(LocalDate.of(year, Month.OCTOBER, 26))
                .global(true)
                .fixed(true)
                .types(createSet(PUBLIC, NATIONAL))
        );

        return resultList;
    }

    @Override
    protected Translation[] translations() {
        return new Translation[]{
                new Translation(CatholicProvider.Id.CHRISTMAS_DAY, "Weihnachten"),
                new Translation(CatholicProvider.Id.ST_STEPHANS_DAY, "Stefanitag"),
                new Translation(CatholicProvider.Id.EASTER_MONDAY, "Ostermontag"),
                new Translation(CatholicProvider.Id.ASCENSION_DAY, "Christi Himmelfahrt"),
                new Translation(CatholicProvider.Id.WHIT_MONDAY, "Pfingstmontag"),
                new Translation(CatholicProvider.Id.CORPUS_CHRISTI, "Fronleichnam"),
                new Translation(CatholicProvider.Id.ALL_SAINT_DAY, "Allerheiligen"),
                new Translation(CatholicProvider.Id.ASSUMPTION_DAY, "Maria Himmelfahrt"),
                new Translation(CatholicProvider.Id.IMMACULATE_CONCEPTION, "Mariä Empfängnis"),
                new Translation(CatholicProvider.Id.EPIPHANY, "Heilige Drei Könige"),
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

    public enum Id implements HolidayIdEnum {
        STAATSFEIERTAG,
        NATIONALFEIRTAG,
    }

}
