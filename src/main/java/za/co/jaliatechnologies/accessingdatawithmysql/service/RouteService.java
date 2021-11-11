package za.co.jaliatechnologies.accessingdatawithmysql.service;

import za.co.jaliatechnologies.accessingdatawithmysql.dto.RouteDto;

import java.util.List;

/**
 * The interface Route service.
 */
public interface RouteService {

    /**
     * Creates a route description
     *
     * @param routeDto contains the information of the route description
     * @return the RouteDto which contains the route description
     */
    RouteDto createRouteDescription(RouteDto routeDto);

    /**
     * Gets the route id to be used by the algorithm to plot the route on a map
     *
     * @return a list of available route ids
     */
    List<RouteDto> getRouteId();
}
