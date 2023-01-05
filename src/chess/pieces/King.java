package chess.pieces;
import tabuleiro.Board;
import chess.ChessPiece;
import chess.Cor;

public class King extends ChessPiece {
	public King(Board board, Cor cor) {
		super(board, cor);
		
	}

	
	@Override
	public String toString() {
		return "K";
		
	}


	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return mat;
	}
}
