package com.addercop.fourteenpegs;

public class Main
{

	public static void main(String[] args)
	{
		Search.search(new BoardState(0));
		Search.search(new BoardState(1));
		Search.search(new BoardState(3));
		Search.search(new BoardState(4));
	}

}
