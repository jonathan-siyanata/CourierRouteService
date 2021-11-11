package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlgorithmTypeDto {

    private Long algorithm_type_id;

    @JsonProperty("algorithm_type")
    private String algorithm_type;

    public AlgorithmTypeDto(Long algorithm_type_id, String algorithm_type) {
        this.algorithm_type_id = algorithm_type_id;
        this.algorithm_type = algorithm_type;
    }

    public AlgorithmTypeDto() {
    }

    public long getAlgorithm_type_id() {
        return algorithm_type_id;
    }

    public void setAlgorithm_type_id(long algorithm_type_id) {
        this.algorithm_type_id = algorithm_type_id;
    }

    public String getAlgorithm_type() {
        return algorithm_type;
    }

    public void setAlgorithm_type(String algorithm_type) {
        this.algorithm_type = algorithm_type;
    }
}
