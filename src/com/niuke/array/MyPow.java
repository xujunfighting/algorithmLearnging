package com.niuke.array;

public class MyPow {
    public static void main(String[] args) {
        double v = myPow(2, 100);
        System.out.println(v);
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        double res = 1.0;
        if (n > 1) {
            return getResult(x, n);
        } else {
            res=getResult(x, -n);
            return 1.0 / res;
        }
    }


    public static double getResult(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double result = getResult(x, n / 2);
            return result * result;
        } else {
            double result = getResult(x, n / 2);
            return result * result * x;
        }
    }

}
