package tabuleiro;

public class Board {

	private int linhas;
	private int colunas;
	private Piece[][] pieces;

	public Board(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new BoardException("Erro criando o tabuleiro:É necessário que haja ao menor uma linha e uma coluna.");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pieces = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Piece piece(int linha, int coluna) {
		if (!positionExists(linha, coluna)) {
			throw new BoardException("Position not on the board");
		}

		return pieces[linha][coluna];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getLinha()][position.getColuna()];

	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is alredy a piece" + position);
		}
		  pieces[position.getLinha()][position.getColuna()] = piece;
	      piece.position = position;
	}

	public Piece removePiece(Position position) {
			if(!positionExists(position)) {
				throw new BoardException("Posição não está no tabuleiro!");
				}
			if(piece(position)== null) {
				return null;
			}
			Piece aux = piece(position);
			aux.position = null;
			pieces[position.getLinha()][position.getColuna()] = null;
			return aux;
		}


	private boolean positionExists(int linha, int coluna) {
		return linha >= 0 && linha < linhas  && coluna >= 0 && coluna < colunas;
		
	}

	public boolean positionExists(Position position){
		return positionExists(position.getLinha(), position.getColuna());
	}

	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		
		return piece(position) != null;
		
	}

}
