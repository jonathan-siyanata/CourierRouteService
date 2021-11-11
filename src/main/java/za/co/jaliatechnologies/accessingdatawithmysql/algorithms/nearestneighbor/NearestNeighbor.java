package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.nearestneighbor;

import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.CityServiceImp;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.AlgorithmRouteServiceImp;

import java.util.ArrayList;
import java.util.Arrays;

public class NearestNeighbor implements NearestNeighborService {

    @Override
    public AlgorithmRouteServiceImp findShortestRoute(ArrayList<CityServiceImp> cities) {
        ArrayList<CityServiceImp> shortestRouteCities = new ArrayList<CityServiceImp>(cities.size());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Initial Route      ==>" + Arrays.toString(cities.toArray()));
        System.out.println("w/ total distance: " + new AlgorithmRouteServiceImp(cities).calculateTotalDistance());
        System.out.println("---------------------------------------------------------------------");
        CityServiceImp city = cities.get((int)(cities.size() * Math.random()));
        updateRoutes(shortestRouteCities, cities, city);
            while(cities.size() >= 1){
                city = getNextCity(cities, city);
                updateRoutes(shortestRouteCities, cities, city);
            }
        return new AlgorithmRouteServiceImp(shortestRouteCities);
    }

    @Override
    public void updateRoutes(ArrayList<CityServiceImp> shortestRouteCities, ArrayList<CityServiceImp> cities, CityServiceImp cityServiceImp) {
        shortestRouteCities.add(cityServiceImp);
        cities.remove(cityServiceImp);
        System.out.println("Cities In Short Route ==> " + Arrays.toString(shortestRouteCities.toArray()));
        System.out.println("Remaining cities           ==> " + Arrays.toString(cities.toArray()) + "\n");
    }

    @Override
    public CityServiceImp getNextCity(ArrayList<CityServiceImp> cities, CityServiceImp city){
        return cities.stream().min((city1, city2) ->{
            int flag = 0;
            if(city1 .measureDistance(city) < city2.measureDistance(city))
                flag = -1;
            else if(city1.measureDistance(city) > city2.measureDistance(city))
                flag = 1;
            return flag;
        }).get();
    }

}