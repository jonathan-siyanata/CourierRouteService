package za.co.jaliatechnologies.accessingdatawithmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.DeliveryDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.DriverDto;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.RouteDtoList;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Driver;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.DriverDao;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Driver service imp.
 */
@Service
@Transactional
public class DriverServiceImp implements DriverService{

    @Autowired
    private DriverDao driverDao;

    @Override
    public DriverDto createDriverInfo(DriverDto driverDto) {

        Driver creatingDriver = new Driver();
        creatingDriver.setDriver_id_number(driverDto.getDriver_id_number());
        creatingDriver.setEmail_address(driverDto.getEmail_address());
        creatingDriver.setFirst_name(driverDto.getFirst_name());
        creatingDriver.setDate_of_birth(driverDto.getDate_of_birth());
        creatingDriver.setPhone_number(driverDto.getPhone_number());
        creatingDriver.setLast_name(driverDto.getLast_name());
        creatingDriver.setPassword(driverDto.getPassword());
        driverDto.setDriver_id(driverDao.save(creatingDriver).getDriver_id());
        System.out.println("Driver has been created and saved!!");
        return driverDto;
    }
    @Override
    public DriverDto createNewDriver(DeliveryDto deliveryDto, String idNumber) {

        DriverDto driverDto = new DriverDto();

        driverDto.setDriver_id_number(idNumber);
        driverDto.setFirst_name(deliveryDto.getDriverDto().getFirst_name());
        driverDto.setLast_name(deliveryDto.getDriverDto().getLast_name());
        driverDto.setDate_of_birth(deliveryDto.getDriverDto().getDate_of_birth());
        driverDto.setEmail_address(deliveryDto.getDriverDto().getEmail_address());
        driverDto.setPhone_number(deliveryDto.getDriverDto().getPhone_number());
        driverDto.setPassword(deliveryDto.getDriverDto().getPassword());
        System.out.println("DriverDto populated");
        return driverDto;
    }

    @Override
    public List<DriverDto> readAllDriversInfo() {
        DriverDto driverDto = new DriverDto();
        List<Driver> driverDtoList =(List<Driver>) driverDao.findAll();
        List<DriverDto> driverDtoReturnList = new ArrayList(Arrays.asList(driverDtoList));
        return driverDtoReturnList;
    }

    @Override
    public DriverDto updateDriverInfo(DriverDto driverDto) {
        Optional<Driver> optionalDriver = this.driverDao.findById(driverDto.getDriver_id());

        if(optionalDriver.isPresent()){
            Driver updateDriver = optionalDriver.get();

            updateDriver.setDriver_id(driverDto.getDriver_id());
            updateDriver.setFirst_name(driverDto.getFirst_name());
            updateDriver.setLast_name(driverDto.getLast_name());
            updateDriver.setDate_of_birth(driverDto.getDate_of_birth());
            updateDriver.setEmail_address(driverDto.getEmail_address());
            updateDriver.setPhone_number(driverDto.getPhone_number());
            updateDriver.setDriver_id_number(driverDto.getDriver_id_number());
            updateDriver.setPassword(driverDto.getPassword());
            driverDao.save(updateDriver);
            System.out.println("Driver info has been successfully updated");
            return driverDto;
        }else{
            throw new ResourceNotFoundException("Driver id : " + driverDto.getDriver_id() + " not found");
        }
    }

    @Override
    public void deleteDriverInfo(Long driverId) {
        Optional<Driver> optionalDriver = this.driverDao.findById(driverId);

        if(optionalDriver.isPresent()){
            this.driverDao.delete(optionalDriver.get());
        }else{
            throw new ResourceNotFoundException("Driver id : " + driverId + " not found");
        }
    }

    @Override
    public DriverDto delivery(Long driverId) {
        Optional<Driver> delivery = this.driverDao.findById(driverId);
        DriverDto driverDto = new DriverDto();

        if(delivery.isPresent()){
         driverDto.setDriver_id(delivery.get().getDriver_id());
         driverDto.setFirst_name(delivery.get().getFirst_name());
         driverDto.setLast_name(delivery.get().getLast_name());
         driverDto.setDate_of_birth(delivery.get().getDate_of_birth());
         driverDto.setEmail_address(delivery.get().getEmail_address());
         driverDto.setPhone_number(delivery.get().getDriver_id_number());
         return driverDto;
        }else{
            throw new ResourceNotFoundException("Driver id : " + driverId + " not found");
        }
    }
}
