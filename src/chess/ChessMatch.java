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
	
	private void placeNewPiece(char coluna, int linha, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(coluna, linha).toPosition());
		
	}
	
	private void inicialSetup() {
		placeNewPiece('c', 1, new Rook(board, Cor.WHITE));
        placeNewPiece('c', 2, new Rook(board, Cor.WHITE));
        placeNewPiece('d', 2, new Rook(board, Cor.WHITE));
        placeNewPiece('e', 2, new Rook(board, Cor.WHITE));
        placeNewPiece('e', 1, new Rook(board, Cor.WHITE));
        placeNewPiece('d', 1, new King(board, Cor.WHITE));

        placeNewPiece('c', 7, new Rook(board, Cor.BLACK));
        placeNewPiece('c', 8, new Rook(board, Cor.BLACK));
        placeNewPiece('d', 7, new Rook(board, Cor.BLACK));
        placeNewPiece('e', 7, new Rook(board, Cor.BLACK));
        placeNewPiece('e', 8, new Rook(board, Cor.BLACK));
        placeNewPiece('d', 8, new King(board, Cor.BLACK));
	}
}
