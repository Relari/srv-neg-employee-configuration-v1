package com.pe.relari.srv_neg_employee_configuration_v1.employee.util;

import java.util.HashMap;

public class GenericMap<K, V> extends HashMap<K, V> {

    public V getValue(K key) {
        return super.get(key);
    }

}
