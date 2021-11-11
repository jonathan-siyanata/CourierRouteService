package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto;

import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.AlgorithmRouteServiceImp;

public class AlgorithmRouteDto {

    private AlgorithmRouteServiceImp shortestRoute;
    private String  distanceInKilometers;

    public AlgorithmRouteDto(AlgorithmRouteServiceImp shortestRoute, String distanceInKilometers) {
        this.shortestRoute = shortestRoute;
        this.distanceInKilometers = distanceInKilometers;
    }

    public AlgorithmRouteDto() {
    }

    public AlgorithmRouteServiceImp getShortestRoute() {
        return shortestRoute;
    }

    public void setShortestRoute(AlgorithmRouteServiceImp shortestRouteServiceImpBruteForce) {
        this.shortestRoute = shortestRouteServiceImpBruteForce;
    }

    public String getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public void setDistanceInKilometers(String distanceInKilometers) {
        this.distanceInKilometers = distanceInKilometers;
    }
}