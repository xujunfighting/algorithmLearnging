package com.zto.algorithm;

/**
 * Author xujun
 * Create date 2019-09-20.
 * desc:
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if((b * b - 4 * a * c)<0){return;}
        double res1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double res2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        if (res1 > res2) {
            System.out.print((int)res1+" ");
            System.out.print((int)res2);
        } else {
            System.out.print((int)res2+" ");
            System.out.print((int)res1);
        }
    }
}
