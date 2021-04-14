package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;

//TODO rename
public class Greeting {

    private final String content;

    public Greeting(@JsonProperty("content") String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "content='" + content + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
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

        Greeting greeting = (Greeting) obj;

        return content.equals(greeting.content);
    }

}
