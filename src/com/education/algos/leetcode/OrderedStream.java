package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class OrderedStream {
    private final String[] values;
    private int ptr;

    public static void main(String[] args) {
        final OrderedStream inst = new OrderedStream(4);
        final Map<Integer, String> vals = new LinkedHashMap<>();
        vals.put(1, "roxxb");
        vals.put(4, "luiqm");
        vals.put(2, "qutzx");
        vals.put(3, "zkugh");
        vals.forEach((k, v) -> System.out.println(inst.insert(k, v)));
    }

    public OrderedStream(int n) {
        values = new String[n];
        ptr = 0;
    }

    public List<String> insert(final int idKey, final String value) {
        if (value == null) return null;
        values[idKey - 1] = value;
        final List<String> result = new ArrayList<>();
        int i = ptr;
        do {
            final String next = values[i];
            if (next == null) break;
            i++;
            if (next.isEmpty()) continue;
            result.add(next);
        } while (i < values.length);
        ptr = i;
        if (result.isEmpty() || i < idKey) return new ArrayList<>();
        for (int j = 0; j < i; j++) values[j] = "";
        return result;
    }
}