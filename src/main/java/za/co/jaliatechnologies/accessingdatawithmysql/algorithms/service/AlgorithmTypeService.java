package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service;

import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto.AlgorithmTypeDto;

import java.util.List;

public interface AlgorithmTypeService {
     AlgorithmTypeDto createAlgorithm(AlgorithmTypeDto algorithm);
     List<AlgorithmTypeDto> readAlgorithms();
     AlgorithmTypeDto updateAlgorithm(String algorithm);
     void deleteAlgorithm(Long algorithmId);
}
