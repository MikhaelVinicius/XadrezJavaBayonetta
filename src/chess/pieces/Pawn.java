package chess.pieces;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.Cor;
import tabuleiro.Board;
import tabuleiro.Position;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Cor cor, ChessMatch chessMatch) {
		super(board, cor);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		Position p = new Position(0, 0);
		
		if(getCor() == Cor.WHITE) {
			p.setValues(position.getLinha()-1, position.getColuna());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
				
			}
			p.setValues(position.getLinha()-2, position.getColuna());
			Position p2 = new Position(position.getLinha() - 1, position.getColuna());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMovecount()==0) {
				mat[p.getLinha()][p.getColuna()] = true;
				
			}
			p.setValues(position.getLinha()-1, position.getColuna()-1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
				
			}
			p.setValues(position.getLinha()-1, position.getColuna()+1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
				
			}
			
			
			if(position.getLinha()==3) {
				Position left = new Position(position.getLinha(), position.getColuna()-1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left)== chessMatch.getEnPassantVulnerable() ) {
					mat[left.getLinha()-1][left.getColuna()] = true;
				}
				Position right = new Position(position.getLinha(), position.getColuna()+1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right)== chessMatch.getEnPassantVulnerable() ) {
					mat[right.getLinha()-1][right.getColuna()] = true;
				}
		
		
			}
		
			
		} else {	
			
		p.setValues(position.getLinha()+1, position.getColuna());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		p.setValues(position.getLinha()+2, position.getColuna());
		Position p2 = new Position(position.getLinha() + 1, position.getColuna());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMovecount()==0) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		p.setValues(position.getLinha()+1, position.getColuna()-1);
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		p.setValues(position.getLinha()+1, position.getColuna()+1);
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
	
		
		if(position.getLinha()==4) {
			Position left = new Position(position.getLinha(), position.getColuna()-1);
			if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left)== chessMatch.getEnPassantVulnerable() ) {
				mat[left.getLinha()+1][left.getColuna()] = true;
			}
			Position right = new Position(position.getLinha(), position.getColuna()+1);
			if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right)== chessMatch.getEnPassantVulnerable() ) {
				mat[right.getLinha()+1][right.getColuna()] = true;
			}
	
	
		}
	
			
		}
		
		return mat;
	}
	@Override
	public String toString() {
		return "p";
		
	}
}
