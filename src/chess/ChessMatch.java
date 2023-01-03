package chess;

import chess.pieces.King;
import chess.pieces.Rook;
import tabuleiro.Board;
import tabuleiro.Position;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		inicialSetup();
	}
	public ChessPiece[][] getPieces(){
		
		ChessPiece[][] mat = new ChessPiece[board.getLinhas()][board.getColunas()];
		for(int i=0; i<board.getLinhas();i++) {
			for(int j=0; j<board.getColunas(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	private void inicialSetup() {
		board.placePiece(new Rook(board,Cor.WHITE), new Position(2,1));
		board.placePiece(new King(board,Cor.BLACK), new Position(2,1));
		board.placePiece(new King(board,Cor.WHITE), new Position(7,4));
	}
}
