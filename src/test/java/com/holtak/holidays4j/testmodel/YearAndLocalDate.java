package com.holtak.holidays4j.testmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
public class YearAndLocalDate {
    int year;
    LocalDate expected;
}
