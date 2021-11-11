package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GeocodeDto {

    @JsonProperty("results")
    private List<ResultDto> results;

    @JsonProperty("status")
    private String status;

    public GeocodeDto(List<ResultDto> results, String status) {
        this.results = results;
        this.status = status;
    }

    public GeocodeDto() {
    }

    public List<ResultDto> getResults() {
        return results;
    }

    public void setResults(List<ResultDto> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
