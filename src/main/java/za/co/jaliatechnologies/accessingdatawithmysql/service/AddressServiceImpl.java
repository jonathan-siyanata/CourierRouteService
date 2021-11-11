package za.co.jaliatechnologies.accessingdatawithmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.AddressDto;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Address;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.AddressDao;
import za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto.GeocodeDto;
import za.co.jaliatechnologies.accessingdatawithmysql.geocoding.proxy.GeocodingClient;

import javax.transaction.Transactional;
import java.util.*;

/**
 * The type Address service.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    /**
     * The Address dao.
     */
    @Autowired
    AddressDao addressDao;

    /**
     * The Client service.
     */
    @Autowired
     ClientService clientService;

    /**
     * The Geocoding client.
     */
    @Autowired
    GeocodingClient geocodingClient;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {

        Address address = new Address();
        address.setAddress_id(addressDto.getAddress_id());
        address.setAddress(addressDto.getAddress());
        address.setLng(addressDto.getLng());
        address.setLat(addressDto.getLat());
        addressDto.setAddress_id(addressDao.save(address).getAddress_id());
        System.out.println("Address Entity Saved!");
        return addressDto;
    }

    public AddressDto geoCodeAddress(String location) {

        GeocodeDto geocodeDto = geocodingClient.getGeocode( location,"en","AIzaSyBie8pixGUaDb2y2_Tp1WDyV3VejOxRFEE",
                "maps.googleapis.com").getBody();

        AddressDto addressDto = new AddressDto();

        assert geocodeDto != null;
        addressDto.setAddress(location);
        addressDto.setLng(geocodeDto.getResults().get(0).getGeometry().getViewPort().getNortheast().getLng());
        addressDto.setLat(geocodeDto.getResults().get(0).getGeometry().getViewPort().getNortheast().getLat());
        System.out.println("AddressDto populated!");
        return addressDto;
    }

    @Override
    public List<AddressDto> readAllAddressInfo() {
        List<Address> addressList = (List<Address>) addressDao.findAll();
        List<AddressDto> addressDtoReturnList = new ArrayList(Arrays.asList(addressList));
             return addressDtoReturnList;
    }

    @Override
    public AddressDto updateAddressInfo(String location) {

        GeocodeDto geocodeDto = geocodingClient.getGeocode( location,"en","AIzaSyBie8pixGUaDb2y2_Tp1WDyV3VejOxRFEE",
                "maps.googleapis.com").getBody();

        AddressDto addressDto = new AddressDto();
        Optional<Address> addressOptional = addressDao.findById(addressDto.getAddress_id());

        if(addressOptional.isPresent()){
            Address updateAddress = addressOptional.get();
            updateAddress.setAddress(geocodeDto.getResults().get(0).getFormattedAddress());
            updateAddress.setLng(geocodeDto.getResults().get(0).getGeometry().getViewPort().getNortheast().getLng());
            updateAddress.setLat(geocodeDto.getResults().get(0).getGeometry().getViewPort().getNortheast().getLat());
            addressDao.save(updateAddress);
            return addressDto;
        }else{
            throw new ResourceNotFoundException("Address id : " + addressDto.getAddress_id() + " not found");
        }
    }

    @Override
    public void deleteAddressInfo(Long addressId) {

        Optional<Address> addressInDb = this.addressDao.findById(addressId);

        if(addressInDb.isPresent()){
            this.addressDao.delete(addressInDb.get());
        }else{
            throw new ResourceNotFoundException("Address id : " + addressId + " not found");
        }
    }
}
