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
}
