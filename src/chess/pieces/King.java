package chess.pieces;
import tabuleiro.Board;
import tabuleiro.Position;
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
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getCor() != getCor();
 		
	}
	


	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		Position p = new Position(0, 0);
		
		p.setValues(position.getLinha()-1,position.getColuna());
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()+1,position.getColuna());
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha(),position.getColuna()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha(),position.getColuna()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()-1,position.getColuna()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()-1,position.getColuna()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()+1,position.getColuna()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		p.setValues(position.getLinha()+1,position.getColuna()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			}
		
		
		
		
		return mat;
	}
}
