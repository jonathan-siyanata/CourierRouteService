package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.proxy;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto.GeocodeDto;


@FeignClient(url = "https://maps.googleapis.com/maps/api",
        name = "geocode-client")
public interface GeocodingClient {

    @RequestMapping(method = RequestMethod.GET, value = "/geocode/json?address&key=AIzaSyBie8pixGUaDb2y2_Tp1WDyV3VejOxRFEE")
    public ResponseEntity <GeocodeDto> getGeocode(

            @RequestParam("address") String address, @RequestParam("language") String language, @RequestHeader("x-googleapis-key") String key,
            @RequestHeader("x-googleapis-host") String host);
}
