package app.dev.java.hacker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jananda on 04/04/2018.
 */
public class BinaryTree
{
	private static Map<Integer, List<BinaryNode>> levelMap = new HashMap<>();
	private static int count = 0;

	private static int getHeight( BinaryNode root )
	{
		int level = addLevels( root );
		do
		{
			List<BinaryNode> node1List = levelMap.get( level );
			level = addLevels( node1List.toArray( new BinaryNode[node1List.size()] ) );
		}
		while ( level != -1 );

		return count;
	}

	private static void levelOrder( BinaryNode root )
	{
		List<Integer> nodeValues = new ArrayList<>();
		nodeValues.add( root.data );

		int level = addLevels( root );
		do
		{
			List<BinaryNode> node1List = levelMap.get( level );
			level = addLevels( node1List.toArray( new BinaryNode[node1List.size()] ) );

			for ( BinaryNode bn : node1List )
			{
				nodeValues.add( bn.data );
			}
		}
		while ( level != -1 );

		String x = "";
		for ( int i : nodeValues )
		{
			x += i + " ";
		}
		System.out.println( x );

	}

	private static int addLevels( BinaryNode... nodes )
	{
		List<BinaryNode> levelList = new ArrayList<>();
		for ( BinaryNode node1 : nodes )
		{
			if ( node1.left != null )
			{
				levelList.add( node1.left );
			}
			if ( node1.right != null )
			{
				levelList.add( node1.right );
			}
		}

		if ( !levelList.isEmpty() )
		{
			levelMap.put( ++count, levelList );
		}

		if ( levelList.isEmpty() )
		{
			return -1;
		}
		return count;
	}

	private static BinaryNode insert( BinaryNode root, int data )
	{
		if ( root == null )
		{
			return new BinaryNode( data );
		}
		else
		{
			BinaryNode cur;
			if ( data <= root.data )
			{
				cur = insert( root.left, data );
				root.left = cur;
			}
			else
			{
				cur = insert( root.right, data );
				root.right = cur;
			}
			return root;
		}
	}

	public static void main( String args[] )
	{
		Scanner sc = new Scanner( System.in );
		int T = sc.nextInt();
		BinaryNode root = null;
		while ( T-- > 0 )
		{
			int data = sc.nextInt();
			root = insert( root, data );
		}
		int height = getHeight( root );
		System.out.println( height );

		levelOrder( root );
	}
}

