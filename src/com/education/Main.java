package com.education;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<List<String>>> strings = new ArrayList<>(List.of(
        List.of(List.of("asd"), List.of("as")), List.of(List.of("asdasdas"))));
        List<Integer> s = strings.stream().map(List::size).collect(Collectors.toList());
        List<Integer> collect = strings.stream().flatMap(
                l -> l.stream().flatMap(l2 -> l2.stream().map(String::length)))
                .collect(Collectors.toList());
        System.out.println();

    }
}
