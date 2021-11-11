package za.co.jaliatechnologies.accessingdatawithmysql.algorithms.enums;

public enum AlgorithmTypes{

    BRUTE_FORCE("BRUTE_FORCE"),
    NEAREST_NEIGHBOR("NEAREST_NEIGHBOR");

    private final String algorithmType;

    AlgorithmTypes(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

}
