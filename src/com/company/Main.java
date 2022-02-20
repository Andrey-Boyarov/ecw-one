package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> books = new ArrayList<>();
        books.add("Three man in a boat");
        books.add("Art of war");
        Utils.deepClone(new Man("John", 28, books));
    }
}
