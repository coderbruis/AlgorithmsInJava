package com.bruis.algorithminjava.algorithm.huawei;

import java.util.Scanner;

/**
 * @author LuoHaiYang
 *
 * 题目描述：输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述： 输入一个整数（int类型）
 *
 * 输出描述： 这个数转换成2进制后，输出1的个数
 *
 * 实例1：
 *
 * 输入：5
 * 输出：2
 *
 */
public class Question01 {

    /**
     * 笨办法
     * @param args
     */
    public static void main(String[] args) {

        // 巧妙法，通过二进制位运算
        Scanner in = new Scanner(System.in);

        int count = in.nextInt(), result = 0;
        while (count > 0) {
            if ((count & 1) > 0) {
                result++;
            }
            count = count >> 1;
        }
        System.out.println(result);
/*
        笨办法
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        char[] bytes = Integer.toBinaryString(input).toCharArray();
        int result = 0;
        for (char c : bytes) {
            if (c == '1') {
                result++;
            }
        }
        System.out.println(result);
*/
    }

}
