package ru.khamedov.ildar;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Atm atm=new Atm(Map.of(500,10,100,50,1000,3,5000,4,2000,3,50,100));
        while (true) {
            System.out.println(atm.getBalance());
            Scanner scanner = new Scanner(System.in);
            int sum = scanner.nextInt();
            System.out.println(sum);
            System.out.println(atm.getSumClient(sum));
            System.out.println(atm.getBalance());
        }
    }
}
