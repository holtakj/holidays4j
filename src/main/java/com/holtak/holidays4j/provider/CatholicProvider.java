package com.holtak.holidays4j.provider;

import java.time.LocalDate;

public class CatholicProvider {

    public static LocalDate easterSunday(int year) {
        int month;
        int dayOfMonth;

        int yearMod19 = year % 19;
        int century = year / 100;
        int h = (century - (century / 4) - ((8 * century + 13) / 25)
                + 19 * yearMod19 + 15) % 30;
        int i = h - (h / 28) * (1 - (h / 28) *
                (29 / (h + 1)) * ((21 - yearMod19) / 11));

        dayOfMonth   = i - ((year + (year / 4) +
                i + 2 - century + (century / 4)) % 7) + 28;
        month = 3;

        if (dayOfMonth > 31)
        {
            month++;
            dayOfMonth -= 31;
        }

        return LocalDate.of(year, month, dayOfMonth);
    }


}
