package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class AlgorithmRouteServiceImp implements AlgorithmRouteService {

    private ArrayList<CityServiceImp> cities = new ArrayList<CityServiceImp>();

    public AlgorithmRouteServiceImp(AlgorithmRouteServiceImp route) {
        route.cities.stream().forEach(x -> cities.add(x));
    }
    public AlgorithmRouteServiceImp(ArrayList<CityServiceImp> cities){
        setCities((ArrayList<CityServiceImp>) cities);
    }
    public AlgorithmRouteServiceImp(){}

    public ArrayList<CityServiceImp> getCities() {
        return cities;
    }

    public void setCities(ArrayList<CityServiceImp> cities) {
        this.cities = cities;
    }

//    public ArrayList<CityServiceImp> getCities() {
//        return cities;
//    }
//
//    public void setCities(ArrayList<CityServiceImp> cities) {
//        this.cities = cities;
//    }

    @Override
    public String toString() {
        return Arrays.toString(cities.toArray());
    }

    @Override
    public int calculateTotalDistance() {
        int citiesSize = this.getCities().size();
        return (int) (this.getCities().stream().mapToDouble(x -> {
            int cityIndex = this.getCities().indexOf(x);
            double returnValue = 0;
            if(cityIndex < citiesSize - 1)
                returnValue = x.measureDistance(this.getCities().get(cityIndex + 1));
            return returnValue;
        }).sum() + this.getCities().get(citiesSize - 1).measureDistance(this.getCities().get(0)));
    }
}
