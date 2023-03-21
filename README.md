# Optimal coins game strategy:
This project was created as part of Algorithm analysis course. A java project that uses dynamic programming to implemnt the Optimal game strategy of coins. 

# Problem Description
<p> This is a two-player game. There are even number of coins arranged in a row. There will be alternate turns. In each turn, a player can either select the first coin in the row or the last coin in the row and keep it with him. The objective of the problem is to determine the maximum possible amount of money a player can definitely win, if he moves first.</p>
<p>In this problem, we will try to collect maximum amount without underestimating the opponent. We can choose either the first or the last coin in the row. We will pick the one which results in giving us lesser amount to ensure that we can definitely win this much of amount irrespective of opponent’s moves.</p>

# Input and Output
<p>Coins [] = 4, 15, 7, 3, 8, 9</p>
<p>Expected result= 27</p>
<p>The input.txt file is an example of the input file.</p>
 
# App screenshots:
Main:
![1](https://user-images.githubusercontent.com/65151701/212492627-dfd90a0d-71f1-4f41-8454-dd2ddd9432fa.jpg)

Browse file or input using the textbox:
![2](https://user-images.githubusercontent.com/65151701/212492630-30bac139-03ed-4653-98bc-a3fceb4e2005.jpg)

The main after running the program:
![3](https://user-images.githubusercontent.com/65151701/212492637-e844f11c-4724-4881-bd44-40750540728d.jpg)

The dynamic table filled using bottom up approach:
![4](https://user-images.githubusercontent.com/65151701/212492640-87c5f265-599b-4682-9e83-25f875a41a4b.jpg)

A simualtion of the game in which player 1 gets the optimal solution:
![5](https://user-images.githubusercontent.com/65151701/212492644-19438a1f-5bab-4dcd-ada4-e51ce8511858.jpg)
