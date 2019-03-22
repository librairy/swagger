package es.upm.oeg.librairy.service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.TimeUnit;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppTest.class})
@WebAppConfiguration
public class RunIntTest {

    private static final Logger LOG = LoggerFactory.getLogger(RunIntTest.class);


    @Test
    public void execute(){

        LOG.info("Application started successfully!");

        ParallelExecutor executor = new ParallelExecutor();

        for(int i=0;i<10;i++){
            executor.submit(() -> {
                try {
                    LOG.info("Doing request");
                    Unirest.get("http://localhost:7777/test").asJson();
                    LOG.info("request completed");
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.HOURS);

        LOG.info("All operations completed!");

    }

}
