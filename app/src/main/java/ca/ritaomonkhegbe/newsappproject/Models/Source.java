package ca.ritaomonkhegbe.newsappproject.Models;

import java.io.Serializable;

public class Source implements Serializable {
    public String id = "";
    public String name = "";

    public String url = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
