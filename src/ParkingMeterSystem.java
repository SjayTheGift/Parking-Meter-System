

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Spha
 */
public class ParkingMeterSystem {
    private static Object scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first time (hh:mm): ");
        String time = input.nextLine();
        System.out.println();
        System.out.print("Enter second time (hh:mm): ");
        String time2 = input.nextLine();

        DateFormat sdf = new SimpleDateFormat("HH:mm");
        Date d1 = sdf.parse(time);
        Date d2 = sdf.parse(time2);
        String convertTime = d1.toString();
        String convertTime2 = d2.toString();

        String hour1 = convertTime.substring(11, 13);
        String minutes1 = convertTime.substring(14, 16);
        String hour2 = convertTime2.substring(11, 13);
        String minutes2 = convertTime2.substring(14, 16);

        int convertHour = Integer.valueOf(hour1);
        int convertHour2 = Integer.valueOf(hour2);
        int convertMintues = Integer.valueOf(minutes1);
        int convertMintues2 = Integer.valueOf(minutes2);

        int returnHours = Math.abs(convertHour - convertHour2);
        int returnMinutes = Math.abs(convertMintues - convertMintues2);
        double amountTopay = 0;

        if (returnHours == 0 || returnHours <= 1) {
            System.out.println("Amount to pay");
            System.out.println("Free");
        } else if (returnHours == 1 || returnHours <= 2) {
            System.out.println("Amount to pay");
            System.out.println("R5.00");
            amountTopay = 5.00;
        } else if (returnHours == 2 || returnHours <= 4) {
            System.out.println("Amount to pay");
            System.out.println("R8.00");
            amountTopay = 8.00;
        } else if (returnHours == 4 || returnHours <= 6) {
            System.out.println("Amount to pay");
            System.out.println("R11.00");
            amountTopay = 11.00;
        } else if (returnHours == 6 || returnHours <= 10) {
            System.out.println("Amount to pay");
            System.out.println("R14.00");
            amountTopay = 14.00;
        } else if (returnHours == 10 || returnHours <= 20) {
            System.out.println("Amount to pay");
            System.out.println("R25,00");
            amountTopay = 25.00;
        } else if (returnHours == 20 || returnHours <= 24) {
            System.out.println("Amount to pay");
            System.out.println("R35.00");
            amountTopay = 35.00;
        } else {
            System.out.println("Amount to pay");
            System.out.println("R50.00");
            amountTopay = 50.00;
        }

        System.out.println("Please Enter pay:");
        double pay = input.nextDouble();
        System.out.println();

        System.out.println("Time");

        System.out.println(returnHours + " hour and " + returnMinutes + " minutes");
        System.out.println("Your Entered \n" + pay + "0");
        System.out.println("Your Change");
        double change = pay - amountTopay;
        System.out.printf("R" + change + "0");
        System.out.println();
        System.out.println("Denominations:");

        //double[] coins = {0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00, 200.00};
        
        final int[] denominations = {200, 100, 50, 20, 10, 5, 2, 1 };
        
      int amount = (int) Math.round(change);
       
      // Determine how many of each denomination are required
      
      MoneyBreakDown money = new MoneyBreakDown();
       
      int[] count = money.breakdown(denominations, amount);
       
      // Output the result
       
      for (int i=0; i<denominations.length; i++) {
         if (count[i]> 0.0) {
            System.out.println("R " + denominations[i]+".00" +" x "+ count[i]);
         }
      }
   }
 
   
}


