package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.bruteforce.BruteForce;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto.AlgorithmRouteDto;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.enums.AlgorithmTypes;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.nearestneighbor.NearestNeighbor;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.AddressDao;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.DeliveryDao;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.DeliveryDto;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Address;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Delivery;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeliveryRouteServiceImp implements DeliveryRouteService {

    @Autowired
    DeliveryDao deliveryDao;

    @Autowired
    AddressDao addressDao;


    private AlgorithmRouteDto algorithmRouteDto = new AlgorithmRouteDto();

    @Override
    public List<CityServiceImp> deliveryAddress(Long routeId) {
        //get deliveries that belong to a specific route
        List<Delivery>deliveryRouteList = (List<Delivery>) deliveryDao.findDeliveriesByRouteId(routeId);

        List<CityServiceImp> addressDtoList = new ArrayList<>();
        DeliveryDto deliveryDto = new DeliveryDto();

        for(Delivery delivery : deliveryRouteList){
            // on the del selected, get the address
            Optional<Address> optionalAddressEntity = addressDao.findById(delivery.getAddress_id());

            if(optionalAddressEntity.isPresent()){

                CityServiceImp cityServiceImp = new CityServiceImp();
                cityServiceImp.setName(optionalAddressEntity.get().getAddress());
                cityServiceImp.setLatitude(optionalAddressEntity.get().getLat());
                cityServiceImp.setLongitude(optionalAddressEntity.get().getLng());
                addressDtoList.add(cityServiceImp);
            }
        }
        return addressDtoList;
    }

    @Override
    public AlgorithmRouteDto shortestRoute(String algorithmType, Long routeId) {


        DeliveryRouteServiceImp deliveryRouteServiceImp = new DeliveryRouteServiceImp();

                AlgorithmTypes algoType = AlgorithmTypes.valueOf(algorithmType);
                switch (algoType) {
                    case BRUTE_FORCE:
                        Instant startInstant = Instant.now();
                        BruteForce bruteForce = new BruteForce();
                        AlgorithmRouteServiceImp currentRouteServiceImpBruteForce = new AlgorithmRouteServiceImp((ArrayList<CityServiceImp>) deliveryAddress(routeId));

                        if (VERBOSE_FLAG)
                            deliveryRouteServiceImp.printHeading("AlgorithmRouteServiceImp ", "    Distance (in kilometers)  |      Shortest Distance      |    Permutation Number", currentRouteServiceImpBruteForce);
                        else
                            System.out.println("Permutation in progress...");

                        deliveryRouteServiceImp.printResult(bruteForce, bruteForce.permuteCities(0, currentRouteServiceImpBruteForce, new AlgorithmRouteServiceImp(currentRouteServiceImpBruteForce)));
                        deliveryRouteServiceImp.printDuration(startInstant);
                        List<AlgorithmRouteServiceImp> routeServiceImpBruteForces = bruteForce.permuteCities(0, currentRouteServiceImpBruteForce, new AlgorithmRouteServiceImp(currentRouteServiceImpBruteForce));
                        routeServiceImpBruteForces.forEach(x -> System.out.println(x + "        |        " + bruteForce.getTotalDistance(x)));
                        algorithmRouteDto.setShortestRoute(routeServiceImpBruteForces.get(0));
                        algorithmRouteDto.setDistanceInKilometers(String.valueOf(bruteForce.getTotalDistance(routeServiceImpBruteForces.get(0))));
                        break;

                    case NEAREST_NEIGHBOR:
                        ArrayList<CityServiceImp> cities = new ArrayList<>(deliveryAddress(routeId));
                        AlgorithmRouteServiceImp shortestRoute = new NearestNeighbor().findShortestRoute(cities);
                        return deliveryRouteServiceImp.printShortestRoute(shortestRoute);

                }
    return algorithmRouteDto;
    }

    @Override
    public void printDuration(Instant startInstant) {
        Duration permutationDuration = Duration.between(startInstant, Instant.now());
        long minutes = permutationDuration.toMinutes();
        long seconds = permutationDuration.getSeconds();

        if(seconds > 59){
            long tempSeconds = seconds - 60 * minutes;
            long tempMilliseconds = permutationDuration.toMillis() - seconds * 1000;
            System.out.println("Duration : " + minutes + " minutes " + tempSeconds + " seconds " +
                    tempMilliseconds + " milliseconds " + " (" + permutationDuration + ")");
        }
        else if(seconds > 0){
            long tempMilliseconds = permutationDuration.toMillis() - seconds * 1000;
            System.out.println("Duration : " + seconds + " seconds " + tempMilliseconds + " milliseconds " + "(" + permutationDuration + ")");
        }
        else
            System.out.println("Duration : " + permutationDuration.toMillis() + " milliseconds (" + permutationDuration + ")");
    }

    @Override
    public void printResult(BruteForce bruteForce, List<AlgorithmRouteServiceImp> shortestRouteServiceImpBruteForce) {
        if(VERBOSE_FLAG)
            System.out.println("");
        printHeading("Shortest AlgorithmRouteServiceImp ", "                        Distance(Kilometers)", shortestRouteServiceImpBruteForce.get(0));
        shortestRouteServiceImpBruteForce.stream().forEach(x -> System.out.println(x + "        |        " + bruteForce.getTotalDistance(x)));
    }

    @Override
    public void printHeading(String headingColumn1, String remainingHeadingColumns, AlgorithmRouteServiceImp routeServiceImpBruteForce) {
        int cityNamesLength = 0;
        for(int x = 0; x < routeServiceImpBruteForce.getCities().size(); x++)
            cityNamesLength += routeServiceImpBruteForce.getCities().get(x).getName().length();

        int arrayLength = cityNamesLength + routeServiceImpBruteForce.getCities().size() * 2;
        int partialLength = (arrayLength - headingColumn1.length()) / 2;

        for(int x = 0; x < partialLength; x++)
            System.out.print(" ");
        System.out.println(headingColumn1);

        for(int x = 0; x < partialLength; x++)
            System.out.print(" ");

        for(int x = 0; x < partialLength; x++)
            System.out.print(" ");
        System.out.println(" | " + remainingHeadingColumns);

        cityNamesLength += remainingHeadingColumns.length() + 3;

        for(int x = 0; x < cityNamesLength + routeServiceImpBruteForce.getCities().size() * 2; x++)
            System.out.print(" - ");
        System.out.println(" ");

    }
    @Override
    public AlgorithmRouteDto printShortestRoute(AlgorithmRouteServiceImp shortestRouteServiceImp) {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Shortest route found so far: " + shortestRouteServiceImp);
        System.out.println("w/ total distance: " + shortestRouteServiceImp.calculateTotalDistance());
        System.out.println("-----------------------------------------------------------------------------------------------------");
        algorithmRouteDto.setShortestRoute(shortestRouteServiceImp);
        algorithmRouteDto.setDistanceInKilometers(shortestRouteServiceImp.calculateTotalDistance() + "");
        return algorithmRouteDto;
    }

//    public static void main(String[] args) {
//        AlgorithmTypes t = AlgorithmTypes.valueOf("BRUTE_FORCE");
//        System.out.println(t);
//    }

}
