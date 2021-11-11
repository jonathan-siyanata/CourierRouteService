package za.co.jaliatechnologies.accessingdatawithmysql.service;

import za.co.jaliatechnologies.accessingdatawithmysql.dto.DeliveryDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.DriverDto;

import java.util.List;

/**
 * The interface Driver service.
 */
public interface DriverService {

    /**
     * Creates driver information
     *
     * @param driverDto with the required information
     * @return the DriverDto which consists of the required information to create a driver
     */
    DriverDto createDriverInfo(DriverDto driverDto);

    /**
     * Returns all the drivers
     *
     * @return the DriverDto which consists of all the drivers
     */
    List<DriverDto> readAllDriversInfo();

    /**
     * Updates driver information
     *
     * @param driverDto with the required information to update the driver
     * @return the DriverDto which consists of the required information to update the driver information
     */
    DriverDto updateDriverInfo(DriverDto driverDto);

    /**
     * Deletes driver information associated with a driver id
     *
     * @param driver_id used to delete a specific driver
     */
    void deleteDriverInfo(Long driver_id);

    /**
     * Makes Delivery
     *
     * @param driverId of the driver associated with a delivery
     * @return the DriverDto which consists of the required information to make a delivery
     */
    DriverDto delivery(Long driverId);

    /**
     * Creates a new driver
     *
     * @param deliveryDto contains delivery information
     * @param idNumber    of the driver
     * @return the DriverDto which consists of the drivers information and delivery
     */
    DriverDto createNewDriver(DeliveryDto deliveryDto, String idNumber);
}
