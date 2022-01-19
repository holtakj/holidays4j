package com.holtak.holidays4j;

import com.holtak.holidays4j.exception.Holiday4jException;
import lombok.Builder;
import lombok.val;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class SqlExport {

    /*
    INSERT INTO CAST_CALENDAREVENT
(ID, TITLE, DESCRIPTION, FROMDATE, TODATE, VALUE, TYPE, RECURRINGCALENDAREVENT_ID, CALENDAR_NAME) VALUES
(CALENDAREVENT_SEQ.nextval, '1. Advent','FEIERTAG',to_date('2022-01-20','yyyy-mm-dd'),to_date('2022-01-20','yyyy-mm-dd'),'1. Advent', 'HOLIDAY', 4777, 'HOLIDAY');

     */

    @Builder
    static class OneLine {
        String ID, TITLE, DESCRIPTION, FROMDATE, TODATE, VALUE, TYPE, RECURRINGCALENDAREVENT_ID, CALENDAR_NAME;

        public String dumpValues() {
            val sb = new StringBuilder();
            sb.append(ID).append(", ");
            sb.append(TITLE).append(", ");
            sb.append(DESCRIPTION).append(", ");
            sb.append(FROMDATE).append(", ");
            sb.append(TODATE).append(", ");
            sb.append(VALUE).append(", ");
            sb.append(TYPE).append(", ");
            sb.append(RECURRINGCALENDAREVENT_ID).append(", ");
            sb.append(CALENDAR_NAME);

            return sb.toString();
        }
    }

    public static void main(String[] args) throws Holiday4jException, IOException {
        val country = Holidays4j.locateCountryChecked("AT");

        val fileName = "calendar.sql";
        val fileWriter = new FileWriter(fileName);

        try (val printWriter = new PrintWriter(fileWriter)) {
            val range = IntStream.range(2024, 2050);
            range.forEach(year -> {
                        val holidays = Holidays4j.holidays(year, country);
                        holidays.forEach(h -> {
                            val sb = new StringBuilder();
                            sb.append("INSERT INTO CAST_CALENDAREVENT (ID, TITLE, DESCRIPTION, FROMDATE, TODATE, VALUE, TYPE, RECURRINGCALENDAREVENT_ID, CALENDAR_NAME) VALUES (");

                            val line = OneLine.builder()
                                    .ID("CALENDAREVENT_SEQ.nextval")
                                    .TITLE(qq(h.localizedName()))
                                    .DESCRIPTION(qq("FEIERTAG"))
                                    .FROMDATE(to_date(h.date()))
                                    .TODATE(to_date(h.date().plusDays(1)))
                                    .VALUE(qq(h.localizedName()))
                                    .TYPE(qq("HOLIDAY"))
                                    .RECURRINGCALENDAREVENT_ID("4777") //FIXME get real value
                                    .CALENDAR_NAME(qq("HOLIDAY"))
                                    .build();
                            sb.append(line.dumpValues());

                            sb.append(");");

                            System.out.println(sb);
                            printWriter.println(sb);
                        });
                    }
            );
        }
    }

    private static String qq(String value) {
        return "'" + value + "'";
    }

    private static String to_date(LocalDate date) {
        return "to_date(" + qq(date.toString()) + "," + qq("yyyy-mm-dd") + ")";
    }

}
