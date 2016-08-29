package de.codecntric.steiner.twitterapi.RestControllers;

import de.codecntric.steiner.twitterapi.Models.PropertiesService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.*;


public class MainControllerTest {
    private MainController mainController;
    private PropertiesService propertiesServiceMock;

    @Before
    public void setUp() {
        mainController = new MainController();
        propertiesServiceMock = mock(PropertiesService.class);

        mainController.propertiesService = propertiesServiceMock;
    }

    @Test
    public void test_that_response_entity_is_not_null() {
        // given

        //when
        ResponseEntity<Map> responseEntity = mainController.getEnvironmentProperties();

        // then
        assertThat(responseEntity, not(nullValue()));
    }

    @Test
    public void test_that_propertiesService_has_been_used() {
        // given

        //when
        ResponseEntity<Map> responseEntity = mainController.getEnvironmentProperties();

        // then
        verify(propertiesServiceMock, times(1)).getEnvAndSystemProperties();
    }

}