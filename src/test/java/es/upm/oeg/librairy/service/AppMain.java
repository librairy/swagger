package es.upm.oeg.librairy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */

public class AppMain {

    private static final Logger LOG = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {
        new SpringApplication(AppTest.class).run(args);
    }
}
