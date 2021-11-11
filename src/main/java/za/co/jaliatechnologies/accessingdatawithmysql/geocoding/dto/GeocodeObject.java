package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeObject {

    @JsonProperty("place_id")
    private String placeId;

    @JsonProperty("address_components")
    private List<AddressComponentDto> addressComponents;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    private GeocodeGeometryDto geocodeGeometry;

    public GeocodeObject(String placeId, List<AddressComponentDto> addressComponents, String formattedAddress, GeocodeGeometryDto geocodeGeometry) {
        this.placeId = placeId;
        this.addressComponents = addressComponents;
        this.formattedAddress = formattedAddress;
        this.geocodeGeometry = geocodeGeometry;
    }

    public GeocodeObject() {
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<AddressComponentDto> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponentDto> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public GeocodeGeometryDto getGeocodeGeometry() {
        return geocodeGeometry;
    }

    public void setGeocodeGeometry(GeocodeGeometryDto geocodeGeometry) {
        this.geocodeGeometry = geocodeGeometry;
    }
}
