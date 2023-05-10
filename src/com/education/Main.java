package com.education;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main {
    public static void main(String[] args) {
        Set<String> strings = new ConcurrentSkipListSet<>();
        strings.add("asd");
        strings.add("asdasd");
        strings.add("asdasdasdas");

        strings.forEach(strings::remove);

        System.out.println();
    }
}
