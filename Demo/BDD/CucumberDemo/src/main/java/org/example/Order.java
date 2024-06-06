package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String from;
    private String to;
    private List<String> contents = new ArrayList<>();

    private String message;
    //...
    public void withMessage(String something) {
        this.message = something;
    }
    public String getTicketMessage() {
        return "From " + from + " to " + to + ": " + message;
    }

    public void declareOwner(String owner) {
        this.from = owner ;
    }

    public void declareTarget(String target) {
        this.to = target ;
    }
    public List<String> getCocktails() {
        return contents;
    }
}
