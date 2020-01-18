package com.ticketing;

import com.ticketing.dto.FlyingDTO;
import com.ticketing.entity.AirlineCompany;
import com.ticketing.entity.Airport;
import com.ticketing.entity.Flying;
import com.ticketing.entity.Route;
import com.ticketing.repository.AirlineCompanyRepository;
import com.ticketing.repository.AirportRepository;
import com.ticketing.repository.FlyingRepository;
import com.ticketing.repository.RouteRepository;
import com.ticketing.service.impl.FlyingServiceImpl;
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
public class FlyingServiceImplTest {

    @Mock
    private RouteRepository routeRepository;

    @Mock
    private FlyingRepository flyingRepository;

    @Mock
    private AirlineCompanyRepository airlineCompanyRepository;

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private FlyingServiceImpl flyingService;


    @Test
    public void addNewFlying_whenFlyingIsCorrectFormatShouldAddToDB() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setCompanyName("Airline Company 1");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setGeneralCenter("Region 1");

        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setAirportName("Airport 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setAirplaneHeight(1000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);

        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setTicketPrice(100D);
        flyingDTO.setQuota(100);

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        flyingService.addNewFlying(flyingDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addNewFlying_whenFlyingDTOIsNullShouldThrowException() {
        FlyingDTO flyingDTO = null;
        flyingService.addNewFlying(flyingDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addNewFlying_whenFlyingAirlineCompanyIdIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setAirportName("Airport 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setAirplaneHeight(1000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);

        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setFlyingRouteId(1L);

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);
        when(airlineCompanyRepository.findFirstById(null)).thenReturn(null);

        flyingService.addNewFlying(flyingDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addNewFlying_whenFlyingBoardingTimeIsNullShouldThrowException() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setCompanyName("Airline Company 1");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setGeneralCenter("Region 1");

        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setAirportName("Airport 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setAirplaneHeight(1000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);

        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setBoardingTime(null);
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setFlyingRouteId(1L);

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        flyingService.addNewFlying(flyingDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addNewFlying_whenFlyingDestinationTimeIsNullShouldThrowException() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setCompanyName("Airline Company 1");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setGeneralCenter("Region 1");

        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setAirportName("Airport 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setAirplaneHeight(1000);
        route.setAirplaneSpeed(1000);
        route.setDistance(1000);
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);

        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(null);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setFlyingRouteId(1L);

        when(routeRepository.findFirstById(1L)).thenReturn(route);
        when(airportRepository.findFirstById(1L)).thenReturn(boardingAirport);
        when(airportRepository.findFirstById(2L)).thenReturn(destinationAirport);
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        flyingService.addNewFlying(flyingDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addNewFlying_whenFlyingRouteIdIsNullShouldThrowException() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setCompanyName("Airline Company 1");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setGeneralCenter("Region 1");

        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setFlyingRouteId(1L);

        when(routeRepository.findFirstById(null)).thenReturn(null);
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        flyingService.addNewFlying(flyingDTO);
    }

    @Test
    public void findAll_whenRequestToFindAllEndPointShouldReturnFlyingDTOList() {
        List<Flying> flyingList = new ArrayList<>();

        AirlineCompany airlineCompanyOne = new AirlineCompany();
        airlineCompanyOne.setId(1L);
        airlineCompanyOne.setCreateDate(new Date());
        airlineCompanyOne.setCompanyName("Airline Company 1");
        airlineCompanyOne.setEmployeeCount(100);
        airlineCompanyOne.setGeneralCenter("Region 1");

        Airport boardingAirportOne = new Airport();
        boardingAirportOne.setId(1L);
        boardingAirportOne.setCreateDate(new Date());
        boardingAirportOne.setAirportLocation("Region 1");
        boardingAirportOne.setAirportName("Airport 1");

        Airport destinationAirportOne = new Airport();
        destinationAirportOne.setId(2L);
        destinationAirportOne.setCreateDate(new Date());
        destinationAirportOne.setAirportLocation("Region 2");
        destinationAirportOne.setAirportName("Airport 2");

        Route routeOne = new Route();
        routeOne.setId(1L);
        routeOne.setCreateDate(new Date());
        routeOne.setAirplaneHeight(1000);
        routeOne.setAirplaneSpeed(1000);
        routeOne.setDistance(1000);
        routeOne.setStartingPlace(boardingAirportOne);
        routeOne.setDestination(destinationAirportOne);

        Flying flyingOne = new Flying();
        flyingOne.setId(1L);
        flyingOne.setBoardingTime(new Date());
        flyingOne.setDestinationTime(new Date());
        flyingOne.setAirlineCompany(airlineCompanyOne);
        flyingOne.setFlyingRoute(routeOne);

        flyingList.add(flyingOne);

        AirlineCompany airlineCompanyTwo = new AirlineCompany();
        airlineCompanyTwo.setId(1L);
        airlineCompanyTwo.setCreateDate(new Date());
        airlineCompanyTwo.setCompanyName("Airline Company 1");
        airlineCompanyTwo.setEmployeeCount(100);
        airlineCompanyTwo.setGeneralCenter("Region 1");

        Airport boardingAirportTwo = new Airport();
        boardingAirportTwo.setId(1L);
        boardingAirportTwo.setCreateDate(new Date());
        boardingAirportTwo.setAirportLocation("Region 1");
        boardingAirportTwo.setAirportName("Airport 1");

        Airport destinationAirportTwo = new Airport();
        destinationAirportTwo.setId(2L);
        destinationAirportTwo.setCreateDate(new Date());
        destinationAirportTwo.setAirportLocation("Region 2");
        destinationAirportTwo.setAirportName("Airport 2");

        Route routeTwo = new Route();
        routeTwo.setId(1L);
        routeTwo.setCreateDate(new Date());
        routeTwo.setAirplaneHeight(1000);
        routeTwo.setAirplaneSpeed(1000);
        routeTwo.setDistance(1000);
        routeTwo.setStartingPlace(boardingAirportTwo);
        routeTwo.setDestination(destinationAirportTwo);

        Flying flyingTwo = new Flying();
        flyingTwo.setId(1L);
        flyingTwo.setBoardingTime(new Date());
        flyingTwo.setDestinationTime(new Date());
        flyingTwo.setAirlineCompany(airlineCompanyTwo);
        flyingTwo.setFlyingRoute(routeTwo);

        flyingList.add(flyingTwo);

        when(flyingRepository.findAll()).thenReturn(flyingList);

        List<FlyingDTO> flyingDTOList = flyingService.findAll();

        Assertions.assertThat(flyingList.size()).isEqualTo(flyingDTOList.size());
        Assertions.assertThat(flyingList.get(0).getAirlineCompany().getId()).isEqualTo(flyingDTOList.get(0).getAirlineCompanyId());
        Assertions.assertThat(flyingList.get(1).getFlyingRoute().getId()).isEqualTo(flyingDTOList.get(1).getFlyingRouteId());
    }

    @Test
    public void findAll_whenRequestToFindAllEndPointReturnEmptyList() {
        when(flyingRepository.findAll()).thenReturn(new ArrayList<>());
        List<FlyingDTO> flyingDTOListOne = flyingService.findAll();
        Assertions.assertThat(flyingDTOListOne).isEmpty();

        when(flyingRepository.findAll()).thenReturn(null);
        Assertions.assertThat(flyingDTOListOne).isEmpty();
    }

    @Test
    public void findAllActiveFlying_whenRequestToFindAllActiveFlyingEndPointReturnFlyingList() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);

        when(flyingRepository.findOneByBoardingTimeAfter(new Date())).thenReturn(null);

        List<FlyingDTO> flyingDTOList = new ArrayList<>();
        Assertions.assertThat(flyingDTOList).isEmpty();
    }

    @Test
    public void findAllActiveFlying_whenRequestToFindAllActiveFlyingEndPointReturnEmptyList() {
        when(flyingRepository.findOneByBoardingTimeAfter(new Date())).thenReturn(null);
        List<FlyingDTO> flyingDTOList = flyingService.findAllActiveFlying();
        Assertions.assertThat(flyingDTOList).isEmpty();
    }

    @Test
    public void findById_whenRequestToFindByIdEndPointReturnFlyingDTO() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);

        FlyingDTO flyingDTO = flyingService.findById(1L);

        Assertions.assertThat(flyingDTO).isNotNull();
        Assertions.assertThat(flyingDTO.getFlyingRouteId()).isEqualTo(route.getId());
    }

    @Test
    public void findById_whenFlyingIdNotFoundInDBThenReturnNull() {
        when(flyingRepository.findFirstById(2L)).thenReturn(null);
        FlyingDTO flyingDTO = flyingService.findById(2L);
        Assertions.assertThat(flyingDTO).isNull();
    }

    @Test
    public void findById_whenFlyingIdIsNullThenReturnNull() {
        when(flyingRepository.findFirstById(null)).thenReturn(null);
        FlyingDTO flyingDTO = flyingService.findById(null);
        Assertions.assertThat(flyingDTO).isNull();
    }

    @Test
    public void updateFlying_whenFlyingUpdateThenUpdateDB() throws Exception {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setBoardingTime(new Date());
        flying.setDestinationTime(new Date());
        flying.setAirlineCompany(airlineCompany);


        Airport boardingAirportUpdate = new Airport();
        boardingAirportUpdate.setId(4L);
        boardingAirportUpdate.setCreateDate(new Date());
        boardingAirportUpdate.setAirportName("Airport");
        boardingAirportUpdate.setAirportLocation("region 1");

        Airport destinationAirportUpdate = new Airport();
        destinationAirportUpdate.setId(5L);
        destinationAirportUpdate.setCreateDate(new Date());
        destinationAirportUpdate.setAirportLocation("region 2");
        destinationAirportUpdate.setAirportName("Airport 2");

        Route routeUpdate = new Route();
        routeUpdate.setId(3L);
        routeUpdate.setCreateDate(new Date());
        routeUpdate.setDestination(destinationAirportUpdate);
        routeUpdate.setStartingPlace(boardingAirportUpdate);
        routeUpdate.setDistance(1000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setAirplaneHeight(1000);

        AirlineCompany airlineCompanyUpdate = new AirlineCompany();
        airlineCompanyUpdate.setId(3L);
        airlineCompanyUpdate.setCreateDate(new Date());
        airlineCompanyUpdate.setGeneralCenter("center");
        airlineCompanyUpdate.setEmployeeCount(100);
        airlineCompanyUpdate.setCompanyName("name");

        FlyingDTO flyingUpdate = new FlyingDTO();
        flyingUpdate.setFlyingRouteId(3L);
        flyingUpdate.setBoardingTime(new Date());
        flyingUpdate.setDestinationTime(new Date());
        flyingUpdate.setAirlineCompanyId(3L);


        when(routeRepository.findFirstById(3L)).thenReturn(routeUpdate);
        when(airportRepository.findFirstById(4L)).thenReturn(boardingAirportUpdate);
        when(airportRepository.findFirstById(5L)).thenReturn(destinationAirportUpdate);
        when(airlineCompanyRepository.findFirstById(3L)).thenReturn(airlineCompanyUpdate);

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);

        flyingService.updateFlying(1L, flyingUpdate);
    }

    @Test
    public void updateFlying_whenFlyingBoardingTimeUpdateThenUpdateDB() throws Exception {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);


        Airport boardingAirportUpdate = new Airport();
        boardingAirportUpdate.setId(4L);
        boardingAirportUpdate.setCreateDate(new Date());
        boardingAirportUpdate.setAirportName("Airport");
        boardingAirportUpdate.setAirportLocation("region 1");

        Airport destinationAirportUpdate = new Airport();
        destinationAirportUpdate.setId(5L);
        destinationAirportUpdate.setCreateDate(new Date());
        destinationAirportUpdate.setAirportLocation("region 2");
        destinationAirportUpdate.setAirportName("Airport 2");

        Route routeUpdate = new Route();
        routeUpdate.setId(3L);
        routeUpdate.setCreateDate(new Date());
        routeUpdate.setDestination(destinationAirportUpdate);
        routeUpdate.setStartingPlace(boardingAirportUpdate);
        routeUpdate.setDistance(1000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setAirplaneHeight(1000);

        AirlineCompany airlineCompanyUpdate = new AirlineCompany();
        airlineCompanyUpdate.setId(3L);
        airlineCompanyUpdate.setCreateDate(new Date());
        airlineCompanyUpdate.setGeneralCenter("center");
        airlineCompanyUpdate.setEmployeeCount(100);
        airlineCompanyUpdate.setCompanyName("name");

        FlyingDTO flyingUpdate = new FlyingDTO();
        flyingUpdate.setFlyingRouteId(3L);
        flyingUpdate.setBoardingTime(new Date());
        flyingUpdate.setAirlineCompanyId(3L);
        flyingUpdate.setDestinationTime(new Date());

        when(routeRepository.findFirstById(3L)).thenReturn(routeUpdate);
        when(airportRepository.findFirstById(4L)).thenReturn(boardingAirportUpdate);
        when(airportRepository.findFirstById(5L)).thenReturn(destinationAirportUpdate);
        when(airlineCompanyRepository.findFirstById(3L)).thenReturn(airlineCompanyUpdate);

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);

        flyingService.updateFlying(1L, flyingUpdate);
    }

    @Test
    public void updateFlying_whenFlyingDestinationTimeUpdateThenUpdateDB() throws Exception {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);


        Airport boardingAirportUpdate = new Airport();
        boardingAirportUpdate.setId(4L);
        boardingAirportUpdate.setCreateDate(new Date());
        boardingAirportUpdate.setAirportName("Airport");
        boardingAirportUpdate.setAirportLocation("region 1");

        Airport destinationAirportUpdate = new Airport();
        destinationAirportUpdate.setId(5L);
        destinationAirportUpdate.setCreateDate(new Date());
        destinationAirportUpdate.setAirportLocation("region 2");
        destinationAirportUpdate.setAirportName("Airport 2");

        Route routeUpdate = new Route();
        routeUpdate.setId(3L);
        routeUpdate.setCreateDate(new Date());
        routeUpdate.setDestination(destinationAirportUpdate);
        routeUpdate.setStartingPlace(boardingAirportUpdate);
        routeUpdate.setDistance(1000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setAirplaneHeight(1000);

        AirlineCompany airlineCompanyUpdate = new AirlineCompany();
        airlineCompanyUpdate.setId(3L);
        airlineCompanyUpdate.setCreateDate(new Date());
        airlineCompanyUpdate.setGeneralCenter("center");
        airlineCompanyUpdate.setEmployeeCount(100);
        airlineCompanyUpdate.setCompanyName("name");

        FlyingDTO flyingUpdate = new FlyingDTO();
        flyingUpdate.setFlyingRouteId(3L);
        flyingUpdate.setBoardingTime(new Date());
        flyingUpdate.setAirlineCompanyId(3L);
        flyingUpdate.setDestinationTime(new Date());

        when(routeRepository.findFirstById(3L)).thenReturn(routeUpdate);
        when(airportRepository.findFirstById(4L)).thenReturn(boardingAirportUpdate);
        when(airportRepository.findFirstById(5L)).thenReturn(destinationAirportUpdate);
        when(airlineCompanyRepository.findFirstById(3L)).thenReturn(airlineCompanyUpdate);

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);

        flyingService.updateFlying(1L, flyingUpdate);
    }

    @Test(expected = NullPointerException.class)
    public void updateFlying_whenFlyingDTOIsNullShouldThrowException() throws Exception {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);

        FlyingDTO flyingDTOUpdate = null;
        when(flyingRepository.findFirstById(1L)).thenReturn(flying);

        flyingService.updateFlying(1L, flyingDTOUpdate);
    }

    @Test(expected = NullPointerException.class)
    public void updateFlying_whenFlyingIdIsNullShouldThrowException() throws Exception {
        Airport boardingAirportUpdate = new Airport();
        boardingAirportUpdate.setId(4L);
        boardingAirportUpdate.setCreateDate(new Date());
        boardingAirportUpdate.setAirportName("Airport");
        boardingAirportUpdate.setAirportLocation("region 1");

        Airport destinationAirportUpdate = new Airport();
        destinationAirportUpdate.setId(5L);
        destinationAirportUpdate.setCreateDate(new Date());
        destinationAirportUpdate.setAirportLocation("region 2");
        destinationAirportUpdate.setAirportName("Airport 2");

        Route routeUpdate = new Route();
        routeUpdate.setId(3L);
        routeUpdate.setCreateDate(new Date());
        routeUpdate.setDestination(destinationAirportUpdate);
        routeUpdate.setStartingPlace(boardingAirportUpdate);
        routeUpdate.setDistance(1000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setAirplaneHeight(1000);

        AirlineCompany airlineCompanyUpdate = new AirlineCompany();
        airlineCompanyUpdate.setId(3L);
        airlineCompanyUpdate.setCreateDate(new Date());
        airlineCompanyUpdate.setGeneralCenter("center");
        airlineCompanyUpdate.setEmployeeCount(100);
        airlineCompanyUpdate.setCompanyName("name");

        FlyingDTO flyingUpdate = new FlyingDTO();
        flyingUpdate.setFlyingRouteId(3L);
        flyingUpdate.setBoardingTime(new Date());
        flyingUpdate.setAirlineCompanyId(3L);
        flyingUpdate.setDestinationTime(new Date());

        when(flyingRepository.findFirstById(null)).thenReturn(null);
        flyingService.updateFlying(2L, flyingUpdate);
    }

    @Test(expected = NullPointerException.class)
    public void updateFlying_whenFlyingIdNotFoundShouldThrowException() throws Exception {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);


        Airport boardingAirportUpdate = new Airport();
        boardingAirportUpdate.setId(4L);
        boardingAirportUpdate.setCreateDate(new Date());
        boardingAirportUpdate.setAirportName("Airport");
        boardingAirportUpdate.setAirportLocation("region 1");

        Airport destinationAirportUpdate = new Airport();
        destinationAirportUpdate.setId(5L);
        destinationAirportUpdate.setCreateDate(new Date());
        destinationAirportUpdate.setAirportLocation("region 2");
        destinationAirportUpdate.setAirportName("Airport 2");

        Route routeUpdate = new Route();
        routeUpdate.setId(3L);
        routeUpdate.setCreateDate(new Date());
        routeUpdate.setDestination(destinationAirportUpdate);
        routeUpdate.setStartingPlace(boardingAirportUpdate);
        routeUpdate.setDistance(1000);
        routeUpdate.setAirplaneSpeed(1000);
        routeUpdate.setAirplaneHeight(1000);

        AirlineCompany airlineCompanyUpdate = new AirlineCompany();
        airlineCompanyUpdate.setId(3L);
        airlineCompanyUpdate.setCreateDate(new Date());
        airlineCompanyUpdate.setGeneralCenter("center");
        airlineCompanyUpdate.setEmployeeCount(100);
        airlineCompanyUpdate.setCompanyName("name");

        FlyingDTO flyingUpdate = new FlyingDTO();
        flyingUpdate.setFlyingRouteId(3L);
        flyingUpdate.setBoardingTime(new Date());
        flyingUpdate.setAirlineCompanyId(3L);
        flyingUpdate.setDestinationTime(new Date());

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);
        flyingService.updateFlying(2L, flyingUpdate);
    }

    @Test
    public void deleteByFlyingId_whenFlyingDeleteThenDeleteFromDB() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);
        flyingService.deleteByFlyingId(1L);
    }

    @Test(expected = NullPointerException.class)
    public void deleteByFlyingId_whenFlyingIdNotFoundShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);
        flyingService.deleteByFlyingId(2L);
    }

    @Test(expected = NullPointerException.class)
    public void deleteByFlyingId_whenFlyingIdIsNullShouldThrowException() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportName("Airport");
        boardingAirport.setAirportLocation("region 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("region 2");
        destinationAirport.setAirportName("Airport 2");

        Route route = new Route();
        route.setId(1L);
        route.setCreateDate(new Date());
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("center");
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("name");

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setFlyingRoute(route);
        flying.setDestinationTime(new Date(11111111L));
        flying.setBoardingTime(new Date());
        flying.setAirlineCompany(airlineCompany);

        when(flyingRepository.findFirstById(1L)).thenReturn(flying);
        flyingService.deleteByFlyingId(null);
    }
}