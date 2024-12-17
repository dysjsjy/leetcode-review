package com.dysjsjy;


import java.util.Arrays;
import java.util.Comparator;

/*
977. 有序数组的平方
已解答
简单
相关标签
相关企业
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class ar977_1 {
    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        Integer[] wrappedNums = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(wrappedNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(Math.abs(a), Math.abs(b));
            }
        });

        for (int i = 0; i < wrappedNums.length; i++) {
            wrappedNums[i] = wrappedNums[i] * wrappedNums[i];
        }

        nums = Arrays.stream(wrappedNums).mapToInt(Integer::intValue).toArray();

        return nums;
    }
}
