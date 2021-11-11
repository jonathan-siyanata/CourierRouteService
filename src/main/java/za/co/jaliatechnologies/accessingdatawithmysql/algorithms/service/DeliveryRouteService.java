package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service;

import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.bruteforce.BruteForce;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto.AlgorithmRouteDto;

import java.time.Instant;
import java.util.List;

public interface DeliveryRouteService {

    boolean VERBOSE_FLAG = true;
    void printDuration(Instant StartInstant);
    void printResult(BruteForce bruteForce, List<AlgorithmRouteServiceImp> shortestRouteServiceImpBruteForce);
    void printHeading(String headingColumn1, String remainingHeadingColumns, AlgorithmRouteServiceImp routeServiceImpBruteForce);
    AlgorithmRouteDto shortestRoute(String algorithmType, Long routeId);
    List<CityServiceImp> deliveryAddress(Long routeId);
    AlgorithmRouteDto printShortestRoute(AlgorithmRouteServiceImp shortestRouteServiceImp);
}
