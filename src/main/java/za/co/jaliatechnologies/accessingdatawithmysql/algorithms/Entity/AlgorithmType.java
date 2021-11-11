package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.Entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Table(name="AlgorithmType")
@Configuration
public class AlgorithmType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ALGORITHM_TYPE_ID", nullable = false)
    private Long algorithm_type_id;

    @Column(name="ALGORITHM_TYPE", nullable = false)
    private String algorithm_type;

    public AlgorithmType(Long algorithm_type_id, String algorithm_type) {
        this.algorithm_type_id = algorithm_type_id;
        this.algorithm_type = algorithm_type;
    }

    public AlgorithmType() {
    }

    public Long getAlgorithm_type_id() {
        return algorithm_type_id;
    }

    public void setAlgorithm_type_id(Long algorithm_type_id) {
        this.algorithm_type_id = algorithm_type_id;
    }

    public String getAlgorithm_type() {
        return algorithm_type;
    }

    public void setAlgorithm_type(String algorithm_type) {
        this.algorithm_type = algorithm_type;
    }
}
