package com.holtak.holidays4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashSet;
import java.util.Set;

import static java.time.temporal.ChronoField.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class Holiday implements Comparable<Holiday> {

    private static final DateTimeFormatter formatter;

    static {
        formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendValue(YEAR, 4)
                .appendLiteral("-")
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral("-")
                .appendValue(DAY_OF_MONTH, 2)
                .optionalStart()
                .parseLenient()
                .appendOffset("+HHMMss", "Z")
                .parseStrict()
                .toFormatter();
    }

    private HolidayIdEnum id;
    private LocalDate date;
    private String dateAsString;
    private String name;
    private String localizedName;
    private Holiday4jCountry country;
    private boolean fixed;
    private boolean global;
    private boolean national;
    private Integer sinceYear;
    private Set<HolidayType> types = new HashSet<>();

    public void setDateAsString(LocalDate date) {
        this.dateAsString = formatter.format(date);
    }

    public Holiday date(LocalDate date) {
        this.date = date;
        setDateAsString(date);
        return this;
    }

    @Override
    public int compareTo(Holiday o) {
        return this.date.compareTo(o.date);
    }
}
