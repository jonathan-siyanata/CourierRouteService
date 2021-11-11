package za.co.jaliatechnologies.accessingdatawithmysql.geocoding.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoundsDto {

    @JsonProperty("northeast")
    private NorthEastDto northEast;

    @JsonProperty("southwest")
    private SouthWestDto southWest;

    public BoundsDto(NorthEastDto northEast, SouthWestDto southWest) {
        this.northEast = northEast;
        this.southWest = southWest;
    }

    public BoundsDto() {
    }

    public NorthEastDto getNorthEast() {
        return northEast;
    }

    public void setNorthEast(NorthEastDto northEastDto) {
        this.northEast = northEastDto;
    }

    public SouthWestDto getSouthWest() {
        return southWest;
    }

    public void setSouthWest(SouthWestDto southWestDto) {
        this.southWest = southWestDto;
    }
}
