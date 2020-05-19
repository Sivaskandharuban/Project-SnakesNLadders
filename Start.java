package com.game.SnakesNLadders;

import java.util.Scanner;
import com.game.SnakesNLadders.Game;

public class Start {

	int P1, P2;
	int n = 0;
	static boolean P1Starts;
	static boolean P2Starts;
	int player1 = 0, player2 = 0;

	public boolean player1() {
		Scanner s = new Scanner(System.in);
		String str;
		System.out.println("---------------------------------------");
		System.out.println("Need 1 to get Started\n");
		if (P1 == 0) {
			System.out.println(GameMain.P1 + " 's turn\n");
			System.out.println("\nPress r to roll dice or x to exit \n");
			str = s.next();

			if (str.equals("r")) {
				do {
					n = Game.rollDice();
					if (P1Starts == false) {
						if (n == 1) {
							player1 = 1;
							P1Starts = true;
							System.out
									.println("---------------------------------------");
							System.out
									.println("\nHooorrraayyyy!!! You've got "
											+ n
											+ " started the game and owned extra turn\n");
							System.out.println(GameMain.P1 + " :: " + player1);
							System.out.println(GameMain.P2 + " :: " + player2);
							System.out
									.println("---------------------------------------");

							break;
						}
					} else {
						System.out.println("\nOops!!! Try again, You've got "
								+ n + "\n");
						player2();
					}
				} while (true);
			} else if (str.equals("x")) {
				System.out
						.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or any keys to cancel :");
				str = s.next();
				if (str.equals("x")) {
					System.out.println("You've exit the game " + GameMain.P2
							+ " wins");
					System.exit(0);
				} else
					player1();
			} else {
				System.out
						.println("\nPlease enter r to roll dice or x to exit\n");
				if (str.equals("r"))
					player1();
				else if (str.equals("x")) {
					System.out
							.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or any keys to cancel :");
					str = s.next();
					if (str.equals("x")) {
						System.out.println("You've exit the game "
								+ GameMain.P2 + " wins");
						System.exit(0);
					} else
						player1();
				}
			}

		}
		return P1Starts;
	}

	public boolean player2() {
		Scanner s = new Scanner(System.in);
		int n = 0;
		if (P2 == 0) {
			System.out.println("---------------------------------------");
			System.out.println(GameMain.P2 + " 's turn\n");
			System.out.println("\nPress r to roll dice or x to exit \n");
			String str = s.next();

			if (str.equals("r")) {
				do {
					n = Game.rollDice();
					if (P2Starts == false) {
						if (n == 1) {
							P2Starts = true;
							player2 = 1;
							System.out
									.println("---------------------------------------");
							System.out
									.println("\nHooorrraayyyy!!! You've got "
											+ n
											+ " and started the game and owned extra turn\n");
							System.out.println(GameMain.P1 + " :: " + player1);
							System.out.println(GameMain.P2 + " :: " + player2);
							System.out
									.println("---------------------------------------");

							break;
						}
					}

					else {
						System.out.println("\nOops!!! Try again, You've got "
								+ n + "\n");
						player1();
					}
				} while (true);
			} else if (str.equals("x")) {
				System.out
						.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or any keys to cancel :");
				str = s.next();
				if (str.equals("x")) {
					System.out.println("You've exit the game " + GameMain.P1
							+ " wins");
					System.exit(0);
				} else
					player2();
			} else {
				System.out
						.println("\nPlease enter r to roll dice or x to exit\n");
				if (str.equals("r"))
					player2();
				else if (str.equals("x")) {
					System.out
							.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or y to cancel :");
					if (str.equals("x")) {
						System.out.println("You've exit the game "
								+ GameMain.P1 + " wins");
						System.exit(0);
					} else
						player2();

				}
			}

		}
		return P2Starts;
	}

}
