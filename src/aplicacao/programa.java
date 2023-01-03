package aplicacao;

import chess.ChessMatch;

public class programa {

	public static void main(String[] args) {
	
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
		
	}

}
