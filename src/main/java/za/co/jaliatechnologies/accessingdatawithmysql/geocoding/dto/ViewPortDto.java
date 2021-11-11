package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewPortDto {
    @JsonProperty("northeast")
    private NorthEastDto northeast;

    @JsonProperty("southeast")
    private SouthWestDto southwest;

    public ViewPortDto(NorthEastDto northeast, SouthWestDto southwest) {
        this.northeast = northeast;
        this.southwest = southwest;
    }

    public ViewPortDto() {
    }

    public NorthEastDto getNortheast() {
        return northeast;
    }

    public void setNortheast(NorthEastDto northeast) {
        this.northeast = northeast;
    }

    public SouthWestDto getSouthwest() {
        return southwest;
    }

    public void setSouthwest(SouthWestDto southwest) {
        this.southwest = southwest;
    }
}
