package com.addercop.fourteenpegs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BoardState
{

	public static final int BOARD_SIZE = 15;

	private final boolean board[];

	public BoardState(int freeSpace)
	{
		boolean board[] = new boolean[BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			board[i] = true;
		}
		board[freeSpace] = false;
		this.board = board;
	}

	private BoardState(boolean board[])
	{
		this.board = board;
	}

	public boolean isLegal(Move m)
	{
		return this.board[m.getStart()] && this.board[m.getMiddle()]
				&& !this.board[m.getEnd()];
	}

	public BoardState applyMove(Move m)
	{
		boolean newBoard[] = Arrays.copyOf(board, BOARD_SIZE);
		newBoard[m.getStart()] = false;
		newBoard[m.getMiddle()] = false;
		newBoard[m.getEnd()] = true;
		return new BoardState(newBoard);
	}

	public boolean isSolved()
	{
		int i;
		int count = 0;
		for (i = 0; i < BOARD_SIZE; i++)
		{
			if (board[i])
			{
				count++;
			}
		}

		return 1 == count;
	}

	public List<Move> getLegalMoves()
	{
		List<Move> legalMoves = new ArrayList<Move>();
		Iterator<Move> iterator = AllMoves.getIterator();
		while (iterator.hasNext())
		{
			Move m = iterator.next();
			if (isLegal(m))
			{
				legalMoves.add(m);
			}
		}
		return legalMoves;
	}

	@Override
	public String toString()
	{
		int i = 0;
		StringBuilder s = new StringBuilder();
		s.append(this.board[i++] ? 'X' : 'O');
		s.append('\n');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append('\n');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append('\n');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append('\n');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');
		s.append(this.board[i++] ? 'X' : 'O');

		return s.toString();
	}
}
