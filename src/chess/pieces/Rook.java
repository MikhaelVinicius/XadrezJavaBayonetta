package chess.pieces;

import tabuleiro.Board;
import chess.ChessPiece;
import chess.Cor;

public class Rook extends ChessPiece {
	
	public Rook(Board board, Cor cor) {
		super(board,cor);
	}

	@Override
	public String toString() {
		
		return "R";
	}
}
