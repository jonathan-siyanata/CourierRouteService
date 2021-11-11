package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto.GeocodeDto;
import za.co.jaliatechnologies.accessingdatawithmysql.geocoding.proxy.GeocodingClient;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path="/accessing-data-with-mysql")
public class GeocodeController {

    @Autowired
    GeocodingClient geocodingClient;

    @GetMapping(path = "/geocode")
    public GeocodeDto getGeocodeApi(@RequestParam("address") String address, HttpServletRequest request){
        GeocodeDto dto = geocodingClient.getGeocode( address,"en","AIzaSyBie8pixGUaDb2y2_Tp1WDyV3VejOxRFEE",
                "maps.googleapis.com").getBody();
        return dto;
    }
}