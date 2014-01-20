package com.addercop.fourteenpegs;

public class Move
{
	private final int start;

	private final int middle;

	private final int end;

	public Move(int start, int middle, int end)
	{
		this.start = start;
		this.middle = middle;
		this.end = end;
	}

	public int getStart()
	{
		return start;
	}

	public int getMiddle()
	{
		return middle;
	}

	public int getEnd()
	{
		return end;
	}

	@Override
	public String toString()
	{
		return String.format("(%d,%d,%d)", this.start, this.middle, this.end);
	}

}
