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
import za.co.jaliatechnologies.accessingdatawithmysql.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(path="accessing-data-with-mysql")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @Operation(summary = "This endpoint creates a client.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The client has been successfully created and returned no errors.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "If the endpoint url is incorrectly spelt.",
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
    @PostMapping(path="/createClient")
    ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto){
        return ResponseEntity.ok().body(this.clientService.createClient(clientDto));
    }

    @Operation(summary = "This endpoint returns all the clients.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client information has been successfully retrieved and returned no errors.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "If the endpoint is incorrectly entered.",
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
    @GetMapping(path="/readAllClients")
    ResponseEntity<List<ClientDto>> readAllClients(){
        return ResponseEntity.ok().body(clientService.readAllClients());
    }

    @Operation(summary = "This endpoint updates client information by client id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client information has been successfully updated and returned no errors.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "If client that doesn't exist is updated",
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
    @PutMapping(path="/updatingClient/{client_id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long client_id, @RequestBody ClientDto clientDto){
        clientDto.setClient_id(client_id);
        return ResponseEntity.ok().body(this.clientService.updateClient(clientDto));
    }

    @Operation(summary = "This endpoint deletes client information by client id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client information has been successfully deleted and returned no errors.",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class),
                                    examples = {
                                            @ExampleObject(value = "")
                                    }
                            )}),
            @ApiResponse(
                    responseCode = "404",
                    description = "If a client that doesn't exist is deleted",
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
    @DeleteMapping(path="/deletingClient/{client_id}")
    public ResponseEntity deletePerson(@PathVariable Long client_id){
        this.clientService.deleteClient(client_id);
        return ResponseEntity.ok().body("Client information by id " + client_id + " has been successfully deleted");
    }
}
