package com.pe.relari.srv_neg_employee_configuration_v1.employee.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <b>Class:</b> Utility.</br>
 * @author Relari.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utility {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT);

    public static String formatDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static LocalDate mapLocalDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static String formatDatetime(LocalDateTime date) {
        return date.format(DATETIME_FORMATTER);
    }

    public static String buildDate(long millis) {
        return new SimpleDateFormat(Constants.DATETIME_FORMAT).format(new Date(millis));
    }

}
