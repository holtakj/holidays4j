package com.holtak.holidays4j.provider;

import com.holtak.holidays4j.ResultCache;
import com.holtak.holidays4j.logic.AbstractProvider;
import com.holtak.holidays4j.model.Holiday;
import com.holtak.holidays4j.model.HolidayIdEnum;
import lombok.val;
import lombok.var;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.holtak.holidays4j.model.StandardHolidayType.PUBLIC;
import static com.holtak.holidays4j.model.StandardHolidayType.RELIGION;

public class CatholicProvider extends AbstractProvider<CatholicProvider> {

    private static final ResultCache<Integer, LocalDate> CACHE_easterSunday = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_easterMonday = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_ascensionDay = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_whitMonday = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_pentecost = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_corpusChristi = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_firstAdvent = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_secondAdvent = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_thirdAdvent = new ResultCache<>();
    private static final ResultCache<Integer, LocalDate> CACHE_fourthAdvent = new ResultCache<>();

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
            return easterSunday.plusDays(50);
        };
    }

    public static LocalDate pentecost(int year) {
        return CACHE_pentecost.computeIfAbsent(year, compute_pentecost());
    }

    private static Function<? super Integer, LocalDate> compute_pentecost() {
        return (year) -> {
            val easterSunday = easterSunday(year);
            return easterSunday.plusDays(49);
        };
    }

    public static LocalDate corpusChristi(int year) {
        return CACHE_corpusChristi.computeIfAbsent(year, compute_corpusChristi());
    }

    private static Function<? super Integer, LocalDate> compute_corpusChristi() {
        return (year) -> {
            val easterSunday = easterSunday(year);
            return easterSunday.plusDays(60);
        };
    }

    public static LocalDate firstAdvent(int year) {
        return CACHE_firstAdvent.computeIfAbsent(year, compute_firstAdvent());
    }

    private static Function<? super Integer, LocalDate> compute_firstAdvent() {
        return (year) -> computeAdvent(year, 1);
    }

    public static LocalDate secondAdvent(int year) {
        return CACHE_secondAdvent.computeIfAbsent(year, compute_secondAdvent());
    }

    private static Function<? super Integer, LocalDate> compute_secondAdvent() {
        return (year) -> computeAdvent(year, 2);
    }

    public static LocalDate thirdAdvent(int year) {
        return CACHE_thirdAdvent.computeIfAbsent(year, compute_thirdAdvent());
    }

    private static Function<? super Integer, LocalDate> compute_thirdAdvent() {
        return (year) -> computeAdvent(year, 3);
    }

    public static LocalDate fourthAdvent(int year) {
        return CACHE_fourthAdvent.computeIfAbsent(year, compute_fourthAdvent());
    }

    private static Function<? super Integer, LocalDate> compute_fourthAdvent() {
        return (year) -> computeAdvent(year, 4);
    }

    private static LocalDate computeAdvent(int year, int advent){
        if( advent < 1 || advent > 4) throw new IllegalArgumentException("advent is an integer between 1 and 4 where 4 is the 4th advent");
        val xmas = LocalDate.of(year, Month.DECEMBER, 25);
        int adventCounter = 4;
        var target = xmas;
        while(true) {
            target = target.minusDays(1);
            if(target.getDayOfWeek() == DayOfWeek.SUNDAY) {
                if(adventCounter == advent) {
                    return target;
                } else {
                    adventCounter--;
                }
            }
        }
    }


    protected Function<? super Integer, ? extends List<Holiday>> compute_holidays() {
        return (year) -> {
            val resultList = new ArrayList<Holiday>();

            resultList.add(new Holiday()
                    .id(Id.EASTER_SUNDAY)
                    .name("Easter Sunday")
                    .date(easterSunday(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.EASTER_MONDAY)
                    .name("Easter Monday")
                    .date(easterMonday(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.ASCENSION_DAY)
                    .name("Ascension Day")
                    .date(ascensionDay(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.PENTECOST)
                    .name("Pentecost")
                    .date(pentecost(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.WHIT_MONDAY)
                    .name("Whit Monday")
                    .date(whitMonday(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.CORPUS_CHRISTI)
                    .name("Corpus Christi")
                    .date(corpusChristi(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.CHRISTMAS_DAY)
                    .name("Christmas Day")
                    .date(LocalDate.of(year, Month.DECEMBER, 25))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.ST_STEPHANS_DAY)
                    .name("t. Stephen's Day")
                    .date(LocalDate.of(year, Month.DECEMBER, 26))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.ALL_SAINT_DAY)
                    .name("All Saints' Day")
                    .date(LocalDate.of(year, Month.NOVEMBER, 1))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.ASSUMPTION_DAY)
                    .name("Assumption Day")
                    .date(LocalDate.of(year, Month.AUGUST, 15))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.IMMACULATE_CONCEPTION)
                    .name("Immaculate Conception")
                    .date(LocalDate.of(year, Month.DECEMBER, 8))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.EPIPHANY)
                    .name("Epiphany")
                    .date(LocalDate.of(year, Month.JANUARY, 6))
                    .global(true)
                    .fixed(true)
                    .types(createSet(PUBLIC, RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.FIRST_ADVENT)
                    .name("1st Advent")
                    .date(firstAdvent(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.SECOND_ADVENT)
                    .name("2nd Advent")
                    .date(secondAdvent(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.THIRD_ADVENT)
                    .name("3rd Advent")
                    .date(thirdAdvent(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(RELIGION))
            );

            resultList.add(new Holiday()
                    .id(Id.FOURTH_ADVENT)
                    .name("4th Advent")
                    .date(fourthAdvent(year))
                    .global(true)
                    .fixed(false)
                    .types(createSet(RELIGION))
            );

            return resultList;
        };
    }


    public enum Id implements HolidayIdEnum {
        EASTER_SUNDAY,
        EASTER_MONDAY,
        ASCENSION_DAY,
        PENTECOST,
        WHIT_MONDAY,
        CORPUS_CHRISTI,
        CHRISTMAS_DAY,
        ALL_SAINT_DAY,
        ASSUMPTION_DAY,
        IMMACULATE_CONCEPTION,
        ST_STEPHANS_DAY,
        EPIPHANY,
        FIRST_ADVENT,
        SECOND_ADVENT,
        THIRD_ADVENT,
        FOURTH_ADVENT
    }
}
