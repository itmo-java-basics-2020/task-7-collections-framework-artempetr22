package ru.ifmo.collections;

import java.util.ArrayList;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    ArrayList<Integer> list;
    int k;


    public KthLargest(int k, int[] numbers) {
        this.k = k;
        list =  new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
    }

    public int add(int val) {
        list.add(val);

        ArrayList<Integer> nums = new ArrayList<>(list);

        int result = 0;

        for (int i = 0; i <k ; i++) {
            int max = Integer.MIN_VALUE;
            int rm = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j) > max) {
                    max = nums.get(j);
                    rm = j;
                }
            }

            result = max;
            nums.remove(rm);
        }

        return result;
    }
}