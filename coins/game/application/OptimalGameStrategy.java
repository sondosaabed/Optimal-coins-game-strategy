package coins.game.application;

import java.util.ArrayList;

/*
 * Create the Optimal Game strategy, 
 * Get the maximum profit,
 * fill the Dynamic table,
 * Saves the moves that gives an optimal solution
 */
public class OptimalGameStrategy {
    //Attributes
	private int size ;
    private int[][]  dpTable;
    private int max;
    private ArrayList<Integer> moves;

	public OptimalGameStrategy(int[] coins) {
    	size = coins.length;
    	dpTable= new int[size][size];
    	moves= new ArrayList<>();
    	printCoins(1,coins.length-1,coins);
    	optimalGame(coins);
    }

    private void optimalGame(int[] coins) {
        // Initialize the dpTable and backtrack arrays
        dpTable = new int[size][size];

        for (int j = 0; j < size; j++) {
            dpTable[j][j] = coins[j]; //Pick that one coin
        }

        for (int j = 0; j < size - 1; j++) {
            dpTable[j][j + 1] = Math.max(coins[j], coins[j + 1]);//Pick the max between thems
        }

        for (int i = 2; i < size; i++) {
            for (int j = 0; j + i < size; j++) {
                int choice1 = coins[j] + Math.min(dpTable[j + 2][j + i], 
                                                dpTable[j + 1][j + i - 1]);
                int choice2 = coins[j + i] + Math.min(dpTable[j + 1][j + i - 1], 
                                                    dpTable[j][j + i - 2]);

                // Store the index of the coin that was chosen
                if (choice1 > choice2) {
                    dpTable[j][j + i] = choice1;
                } else {
                    dpTable[j][j + i] = choice2;
                }
            }
        }
        max= dpTable[0][size - 1];
    }
    
    public void printCoins(int start, int end,int []coins) {
        // Base case: if start is greater than end, return
        if (start > end) {
            return;
        }
        // Base case: if start is equal to end, add the value of the coin at that index to the moves string and return
        if (start == end) {
            moves.add(coins[start]);
            return;
        }
        // Calculate the values of the two choices
        int choice1 = coins[start] + Math.min(dpTable[start + 2][end], dpTable[start + 1][end - 1]);
        int choice2 = coins[end] + Math.min(dpTable[start + 1][end - 1], dpTable[start][end - 2]);

        // If choice1 is greater, add the value of the first coin to the moves string and call printCoins again with updated indices
        if (choice1 > choice2) {
            moves.add(coins[start]);
            if (dpTable[start + 2][end] < dpTable[start + 1][end - 1]) {
                printCoins(start + 2, end, coins);
            } else {
                printCoins(start + 1, end - 1, coins);
            }
        } 
        // If choice2 is greater, add the value of the last coin to the moves string and call printCoins again with updated indices
        else {
            moves.add(coins[end]);

            if (dpTable[start + 1][end - 1] < dpTable[start][end - 2]) {
                printCoins(start + 1, end - 1, coins);
            } else {
                printCoins(start, end - 2, coins);
            }
        }
    }
    /*
     * Getters and Setters
     */
    public ArrayList<Integer> getSolution() {
		return moves;
	}

	public void setSolution(ArrayList<Integer> solution) {
		this.moves = solution;
	}
	
    public int getSize() {
		return size;
	}

	public void setSize(int n) {
		this.size = n;
	}

	public int[][] getDp() {
		return dpTable;
	}

	public void setDp(int[][] dp) {
		this.dpTable = dp;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}