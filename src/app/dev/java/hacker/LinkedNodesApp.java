package app.dev.java.hacker;

import java.util.Scanner;

/**
 * Created by jananda on 04/04/2018.
 */
class LinkedNodesApp
{
	private static void display( TailNode head )
	{
		TailNode start = head;
		while ( start != null )
		{
			System.out.print( start.data + " " );
			start = start.next;
		}
	}

	public static void main( String args[] )
	{
		Scanner sc = new Scanner( System.in );
		TailNode head = null;
		int N = sc.nextInt();

		while ( N-- > 0 )
		{
			int ele = sc.nextInt();
			head = insert( head, ele );
		}
		display( head );
		sc.close();

	}

	private static TailNode insert( TailNode head, int data )
	{
		TailNode x = new TailNode( data );

		if ( head == null )
		{
			head = x;
		}
		else
		{
			TailNode start = head;
			TailNode end = head;
			while ( start != null )
			{
				end = start;
				start = start.next;
			}
			end.next = x;
		}
		return head;
	}
}

class TailNode
{
	int data;
	TailNode next;

	TailNode( int d )
	{
		data = d;
		next = null;
	}
}

