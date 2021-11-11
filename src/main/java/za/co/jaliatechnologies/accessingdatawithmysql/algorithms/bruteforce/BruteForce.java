package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.bruteforce;

import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.AlgorithmRouteServiceImp;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.CityServiceImp;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.DeliveryRouteServiceImp;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class BruteForce implements BruteForceService {

    static int permutationNumber = 1;
    ArrayList<AlgorithmRouteServiceImp> shortestRoute = new ArrayList<AlgorithmRouteServiceImp>();


    @Override
    public ArrayList<AlgorithmRouteServiceImp> permuteCities(int x, AlgorithmRouteServiceImp currentRouteServiceImp, AlgorithmRouteServiceImp shortestRouteServiceImp) {
        currentRouteServiceImp.getCities().stream().filter(y -> currentRouteServiceImp.getCities().indexOf(y) >= x).forEach(y -> {
            int indexOfY = currentRouteServiceImp.getCities().indexOf(y);
            Collections.swap(currentRouteServiceImp.getCities(), indexOfY, x);
            permuteCities(x + 1, currentRouteServiceImp, shortestRouteServiceImp);
            Collections.swap(currentRouteServiceImp.getCities(), x, indexOfY);
        });
        if(x == currentRouteServiceImp.getCities().size() - 1){
            if(DeliveryRouteServiceImp.VERBOSE_FLAG)
                System.out.print(currentRouteServiceImp + " |       " + getTotalDistance(currentRouteServiceImp));
            if((int)calculateTotalDistance(currentRouteServiceImp) <= (int)calculateTotalDistance(shortestRouteServiceImp)){
                shortestRouteServiceImp.getCities().clear();
                shortestRouteServiceImp.getCities().addAll(currentRouteServiceImp.getCities());
                addToShortestRoutes(new AlgorithmRouteServiceImp(shortestRouteServiceImp));
            }
            System.out.println("               |               " + getTotalDistance(shortestRouteServiceImp) + "               |               " + permutationNumber++);
        }
        return this.shortestRoute;
    }

    @Override
    public int calculateTotalDistance(AlgorithmRouteServiceImp route) {
        int citiesDistance = route.getCities().size();

        return (int) (route.getCities().stream().mapToDouble(x -> {
            int cityIndex = route.getCities().indexOf(x);
            double returnValue = 0;
            if(cityIndex < citiesDistance - 1)
                returnValue = x.measureDistance(route.getCities().get(cityIndex + 1));
            return returnValue;
        }).sum() + route.getCities().get(0).measureDistance(route.getCities().get(citiesDistance - 1)));
    }

    @Override
    public void addToShortestRoutes(AlgorithmRouteServiceImp routeServiceImp) {
        shortestRoute.removeIf(x -> (int) calculateTotalDistance(x) > (int) calculateTotalDistance(routeServiceImp));
        shortestRoute.add(routeServiceImp);
    }

    @Override
    public String getTotalDistance(AlgorithmRouteServiceImp route) {
        String returnValue = Integer.toString(calculateTotalDistance(route));
        if(returnValue.length() == 4)
            returnValue = " " + returnValue;
        else if(returnValue.length() == 3)
            returnValue = " " + returnValue;
        return returnValue;
    }
}
