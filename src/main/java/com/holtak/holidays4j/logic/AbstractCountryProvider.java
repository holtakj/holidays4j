package com.holtak.holidays4j.logic;

import com.holtak.holidays4j.ResultCache;
import com.holtak.holidays4j.model.*;
import lombok.val;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractCountryProvider implements HolidayProvider {

    private static final ResultCache<Integer, List<Holiday>> CACHE = new ResultCache<>();

    protected abstract List<Holiday> countryHolidays(int year);

    @Override
    public List<Holiday> holidays(int year) {
        return CACHE.computeIfAbsent(year, compute_holidays());
    }

    protected Function<? super Integer, ? extends List<Holiday>> compute_holidays() {
        return (year) ->
        {
            val providerStream = Stream.of(
                            providers()
                    )
                    .filter(Objects::nonNull)
                    .map(provider -> provider.holidays(year))
                    .filter(Objects::nonNull)
                    .flatMap(Collection::stream)
                    .filter(Objects::nonNull);

            val additionalHolidaysStream = countryHolidays(year).stream()
                    .filter(Objects::nonNull);

            return Stream.concat(providerStream, additionalHolidaysStream)
                    .peek(p -> {
                        if (translations() == null) return;
                        val translationOption = Arrays.stream(translations()).filter(t -> p.id() == t.getId()).findAny();
                        translationOption.ifPresent(t -> p.localizedName(t.getTranslation()));
                    })
                    .peek(p -> {
                        if (sinceYears() == null) return;
                        val sinceYearOption = Arrays.stream(sinceYears()).filter(t -> p.id() == t.getId()).findAny();
                        sinceYearOption.ifPresent(t -> p.sinceYear(t.getSinceYear()));
                    })
                    .peek(p -> {
                        if (holidayTypes() == null) return;
                        val holidayTypesOptionYearOption = Arrays.stream(holidayTypes()).filter(t -> p.id() == t.getId()).findAny();
                        holidayTypesOptionYearOption.ifPresent(t -> p.types().addAll(t.getHolidayTypes()));
                    })
                    .peek(p -> p.country(country()))
                    .sorted()
                    .collect(Collectors.toList());
        };
    }

    protected abstract Country country();

    protected abstract HolidayProvider[] providers();

    protected abstract Translation[] translations();

    protected abstract SinceYear[] sinceYears();

    protected abstract HolidayTypeMap[] holidayTypes();

}
