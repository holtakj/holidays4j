package com.holtak.holidays4j.provider.country;

import com.holtak.holidays4j.model.Country;
import com.holtak.holidays4j.provider.CatholicProvider;
import com.holtak.holidays4j.provider.HolidayProvider;
import com.holtak.holidays4j.provider.Translation;

public class Austria extends AbstractCountryProvider {

    private static final CatholicProvider catholicProvider = new CatholicProvider();

    @Override
    Country country() {
        return Country.AUSTRIA;
    }

    @Override
    HolidayProvider[] providers() {
        return new HolidayProvider[]{
                catholicProvider
        };
    }

    Translation[] translations() {
        return new Translation[]{
                new Translation(CatholicProvider.Id.CHRISTMAS_DAY, "Weihnachten"),
                new Translation(CatholicProvider.Id.EASTER_MONDAY, "Ostermontag")
        };
    }

}
