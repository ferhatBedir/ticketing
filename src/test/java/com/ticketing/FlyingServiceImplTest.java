package com.ticketing;

import com.ticketing.repository.FlyingRepository;
import com.ticketing.service.impl.FlyingServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FlyingServiceImplTest {

    @Mock
    private FlyingRepository flyingRepository;

    @InjectMocks
    private FlyingServiceImpl flyingService;
}
