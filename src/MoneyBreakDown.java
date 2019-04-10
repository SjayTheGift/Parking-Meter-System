/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ejonas
 */
public class MoneyBreakDown {

    public int[] breakdown(int[] denominations, int amount) {
        int[] count = new int[denominations.length];

      // Loop through each denomination (starting at largest)
        for (int i = 0; i < denominations.length; i++) {

         // Use one of that denomination until we need something smaller
            while (amount >= denominations[i]) {
                count[i]++;
                amount -= denominations[i];
            }
        }

        return count;
    }
}
