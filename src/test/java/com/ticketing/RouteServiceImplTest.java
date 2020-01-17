package com.ticketing;

import com.ticketing.dto.RouteDTO;
import com.ticketing.entity.Airport;
import com.ticketing.entity.Route;
import com.ticketing.repository.AirportRepository;
import com.ticketing.repository.RouteRepository;
import com.ticketing.service.impl.RouteServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RouteServiceImplTest {


    @Mock
    private RouteRepository routeRepository;

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private RouteServiceImpl routeService;


    @Test
    public void addRoute_whenRouteIsCorrectFormatShouldAddToDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");


        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setBoardingAirportId(1L);
        routeDTO.setDestinationAirportId(2L);
        routeDTO.setDistance(1000);
        routeDTO.setAirplaneSpeed(800);
        routeDTO.setAirplaneHeight(2500);

        routeService.addRoute(routeDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addRoute_whenRouteDTOIsNullShouldThrowException() {
        RouteDTO routeDTO = null;
        routeService.addRoute(routeDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addRoute_whenRouteBoardingAirportIdIsNullShouldThrowException() {
        Airport boardingAirport = null;

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");


        when(airportRepository.findFirstById(null)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setBoardingAirportId(1L);
        routeDTO.setDestinationAirportId(2L);
        routeDTO.setDistance(1000);
        routeDTO.setAirplaneSpeed(800);
        routeDTO.setAirplaneHeight(2500);

        routeService.addRoute(routeDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addRoute_whenRouteDestinationAirportIdIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");

        Airport destinationAirport = null;


        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(null)).thenReturn(destinationAirport);

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setBoardingAirportId(1L);
        routeDTO.setDestinationAirportId(2L);
        routeDTO.setDistance(1000);
        routeDTO.setAirplaneSpeed(800);
        routeDTO.setAirplaneHeight(2500);

        routeService.addRoute(routeDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addRoute_whenRouteDistanceIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");


        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setBoardingAirportId(1L);
        routeDTO.setDestinationAirportId(2L);
        routeDTO.setDistance(null);
        routeDTO.setAirplaneSpeed(800);
        routeDTO.setAirplaneHeight(2500);

        routeService.addRoute(routeDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addRoute_whenRouteAirplaneSpeedIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");


        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setBoardingAirportId(1L);
        routeDTO.setDestinationAirportId(2L);
        routeDTO.setDistance(1000);
        routeDTO.setAirplaneSpeed(null);
        routeDTO.setAirplaneHeight(2500);

        routeService.addRoute(routeDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addRoute_whenRouteAirplaneHeightIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");


        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setBoardingAirportId(1L);
        routeDTO.setDestinationAirportId(2L);
        routeDTO.setDistance(1000);
        routeDTO.setAirplaneSpeed(800);
        routeDTO.setAirplaneHeight(null);

        routeService.addRoute(routeDTO);
    }

    @Test
    public void findAllRoute_whenRequestToFindAllEndPointShouldReturnRouteDTOList() {
        List<Route> routeList = new ArrayList<>();

        Airport boardingAirportForRouteOne = new Airport();
        boardingAirportForRouteOne.setId(1L);
        boardingAirportForRouteOne.setCreateDate(new Date());
        boardingAirportForRouteOne.setAirportLocation("Boarding Region 1");
        boardingAirportForRouteOne.setAirportName("Boarding Airport 1");

        Airport destinationAirportForRouteOne = new Airport();
        destinationAirportForRouteOne.setId(2L);
        destinationAirportForRouteOne.setCreateDate(new Date());
        destinationAirportForRouteOne.setAirportLocation("Destination Region 1");
        destinationAirportForRouteOne.setAirportName("Destination Airport 1");

        Airport boardingAirportForRouteTwo = new Airport();
        boardingAirportForRouteTwo.setId(3L);
        boardingAirportForRouteTwo.setCreateDate(new Date());
        boardingAirportForRouteTwo.setAirportLocation("Boarding Region 2");
        boardingAirportForRouteTwo.setAirportName("Boarding Airport 2");

        Airport destinationAirportForRouteTwo = new Airport();
        destinationAirportForRouteTwo.setId(4L);
        destinationAirportForRouteTwo.setCreateDate(new Date());
        destinationAirportForRouteTwo.setAirportLocation("Destination Region 2");
        destinationAirportForRouteTwo.setAirportName("Destination Airport 2");

        Airport boardingAirportForRouteThree = new Airport();
        boardingAirportForRouteThree.setId(5L);
        boardingAirportForRouteThree.setCreateDate(new Date());
        boardingAirportForRouteThree.setAirportLocation("BoardingRegion 3");
        boardingAirportForRouteThree.setAirportName("Boarding Airport 3");

        Airport destinationAirportForRouteThree = new Airport();
        destinationAirportForRouteThree.setId(6L);
        destinationAirportForRouteThree.setCreateDate(new Date());
        destinationAirportForRouteThree.setAirportLocation("Destination Region 3");
        destinationAirportForRouteThree.setAirportName("Destination Airport 3");

        Route routeOne = new Route();
        routeOne.setId(1L);
        routeOne.setStartingPlace(boardingAirportForRouteOne);
        routeOne.setDestination(destinationAirportForRouteOne);
        routeOne.setDistance(1000);
        routeOne.setCreateDate(new Date());
        routeOne.setAirplaneSpeed(2000);
        routeOne.setAirplaneHeight(1000);
        routeList.add(routeOne);

        Route routeTwo = new Route();
        routeTwo.setId(2L);
        routeTwo.setStartingPlace(boardingAirportForRouteTwo);
        routeTwo.setDestination(destinationAirportForRouteTwo);
        routeTwo.setDistance(1100);
        routeTwo.setCreateDate(new Date());
        routeTwo.setAirplaneSpeed(2100);
        routeTwo.setAirplaneHeight(1100);
        routeList.add(routeTwo);

        Route routeThree = new Route();
        routeThree.setId(2L);
        routeThree.setStartingPlace(boardingAirportForRouteThree);
        routeThree.setDestination(destinationAirportForRouteThree);
        routeThree.setDistance(1200);
        routeThree.setCreateDate(new Date());
        routeThree.setAirplaneSpeed(2200);
        routeThree.setAirplaneHeight(1200);
        routeList.add(routeThree);

        when(routeRepository.findAll()).thenReturn(routeList);

        List<RouteDTO> routeDTOList = routeService.findAllRoute();

        Assertions.assertThat(routeDTOList).isNotEmpty();
        Assertions.assertThat(routeDTOList.get(0).getBoardingAirportId()).isEqualTo(routeList.get(0).getStartingPlace().getId());
        Assertions.assertThat(routeDTOList.get(0).getDestinationAirportId()).isEqualTo(routeList.get(0).getDestination().getId());

        Assertions.assertThat(routeDTOList.get(1).getBoardingAirportId()).isEqualTo(routeList.get(1).getStartingPlace().getId());
        Assertions.assertThat(routeDTOList.get(1).getDestinationAirportId()).isEqualTo(routeList.get(1).getDestination().getId());

        Assertions.assertThat(routeDTOList.get(2).getBoardingAirportId()).isEqualTo(routeList.get(2).getStartingPlace().getId());
        Assertions.assertThat(routeDTOList.get(2).getDestinationAirportId()).isEqualTo(routeList.get(2).getDestination().getId());
    }

    @Test
    public void findAllRoute_whenRequestToFindAllEndPointReturnEmptyList() {
        List<Route> routeList = null;
        when(routeRepository.findAll()).thenReturn(routeList);

        List<RouteDTO> routeDTOList = routeService.findAllRoute();
        Assertions.assertThat(routeDTOList).isEmpty();
    }

    @Test
    public void findByRouteId_whenRequestToFindByIdEndPointReturnRouteDTO() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Boarding Region 1");
        boardingAirport.setAirportName("Boarding Airport 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Destination Region 1");
        destinationAirport.setAirportName("Destination Airport 1");

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setDistance(1000);
        route.setCreateDate(new Date());
        route.setAirplaneSpeed(2000);
        route.setAirplaneHeight(1000);

        when(routeRepository.findFirstById(1L)).thenReturn(route);

        RouteDTO routeDTO = routeService.findByRouteId(1L);
        Assertions.assertThat(routeDTO.getDestinationAirportId()).isEqualTo(route.getDestination().getId());
        Assertions.assertThat(routeDTO.getBoardingAirportId()).isEqualTo(route.getStartingPlace().getId());
    }

    @Test
    public void findByRouteId_whenRouteIdNotFoundInDBThenReturnNull() {
        when(routeRepository.findFirstById(1L)).thenReturn(null);
        RouteDTO routeDTO = routeService.findByRouteId(1L);
        Assertions.assertThat(routeDTO).isNull();
    }

    @Test
    public void findByRouteId_whenRouteIdIsNullThenReturnNull() {
        when(routeRepository.findFirstById(null)).thenReturn(null);
        RouteDTO routeDTO = routeService.findByRouteId(null);
        Assertions.assertThat(routeDTO).isNull();
    }

    @Test
    public void updateRoute_whenRouteUpdateThenUpdateDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);

        Airport boardingAirportUpdate = new Airport();
        boardingAirportUpdate.setId(3L);
        boardingAirportUpdate.setAirportName("Airport 3");
        boardingAirportUpdate.setAirportLocation("Region 3");
        boardingAirportUpdate.setCreateDate(new Date());

        Airport destinationAirportUpdate = new Airport();
        destinationAirportUpdate.setId(4L);
        destinationAirportUpdate.setAirportName("Airport 4");
        destinationAirportUpdate.setAirportLocation("Region 4");
        destinationAirportUpdate.setCreateDate(new Date());

        when(airportRepository.findFirstById(3L)).thenReturn(boardingAirportUpdate);
        when(airportRepository.findFirstById(4L)).thenReturn(destinationAirportUpdate);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setId(1L);
        routeUpdate.setBoardingAirportId(3L);
        routeUpdate.setDestinationAirportId(4L);
        routeUpdate.setAirplaneHeight(2000);
        routeUpdate.setAirplaneSpeed(2000);
        routeUpdate.setDistance(2000);
        routeUpdate.setCreateDate(new Date());

        routeService.updateRoute(1L, routeUpdate);

    }

    @Test
    public void updateRoute_whenRouteBoardingAirportIdUpdateThenUpdateDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);

        Airport boardingAirportUpdate = new Airport();
        boardingAirportUpdate.setId(3L);
        boardingAirportUpdate.setAirportName("Airport 3");
        boardingAirportUpdate.setAirportLocation("Region 3");
        boardingAirportUpdate.setCreateDate(new Date());

        when(airportRepository.findFirstById(3L)).thenReturn(boardingAirportUpdate);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setBoardingAirportId(3L);
        routeUpdate.setDestinationAirportId(2L);
        routeUpdate.setAirplaneHeight(2000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setDistance(1000);

        routeService.updateRoute(1L, routeUpdate);
    }

    @Test
    public void updateRoute_whenRouteDestinationAirportIdUpdateThenUpdateDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);

        Airport destinationAirportUpdate = new Airport();
        destinationAirportUpdate.setId(4L);
        destinationAirportUpdate.setAirportName("Airport 4");
        destinationAirportUpdate.setAirportLocation("Region 4");
        destinationAirportUpdate.setCreateDate(new Date());

        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(4L)).thenReturn(destinationAirportUpdate);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setBoardingAirportId(1L);
        routeUpdate.setDestinationAirportId(4L);
        routeUpdate.setAirplaneHeight(2000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setDistance(1000);

        routeService.updateRoute(1L, routeUpdate);
    }

    @Test
    public void updateRoute_whenRouteAirplaneSpeedUpdateThenUpdateDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setBoardingAirportId(1L);
        routeUpdate.setDestinationAirportId(2L);
        routeUpdate.setAirplaneHeight(2000);
        routeUpdate.setAirplaneSpeed(2000);
        routeUpdate.setDistance(1000);

        routeService.updateRoute(1L, routeUpdate);
    }

    @Test
    public void updateRoute_whenRouteAirplaneHeightUpdateThenUpdateDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setBoardingAirportId(1L);
        routeUpdate.setDestinationAirportId(2L);
        routeUpdate.setAirplaneHeight(1000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setDistance(1000);

        routeService.updateRoute(1L, routeUpdate);
    }

    @Test
    public void updateRoute_whenRouteDistanceUpdateThenUpdateDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setBoardingAirportId(1L);
        routeUpdate.setDestinationAirportId(2L);
        routeUpdate.setAirplaneHeight(2000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setDistance(2000);

        routeService.updateRoute(1L, routeUpdate);
    }

    @Test(expected = NullPointerException.class)
    public void updateRoute_whenRouteDTOIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeUpdate = null;
        routeService.updateRoute(1L, routeUpdate);
    }

    @Test(expected = NullPointerException.class)
    public void updateRoute_whenRouteIdIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(null)).thenReturn(null);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setBoardingAirportId(1L);
        routeUpdate.setDestinationAirportId(2L);
        routeUpdate.setAirplaneHeight(2000);
        routeUpdate.setAirplaneSpeed(2000);
        routeUpdate.setDistance(1000);

        routeService.updateRoute(null, routeUpdate);
    }

    @Test(expected = NullPointerException.class)
    public void updateRoute_whenRouteIdNotFoundShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);

        RouteDTO routeUpdate = new RouteDTO();
        routeUpdate.setBoardingAirportId(1L);
        routeUpdate.setDestinationAirportId(2L);
        routeUpdate.setAirplaneHeight(2000);
        routeUpdate.setAirplaneSpeed(2000);
        routeUpdate.setDistance(1000);

        routeService.updateRoute(2L, routeUpdate);
    }

    @Test
    public void deleteRoute_whenRouteDeleteThenDeleteFromDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);

        routeService.deleteRoute(1L);

    }

    @Test(expected = NullPointerException.class)
    public void deleteRoute_whenRouteIdNotFoundShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(1L)).thenReturn(route);

        routeService.deleteRoute(2L);
    }

    @Test(expected = NullPointerException.class)
    public void deleteRoute_whenRouteIdIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setAirportName("Airport 1");
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setCreateDate(new Date());

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setAirportName("Airport 2");
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setCreateDate(new Date());

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        route.setAirplaneHeight(2000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setCreateDate(new Date());

        when(routeRepository.findFirstById(null)).thenReturn(null);

        routeService.deleteRoute(null);
    }
}
