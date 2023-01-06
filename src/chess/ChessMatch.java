package chess;

import chess.pieces.King;
import chess.pieces.Rook;
import tabuleiro.Board;
import tabuleiro.Piece;
import tabuleiro.Position;

public class ChessMatch {

	
	private int turn;
	private Cor currentPlayer;
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		turn = 1;
		currentPlayer = Cor.WHITE;
		inicialSetup();
	}
	
	public int getTurn() {
		
		return turn;
	}
	
	public Cor getCurrentPlayer() {
		return currentPlayer;
		
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
	
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
		
		
	}
	
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateTargetPosition(source,target);
		validateSourcePosition(source);
		Piece capturedPiece = makeMovie(source, target);
		nextTurn()
		return (ChessPiece)capturedPiece;
		
	}
	
	private Piece makeMovie(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p,target);
		return capturedPiece;
		
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMoves(target)) {
			throw new ChessException("A peça escolhida não pode se mover para essa posição.");
			
		}
		
	}
	
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
			
		}
		
	if(currentPlayer != ((ChessPiece)board.piece(position)).getCor()) {
			throw new ChessException("A peça escolhida não é sua!");
			
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Não há movimentos possíveis!");
			
		}
		
		
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
		
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
