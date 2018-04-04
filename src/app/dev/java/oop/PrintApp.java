package app.dev.java.oop;

import java.util.Scanner;

/**
 * Created by java on 04/04/2018.
 */
public class PrintApp
{
	public static void main1( String[] args )
	{
		Book xx = new MyBook( "x", "y", 10 );
		xx.display();

		Scanner scan = new Scanner( System.in );
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for ( int i = 0; i < numScores; i++ )
		{
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student( firstName, lastName, id, testScores );
		s.printPerson();
		System.out.println( "Grade: " + s.calculate() );
	}

	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );
		String x = scan.nextLine();
		int y = scan.nextInt();

		System.out.println( "You entered" + x + " " + y );
	}
}
