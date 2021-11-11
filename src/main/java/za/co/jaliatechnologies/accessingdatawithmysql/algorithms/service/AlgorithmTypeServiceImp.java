package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.Entity.AlgorithmType;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dao.AlgorithmTypeDao;
import za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto.AlgorithmTypeDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class AlgorithmTypeServiceImp implements AlgorithmTypeService{

    @Autowired
    AlgorithmTypeDao algorithmTypeDao;

    @Override
    public AlgorithmTypeDto createAlgorithm(AlgorithmTypeDto algorithmTypeDto) {
        AlgorithmType creatingAlgorithm = new AlgorithmType();
        creatingAlgorithm.setAlgorithm_type(algorithmTypeDto.getAlgorithm_type());
        AlgorithmType save = algorithmTypeDao.save(creatingAlgorithm);
        algorithmTypeDto.setAlgorithm_type_id(save.getAlgorithm_type_id());
        return algorithmTypeDto;
    }

    @Override
    public List<AlgorithmTypeDto> readAlgorithms() {
        AlgorithmTypeDto algorithmTypeDto = new AlgorithmTypeDto();
        List<AlgorithmType> algorithmTypeList = (List<AlgorithmType>) algorithmTypeDao.findAll();
        List<AlgorithmTypeDto> dtoReturnList = new ArrayList (Arrays.asList(algorithmTypeList));
        return dtoReturnList;
    }

    @Override
    public AlgorithmTypeDto updateAlgorithm(String algorithm) {
        return null;
    }

    @Override
    public void deleteAlgorithm(Long algorithmId) {

    }
}
