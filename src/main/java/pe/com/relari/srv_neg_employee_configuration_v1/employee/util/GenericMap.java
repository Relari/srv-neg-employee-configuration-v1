package pe.com.relari.srv_neg_employee_configuration_v1.employee.util;

import java.util.HashMap;

public class GenericMap<K, V> extends HashMap<K, V> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public V getValue(K key) {
        return super.get(key);
    }

}
