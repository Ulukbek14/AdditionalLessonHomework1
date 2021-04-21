package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] banknotes = {1, 3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
        int[] quantities = {10, 5, 5, 3, 2, 1, 2, 3, 3, 2, 0, 2};
        int totalAvailable = 0;
        String result = "";
        int quantity = 0;
        int noChange = 0;

        for (int i = 1; i < banknotes.length; i++) {
            totalAvailable = totalAvailable + banknotes[i] * quantities[i];
        }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите желаемую сумму: ");
            int withdraw = scanner.nextInt();
            int remainingAmountToGive = withdraw;
            if (remainingAmountToGive > totalAvailable) {
                System.out.println("Вы можете снять только " + totalAvailable);
            } else { for (int i = banknotes.length - 1; i >= 0; i--) {
                if (quantities[i] > 0) {
                    quantity = remainingAmountToGive / banknotes[i];
                    if (quantity > 0) {
                        if (quantities[i] < quantity){
                            quantity = quantities[i];
                        }
                        result = result + quantity + " x " + banknotes[i] + " ";
                        remainingAmountToGive = remainingAmountToGive - quantity * banknotes[i];
                        noChange += quantity * banknotes[i];
                        if (remainingAmountToGive == 0){
                            break;
                        }
                    }
                }
            }
            if (remainingAmountToGive == 0){
                System.out.println("Вы получили " + result + ". Всего " + withdraw);
            }else {
                System.out.println("Вы можете снять только " + noChange);
            }
        }
    }
}
