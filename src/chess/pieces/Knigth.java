package chess.pieces;
import tabuleiro.Board;
import tabuleiro.Position;
import chess.ChessPiece;
import chess.Cor;

public class Knigth extends ChessPiece {
	public  Knigth(Board board, Cor cor) {
		super(board, cor);
		
	}

	
	@Override
	public String toString() {
		return "N";
		
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getCor() != getCor();
 		
	}
	


	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		Position p = new Position(0, 0);
		
		p.setValues(position.getLinha()-1,position.getColuna()-2);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()-2,position.getColuna()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()-2,position.getColuna()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()-1,position.getColuna()+2);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()+1,position.getColuna()+2);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()+2,position.getColuna()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()+2,position.getColuna()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()+1,position.getColuna()-2);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		
		
		
		return mat;
	}
}