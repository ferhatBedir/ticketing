package com.ticketing;


import com.ticketing.dto.AirlineCompanyDTO;
import com.ticketing.entity.AirlineCompany;
import com.ticketing.repository.AirlineCompanyRepository;
import com.ticketing.service.impl.AirlineCompanyServiceImpl;
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
public class AirlineCompanyServiceImplTest {

    @Mock
    private AirlineCompanyRepository airlineCompanyRepository;

    @InjectMocks
    private AirlineCompanyServiceImpl airlineCompanyService;


    @Test
    public void addAirlineCompany_whenAirportLineIsCorrectFormatShouldAddToDB() {
        AirlineCompanyDTO airlineCompanyDTO = new AirlineCompanyDTO();
        airlineCompanyDTO.setId(1L);
        airlineCompanyDTO.setGeneralCenter("Region 1");
        airlineCompanyDTO.setEmployeeCount(100);
        airlineCompanyDTO.setCompanyName("Airline Company");
        airlineCompanyService.addAirlineCompany(airlineCompanyDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addAirlineCompany_whenAirportLineIsNullShouldThrowException() {
        AirlineCompanyDTO airlineCompanyDTO = null;
        airlineCompanyService.addAirlineCompany(airlineCompanyDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addAirlineCompany_whenAirlineCompanyNameIsNullShouldThrowException() {
        AirlineCompanyDTO airlineCompanyDTO = new AirlineCompanyDTO();
        airlineCompanyDTO.setCompanyName(null);
        airlineCompanyDTO.setEmployeeCount(100);
        airlineCompanyDTO.setGeneralCenter("Region 1");
        airlineCompanyService.addAirlineCompany(airlineCompanyDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addAirlineCompany_whenAirlineEmployeeCountIsNullShouldThrowException() {
        AirlineCompanyDTO airlineCompanyDTO = new AirlineCompanyDTO();
        airlineCompanyDTO.setCompanyName("Airline Name");
        airlineCompanyDTO.setEmployeeCount(null);
        airlineCompanyDTO.setGeneralCenter("Region 1");
        airlineCompanyService.addAirlineCompany(airlineCompanyDTO);
    }

    @Test(expected = NullPointerException.class)
    public void addAirlineCompany_whenAirlineGeneralCenterIsNullShouldThrowException() {
        AirlineCompanyDTO airlineCompanyDTO = new AirlineCompanyDTO();
        airlineCompanyDTO.setCompanyName("Airline Name");
        airlineCompanyDTO.setEmployeeCount(100);
        airlineCompanyDTO.setGeneralCenter(null);
        airlineCompanyService.addAirlineCompany(airlineCompanyDTO);
    }

    @Test
    public void findAllAirlineCompany_whenRequestToFindAllEndPointShouldReturnAirportDTOList() {
        List<AirlineCompany> airlineCompanyList = new ArrayList<>();

        AirlineCompany airlineCompanyOne = new AirlineCompany();
        airlineCompanyOne.setId(1L);
        airlineCompanyOne.setEmployeeCount(100);
        airlineCompanyOne.setCompanyName("Airline 1");
        airlineCompanyOne.setGeneralCenter("Region 1");
        airlineCompanyOne.setCreateDate(new Date());
        airlineCompanyList.add(airlineCompanyOne);

        AirlineCompany airlineCompanyTwo = new AirlineCompany();
        airlineCompanyTwo.setId(2L);
        airlineCompanyTwo.setEmployeeCount(200);
        airlineCompanyTwo.setCompanyName("Airline 2");
        airlineCompanyTwo.setGeneralCenter("Region 2");
        airlineCompanyTwo.setCreateDate(new Date());
        airlineCompanyList.add(airlineCompanyTwo);

        AirlineCompany airlineCompanyThree = new AirlineCompany();
        airlineCompanyThree.setId(1L);
        airlineCompanyThree.setEmployeeCount(300);
        airlineCompanyThree.setCompanyName("Airline 3");
        airlineCompanyThree.setGeneralCenter("Region 3");
        airlineCompanyThree.setCreateDate(new Date());
        airlineCompanyList.add(airlineCompanyThree);

        when(airlineCompanyRepository.findAll()).thenReturn(airlineCompanyList);
        List<AirlineCompanyDTO> airlineCompanyDTOList = airlineCompanyService.findAllAirlineCompany();

        Assertions.assertThat(airlineCompanyDTOList).isNotEmpty();
        Assertions.assertThat(airlineCompanyList.size()).isEqualTo(airlineCompanyDTOList.size());

        Assertions.assertThat(airlineCompanyList.get(0).getCompanyName()).isEqualTo(airlineCompanyDTOList.get(0).getCompanyName());
        Assertions.assertThat(airlineCompanyList.get(0).getGeneralCenter()).isEqualTo(airlineCompanyDTOList.get(0).getGeneralCenter());
        Assertions.assertThat(airlineCompanyList.get(0).getCreateDate()).isEqualTo(airlineCompanyDTOList.get(0).getCreateDate());

        Assertions.assertThat(airlineCompanyList.get(1).getCompanyName()).isEqualTo(airlineCompanyDTOList.get(1).getCompanyName());
        Assertions.assertThat(airlineCompanyList.get(1).getEmployeeCount()).isEqualTo(airlineCompanyDTOList.get(1).getEmployeeCount());
        Assertions.assertThat(airlineCompanyList.get(1).getId()).isEqualTo(airlineCompanyDTOList.get(1).getId());

        Assertions.assertThat(airlineCompanyList.get(2).getCreateDate()).isEqualTo(airlineCompanyDTOList.get(2).getCreateDate());
        Assertions.assertThat(airlineCompanyList.get(2).getCompanyName()).isEqualTo(airlineCompanyDTOList.get(2).getCompanyName());
        Assertions.assertThat(airlineCompanyList.get(2).getGeneralCenter()).isEqualTo(airlineCompanyDTOList.get(2).getGeneralCenter());
    }

    @Test
    public void findAllAirlineCompany_whenRequestToFindAllEndPointShouldReturnNull() {
        List<AirlineCompany> airlineCompanyList = new ArrayList<>();
        when(airlineCompanyRepository.findAll()).thenReturn(airlineCompanyList);
        List<AirlineCompanyDTO> airlineCompanyDTOListOne = airlineCompanyService.findAllAirlineCompany();
        Assertions.assertThat(airlineCompanyDTOListOne).isNull();


        when(airlineCompanyRepository.findAll()).thenReturn(null);
        List<AirlineCompanyDTO> airlineCompanyDTOListTwo = airlineCompanyService.findAllAirlineCompany();
        Assertions.assertThat(airlineCompanyDTOListTwo).isNull();
    }

    @Test
    public void findByAirlineCompanyId_whenRequestToFindByIdEndPointReturnAirlineCompanyDTO() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setId(1L);
        airlineCompany.setGeneralCenter("Region 1");
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setEmployeeCount(100);

        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);
        AirlineCompanyDTO airlineCompanyDTO = airlineCompanyService.findByAirlineCompanyId(1L);

        Assertions.assertThat(airlineCompanyDTO).isNotNull();
        Assertions.assertThat((airlineCompany.getId())).isEqualTo(airlineCompanyDTO.getId());
        Assertions.assertThat((airlineCompany.getCompanyName())).isEqualTo(airlineCompanyDTO.getCompanyName());
        Assertions.assertThat((airlineCompany.getEmployeeCount())).isEqualTo(airlineCompanyDTO.getEmployeeCount());
    }

    @Test
    public void findByAirlineCompanyId_whenAirlineIdIsNullShouldReturnNull() {
        when(airlineCompanyRepository.findFirstById(null)).thenReturn(null);
        AirlineCompanyDTO airlineCompanyDTO = airlineCompanyService.findByAirlineCompanyId(null);
        Assertions.assertThat(airlineCompanyDTO).isNull();
    }

    @Test
    public void findByAirlineCompanyId_whenAirlineIdNotFoundShouldReturnNull() {
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(null);
        AirlineCompanyDTO airlineCompanyDTO = airlineCompanyService.findByAirlineCompanyId(1L);
        Assertions.assertThat(airlineCompanyDTO).isNull();
    }

    @Test
    public void updateAirlineCompany_whenAirlineUpdateThenUpdateDB() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setGeneralCenter("Region 1");
        airlineCompany.setCreateDate(new Date());
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        AirlineCompanyDTO updateAirlineCompanyDTO = new AirlineCompanyDTO();
        updateAirlineCompanyDTO.setId(1L);
        updateAirlineCompanyDTO.setEmployeeCount(200);
        updateAirlineCompanyDTO.setCompanyName("Airline Name Update");
        updateAirlineCompanyDTO.setGeneralCenter("Region 1 Update");
        updateAirlineCompanyDTO.setCreateDate(new Date());

        airlineCompanyService.updateAirlineCompany(1L, updateAirlineCompanyDTO);
    }

    @Test
    public void updateAirlineCompany_whenAirlineNameUpdateThenUpdateDB() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setGeneralCenter("Region 1");
        airlineCompany.setCreateDate(new Date());
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        AirlineCompanyDTO updateAirlineCompany = new AirlineCompanyDTO();
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("Airline Name Update");
        airlineCompany.setGeneralCenter("Region 1");

        airlineCompanyService.updateAirlineCompany(1L, updateAirlineCompany);
    }

    @Test
    public void updateAirlineCompany_whenAirlineEmployeeCountUpdateThenUpdateDB() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setGeneralCenter("Region 1");
        airlineCompany.setCreateDate(new Date());
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        AirlineCompanyDTO updateAirlineCompany = new AirlineCompanyDTO();
        airlineCompany.setEmployeeCount(200);
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setGeneralCenter("Region 1");

        airlineCompanyService.updateAirlineCompany(1L, updateAirlineCompany);
    }

    @Test
    public void updateAirlineCompany_whenAirlineGeneralCenterUpdateThenUpdateDB() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setGeneralCenter("Region 1");
        airlineCompany.setCreateDate(new Date());
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        AirlineCompanyDTO updateAirlineCompany = new AirlineCompanyDTO();
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setGeneralCenter("Region 1 Update");

        airlineCompanyService.updateAirlineCompany(1L, updateAirlineCompany);
    }

    @Test(expected = NullPointerException.class)
    public void updateAirlineCompany_whenAirlineCompanyDTOIsNullShouldThrowException() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setEmployeeCount(100);
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setGeneralCenter("Region 1");
        airlineCompany.setCreateDate(new Date());
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);

        AirlineCompanyDTO airlineCompanyDTO = null;
        airlineCompanyService.updateAirlineCompany(1L, airlineCompanyDTO);
    }

    @Test(expected = NullPointerException.class)
    public void updateAirlineCompany_whenAirlineCompanyIdIsNullShouldThrowException() {
        when(airlineCompanyRepository.findFirstById(null)).thenReturn(null);
        AirlineCompanyDTO updateAirlineCompany = new AirlineCompanyDTO();
        updateAirlineCompany.setEmployeeCount(100);
        updateAirlineCompany.setCompanyName("Airline Name Update");
        updateAirlineCompany.setGeneralCenter("Region 1 Update");
        airlineCompanyService.updateAirlineCompany(null, updateAirlineCompany);
    }

    @Test(expected = NullPointerException.class)
    public void updateAirlineCompany_whenAirlineCompanyNotFountShouldThrowException() {
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(null);
        AirlineCompanyDTO updateAirlineCompany = new AirlineCompanyDTO();
        updateAirlineCompany.setEmployeeCount(100);
        updateAirlineCompany.setCompanyName("Airline Name Update");
        updateAirlineCompany.setGeneralCenter("Region 1 Update");
        airlineCompanyService.updateAirlineCompany(null, updateAirlineCompany);
    }

    @Test
    public void deleteAirlineCompany_whenAirportDeleteThenDeleteFromDB() {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter("Region 1");
        airlineCompany.setCompanyName("Airline Name");
        airlineCompany.setEmployeeCount(100);
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(airlineCompany);
        airlineCompanyService.deleteAirlineCompany(1L);
    }

    @Test(expected = NullPointerException.class)
    public void deleteAirlineCompany_whenAirlineIdNotFoundShouldThrowException() {
        when(airlineCompanyRepository.findFirstById(1L)).thenReturn(null);
        airlineCompanyService.deleteAirlineCompany(1L);
    }

    @Test(expected = NullPointerException.class)
    public void deleteAirlineCompany_whenAirLineIdIsNullShouldThrowException() {
        when(airlineCompanyRepository.findFirstById(null)).thenReturn(null);
        airlineCompanyService.deleteAirlineCompany(null);
    }
}
