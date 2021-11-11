package za.co.jaliatechnologies.accessingdatawithmysql.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.enums.AlgorithmTypes;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.ClientDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.DeliveryDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.RouteDto;
import za.co.jaliatechnologies.accessingdatawithmysql.service.RouteService;

import java.util.List;

@RestController
@RequestMapping(path="/accessing-data-with-mysql")
public class RouteController {
    @Autowired
    RouteService routeService;

    @Operation(summary = "This endpoint creates route description which contain the destination the driver will have to go to.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Route description has been successfully created and saved.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = RouteDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "If information is not entered correctly",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = RouteDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content)})
    @PostMapping(path="/createRouteDescription")
    ResponseEntity<RouteDto> createRouteDescription(@RequestBody RouteDto routeDto){
        return ResponseEntity.ok().body(this.routeService.createRouteDescription(routeDto));
    }
    @Operation(summary = "This endpoint gets the route id used by the driver to make delivers.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Route id has been successfully retrieved.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = RouteDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Route id doesn't exist",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = RouteDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content)})
    @CrossOrigin("http://localhost:63342")
    @GetMapping(path="/getRouteId")
    ResponseEntity<List<RouteDto>> getRouteId(){
        return (ResponseEntity<List<RouteDto>>)ResponseEntity.ok().body(routeService.getRouteId());
    }
}
