package com.example.restservice;

public class Greeting {

    private final String content;

    public Greeting(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
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
