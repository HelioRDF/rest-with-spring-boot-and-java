package br.com.java.rest.model;

public record Greeting(long id, String content) {
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }


}
