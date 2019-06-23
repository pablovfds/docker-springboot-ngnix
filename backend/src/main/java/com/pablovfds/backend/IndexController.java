package com.pablovfds.backend;

import com.mongodb.MongoClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class IndexController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String index() {

        try(MongoClient mongoClient = new MongoClient("mongodb")){
            logger.log(Level.INFO, "First database name: " + mongoClient.listDatabaseNames().first());
        }

        return "Server on!";
    }
}
