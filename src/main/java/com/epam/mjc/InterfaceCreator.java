package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (var str : strings) {
                if (!str.substring(0, 1).equals(str.substring(0, 1).toUpperCase())) {
                    return false;
                }
            }
            return false;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return numbers -> {
            List<Integer> addNums = new ArrayList<>();
            for (var num : numbers) {
                if (num % 2 == 0) {
                    addNums.add(num);
                }
            }
            numbers.addAll(addNums);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(x -> x.substring(0, 1).equals(x.substring(0, 1).toUpperCase())
                && x.endsWith(".")
                && x.trim().split("\\s").length > 3).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1, l2) -> Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());
    }
}
