package app.dev.java.hacker;

import java.util.Scanner;

/**
 * Created by jananda on 05/04/2018.
 */
public class DuplicateNodesApp
{
	private static TailNode removeDuplicates( TailNode head )
	{
		TailNode start = head;
		TailNode end;
		while ( start != null )
		{
			end = start;
			start = start.next;
			if ( start != null && start.data == end.data )
			{
				end.next = start.next;
				start = head;
			}
		}
		return head;
	}

	private static TailNode insert( TailNode head, int data )
	{
		TailNode p = new TailNode( data );
		if ( head == null )
		{
			head = p;
		}
		else if ( head.next == null )
		{
			head.next = p;
		}
		else
		{
			TailNode start = head;
			while ( start.next != null )
			{
				start = start.next;
			}
			start.next = p;
		}
		return head;
	}

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
		int T = sc.nextInt();
		while ( T-- > 0 )
		{
			int ele = sc.nextInt();
			head = insert( head, ele );
		}
		head = removeDuplicates( head );
		display( head );

	}
}
