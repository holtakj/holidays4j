package com.holtak.holidays4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class HolidayTypeMap {
    private HolidayIdEnum id;
    private Set<HolidayType> holidayTypes;
}
