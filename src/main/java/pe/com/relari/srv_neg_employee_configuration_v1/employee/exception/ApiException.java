package pe.com.relari.srv_neg_employee_configuration_v1.employee.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final ErrorCategory catalog;
    private final Throwable detail;

    private ApiException(ErrorCategory catalog) {
        super();
        this.catalog = catalog;
        this.detail = null;
    }

    private ApiException(ErrorCategory catalog, Throwable detail) {
        super();
        this.catalog = catalog;
        this.detail = detail;
    }

    public static ApiException of(ErrorCategory catalog) {
        return new ApiException(catalog);
    }

    public static ApiException of(ErrorCategory catalog, Throwable throwable) {
        return new ApiException(catalog, throwable);
    }

}
