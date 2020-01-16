package com.ticketing;

import com.ticketing.repository.AirlineCompanyRepository;
import com.ticketing.service.impl.AirlineCompanyServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AirlineCompanyServiceImplTest {

    @Mock
    private AirlineCompanyRepository airlineCompanyRepository;

    @InjectMocks
    private AirlineCompanyServiceImpl airlineCompanyService;
}
