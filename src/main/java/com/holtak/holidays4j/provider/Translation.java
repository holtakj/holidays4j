package com.holtak.holidays4j.provider;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Translation {
    private HolidayIdEnum id;
    private String translation;
}
