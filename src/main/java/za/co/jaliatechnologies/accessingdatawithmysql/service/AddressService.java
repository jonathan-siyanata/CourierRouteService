package za.co.jaliatechnologies.accessingdatawithmysql.service;

import za.co.jaliatechnologies.accessingdatawithmysql.dto.AddressDto;

import java.util.List;


/**
 * The interface Address service.
 */
public interface AddressService {

    /**
     * Creates an address used for the delivery by the driver
     *
     * @param addressDto with the required information
     * @return the AddressDto which consists of the required information to create an address
     */
    AddressDto createAddress(AddressDto addressDto);

    /**
     * Reads all Address
     *
     * @return the list of addresses, which contains latitude and longitude
     */
    List<AddressDto> readAllAddressInfo();

    /**
     * Deletes a address associated  with a specific ID
     *
     * @param addressId of the location
     */
    void deleteAddressInfo(Long addressId);

    /**
     * Updates the address associated  with a specific ID
     *
     * @param location the new information of the address you want to update
     * @return AddressDto which consists of the required field to update a address
     */
    AddressDto updateAddressInfo (String location);

    /**
     * Live coordinates of a particular place consisting of latitude and longitude
     *
     * @param location of the address you want to create
     * @return AddressDto which consists of the required field to update a address
     */
    AddressDto geoCodeAddress(String location);
}
