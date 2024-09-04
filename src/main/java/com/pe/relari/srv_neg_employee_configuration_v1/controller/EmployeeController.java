package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.PersonResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <b>Class:</b> EmployeeController.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Tag(name = "Employee", description = "Employee Controller")
@OpenAPIDefinition(
        info = @Info(
                title = "Employee API",
                version = "${application.info.version}",
                description = "${application.info.description}")
)
@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
class EmployeeController {

  private final EmployeeService employeeService;

  @Operation(
          summary = "Listado de Empleados",
          method = "GET",
          responses  = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Retorna todos los Empleados",
                          content = @Content(
                                  array = @ArraySchema(
                                          schema = @Schema(implementation = PersonResponse.class)),
                                  mediaType = MediaType.APPLICATION_JSON_VALUE
                          )
                  )
          })
  @GetMapping
  public Observable<PersonResponse> listOfEmployees() {
    return this.employeeService.findAll()
            .map(RequestToEmployeeMapper::mapPersonResponse);
  }

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
                                  schema = @Schema(implementation = PersonResponse.class),
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
  @GetMapping(path = "/{id}")
  public Single<PersonResponse> findEmployeeById(
          @PathVariable("id") Integer id) {
    return employeeService.findById(id)
            .map(RequestToEmployeeMapper::mapPersonResponse);
  }

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
