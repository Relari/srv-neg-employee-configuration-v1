package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class FindEmployeeController {

    EmployeeService employeeService;

    @Operation(
            summary = "Obtiene la informacion de un empleado.",
            method = "GET",
            parameters = {
                    @Parameter(
                            description = "Id del Empleado",
                            name = "id",
                            in = ParameterIn.PATH,
                            example = "1",
                            required = true)
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Show Students",
                            content = @Content(
                                    schema = @Schema(implementation = EmployeeResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error to Save",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Error to Save",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            })
    @GetMapping(path = "/{username}")
    public Single<EmployeeResponse> findEmployeeById(
            @PathVariable("username") String username) {
        return employeeService.findByUsername(username)
                .map(RequestToEmployeeMapper::mapPersonResponse);
    }

}
