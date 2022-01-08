package com.holtak.holidays4j.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface HolidayProvider {

    List<Holiday> holidays(int year);

    @SuppressWarnings("unchecked")
    default <T> Set<T> createSet(T... elements) {
        return Stream.of(elements).collect(Collectors.toSet());
    }

}
