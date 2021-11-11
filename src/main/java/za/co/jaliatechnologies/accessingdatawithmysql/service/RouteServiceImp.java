package za.co.jaliatechnologies.accessingdatawithmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.RouteDao;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.RouteDto;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.RouteEntity;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Route service imp.
 */
@Service
@Transactional
public class RouteServiceImp implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public RouteDto createRouteDescription(RouteDto routeDto) {
        RouteEntity creatingRouteEntityDesc = new RouteEntity();

        creatingRouteEntityDesc.setRoute_description(routeDto.getRoute_description());
        routeDao.save(creatingRouteEntityDesc);
        return routeDto;
    }

    @Override
    public List<RouteDto> getRouteId() {
        List<RouteEntity> routeIdList = (List<RouteEntity>) routeDao.findAll();
        List<RouteDto> routeDtoIdList = new ArrayList(Arrays.asList(routeIdList));
        return routeDtoIdList;
    }

}
