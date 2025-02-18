package pe.com.relari.srv_neg_employee_configuration_v1.employee.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <b>Enum:</b> Constants.</br>
 * @author Relari.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    
    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String ARROBA = "@";

    public static final String REGEXP_ONLY_LETTERS = "[a-zA-Z]*";
    public static final String REGEXP_SEX = "M|F";
    public static final String REGEXP_JOBS_TITLES = "SCRUM_MASTER|TEAM_LEAD|DEVELOPER|MANAGER|ARCHITECT";
    public static final String REGEXP_LETTERS_AND_NUMBERS = "[a-zA-Z0-9]";
    public static final String REGEXP_TIPO_DOCUMENTO = "DNI|PASAPORTE";
    public static final String REGEXP_TIPO_COMPROBANTE = "BOLETA|FACTURA";
    public static final String REGEXP_ONLY_NUMBER = "[0-9]*";
    public static final String REGEXP_PHONE_NUMBER = "[0-9]{9}";
    public static final String REGEXP_DATE = "[0-9]{2}-[0-9]{2}-[0-9]{4}";

    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";

    public static final int ZERO = 0;
    public static final String TOPIC = "employee_topic";
    public static final String GROUP_ID = "employee_group_id";

}
