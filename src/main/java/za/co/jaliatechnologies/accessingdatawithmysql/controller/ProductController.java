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
import za.co.jaliatechnologies.accessingdatawithmysql.dto.ProductDto;
import za.co.jaliatechnologies.accessingdatawithmysql.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path="/accessing-data-with-mysql")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "This endpoint creates product information.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "product information has been successfully created.",
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
                    description = "Appears when entered format doesn't match the required tables",
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
    @PostMapping(path="/createProduct")
    ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok().body(this.productService.createProduct(productDto));
    }

    @Operation(summary = "This endpoint returns all product information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product information has been successfully retrieved .",
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
                    description = "Appears when the endpoint url has be incorrectly entered",
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
    @GetMapping(path="/readAllProductInfo")
    ResponseEntity<List<ProductDto>> readAllProductInfo(){
        return ResponseEntity.ok().body(productService.readAllProductInfo());
    }
    @Operation(summary = "This endpoint updates Product information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product information has been successfully updated .",
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
                    description = "Appears when updated information format doesn't match tables in the database",
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
    @PutMapping(path="/updatingProduct/{product_id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long product_id, @RequestBody ProductDto  productDto){
        productDto.setProduct_id(product_id);
        return ResponseEntity.ok().body(this.productService.updateProductInfo(productDto));
    }

    @Operation(summary = "This endpoint deletes product information")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product information has been successfully deleted .",
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
                    description = "Appears when product id that doesn't exist is entered",
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
    @DeleteMapping(path="/deleteProduct/{product_id}")
    public ResponseEntity deleteProduct(@PathVariable Long product_id){
        this.productService.deleteProductInfo(product_id);
        return ResponseEntity.ok().body("Product information by id " + product_id + " has been successfully deleted");
    }
}
