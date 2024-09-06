package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class CreateEmployeeController {

    EmployeeService employeeService;

    @Operation(
            summary = "Guarda al empleado",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Create Successful"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error to Save",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Completable save(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return Single.fromCallable(() -> RequestToEmployeeMapper.mapEmployee(employeeRequest))
                .flatMapCompletable(employeeService::save);
    }

}
