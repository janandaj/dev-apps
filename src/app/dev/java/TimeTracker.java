package app.dev.java;

/**
 * Created by jananda on 04/04/2018.
 */
public class TimeTracker
{
	private boolean mesuring;
	private long totalTime = 0;
	private long tStart = 0;

	public TimeTracker start()
	{
		mesuring = true;
		tStart = System.currentTimeMillis();
		return this;
	}

	public void endAndTrace()
	{
		end();
		System.out.println( totalTime );
	}

	public void endAndTrace( String text )
	{
		end();
		System.out.println( text + " :: " + totalTime );
	}

	public long end()
	{
		if ( mesuring )
		{
			mesuring = false;
			long tStoped = System.currentTimeMillis();
			long tLastAction = tStoped - tStart;
			totalTime += tLastAction;
			tStart = 0;
		}
		return totalTime;
	}
}
