package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultDto {

    @JsonProperty("address_components")
    private List<AddressComponentDto> addressComponents;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    @JsonProperty("geometry")
    private GeometryDto geometry;

    @JsonProperty("place_id")
    private String placeId;

    @JsonProperty("types")
    private List<String> types;

    public ResultDto(List<AddressComponentDto> addressComponents, String formattedAddress, GeometryDto geometry, String placeId, List<String> types) {
        this.addressComponents = addressComponents;
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
        this.placeId = placeId;
        this.types = types;
    }

    public ResultDto() {
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

    public GeometryDto getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryDto geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
