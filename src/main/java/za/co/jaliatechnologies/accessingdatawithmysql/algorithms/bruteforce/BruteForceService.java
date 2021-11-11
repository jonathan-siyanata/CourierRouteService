package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.bruteforce;

import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service.AlgorithmRouteServiceImp;

import java.util.ArrayList;
import java.util.List;

public interface BruteForceService {

    ArrayList<AlgorithmRouteServiceImp> permuteCities(int x, AlgorithmRouteServiceImp currentRouteServiceImpBruteForce, AlgorithmRouteServiceImp shortestRouteServiceImpBruteForce);
    int calculateTotalDistance(AlgorithmRouteServiceImp routeServiceImpBruteForce);
    void addToShortestRoutes(AlgorithmRouteServiceImp routeServiceImpBruteForce);
    String getTotalDistance(AlgorithmRouteServiceImp routeServiceImpBruteForce);
}
