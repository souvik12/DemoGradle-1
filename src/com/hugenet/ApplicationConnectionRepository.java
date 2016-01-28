package com.hugenet;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationConnectionRepository extends MongoRepository<ApplicationConnection, String> {

    public ApplicationConnection findByUrl(String url);
    public List<ApplicationConnection> findByApplicationName(String appName);

}