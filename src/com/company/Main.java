package com.company;
import java.util.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter number of inputs: ");
        Scanner scan = new Scanner (System.in);
        int number = scan.nextInt();
        int loop = 0;
        float totalSalesTax = 0.0f;
        float totalAmount = 0.0f;
        ArrayList<String> salesName = new ArrayList<String>();
        while (loop < number) {

            System.out.print("Enter input: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            // String input = scanner.nextLine();
            System.out.println("Is it a book, food, medical item: \n 1: Yes\n 2: No\n");
            int input_type = scanner.nextInt();
            System.out.print("Is it imported: \n 1: Yes \n 2. No\n" );
            int input_imprt = scanner.nextInt();

            // tags.add(input_type);
            // tags.add(input_imprt);

            String lastWord = input.substring(input.lastIndexOf(" ") + 1);
            float bill = Float.parseFloat(lastWord);
            float add_1 = 0.0f;
            float add_2 = 0.0f;

            float temp_bill = bill;

            if(input_type == 2){
                add_1 = bill * (10.0f / 100.0f);
            }

            if(input_imprt == 1){
                add_2 = bill * (5.0f / 100.0f);
            }
            bill = bill + add_1 + add_2;
            bill = Math.round(bill * 100.0f) / 100.0f;
            // System.out.println(temp_bill);
            // System.out.println(bill);

            totalSalesTax = totalSalesTax + temp_bill - bill;
            totalAmount = totalAmount + bill;

            String firstWords = input.substring(0, input.lastIndexOf(" ")-2);
            // String output = firstWords + " " + bill;
            String round = String.format(" %.02f", bill);
            // System.out.println(round);
            String output = firstWords + " - " + round;

            salesName.add(output);

            // System.out.println(output);


            loop = loop + 1;

        }

        float totalSalesTax_rounded = Math.round(totalSalesTax * 20.0f) / 20.0f;
        float add_subtrct = totalSalesTax - totalSalesTax_rounded;
        // System.out.println(add_subtrct);
        if(add_subtrct<0){
            add_subtrct = add_subtrct + 0.05f;

            totalSalesTax_rounded = totalSalesTax_rounded - 0.05f;
        }

        totalAmount = totalAmount + add_subtrct;

        String str_1 = salesName.get(salesName.size()-1);

        String firstWords_1 = str_1.substring(0, str_1.lastIndexOf(" ")-2);
        String lastWord_1 = str_1.substring(str_1.lastIndexOf(" ") + 1);

        float val_round = Float.parseFloat(lastWord_1);
        val_round = val_round + add_subtrct;
        val_round = Math.round(val_round * 100.0f) / 100.0f;

        String output_last = firstWords_1 + " - " + val_round;

        // String firstWords = str_1.substring(0, str_1.lastIndexOf(" "));

        salesName.remove(salesName.size() - 1);
        salesName.add(output_last);

        for (String temp : salesName) {
            System.out.println(temp);
        }
        totalAmount = Math.round(totalAmount * 100.0f) / 100.0f;
        totalSalesTax_rounded = Math.round(totalSalesTax_rounded * 100.0f) / 100.0f;
        totalSalesTax_rounded = Math.abs(totalSalesTax_rounded);
        System.out.printf("Sales Taxes - %.2f\n",totalSalesTax_rounded);
        System.out.printf("Sales Taxes - %.2f\n",totalAmount);

    }
}

