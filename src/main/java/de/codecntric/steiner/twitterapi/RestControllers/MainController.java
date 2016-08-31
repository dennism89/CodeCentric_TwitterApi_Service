package de.codecntric.steiner.twitterapi.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/")
public class MainController {

//    @Autowired
//    PropertiesService propertiesService;
//
//    @RequestMapping(value = "/props", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Map> getEnvironmentProperties(){
//        Map<String, String> treeMap = propertiesService.getEnvAndSystemProperties();
//        return new ResponseEntity<Map>(treeMap, HttpStatus.OK);
//    }


    @Autowired
    private Twitter twitter;
    @Autowired
    private ConnectionRepository connectionRepository;



    @RequestMapping(method = RequestMethod.GET)
    public String helloTwitter(Model model) {

        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {

            return "redirect:/connect/twitter";
        }

        model.addAttribute(twitter.userOperations().getUserProfile());

        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
        model.addAttribute("friends", friends);
        return "index";
    }
}

