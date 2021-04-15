package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;


public class URLBean {

    private final String url;

    public URLBean(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "URLBean{" +
                "url='" + url + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        URLBean URLBean = (URLBean) obj;

        return url.equals(URLBean.url);
    }

}
