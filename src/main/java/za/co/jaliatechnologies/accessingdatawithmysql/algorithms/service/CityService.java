package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service;

public interface CityService {

    double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
    double CONVERT_DEGREES_TO_RADIANS = Math.PI/180D;

    double measureDistance(CityServiceImp cityServiceImp);
}
