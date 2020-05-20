package ru.ifmo.collections;

import java.util.ArrayList;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    ArrayList<Integer> numbers;

    public FirstUnique(int[] numbers) {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            this.numbers.add(numbers[i]);
        }
    }

    public int showFirstUnique() {
        ArrayList<Integer> uniq = new ArrayList<>();
        ArrayList<Integer> paired = new ArrayList<>();

        numbers.forEach(number->{
            if (uniq.contains(number)) {
                uniq.remove(number);
                paired.add(number);
            }
            else {
                if (!paired.contains(number)) uniq.add(number);
            }
        });

        if (uniq.size()<1) return -1;
        return uniq.get(0);
    }

    public void add(int value) {
        this.numbers.add(value);
    }
}
