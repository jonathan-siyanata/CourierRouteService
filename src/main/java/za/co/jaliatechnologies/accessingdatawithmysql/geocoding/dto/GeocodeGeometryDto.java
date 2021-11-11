package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeGeometryDto {

    @JsonProperty("location")
    private GeocodeLocationDto geocodeLocation;

    public GeocodeGeometryDto(GeocodeLocationDto geocodeLocation) {
        this.geocodeLocation = geocodeLocation;
    }

    public GeocodeGeometryDto() {
    }

    public GeocodeLocationDto getGeocodeLocation() {
        return geocodeLocation;
    }

    public void setGeocodeLocation(GeocodeLocationDto geocodeLocation) {
        this.geocodeLocation = geocodeLocation;
    }
}
