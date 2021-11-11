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
import za.co.jaliatechnologies.accessingdatawithmysql.dto.ClientDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.DeliveryDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.DriverDto;
import za.co.jaliatechnologies.accessingdatawithmysql.service.DriverService;

import java.util.List;

@RestController
@RequestMapping(path="accessing-data-with-mysql")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Operation(summary = "This endpoint creates driver information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Driver information has been successfully retrieved .",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DeliveryDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Appears when inaccurate information according to the table has been entered",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @PostMapping(path="/createDriverInfo")
    ResponseEntity<DriverDto> createDriver(@RequestBody DriverDto driverDto){
        return ResponseEntity.ok().body(this.driverService.createDriverInfo(driverDto));
    }

    @Operation(summary = "This endpoint returns all driver information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Driver information has been successfully retrieved .",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DeliveryDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Appears when the endpoint url has been entered incorrectly",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @GetMapping(path="/readAllDriversInfo")
    ResponseEntity<List<DriverDto>> readAllDriversInfo(){
        return ResponseEntity.ok().body(driverService.readAllDriversInfo());
    }

    @Operation(summary = "This endpoint returns updates driver information.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Driver information has been successfully updated.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DeliveryDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Appears when inaccurate information has been entered according to the tables.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @PutMapping(path="/updateDriverInfo/{driver_id}")
    public ResponseEntity<DriverDto> updateDriverInfo(@PathVariable Long driver_id, @RequestBody DriverDto driverDto){
        driverDto.setDriver_id(driver_id);
        return ResponseEntity.ok().body(this.driverService.updateDriverInfo(driverDto));
    }

    @Operation(summary = "This endpoint deletes driver information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "driver information has been successfully deleted .",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DeliveryDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Appears when a driver id that doesn't exist is entered",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @DeleteMapping(path="/deleteDriverInfo/{driver_person_id}")
    public ResponseEntity deleteDriver(@PathVariable Long driver_id){
        this.driverService.deleteDriverInfo(driver_id);
        return ResponseEntity.ok().body("Address information by id " + driver_id + " has been successfully deleted");
    }
}
