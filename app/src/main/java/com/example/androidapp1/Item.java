package com.example.androidapp1;

public class Item {
    private String name;
    private Type type;


    public Item(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public enum Type{
        hidden_password,
        public_password
    }
}
