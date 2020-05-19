package com.game.SnakesNLadders;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game extends Start {

	final static int WINPOINT = 100;
	Scanner s = new Scanner(System.in);
	String str;

	HashMap<Integer, Integer> snakes = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> ladders = new HashMap<Integer, Integer>();

	{
		snakes.put(17, 7);
		snakes.put(54, 34);
		snakes.put(64, 60);
		snakes.put(87, 24);
		snakes.put(95, 75);
		snakes.put(62, 19);

		ladders.put(4, 14);
		ladders.put(9, 31);
		ladders.put(20, 38);
		ladders.put(28, 84);
		ladders.put(40, 59);
		ladders.put(51, 67);
	}

	public void Rules() {
		// for player 1
		boolean P1Plays = player1();
		if (P1Plays == true)
			P1startGame();

		boolean P2Plays = player2();
		if (P2Plays == true)
			P2startGame();
	}

	public static int rollDice() {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(7);
		return (n == 0 ? 1 : n);
	}

	public void P1startGame() {
		int diceValue = 0;

		System.out.println("\n\n" + GameMain.P1 + " 's TURN:");
		System.out.println("Press r to roll Dice (or) x to exit");
		str = s.next();
		if (str.equals("r")) {
			diceValue = rollDice();

			System.out.println(GameMain.P1 + " got " + diceValue);
			if (diceValue == 1) {
				System.out.println(GameMain.P1 + " got extra turn ");
				player1 = calculatePlayerValue(player1, diceValue);
				System.out.println("---------------------------------------");
				System.out.println(GameMain.P1 + " :: " + player1);
				System.out.println(GameMain.P2 + " :: " + player2);
				System.out.println("---------------------------------------");

				if (isWin(player1)) {
					System.out.println(GameMain.P1 + " wins");
					System.out
							.println("\nWant to play again, Press s to play again or any other key to quit");
					str = s.next();
					if (str.equals("s")) {
						Rules();
					} else {
						System.out.println("See you soon!!!!!!!");
						System.exit(0);
					}
				}

				// if (P2Starts == true) {
				// P2startGame();
				// }

				P1startGame();
			}

			else {
				player1 = calculatePlayerValue(player1, diceValue);
				System.out.println("---------------------------------------");
				System.out.println(GameMain.P1 + " :: " + player1);
				System.out.println(GameMain.P2 + " :: " + player2);
				System.out.println("---------------------------------------");
				if (isWin(player1)) {
					System.out.println(GameMain.P1 + " wins");
					System.out
							.println("\nWant to play again, Press s to play again or any other key to quit");
					str = s.next();
					if (str.equals("s")) {
						Rules();
					} else {
						System.out.println("See you soon!!!!!!!");
						System.exit(0);
					}

				}
				if (P2Starts == true) {
					P2startGame();
				}
			}
		}

		else if (str.equals("x")) {
			System.out
					.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or any keys to cancel :");
			str = s.next();
			if (str.equals("x")) {
				System.out.println("You've exit the game " + GameMain.P2
						+ " wins");
				System.exit(0);
			} else
				P1startGame();
		} else {
			System.out.println("\nPlease enter r to roll dice or x to exit\n");
			str = s.next();
			if (str.equals("r"))
				P1startGame();
			else if (str.equals("x")) {
				System.out
						.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or any keys to cancel :");
				str = s.next();
				if (str.equals("x")) {
					System.out.println("You've exit the game " + GameMain.P2
							+ " wins");
					System.exit(0);
				} else {
					P1startGame();
				}
			}
		}
	}

	public void P2startGame() {
		int diceValue = 0;

		System.out.println("\n\n" + GameMain.P2 + " 's TURN:");
		System.out.println("Press r to roll Dice (or) x to exit");
		str = s.next();
		if (str.equals("r")) {
			diceValue = rollDice();

			System.out.println(GameMain.P2 + " got " + diceValue);
			if (diceValue == 1) {
				System.out.println(GameMain.P2 + " got extra turn ");
				player2 = calculatePlayerValue(player2, diceValue);
				System.out.println("---------------------------------------");
				System.out.println(GameMain.P1 + " :: " + player1);
				System.out.println(GameMain.P2 + " :: " + player2);
				System.out.println("---------------------------------------");
				if (isWin(player2)) {
					System.out.println(GameMain.P2 + " wins");
					System.out
							.println("\nWant to play again, Press s to play again or any other key to quit");
					str = s.next();
					if (str.equals("s")) {
						Rules();
					} else {
						System.out.println("See you soon!!!!!!!");
						System.exit(0);
					}

				}
				P2startGame();

			}

			else {
				player2 = calculatePlayerValue(player2, diceValue);
				System.out.println("---------------------------------------");
				System.out.println(GameMain.P1 + " :: " + player1);
				System.out.println(GameMain.P2 + " :: " + player2);
				System.out.println("---------------------------------------");
				if (isWin(player2)) {
					System.out.println(GameMain.P2 + " wins");
					System.out
							.println("\nWant to play again, Press s to play again or any other key to quit");
					str = s.next();
					if (str.equals("s")) {
						Rules();
					} else {
						System.out.println("See you soon!!!!!!!");
						System.exit(0);
					}

				}
				if (P1Starts == true) {
					P1startGame();
				}
			}
		}

		else if (str.equals("x")) {
			System.out
					.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or any keys to cancel :");
			str = s.next();
			if (str.equals("x")) {
				System.out.println("You've exit the game " + GameMain.P1
						+ " wins");
				System.exit(0);
			} else
				P2startGame();
		} else {
			System.out.println("\nPlease enter r to roll dice or x to exit\n");
			str = s.next();
			if (str.equals("r"))
				P2startGame();
			else if (str.equals("x")) {
				System.out
						.println("Are you sure, You want to exit? It will make opponent win\n if Yes Press x or any keys to cancel :");
				str = s.next();
				if (str.equals("x")) {
					System.out.println("You've exit the game " + GameMain.P1
							+ " wins");
					System.exit(0);
				} else {
					P2startGame();
				}
			}
		}
	}

	public int calculatePlayerValue(int player, int diceValue) {
		player = player + diceValue;

		if (player > WINPOINT) {
			player = player - diceValue;
			return player;
		}

		try {

			if (null != snakes.get(player)) {
				System.out.println("swallowed by snake");
				player = snakes.get(player);

			}

			if (null != ladders.get(player)) {
				System.out.println("climbing up the ladder");
				player = ladders.get(player);

			}
		} catch (NullPointerException e) {
			System.out.println("Number is Missing");
			e.printStackTrace();

		}
		return player;
	}

	public static boolean isWin(int player) {
		return WINPOINT == player;

	}

}
