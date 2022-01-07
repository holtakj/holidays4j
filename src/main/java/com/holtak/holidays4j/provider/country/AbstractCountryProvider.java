package com.holtak.holidays4j.provider.country;

import com.holtak.holidays4j.ResultCache;
import com.holtak.holidays4j.model.Country;
import com.holtak.holidays4j.model.Holiday;
import com.holtak.holidays4j.provider.HolidayProvider;
import com.holtak.holidays4j.provider.Translation;
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

    @Override
    public List<Holiday> holidays(int year) {
        return CACHE.computeIfAbsent(year, compute_holidays());
    }

    protected Function<? super Integer, ? extends List<Holiday>> compute_holidays() {
        return (year) -> Stream.of(
                        providers()
                )
                .filter(Objects::nonNull)
                .map(provider -> provider.holidays(year))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .peek(p -> {
                    val translationOption = Arrays.stream(translations()).filter(t -> p.id() == t.getId()).findAny();
                    translationOption.ifPresent(t -> p.localizedName(t.getTranslation()));
                })
                .peek(p -> p.country(country()))
                .collect(Collectors.toList());
    }

    abstract HolidayProvider[] providers();

    abstract Translation[] translations();

    abstract Country country();

}
