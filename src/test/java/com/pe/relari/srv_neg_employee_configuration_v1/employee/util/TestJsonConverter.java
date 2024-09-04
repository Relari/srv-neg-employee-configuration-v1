package com.pe.relari.srv_neg_employee_configuration_v1.employee.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TestJsonConverter {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }

    private TestJsonConverter() {}

    public static <T> T readDataFromFileJson(
            String fileName, Class<T> className) {
        try {
            return mapper.readValue(
                    TestJsonConverter.class.getClassLoader().getResourceAsStream(fileName), className
            );
        } catch (IOException e) {
            return null;
        }
    }

}
