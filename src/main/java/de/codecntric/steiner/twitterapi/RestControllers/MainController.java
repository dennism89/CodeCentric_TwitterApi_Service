package de.codecntric.steiner.twitterapi.RestControllers;

import de.codecntric.steiner.twitterapi.Models.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by dennisMsteiner on 29.08.16.
 */
@RestController
public class MainController {

    @Autowired
    PropertiesService propertiesService;

    @RequestMapping(value = "/props", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getEnvironmentProperties(){
        Map<String, String> treeMap = propertiesService.getEnvAndSystemProperties();
        return new ResponseEntity<Map>(treeMap, HttpStatus.OK);
    }

}
