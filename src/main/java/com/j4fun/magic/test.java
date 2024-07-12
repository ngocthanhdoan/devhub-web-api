package com.j4fun.magic;

import java.util.Random;

import com.j4fun.eNum.TheIChing;

public class test {
    public static void main(String[] args) {
        // Mảng chứa các tên quẻ

        // Sử dụng lớp Random để tạo số ngẫu nhiên
        Random random = new Random();
        // Lấy ra 6 quẻ ngẫu nhiên
         System.out.println("Câu hỏi: Kỳ này tôi có thể làm quen với cô Tiên để có 1 gia đình khong?");
        System.out.println("Quẻ lấy được");
        // System.out.println(TheIChing.getCode(19).getMeaning());
        // System.out.println(TheIChing.getCode(36).getMeaning());
        // System.out.println(TheIChing.getCode(28).getMeaning());
        // System.out.println(TheIChing.getCode(06).getMeaning());
        // System.out.println(TheIChing.getCode(41).getMeaning());
        // System.out.println(TheIChing.getCode(46).getMeaning());
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(64);
            System.out.println(TheIChing.getCode(index) + "-" + TheIChing.getCode(index).getMeaning());
        }

    }
}
