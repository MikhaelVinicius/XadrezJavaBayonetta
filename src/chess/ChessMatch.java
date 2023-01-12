package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knigth;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;
import tabuleiro.Board;
import tabuleiro.Piece;
import tabuleiro.Position;

public class ChessMatch {

	
	private int turn;
	private Cor currentPlayer;
	private Board board;
	private boolean check;
	private boolean checkMate;
	
	private List<Piece> piecesOnTheBoard = new ArrayList();
	private List<Piece> capturedPieces = new ArrayList();
	
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
	
	public boolean getCheck() {
		
		return check;
		
	}
	
	public boolean getCheckMate(){
		
		
		return checkMate;
		
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
		
		if(testCheck(currentPlayer)) {
			undoMove(source,target, capturedPiece);
			throw new ChessException("Voce não pode se colocar em check");
			}
		
		check = (testCheck(opponent(currentPlayer)))? true : false;
		
		if(testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		}
		else {
		
		nextTurn();
		
		}
		
		return (ChessPiece)capturedPiece;
		
	}
	
	private Piece makeMovie(Position source, Position target) {
		ChessPiece p = (ChessPiece)board.removePiece(source);
		p.increaseMoveCount();
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p,target);
		
		if (capturedPiece !=  null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
		
	}
	
	
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		ChessPiece p =(ChessPiece)board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p,source);
		
		if(capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPieces);
			piecesOnTheBoard.add(capturedPiece);
		}
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
	
	private Cor opponent(Cor cor) {
		return (cor == Cor.WHITE)? Cor.BLACK : Cor.WHITE;
		
		
	}
	
	
	private ChessPiece king(Cor cor) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getCor()== cor).collect(Collectors.toList()); 
		for(Piece p : list) {
			if(p instanceof King) {
				
				return (ChessPiece)p;
				
			}
			
			
		}
		throw new IllegalStateException("Não há rei"+ cor + "no tabuleiro");
		
	}
	
	private boolean testCheck(Cor cor) {
		Position kingPosition = king(cor).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getCor()== opponent(cor)).collect(Collectors.toList()); 
		for(Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if(mat[kingPosition.getLinha()][kingPosition.getColuna()]) {
				return true;
			}
			
			
			
		}
		return false;
	}
	
	private boolean testCheckMate(Cor cor) {
		if(!testCheck(cor)) {
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getCor()== cor).collect(Collectors.toList()); 
		for(Piece p : list ) {
			boolean[][] mat = p.possibleMoves();
			for(int i = 0;i<board.getLinhas(); i++ ) {
				for(int j=0; j < board.getColunas();j++) {
					if(mat[i][j]) {
						Position source = ((ChessPiece)p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMovie(source, target);
						boolean testCheck = testCheck(cor);
						undoMove(source, target, capturedPiece);
						if(!testCheck){
							return false;
							
						}
					}
				}
				
				
			}
		}
		
		return true;
	}
	
	
	private void placeNewPiece(char coluna, int linha, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(coluna, linha).toPosition());
		piecesOnTheBoard.add(piece);
		
	}
	
	private void inicialSetup() {
	        placeNewPiece('a', 1, new Rook(board, Cor.WHITE));
	        placeNewPiece('b', 1, new Knigth(board, Cor.WHITE));
	        placeNewPiece('c', 1, new Bishop(board, Cor.WHITE));
	        placeNewPiece('d', 1, new Queen(board, Cor.WHITE));
	        placeNewPiece('e', 1, new King(board, Cor.WHITE));
	        placeNewPiece('f', 1, new Bishop(board, Cor.WHITE));
	        placeNewPiece('g', 1, new Knigth(board, Cor.WHITE));
	        placeNewPiece('h', 1, new Rook(board, Cor.WHITE));
	        placeNewPiece('a', 2, new Pawn(board, Cor.WHITE));
	        placeNewPiece('b', 2, new Pawn(board, Cor.WHITE));
	        placeNewPiece('c', 2, new Pawn(board, Cor.WHITE));
	        placeNewPiece('d', 2, new Pawn(board, Cor.WHITE));
	        placeNewPiece('e', 2, new Pawn(board, Cor.WHITE));
	        placeNewPiece('f', 2, new Pawn(board, Cor.WHITE));
	        placeNewPiece('g', 2, new Pawn(board, Cor.WHITE));
	        placeNewPiece('h', 2, new Pawn(board, Cor.WHITE));

	        placeNewPiece('a', 8, new Rook(board, Cor.BLACK));
	        placeNewPiece('b', 8, new Knigth(board, Cor.BLACK));
	        placeNewPiece('c', 8, new Bishop(board, Cor.BLACK));
	        placeNewPiece('d', 8, new Queen(board, Cor.BLACK));
	        placeNewPiece('e', 8, new King(board, Cor.BLACK));
	        placeNewPiece('f', 8, new Bishop(board, Cor.BLACK));
	        placeNewPiece('g', 8, new Knigth(board, Cor.BLACK));
	        placeNewPiece('h', 8, new Rook(board, Cor.BLACK));
	        placeNewPiece('a', 7, new Pawn(board, Cor.BLACK));
	        placeNewPiece('b', 7, new Pawn(board, Cor.BLACK));
	        placeNewPiece('c', 7, new Pawn(board, Cor.BLACK));
	        placeNewPiece('d', 7, new Pawn(board, Cor.BLACK));
	        placeNewPiece('e', 7, new Pawn(board, Cor.BLACK));
	        placeNewPiece('f', 7, new Pawn(board, Cor.BLACK));
	        placeNewPiece('g', 7, new Pawn(board, Cor.BLACK));
	        placeNewPiece('h', 7, new Pawn(board, Cor.BLACK));
	      
      
	}
}
