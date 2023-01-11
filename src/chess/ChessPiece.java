package chess;

import tabuleiro.Board;
import tabuleiro.Piece;
import tabuleiro.Position;

public abstract class ChessPiece extends Piece {

	private Cor cor;
	private int moveCount;

	public ChessPiece(Board board, Cor cor) {
		super(board);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getMovecount() {
		return moveCount;
		
	}
	
	
	public void increaseMoveCount() {
		moveCount++;
		
		
		
	}
	
	public void decreaseMoveCount() {
		moveCount--;
		
		
		
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getCor() != cor;
	}

}
