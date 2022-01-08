package com.holtak.holidays4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SinceYear {
    private HolidayIdEnum id;
    private int sinceYear;
}
