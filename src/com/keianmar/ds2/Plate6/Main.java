package com.keianmar.ds2.Plate6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner_Mar = new Scanner(System.in);
        System.out.println("Which problem? [1-8]");
        char chosenString_Mar = scanner_Mar.nextLine().toCharArray()[0];
        
        switch (chosenString_Mar) {
            case '1':
                Problem1.main(scanner_Mar);
                break;
            case '2':
                Problem2.main(scanner_Mar);
                break;
            case '3':
                Problem3.main(scanner_Mar);
                break;
            case '4':
                Problem4.main(scanner_Mar);
                break;
            case '5':
                Problem5.main(scanner_Mar);
                break;
            case '6':
                Problem6.main(scanner_Mar);
                break;
            case '7':
                Problem7.main(scanner_Mar);
                break;
            case '8':
                Problem8.main(scanner_Mar);
                break;
            default:
                System.out.println("Invalid problem number. Exiting.");
                break;
        }
        
        scanner_Mar.close();
    }
}
