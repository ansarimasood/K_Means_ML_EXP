package com.masood;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 12, 3, 20, 30, 11, 25};
        int i, a, b, n = 0;
        double c1 = 0, c2 = 0;
        boolean flag;
        float sum1, sum2;
        DecimalFormat df = new DecimalFormat("#.##");
        int[] cluster1;
        int[] cluster2;
        sum1 = 0;
        sum2 = 0;
        cluster1 = new int[arr.length];
        cluster2 = new int[arr.length];
        n++;
        int k = 0, j = 0;
        System.out.println("Input Data:");
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
        System.out.println("\n");
        System.out.println("Choose 1 for creating cluster using first 2 elements\nChoose 2 for creating cluster using 2 random elements\nChoose 3 for creating cluster using odd/even place cluster");

        System.out.print("Choose : ");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                a = arr[0];
                b = arr[1];
                c1 = a;
                c2 = b;
                for (i = 0; i < arr.length; i++) {
                    if (Math.abs(arr[i] - c1) <= Math.abs(arr[i] - c2)) {
                        cluster1[k] = arr[i];
                        k++;
                    } else {
                        cluster2[j] = arr[i];
                        j++;
                    }
                }
                break;
            case 2:
                a = arr[(int) Math.floor(Math.random() * arr.length)];
                b = arr[(int) Math.floor(Math.random() * arr.length)];
                if (a == b) {
                    b = arr[(int) Math.floor(Math.random() * arr.length)];
                }
                c1 = a;
                c2 = b;
                for (i = 0; i < arr.length; i++) {
                    if (Math.abs(arr[i] - c1) <= Math.abs(arr[i] - c2)) {
                        cluster1[k] = arr[i];
                        k++;
                    } else {
                        cluster2[j] = arr[i];
                        j++;
                    }
                }
                break;
            case 3:
                for (i = 0; i < arr.length; i++) {
                    if (i%2==0) {
                        cluster1[k] = arr[i];
                        k++;
                    } else {
                        cluster2[j] = arr[i];
                        j++;
                    }
                }

                break;
            default:
                System.out.println("Choose valid number");
        }

        if (choose == 1 || choose == 2 || choose == 3) {
            System.out.println();
            for (i = 0; i < k; i++) {
                sum1 = sum1 + cluster1[i];
            }
            for (i = 0; i < j; i++) {
                sum2 = sum2 + cluster2[i];
            }
            System.out.println("Step 1 : Randomly Creating the Clusters.");
            a = (int) c1;
            b = (int) c2;
            c1 = (sum1 / k);
            c2 = (sum2 / j);
            flag = !(c1 == a && c2 == b);

            for (i = 0; i < cluster1.length; i++) {
                System.out.print(cluster1[i] + "\t");
            }
            System.out.print("\tc1 = " + df.format(c1));
            System.out.println();
            for (i = 0; i < cluster2.length; i++) {
                System.out.print(cluster2[i] + "\t");
            }
            System.out.print("\tc2 = " + df.format(c2));

            while (flag) {
                sum1 = 0;
                sum2 = 0;
                cluster1 = new int[arr.length];
                cluster2 = new int[arr.length];
                n++;
                k = 0;
                j = 0;
                for (i = 0; i < arr.length; i++) {
                    if (Math.abs(arr[i] - c1) <= Math.abs(arr[i] - c2)) {
                        cluster1[k] = arr[i];
                        k++;
                    } else {
                        cluster2[j] = arr[i];
                        j++;
                    }
                }
                System.out.println("\n");
                for (i = 0; i < k; i++) {
                    sum1 = sum1 + cluster1[i];
                }
                for (i = 0; i < j; i++) {
                    sum2 = sum2 + cluster2[i];
                }
                a = (int) c1;
                b = (int) c2;
                c1 = (sum1 / k);
                c2 = (sum2 / j);
                flag = !(c1 == a && c2 == b);

                System.out.println("Step " + n + " Reassign :");
                for (i = 0; i < cluster1.length; i++) {
                    System.out.print(cluster1[i] + "\t");
                }
                System.out.print("\tc1 = " + df.format(c1));
                System.out.println();
                for (i = 0; i < cluster2.length; i++) {
                    System.out.print(cluster2[i] + "\t");
                }
                System.out.print("\tc2 = " + df.format(c2));
            }
            System.out.println("\n\nWe get the same cluster , Hence Stop");
        }
    }
}
