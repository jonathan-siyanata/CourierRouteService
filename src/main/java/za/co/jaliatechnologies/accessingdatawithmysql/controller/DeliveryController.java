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
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto.AlgorithmRouteDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.*;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.DeliveryRouteService;
import za.co.jaliatechnologies.accessingdatawithmysql.service.DeliveryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="accessing-data-with-mysql")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private DeliveryRouteService deliveryRouteService;

    @Operation(summary = "This endpoint creates delivery information used by the driver to make delivers.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery information has been successfully created and saved.",
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
                    description = "If information is not entered correctly",
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
                    content = @Content)})
    @PostMapping(path = "/createDelivery")
    public ResponseEntity<DeliveryDto> createDelivery(@Valid @RequestBody DeliveryDto deliveryDto) throws Exception {
        DeliveryDto savedDelivery = this.deliveryService.createDelivery(deliveryDto, null);
        return new ResponseEntity<DeliveryDto>(savedDelivery, HttpStatus.CREATED);
    }
    @Operation(summary = "This endpoint creates the route used by the driver to make delivers.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Route has been successfully created and saved.",
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
                    description = "If information is not entered correctly",
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
                    content = @Content)})
    @PostMapping(path = "/createRoute")
    public ResponseEntity<ResultDto> createRoute(@Valid @RequestBody RouteDtoList routeDtoList) throws Exception {
        ResultDto result = this.deliveryService.createRoute(routeDtoList);
        return new ResponseEntity<ResultDto>(result, HttpStatus.CREATED);
    }

    @Operation(summary = "This endpoint returns all delivery information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery information has been successfully retrieved .",
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
                    description = "Appears when endpoint is entered incorrectly",
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
                    content = @Content)})
    @GetMapping(path = "/readAllDeliveryInfo")
    ResponseEntity<List<DeliveryDto>> readAllDeliveryInfo() {
        return ResponseEntity.ok().body(this.deliveryService.readAllDelivery());
    }

    @Operation(summary = "This endpoint deletes delivery information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery information has been successfully deleted .",
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
                    description = "Appears when a delivery id that doesn't exist is tried to be deleted",
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
                    content = @Content)})
    @DeleteMapping(path = "/deletingDeliveryInfo/{delivery_id}")
    public ResponseEntity<String> deleteDeliveryInfo(@PathVariable("{delivery_id}") Long delivery_id) {
        this.deliveryService.deleteDelivery(delivery_id);
        return ResponseEntity.ok().body("Delivery information by id " + delivery_id + " has been successfully deleted");
    }

    @Operation(summary = "This endpoint updates delivery information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery information has been successfully updated .",
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
                    description = "Appears when incorrect information is inserted",
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
                    content = @Content)})
    @PutMapping(path = "/updateDeliveryInfo/{delivery_id}")
    public ResponseEntity<DeliveryDto> updateDeliveryInfo(@PathVariable("{delivery_id}") Integer delivery_id, @RequestBody DeliveryDto deliveryDto) {
        deliveryDto.setDelivery_id(delivery_id);
        return ResponseEntity.ok().body(this.deliveryService.updateDelivery(deliveryDto));
    }

    @Operation(summary = "This endpoint returns the information required by a driver to make deliveries")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delivery information has been successfully retrieved .",
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
                    description = "Appears when the endpoint url has been incorrectly entered",
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
                    content = @Content)})
    @CrossOrigin("http://localhost:63342")
    @GetMapping(path = "/shortestRoute/{algorithmType}/{routeId}")
    public ResponseEntity<AlgorithmRouteDto> shortestRoute(@PathVariable("algorithmType") String algorithmType, @PathVariable("routeId") Long routeId) {
        return ResponseEntity.ok().body(this.deliveryRouteService.shortestRoute(algorithmType, routeId));
    }


}
