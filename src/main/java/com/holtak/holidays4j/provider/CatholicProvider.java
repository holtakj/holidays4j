package com.holtak.holidays4j.provider;

import com.holtak.holidays4j.ResultCache;
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
import static com.holtak.holidays4j.model.StandardHolidayType.RELIGION;

public class CatholicProvider extends AbstractProvider<CatholicProvider> {

    private static final ResultCache<Integer, LocalDate> CACHE_easterSunday = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_easterMonday = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_ascensionDay = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_whitMonday = new ResultCache<>();

    public static LocalDate easterMonday(int year) {
        return CACHE_easterMonday.computeIfAbsent(year, compute_easterMonday());
    }

    private static Function<? super Integer, LocalDate> compute_easterMonday() {
        return (year) -> {
            val easterSunday = easterSunday(year);
            return easterSunday.plusDays(1);
        };
    }

    public static LocalDate easterSunday(int year) {
        return CACHE_easterSunday.computeIfAbsent(year, compute_easterSunday());
    }

    private static Function<Integer, LocalDate> compute_easterSunday() {
        return (year) -> {
            int month;
            int dayOfMonth;

            int yearMod19 = year % 19;
            int century = year / 100;
            int h = (century - (century / 4) - ((8 * century + 13) / 25)
                    + 19 * yearMod19 + 15) % 30;
            int i = h - (h / 28) * (1 - (h / 28) *
                    (29 / (h + 1)) * ((21 - yearMod19) / 11));

            dayOfMonth = i - ((year + (year / 4) +
                    i + 2 - century + (century / 4)) % 7) + 28;
            month = 3;

            if (dayOfMonth > 31) {
                month++;
                dayOfMonth -= 31;
            }

            return LocalDate.of(year, month, dayOfMonth);
        };
    }

    public static LocalDate ascensionDay(int year) {
        return CACHE_ascensionDay.computeIfAbsent(year, compute_ascensionDay());
    }

    private static Function<? super Integer, LocalDate> compute_ascensionDay() {
        return (year) -> {
            val easterSunday = easterSunday(year);
            return easterSunday.plusDays(39);
        };
    }

    public static LocalDate whitMonday(int year) {
        return CACHE_whitMonday.computeIfAbsent(year, compute_whitMonday());
    }

    private static Function<? super Integer, LocalDate> compute_whitMonday() {
        return (year) -> {
            val easterSunday = easterSunday(year);
            return easterSunday.plusDays(49);
        };
    }


    protected Function<? super Integer, ? extends List<Holiday>> compute_holidays() {
        return (year) -> {
            val easterMonday = new Holiday()
                    .id(Id.EASTER_MONDAY)
                    .name("Easter Monday")
                    .date(easterMonday(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION));

            val ascensionDay = new Holiday()
                    .id(Id.ASCENSION_DAY)
                    .name("Ascension Day")
                    .date(ascensionDay(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION));

            val whitMonday = new Holiday()
                    .id(Id.WHIT_MONDAY)
                    .name("Whit Monday")
                    .date(whitMonday(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION));

            val christmasDay = new Holiday()
                    .id(Id.CHRISTMAS_DAY)
                    .name("Christmas Day")
                    .date(LocalDate.of(year, Month.DECEMBER, 25))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC, RELIGION));

            return Arrays.asList(
                    easterMonday,
                    ascensionDay,
                    whitMonday,
                    christmasDay
            );
        };
    }


    public enum Id implements HolidayIdEnum {
        EASTER_MONDAY,
        ASCENSION_DAY,
        WHIT_MONDAY,
        CHRISTMAS_DAY
    }
}
