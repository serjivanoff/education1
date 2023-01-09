package com.education.patterns.decorator;

public class Main {
    public static void main(String[] args) {
        Printer p = new PrefixedPrinter(new CapitalizedPrinter(new ReversePrinter(new RegularPrinter())));
        p.print("абаба-каламага");
    }
}
