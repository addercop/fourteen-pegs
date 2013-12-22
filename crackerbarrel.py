#!/usr/bin/python

import collections
import sys

Move = collections.namedtuple('Move',['start','jump','end'])

ALL_MOVES = []
ALL_MOVES.append(Move(0,2,5))
ALL_MOVES.append(Move(0,1,3))

ALL_MOVES.append(Move(1,4,8))
ALL_MOVES.append(Move(1,3,6))

ALL_MOVES.append(Move(2,4,7))
ALL_MOVES.append(Move(2,5,9))

ALL_MOVES.append(Move(3,1,0))
ALL_MOVES.append(Move(3,4,5))
ALL_MOVES.append(Move(3,6,10))
ALL_MOVES.append(Move(3,7,12))

ALL_MOVES.append(Move(4,7,11))
ALL_MOVES.append(Move(4,8,13))

ALL_MOVES.append(Move(5,2,0))
ALL_MOVES.append(Move(5,4,3))
ALL_MOVES.append(Move(5,8,12))
ALL_MOVES.append(Move(5,9,14))

ALL_MOVES.append(Move(6,3,1))
ALL_MOVES.append(Move(6,7,8))

ALL_MOVES.append(Move(7,4,2))
ALL_MOVES.append(Move(7,8,9))

ALL_MOVES.append(Move(8,4,1))
ALL_MOVES.append(Move(8,7,6))

ALL_MOVES.append(Move(9,5,2))
ALL_MOVES.append(Move(9,8,7))

ALL_MOVES.append(Move(10,6,13))
ALL_MOVES.append(Move(10,11,12))

ALL_MOVES.append(Move(11,7,4))
ALL_MOVES.append(Move(11,12,13))

ALL_MOVES.append(Move(12,7,3))
ALL_MOVES.append(Move(12,8,5))
ALL_MOVES.append(Move(12,11,10))
ALL_MOVES.append(Move(12,13,14))

ALL_MOVES.append(Move(13,8,4))
ALL_MOVES.append(Move(13,12,11))

ALL_MOVES.append(Move(14,9,5))
ALL_MOVES.append(Move(14,13,12))

ALL_MOVES = tuple(ALL_MOVES)

def make_starting_board(free_slot):
	if free_slot < 0 or free_slot > 14:
		raise Exception('Couldn\'t make starting board with free slot %d' % free_slot)
	return '1'*free_slot + '0' + '1'*(14-free_slot)

def make_all_starting_boards():
	return [make_starting_board(i) for i in range(15)]

def is_singleton_solution(board):
	return 1==board.count('1')

def is_legal_move(board,move):
	return board[move.start] == '1' and board[move.jump] == '1' and board[move.end] == '0'

def get_all_legal_moves(board):
	return [move for move in ALL_MOVES if is_legal_move(board,move)]

def apply_move(board,move):
	assert is_legal_move(board, move)
	slot_list = list(board)
	slot_list[move.start] = '0'
	slot_list[move.jump] = '0'
	slot_list[move.end] = '1'
	new_board = "".join(slot_list)
	assert board.count('1') == (new_board.count('1')+1)
	return new_board

def output_solution(board_stack,move_stack):
	print "Solution found"
	for board in board_stack:
		print "\t%s" % str(board)
	for move in move_stack:
		print "\t%s" % str(move)
	print

def search(board_stack, move_stack=[]):
	if is_singleton_solution(board_stack[-1]):
		output_solution(board_stack,move_stack)
		if len(move_stack) > 0:
			move_stack.pop()
		if len(board_stack) > 0:
			board_stack.pop()
		return
	moves = get_all_legal_moves(board_stack[-1])
	for move in moves:
		new_board = apply_move(board_stack[-1],move)
		move_stack.append(move)
		board_stack.append(new_board)
		search(board_stack,move_stack)
		if len(move_stack) > 0:
			move_stack.pop()
		if len(board_stack) > 0:
			board_stack.pop()

def main():
	starting_boards = [make_starting_board(0)]
	for board in starting_boards:
		print board
		search([board])

if __name__ == '__main__':
	main()
