package com.vsu.kata;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Utility class for date formatting.
 */
public class DateUtils {

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
