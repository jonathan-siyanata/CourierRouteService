package za.co.jaliatechnologies.accessingdatawithmysql.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto.AlgorithmTypeDto;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.AlgorithmTypeService;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.AddressDto;

import java.util.List;

@RestController
@RequestMapping(path="accessing-data-with-mysql")
public class AlgorithmTypeController {

    @Autowired
    AlgorithmTypeService algorithmTypeService;

    @Operation(summary = "This endpoint creates a algorithm")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The algorithm was successfully created and returned with no errors.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AlgorithmTypeDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Algorithm Type table doesn't exist.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AlgorithmTypeDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @CrossOrigin("http://localhost:63342")
    @PostMapping(path="/createAlgorithm")
    public ResponseEntity<AlgorithmTypeDto> createAlgorithm( @RequestBody AlgorithmTypeDto algorithmTypeDto) throws Exception{
        AlgorithmTypeDto savedAlgorithmType = algorithmTypeService.createAlgorithm(algorithmTypeDto);
        return new ResponseEntity<AlgorithmTypeDto>(savedAlgorithmType, HttpStatus.CREATED);
    }

    @Operation(summary = "This endpoint reads the algorithms in the database.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The algorithms were successfully retrieved  and returned with no errors.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AlgorithmTypeDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "The Algorithm doesn't exist.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AlgorithmTypeDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "500",
                    description = "A service error has occurred. Please try again later.",
                    content = @Content) })
    @CrossOrigin("http://localhost:63342")
    @GetMapping(path="/readAlgorithms")
    public ResponseEntity <List<AlgorithmTypeDto>> readAlgorithms(){
        return ResponseEntity.ok().body(algorithmTypeService.readAlgorithms());
    }
}
