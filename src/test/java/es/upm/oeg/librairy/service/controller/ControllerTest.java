package es.upm.oeg.librairy.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
@Api(tags="/test", description="topic details")
public class ControllerTest {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerTest.class);

    @PostConstruct
    public void setup(){
        LOG.info("up and running");
    }

    @PreDestroy
    public void destroy(){

    }

    @ApiOperation(value = "list of topics", nickname = "getTopics", response=String.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class, responseContainer = "List"),
    })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<String>> execute()  {
        try {
            LOG.info("handle new request");
            Thread.currentThread().sleep(5000);
            return new ResponseEntity<List<String>>(Arrays.asList("hello","world"),HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Error", e);
            return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
