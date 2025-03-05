package com.lld.designproject.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class FlattenObject {
    public static void main(String[] args) {
        Object[] array = {1, 2, new Object[] {3, 4, new Object[] {5}, 6, 7}, 8, 9, 10};
        List<Integer> output = new ArrayList<>();
        flatten(array, output);
        System.out.println(output);
    }

    private static void flatten(Object[] arr, List<Integer> output) {
        for (Object object : arr) {
            if (object instanceof Integer) {
                output.add((Integer) object);
            } else if (object instanceof Object[]) {
                flatten((Object[]) object, output);
            }
        }
    }
}
