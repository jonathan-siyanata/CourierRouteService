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
import za.co.jaliatechnologies.accessingdatawithmysql.dto.AddressDto;
import za.co.jaliatechnologies.accessingdatawithmysql.service.AddressService;

import java.util.List;

@RestController
@RequestMapping(path="accessing-data-with-mysql")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Operation(summary = "This endpoint creates a client address.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The clients address was successfully created and returned with no errors.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AddressDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "The client ID was not was not provided.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AddressDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })

    @PostMapping(path="/createAddress")
    ResponseEntity<AddressDto> createAddress(AddressDto addressDto){
        return ResponseEntity.ok().body(this.addressService.createAddress(addressDto));
    }


    @Operation(summary = "This endpoint reads all the information in the address table.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The information has been successfully read and displayed.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AddressDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @GetMapping(path="/readAllAddressInfo")
    ResponseEntity<List<AddressDto>> readAllAddressInfo(){
        return (ResponseEntity<List<AddressDto>>) ResponseEntity.ok().body(addressService.readAllAddressInfo());
    }

    @Operation(summary = "This endpoint updates the address information.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The address information was successfully updated.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AddressDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "If the endpoint url is incorrectly spelt",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AddressDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @PutMapping(path="/updatingAddress/{address_id}")
    public ResponseEntity<AddressDto> updateAddressInfo(@PathVariable Long address_id, String location){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress_id(address_id);
        return ResponseEntity.ok().body(this.addressService.updateAddressInfo(location));
    }

    @Operation(summary = "This endpoint deletes address information by id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The address information by id was successfully deleted.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AddressDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "400",
                    description = "The client entered an address id that doesn't exist.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AddressDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @DeleteMapping(path="/deletingAddressInfo/{address_id}")
    public ResponseEntity deleteAddressInfo(@PathVariable Long address_id){
        this.addressService.deleteAddressInfo(address_id);
        return ResponseEntity.ok().body("Address information by id " + address_id + " has been successfully deleted");
    }

}
