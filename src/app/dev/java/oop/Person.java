package app.dev.java.oop;

/**
 * Created by java on 04/04/2018.
 */
class Person
{
	private String firstName;
	private String lastName;
	private int idNumber;

	// Constructor
	Person( String firstName, String lastName, int identification )
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

	// Print person data
	void printPerson()
	{
		System.out.println( "Name: " + lastName + ", " + firstName + "\nID: " + idNumber );
	}
}

class Student extends Person
{
	private int[] testScores;

	Student( String firstName, String lastName, int identification, int[] scores )
	{
		super( firstName, lastName, identification );
		this.testScores = scores;
	}

	char calculate()
	{
		int total = 0;
		for ( int testScore : testScores )
		{
			total += testScore;
		}
		double average = ( double ) total / testScores.length;
		System.out.println( average );
		if ( average < 40 )
		{
			return 'T';
		}
		else if ( average >= 40 && average < 55 )
		{
			return 'D';
		}
		else if ( average >= 55 && average < 70 )
		{
			return 'P';
		}
		else if ( average >= 70 && average < 80 )
		{
			return 'A';
		}
		else if ( average >= 80 && average < 90 )
		{
			return 'E';
		}
		else
		{
			return 'O';
		}
	}
}