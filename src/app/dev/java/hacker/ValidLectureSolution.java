package app.dev.java.hacker;

/**
 * Created by jananda on 17/04/2018.
 */
public class ValidLectureSolution
{
	public static void main( String[] args )
	{
		int lectureCount = 5;
		System.out.println( lectureCount );

		ValidLecture vl1 = new ValidLecture( 4, 3, new int[] { -1, -3, 1, 2 } );
		vl1.print();

		ValidLecture vl2 = new ValidLecture( 4, 2, new int[] { 0, -1, 2, 1 } );
		vl2.print();

		ValidLecture vl3 = new ValidLecture( 5, 3, new int[] { -1, -3, 1, 2, -1 } );
		vl3.print();

		ValidLecture vl4 = new ValidLecture( 5, 3, new int[] { -1, -3, 1, 2, 1 } );
		vl4.print();

		ValidLecture vl5 = new ValidLecture( 6, 3, new int[] { -1, -2, -3, 1, 2, 3 } );
		vl5.print();
	}
}

class ValidLecture
{
	private int students;
	private int margin;
	private int[] arrivetime;

	ValidLecture( int students, int margin, int[] arrivetime )
	{
		this.students = students;
		this.margin = margin;
		this.arrivetime = arrivetime;

	}

	void print()
	{
		System.out.println( students + " " + margin );
		StringBuilder x = new StringBuilder();
		for ( int anArrivetime : arrivetime )
		{
			x.append( anArrivetime ).append( " " );
		}
		System.out.println( x );
	}
}

