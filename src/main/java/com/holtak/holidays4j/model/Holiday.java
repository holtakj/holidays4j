package com.holtak.holidays4j.model;

import com.holtak.holidays4j.provider.HolidayIdEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.temporal.ChronoField.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class Holiday {

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
    private Country country;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private boolean national;
    private Integer sinceYear;
    private HolidayType[] types;

    public void setDateAsString(LocalDate date) {
        this.dateAsString = formatter.format(date);
    }

    public Holiday date(LocalDate date) {
        this.date = date;
        setDateAsString(date);
        return this;
    }

}
