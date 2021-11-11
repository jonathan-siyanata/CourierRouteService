package za.co.jaliatechnologies.accessingdatawithmysql.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.*;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.*;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Delivery;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Driver;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.RouteEntity;
import za.co.jaliatechnologies.accessingdatawithmysql.exception.EmptyInputException;
import za.co.jaliatechnologies.accessingdatawithmysql.exception.ValidationException;

import javax.transaction.Transactional;
import java.util.*;

/**
 * The type Delivery service imp.
 */
@Service
@Configuration
@Transactional
public class DeliveryServiceImp implements DeliveryService {

    /**
     * The Delivery dao.
     */
    @Autowired
    DeliveryDao deliveryDao;

    /**
     * The Driver dao.
     */
    @Autowired
    DriverDao driverDao;

    /**
     * The Product dao.
     */
    @Autowired
    ProductDao productDao;

    /**
     * The Driver service.
     */
    @Autowired
    DriverService driverService;

    /**
     * The Route dao.
     */
    @Autowired
    RouteDao routeDao;

    /**
     * The Address dao.
     */
    @Autowired
    AddressDao addressDao;

    /**
     * The Address service.
     */
    @Autowired
    AddressService addressService;

    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;

    @Override
    public void driverDtoValidation(DriverDto driverDto) throws ValidationException {

        if (StringUtils.isEmpty(driverDto.getFirst_name())) {
            throw new ValidationException("Driver first name field does not exist");
        }

        if (StringUtils.isEmpty(driverDto.getLast_name())) {
            throw new ValidationException("Driver last name field does not exist");
        }

        if (StringUtils.isEmpty(driverDto.getDate_of_birth())) {
            throw new ValidationException("The date of birth field does not exist");
        }

        if (StringUtils.isEmpty(driverDto.getEmail_address())) {
            throw new ValidationException("Driver email address field does not exist");
        }

        if (StringUtils.isEmpty(driverDto.getPhone_number())) {
            throw new ValidationException("Driver phone number field does not exist");
        }

        if (StringUtils.isEmpty(driverDto.getDriver_id_number())) {
            throw new ValidationException("Driver id number field does not exist");
        }
    }
    @Override
    public void addressDtoValidation(AddressDto addressDto) throws ValidationException {

        if(StringUtils.isEmpty(addressDto.getAddress())){
            throw new ValidationException("Address field does not exist");
        }

    }
    @Override
    public void productDtoValidation(ProductDto productDto) throws ValidationException {

        if(StringUtils.isEmpty(productDto.getProduct_type())){
            throw new ValidationException("Product type field does not exist");
        }
    }

    @Override
    public void deliveryValidation(DeliveryDto deliveryDto) throws Exception {

        if (deliveryDto.getDriver_id_number() == null || deliveryDto.getDriver_id_number().isEmpty()) {
            throw new EmptyInputException("Driver id number field is empty please enter Driver id number");
        } else if (driverDao.findDriverIdNumber(deliveryDto.getDriver_id_number()) == null) {
            System.out.println("Check DriverDto fields");
             driverDtoValidation(deliveryDto.getDriverDto());
        }

        if (deliveryDto.getProduct_type() == null || deliveryDto.getProduct_type().isEmpty()) {
                throw new EmptyInputException("Product type field is empty please enter product type information");
        } else if (productDao.findProductType(deliveryDto.getProduct_type()) == null) {
              System.out.println("Check ProductDto fields");
              productDtoValidation(deliveryDto.getProductDto());
        }

        if (deliveryDto.getProduct_quantity() == null) {
            throw new EmptyInputException("Product quantity field is empty please enter product quantity information");
        }

            if (deliveryDto.getAddress() == null || deliveryDto.getAddress().isEmpty()) {
                throw new EmptyInputException("address field is empty please enter product quantity information");
            }else if (addressDao.findByAddress(deliveryDto.getAddress()) == null){
                System.out.println("Check AddressDto fields");
                addressDtoValidation(deliveryDto.getAddressDto());
            }

            if (deliveryDto.getDelivery_time() == null || deliveryDto.getDelivery_time().isEmpty()) {
                throw new EmptyInputException("Time field is empty please enter time information");
            }

            if (deliveryDto.getDelivery_date() == null || deliveryDto.getDelivery_date().isEmpty()) {
                throw new EmptyInputException("Date field is empty please enter date information");
            }
       }



    @Override
    public DeliveryDto create(DeliveryDto deliveryDto, Long routeId) throws Exception {

        Delivery delivery = new Delivery();

        deliveryValidation(deliveryDto);

        if (driverDao.findDriverIdNumber(deliveryDto.getDriver_id_number()) == null) {

            String idNumber = deliveryDto.getDriver_id_number();
            DriverDto driverDto = driverService.createDriverInfo(driverService.createNewDriver(deliveryDto, idNumber));
            delivery.setDriver_id(driverDto.getDriver_id());

        }else{
            delivery.setDriver_id(driverDao.findDriverIdNumber(deliveryDto.getDriver_id_number()).getDriver_id());
        }

        if(addressDao.findByAddress(deliveryDto.getAddress()) == null){

            String location = deliveryDto.getAddress();
           AddressDto addressDto = addressService.createAddress(addressService.geoCodeAddress(location));
            delivery.setAddress_id(addressDto.getAddress_id());
        }else{
            delivery.setAddress_id(addressDao.findByAddress(deliveryDto.getAddress()).getAddress_id());
        }

        if(productDao.findProductType(deliveryDto.getProduct_type()) == null){

            String productType = deliveryDto.getProduct_type();
            Long productQuantity = deliveryDto.getProduct_quantity();
            ProductDto productDto = productService.createProduct(productService.createNewProduct(productType, productQuantity));
            delivery.setProduct_id(productDto.getProduct_id());
        }else{
            delivery.setProduct_id(productDao.findProductType(deliveryDto.getProduct_type()).getProduct_id());
        }

        delivery.setRoute_id(routeId);
        delivery.setDriver_id_number(deliveryDto.getDriver_id_number());
        delivery.setDelivery_date(deliveryDto.getDelivery_date());
        delivery.setDelivery_time(deliveryDto.getDelivery_time());
        delivery.setProduct_quantity(deliveryDto.getProduct_quantity());
        delivery.setProduct_type(deliveryDto.getProduct_type());
        delivery.setAddress(deliveryDto.getAddress());
        deliveryDao.save(delivery);
        System.out.println("Delivery has been created and saved!!");
        return deliveryDto;

    }



    @Override
    public DeliveryDto createDelivery(DeliveryDto deliveryDto, Long routeId) throws Exception {
        deliveryValidation(deliveryDto);
        create(deliveryDto, routeId);

        return deliveryDto;
    }

    @Override
    public ResultDto createRoute(RouteDtoList routeDtoList) throws Exception {

        RouteEntity routeEntity = new RouteEntity();
        StringBuilder route_desc = new StringBuilder("AlgorithmRouteServiceImp for today consists of the following stops : ");

        Long routeId;
        routeEntity.setRoute_description(route_desc.toString());

        routeId = routeDao.save(routeEntity).getRoute_id();

        routeEntity.setRoute_id(routeId);

        for (DeliveryDto dto : routeDtoList.getRouteDtoList()) {
            route_desc.append(create(dto, routeEntity.getRoute_id()).getAddress()).append(", ");
        }
        routeEntity.setRoute_description(route_desc.toString());

        routeDao.saveAndFlush(routeEntity);
        return new ResultDto(routeId + "");
    }

    @Override
    public List<DeliveryDto> readAllDelivery() {
        List<Delivery> deliveryList = (List<Delivery>) deliveryDao.findAll();
        List<DeliveryDto> deliveryDtoReturnList = new ArrayList(Arrays.asList(deliveryList));
        return deliveryDtoReturnList;
    }

    @Override
    public DeliveryDto updateDelivery(DeliveryDto deliveryDto) {
        Optional<Delivery> deliveryOptional = this.deliveryDao.findById(deliveryDto.getDelivery_id());

        if (deliveryOptional.isPresent()) {
            Delivery updateDelivery = deliveryOptional.get();

            // Load driver entity based on id number
            Driver driver = driverDao.findDriverIdNumber(deliveryDto.getDriver_id_number());

            // set driverId on delivery entity
            updateDelivery.setDriver_id(driver.getDriver_id());
            // populate rest of delivery entity

            updateDelivery.setDriver_id_number(deliveryDto.getDriverDto().getDriver_id_number());
            updateDelivery.setDelivery_date(deliveryDto.getDelivery_date());
            updateDelivery.setDelivery_time(deliveryDto.getDelivery_time());
            updateDelivery.setAddress(deliveryDto.getAddressDto().getAddress());
            updateDelivery.setProduct_quantity(deliveryDto.getProductDto().getProduct_quantity());
            updateDelivery.setProduct_type(deliveryDto.getProductDto().getProduct_type());
            deliveryDao.save(updateDelivery);
            System.out.println("Delivery has been successfully updated!!");
            return deliveryDto;
        } else {
            throw new ResourceNotFoundException("Delivery id : " + deliveryDto.getDelivery_id() + " not found");
        }
    }

    @Override
    public void deleteDelivery(Long delivery_id) {
        Optional<Delivery> deliveryInDb = this.deliveryDao.findById(delivery_id);

        if (deliveryInDb.isPresent()) {
            this.deliveryDao.delete(deliveryInDb.get());
        } else {
            throw new ResourceNotFoundException("Delivery id : " + delivery_id + " not found");
        }

    }

}
