package com.holtak.holidays4j.provider;

import com.holtak.holidays4j.model.Holiday;

import java.util.List;

public interface HolidayProvider {

    List<Holiday> holidays(int year);

}
