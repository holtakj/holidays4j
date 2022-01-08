package com.holtak.holidays4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Translation {
    private HolidayIdEnum id;
    private String translation;
}
