package chess.pieces;

import tabuleiro.Board;
import tabuleiro.Position;
import chess.ChessPiece;
import chess.Cor;

public class Queen extends ChessPiece {
	
	public Queen(Board board, Cor cor) {
		super(board,cor);
	}

	@Override
	public String toString() {
		
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		Position p = new Position(0, 0);
		
		
		p.setValues(position.getLinha() - 1, position.getColuna());
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setLinha(p.getLinha()-1);
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		
		p.setValues(position.getLinha(), position.getColuna()-1);
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setColuna(p.getColuna()-1);
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		p.setValues(position.getLinha(), position.getColuna()+1);
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setColuna(p.getColuna()+1);
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		
		p.setValues(position.getLinha() + 1, position.getColuna());
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setLinha(p.getLinha()+1);
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		
		
		p.setValues(position.getLinha() - 1, position.getColuna()-1);
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setValues(p.getLinha()-1, p.getColuna()-1);
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		
		
		p.setValues(position.getLinha()-1, position.getColuna()+1);
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setValues(p.getLinha()-1, p.getColuna()+1);
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		
		
		
		p.setValues(position.getLinha()+1, position.getColuna()+1);
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setValues(p.getLinha()+1, p.getColuna()+1);
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		
		p.setValues(position.getLinha() + 1, position.getColuna()-1);
		while (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
	    mat[p.getLinha()][p.getColuna()] = true;	
	    p.setValues(p.getLinha()+1, p.getColuna()-1);
	 
			
		}
		if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			
		}
		
		
		return mat;
	}
}
