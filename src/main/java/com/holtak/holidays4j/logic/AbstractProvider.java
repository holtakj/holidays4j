package com.holtak.holidays4j.logic;

import com.holtak.holidays4j.ResultCache;
import com.holtak.holidays4j.model.Holiday;
import com.holtak.holidays4j.model.HolidayIdEnum;
import com.holtak.holidays4j.model.HolidayProvider;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractProvider<T> implements HolidayProvider {

    protected final ResultCache<Integer, List<Holiday>> CACHE = new ResultCache<>();

    Set<HolidayIdEnum> whitelistedSet = new HashSet<>();

    public T whitelist(HolidayIdEnum id) {
        whitelistedSet.add(id);
        //noinspection unchecked
        return (T) this;
    }

    public T whitelist(HolidayIdEnum... ids) {
        Collections.addAll(whitelistedSet, ids);
        //noinspection unchecked
        return (T) this;
    }

    public Set<HolidayIdEnum> whitelist() {
        return whitelistedSet;
    }

    @Override
    public List<Holiday> holidays(int year) {
        return filterById(CACHE.computeIfAbsent(year, compute_holidays()));
    }

    private List<Holiday> filterById(List<Holiday> holidayList) {
        if (whitelistedSet.size() > 0) {
            return holidayList.stream()
                    .filter(h -> whitelistedSet.contains(h.id()))
                    .collect(Collectors.toList());
        } else {
            return holidayList;
        }
    }

    protected abstract Function<? super Integer, ? extends List<Holiday>> compute_holidays();
}
