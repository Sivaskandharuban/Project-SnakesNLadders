package com.game.SnakesNLadders;

import java.util.Scanner;

public class GameMain {
	static String P1, P2;

	public static void main(String[] args) {

		
		int counter = 100, iteration = -1;
		System.out
				.println("-----------------------------------------------------Game Board-----------------------------------------------------------------------------");

		while (counter > 0) {
			if (counter % 10 == 0 && counter != 100) {// checks if the counter
														// is at a 90, or 80...
				if (iteration == -1) {

					counter -= 9;
					iteration = 1;
				} else {
					System.out.print(counter + "\t");
					counter -= 10;
					iteration = -1;
				}
				if (counter != 0)
					System.out.print("\n" + counter + "\t");
			} else
				System.out.print(counter + "\t");
			counter += iteration;
		}
		System.out.println();
		System.out
				.println("----------------------------------------------------------------------------------------------------------------------------------");

		Game G = new Game();

		Scanner s = new Scanner(System.in);
		System.out.print("Enter Player 1 name : ");

		do {
			P1 = s.next();
			if (P1.length() >= 2) {
				System.out.println("Hello " + P1);
			} else {
				System.out.println("Please give a valid name");
			}
		} while (P1.length() <= 1);

		System.out.print("Enter Player 2 name : ");
		do {
			P2 = s.next();
			if (P2.length() >= 2) {
				System.out.println("Hello " + P2);
			} else {
				System.out.println("Please give a valid name");
			}
		} while (P1.length() <= 1);

		G.Rules();

	}
}
