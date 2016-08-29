package de.codecntric.steiner.twitterapi.Models;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


public class PropertiesServiceTest {

    private PropertiesService propertiesService;

    @Before
    public void setUp(){
        propertiesService = new PropertiesService();
    }
    @Test
    public void test_rest_controller_answers_with_all_properties() {
        int count = System.getProperties().size() + System.getenv().size();

        Map<String, String> resultMap = propertiesService.getEnvAndSystemProperties();

        assertThat(resultMap.size(), equalTo(count));
    }

}