package test;

import java.util.Scanner;

public class HILO {

	public static void main(String[] args) {

		final int MAX= 100;

		String againfinal = "ja";
		String again= "ja";

		Scanner scan= new Scanner (System.in);
		Scanner scan2= new Scanner (System.in);








		while (againfinal.equals(again)) {

			int anzahl = 0;
			int winnr= (int)(Math.random() * MAX) + 1;
			System.out.println("Bitte geben sie eine Zahl von 1-100 ein.");
			int eingabe = scan.nextInt();
			

			while (eingabe > 100 || eingabe<1){

				System.out.println("Bitte geben sie eine Zahl von 1-100 ein.");
				eingabe = scan.nextInt();

			}

			while (eingabe != winnr ){
				anzahl++;

				if (eingabe < winnr){

					System.out.println("Die gesuchte Zahl ist höher");
					System.out.println("Bitte geben sie eine Zahl von 1-100 ein.");
					eingabe = scan.nextInt();

				}
				else {

					System.out.println("Die gesuchte Zahl ist tiefer");
					System.out.println("Bitte geben sie eine Zahl von 1-100 ein.");
					eingabe = scan.nextInt();
				}




			}



			System.out.println("Sie haben die Zahl erraten!!!!");
			System.out.println("Sie haben "+ (anzahl+1)+ " gebraucht");
			System.out.println("Nochmal spielen?.");
			again = scan2.nextLine();


		}

		System.out.println("Danke fürs spielen");


	}




}
