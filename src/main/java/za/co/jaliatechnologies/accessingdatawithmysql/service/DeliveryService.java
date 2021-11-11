package za.co.jaliatechnologies.accessingdatawithmysql.service;


import za.co.jaliatechnologies.accessingdatawithmysql.dto.*;
import za.co.jaliatechnologies.accessingdatawithmysql.exception.ValidationException;

import java.util.List;

/**
 * The interface Delivery service.
 */
public interface DeliveryService {

    /**
     * Creates a delivery
     *
     * @param deliveryDto contains the information required to create a delivery
     * @param routeId     contains all the deliveries required to create a route
     * @return DeliveryDto which contains the delivery information
     * @throws Exception the exception
     */
    DeliveryDto createDelivery(DeliveryDto deliveryDto, Long routeId) throws Exception;

    /**
     * Creates a route containing a list of deliveries
     *
     * @param routeDtoList of the list of deliveries
     * @return the ResultDto which consists of a route
     * @throws Exception the exception
     */
    ResultDto createRoute(RouteDtoList routeDtoList) throws Exception;

    /**
     * Creates a delivery associated with a route id
     *
     * @param deliveryDto the required information to make a delivery
     * @param routeId     for a particular delivery
     * @return the DeliveryDto which contains
     * @throws Exception the exception
     */
    DeliveryDto create(DeliveryDto deliveryDto, Long routeId) throws Exception;

    /**
     * Deliveries that are available
     *
     * @return list of deliveries
     */
    List<DeliveryDto> readAllDelivery();

    /**
     * Updates a delivery
     *
     * @param deliveryDto information required to update the delivery
     * @return DeliveryDto which consists of the updated information
     */
    DeliveryDto updateDelivery(DeliveryDto deliveryDto);

    /**
     * Deletes a delivery according to the delivery id associated with a delivery
     *
     * @param delivery_id associated with the delivery
     */
    void deleteDelivery(Long delivery_id);

    /**
     * Validates whether the information entered in the driver dto match the required format
     *
     * @param driverDto contains the driver information that needs to be validated
     * @throws ValidationException if information is missing
     */
    void driverDtoValidation(DriverDto driverDto) throws ValidationException;

    /**
     * Validates whether the information entered in the address dto match the required format
     *
     * @param addressDto contains the address information that needs to be validated
     * @throws ValidationException if information is missing
     */
    void addressDtoValidation(AddressDto addressDto) throws ValidationException;

    /**
     * Validates whether the information entered in the delivery dto match the required format
     *
     * @param deliveryDto contains the driver information that needs to be validated
     * @throws Exception the exception
     */
    void deliveryValidation(DeliveryDto deliveryDto) throws Exception;

    /**
     * Validates whether the information entered in the product dto match the required format
     *
     * @param productDto contains the driver information that needs to be validated
     * @throws ValidationException if information is missing
     */
    void productDtoValidation(ProductDto productDto) throws  ValidationException;


}
