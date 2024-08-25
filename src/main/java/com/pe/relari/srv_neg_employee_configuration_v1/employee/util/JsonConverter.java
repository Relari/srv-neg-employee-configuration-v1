package com.pe.relari.srv_neg_employee_configuration_v1.employee.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    private static ObjectMapper mapper;

    private JsonConverter() {}

    static {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }

    public static String convertJsonString(Object data) {
        if (data == null) {
            return null;
        }
        try {
            return mapper.writeValueAsString(data);
        } catch (Exception ignored) {}
        return null;
    }
}
