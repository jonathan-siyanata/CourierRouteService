package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeometryDto {

    @JsonProperty("bounds")
    private BoundsDto bounds;

    @JsonProperty("location")
    private LocationDto location;

    @JsonProperty("location_type")
    private String locationType;

    @JsonProperty("viewport")
    private ViewPortDto viewPort;

    public GeometryDto(BoundsDto bounds, LocationDto location, String locationType, ViewPortDto viewPort) {
        this.bounds = bounds;
        this.location = location;
        this.locationType = locationType;
        this.viewPort = viewPort;
    }

    public GeometryDto() {
    }

    public BoundsDto getBounds() {
        return bounds;
    }

    public void setBounds(BoundsDto bounds) {
        this.bounds = bounds;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = this.locationType;
    }

    public ViewPortDto getViewPort() {
        return viewPort;
    }

    public void setViewPort(ViewPortDto viewPort) {
        this.viewPort = viewPort;
    }
}
