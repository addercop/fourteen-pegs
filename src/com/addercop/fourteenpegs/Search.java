package com.addercop.fourteenpegs;

import java.util.List;
import java.util.Stack;

public class Search
{

	public static void search(BoardState boardState)
	{
		System.out.println("Starting a search on board:");
		System.out.println(boardState);
		search(boardState, new Stack<Move>());
		System.out.println();
	}

	private static void search(BoardState boardState, Stack<Move> stack)
	{
		if (boardState.isSolved())
		{
			System.out.printf("Solution found\n");
			for (Move m : stack)
			{
				System.out.println(m);
			}
		}
		else
		{
			List<Move> legalMoves = boardState.getLegalMoves();
			for (Move m : legalMoves)
			{
				stack.push(m);
				search(boardState.applyMove(m), stack);
				stack.pop();
			}
		}
	}

}
