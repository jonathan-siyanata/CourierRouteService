package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CityServiceImp implements CityService {
    private String name;
    private double longitude;
    private double latitude;

    public CityServiceImp(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude * CONVERT_DEGREES_TO_RADIANS;
        this.latitude = latitude * CONVERT_DEGREES_TO_RADIANS;
    }

    public CityServiceImp() {
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public double measureDistance(CityServiceImp city) {
        double deltaLongitude = (city.getLongitude() - this.getLongitude());
        double deltaLatitude = (city.getLatitude() - this.getLatitude());
        double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) +
                Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
        return EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
    }
}
