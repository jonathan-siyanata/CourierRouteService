package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.nearestneighbor;

import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.CityServiceImp;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.AlgorithmRouteServiceImp;

import java.util.ArrayList;

public interface NearestNeighborService {
    AlgorithmRouteServiceImp findShortestRoute(ArrayList<CityServiceImp> cities);
    void  updateRoutes(ArrayList<CityServiceImp> shortestRouteCities, ArrayList<CityServiceImp> cities, CityServiceImp cityServiceImp);
    CityServiceImp getNextCity(ArrayList<CityServiceImp> cities, CityServiceImp cityServiceImp);
}
