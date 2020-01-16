package com.ticketing;


import com.ticketing.dto.AirportDTO;
import com.ticketing.entity.Airport;
import com.ticketing.repository.AirportRepository;
import com.ticketing.service.impl.AirportServiceImpl;
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
public class AirportServiceImplTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportServiceImpl airportService;


    @Test
    public void addAirport_whenAirportIsCorrectFormatShouldAddToDB() {
        AirportDTO newAirport = new AirportDTO();
        newAirport.setAirportLocation("IST");
        newAirport.setAirportName("IST Hava Limani");
        airportService.addAirport(newAirport);
    }

    @Test(expected = NullPointerException.class)
    public void addAirport_whenAirportDTOIsNullShouldThrowException() {
        AirportDTO newAirport = null;
        airportService.addAirport(newAirport);
    }

    @Test(expected = NullPointerException.class)
    public void addAirport_whenAirportLocationIsNullShouldThrowException() {
        AirportDTO newAirport = new AirportDTO();
        newAirport.setAirportLocation(null);
        newAirport.setAirportName("IST Hava Limani");
        airportService.addAirport(newAirport);
    }

    @Test(expected = NullPointerException.class)
    public void addAirport_whenAirportNameIsNullShouldThrowException() {
        AirportDTO newAirport = new AirportDTO();
        newAirport.setAirportLocation("IST");
        newAirport.setAirportName(null);
        airportService.addAirport(newAirport);
    }

    @Test
    public void findAllAirport_whenRequestToFindAllEndPointShouldReturnAirportDTOList() {
        List<Airport> airportList = new ArrayList<>();

        Airport airportOne = new Airport();
        airportOne.setId(1L);
        airportOne.setAirportName("Airport 1");
        airportOne.setAirportLocation("1. Region");
        airportOne.setCreateDate(new Date());
        airportList.add(airportOne);

        Airport airportTwo = new Airport();
        airportTwo.setId(2L);
        airportTwo.setAirportName("Airport 2");
        airportTwo.setAirportLocation("2. Region");
        airportTwo.setCreateDate(new Date());
        airportList.add(airportTwo);

        Airport airportThree = new Airport();
        airportThree.setId(3L);
        airportThree.setAirportName("Airport 3");
        airportThree.setAirportLocation("3. Region");
        airportThree.setCreateDate(new Date());
        airportList.add(airportThree);

        when(airportRepository.findAll()).thenReturn(airportList);
        List<AirportDTO> airportDTOList = airportService.findAllAirport();


        Assertions.assertThat(airportList.size()).isEqualTo(airportDTOList.size());
        Assertions.assertThat(airportList).isNotEmpty();

        Assertions.assertThat(airportList.get(0).getAirportName()).isEqualTo(airportDTOList.get(0).getAirportName());
        Assertions.assertThat(airportList.get(0).getAirportLocation()).isEqualTo(airportDTOList.get(0).getAirportLocation());

        Assertions.assertThat(airportList.get(1).getAirportName()).isEqualTo(airportDTOList.get(1).getAirportName());
        Assertions.assertThat(airportList.get(1).getAirportLocation()).isEqualTo(airportDTOList.get(1).getAirportLocation());

        Assertions.assertThat(airportList.get(2).getAirportName()).isEqualTo(airportDTOList.get(2).getAirportName());
        Assertions.assertThat(airportList.get(2).getAirportLocation()).isEqualTo(airportDTOList.get(2).getAirportLocation());
    }

    @Test
    public void findAllAirport_whenRequestToFindAllEndPointReturnEmptyList() {
        List<Airport> airportList = new ArrayList<>();
        when(airportRepository.findAll()).thenReturn(airportList);
        List<AirportDTO> airportDTOList = airportService.findAllAirport();
        Assertions.assertThat(airportDTOList).isEmpty();
    }

    @Test
    public void findByAirportId_whenRequestToFindByIdEndPointReturnAirportDTO() {
        Airport newAirport = new Airport();
        newAirport.setId(1L);
        newAirport.setAirportName("Airport 1");
        newAirport.setAirportLocation("1. Region");
        newAirport.setCreateDate(new Date());

        when(airportRepository.findFirstById(1L)).thenReturn(newAirport);

        AirportDTO airportDTO = airportService.findByAirportId(1L);
        Assertions.assertThat(airportDTO).isNotNull();
        Assertions.assertThat(airportDTO.getAirportName()).isEqualTo(newAirport.getAirportName());
    }

    @Test
    public void findByAirportId_whenAirportIdNotFoundInDBThenReturnNull() {
        Airport newAirport = new Airport();
        newAirport.setId(1L);
        newAirport.setAirportName("Airport 1");
        newAirport.setAirportLocation("1. Region");
        newAirport.setCreateDate(new Date());

        when(airportRepository.findFirstById(1L)).thenReturn(newAirport);

        AirportDTO airportDTO = airportService.findByAirportId(2L);
        Assertions.assertThat(airportDTO).isNull();
    }

    @Test
    public void findByAirportId_whenAirportIdIsNullThenReturnNull() {
        when(airportRepository.findFirstById(1L)).thenReturn(null);
        AirportDTO airportDTO = airportService.findByAirportId(1L);
        Assertions.assertThat(airportDTO).isNull();
    }

    @Test
    public void updateAirport_whenAirportUpdateThenUpdateDB() {
        Airport newAirport = new Airport();
        newAirport.setId(1L);
        newAirport.setCreateDate(new Date());
        newAirport.setAirportLocation("1. Region");
        newAirport.setAirportName("Airport 1");

        when(airportRepository.findFirstById(1L)).thenReturn(newAirport);

        AirportDTO updateAirport = new AirportDTO();
        updateAirport.setAirportLocation("1. Region Update");
        updateAirport.setAirportName("Airport 1 Update");

        airportService.updateAirport(1L, updateAirport);
    }

    @Test
    public void updateAirport_whenAirportNameUpdateThenUpdateDB() {
        Airport newAirport = new Airport();
        newAirport.setId(1L);
        newAirport.setCreateDate(new Date());
        newAirport.setAirportLocation("1. Region");
        newAirport.setAirportName("Airport 1");

        when(airportRepository.findFirstById(1L)).thenReturn(newAirport);

        AirportDTO updateAirport = new AirportDTO();
        updateAirport.setAirportLocation("1. Region");
        updateAirport.setAirportName("Airport 1 Update");

        airportService.updateAirport(1L, updateAirport);
    }

    @Test
    public void updateAirport_whenAirportLocationUpdateThenUpdateDB() {
        Airport newAirport = new Airport();
        newAirport.setId(1L);
        newAirport.setCreateDate(new Date());
        newAirport.setAirportLocation("1. Region");
        newAirport.setAirportName("Airport 1");

        when(airportRepository.findFirstById(1L)).thenReturn(newAirport);

        AirportDTO updateAirport = new AirportDTO();
        updateAirport.setAirportLocation("1. Region Update");
        updateAirport.setAirportName("Airport 1");

        airportService.updateAirport(1L, updateAirport);
    }

    @Test(expected = NullPointerException.class)
    public void updateAirport_whenAirportDTOIsNullShouldThrowException() {
        Airport newAirport = new Airport();
        newAirport.setId(1L);
        newAirport.setCreateDate(new Date());
        newAirport.setAirportName("Airport 1");
        newAirport.setAirportLocation("1. Region");

        when(airportRepository.findFirstById(1L)).thenReturn(newAirport);

        airportService.updateAirport(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void updateAirport_whenAirportIdIsNullShouldThrowException() {
        AirportDTO newAirportDTO = new AirportDTO();
        newAirportDTO.setAirportLocation("1. Region Update");
        newAirportDTO.setAirportName("Airport 1 Update");

        when(airportRepository.findFirstById(null)).thenReturn(null);
        airportService.updateAirport(null, newAirportDTO);
    }

    @Test(expected = NullPointerException.class)
    public void updateAirport_whenAirportIdNotFoundShouldThrowException() {
        when(airportRepository.findFirstById(1L)).thenReturn(null);

        AirportDTO newAirportDTO = new AirportDTO();
        newAirportDTO.setAirportLocation("1. Region Update");
        newAirportDTO.setAirportName("Airport 1 Update");
        airportService.updateAirport(1L, newAirportDTO);
    }

    @Test
    public void deleteAirport_whenAirportDeleteThenDeleteFromDB() {
        Airport airport = new Airport();
        airport.setId(1L);
        airport.setCreateDate(new Date());
        airport.setAirportName("Airport 1");
        airport.setAirportLocation("1. Region");

        when(airportRepository.findFirstById(1L)).thenReturn(airport);
        airportService.deleteAirport(1L);
    }

    @Test(expected = NullPointerException.class)
    public void deleteAirport_whenAirportIdNotFoundShouldThrowException() {
        when(airportRepository.findFirstById(1L)).thenReturn(null);
        airportService.deleteAirport(1L);
    }

    @Test(expected = NullPointerException.class)
    public void deleteAirport_whenAirportIdIsNullShouldThrowException() {
        when(airportRepository.findFirstById(null)).thenReturn(null);
        airportService.deleteAirport(null);
    }
}
