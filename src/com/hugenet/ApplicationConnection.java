package com.hugenet;

import org.springframework.data.annotation.Id;

public class ApplicationConnection {
    @Id
    private String id;
    private String applicationName;
    private String applicationAccessKey;
    private String userId;
    private String credential;

    public String getApplicationAccessKey() {
        return applicationAccessKey;
    }

    public void setApplicationAccessKey(String applicationAccessKey) {
        this.applicationAccessKey = applicationAccessKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String url;
    private String description;

        public ApplicationConnection() {}

        public ApplicationConnection(String applicationName, String url) {
            this.applicationName = applicationName;
            this.url = url;
        }

        @Override
        public String toString() {
            return String.format(
                    "Application[id=%s, url='%s', applicationName='%s']",
                    id, applicationName, url);
        }

}


