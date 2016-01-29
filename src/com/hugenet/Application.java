package com.hugenet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application configuration and bootstrap
 *
 * java -jar <Path to collector-name.jar>
 * --spring.config.name=<prefix for properties>
 * --spring.config.location=<path to properties file location>
 *
 */


@SpringBootApplication

public class Application implements CommandLineRunner {

    @Autowired
    private ApplicationConnectionRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        ApplicationConnection apCon = new ApplicationConnection("elephant", "http://elephant.saas.appdynamics.com");
        apCon.setCredential("demo");
        apCon.setUserId("hbrien");
        repository.save(apCon);

        ApplicationConnection apprenda1 =  new ApplicationConnection("apprenda", "http://apprenda.saas.appdynamics.com" );
        apprenda1.setCredential("apprenda");
        apprenda1.setCredential("hbrien");
        repository.save(apprenda1);



        repository.save(new ApplicationConnection("demo2", "http://demo2.appdynamics.com" ));
        repository.save(new ApplicationConnection("demo1", "http://demo1.appdynamics.com" ));

        // fetch all customers
        System.out.println("ApplicationConnection found with findAll():");
        System.out.println("-------------------------------");
        for (ApplicationConnection appConn : repository.findAll()) {
            System.out.println(appConn);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("ApplicationConnection found with findByApplicationName('Elephant'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByApplicationName("Elephant"));

        System.out.println("ApplicationConnection found with findByUrl('http://apprenda.saas.appdynamics.com'):");
        System.out.println("--------------------------------");
        repository.findByUrl("http://apprenda.saas.appdynamics.com");

    }


}
