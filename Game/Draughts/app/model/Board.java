package model;

public class Board {

	private final int LENGTH = 8;
	private final int HIGH = 8;

	private Piece[][] board = new Piece[LENGTH][HIGH];
	private int countOfWhitePieces;
	private int countOfBlackPieces;

	public Board() {
		// init the board
		
		for(int i = 0 ;i < LENGTH ; i++){
			for(int j =0 ; j< HIGH;j++){
				this.board[i][j] = new Piece(PieceType.blank, null);
			}
		}

		// Init black player
		this.board[1][0] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[3][0] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[5][0] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[7][0] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[0][1] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[2][1] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[4][1] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[6][1] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[1][2] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[3][2] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[5][2] = new Piece(PieceType.piece, PlayerColor.black);
		this.board[7][2] = new Piece(PieceType.piece, PlayerColor.black);

		// Init white player
		this.board[0][5] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[2][5] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[4][5] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[6][5] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[1][6] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[3][6] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[5][6] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[7][6] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[0][7] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[2][7] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[4][7] = new Piece(PieceType.piece, PlayerColor.white);
		this.board[6][7] = new Piece(PieceType.piece, PlayerColor.white);

		this.countOfBlackPieces = 12;
		this.countOfWhitePieces = 12;
	}

	public Piece[][] getBoard(){
		return this.board;
	}
	
	public boolean isGameOver() {
		return (this.countOfBlackPieces == 0 || this.countOfWhitePieces == 0);
	}

	public boolean move(PlayerColor playercolor, int fromX, int fromY, int toX,
			int toY) {

		if (board[fromX][fromY].getPlayerColor() == playercolor) {
			
			if (board[fromX][fromY].getPieceType() == PieceType.queen) {
				return moveQueen(playercolor, fromX, fromY, toX, toY);
			} else if (board[fromX][fromY].getPieceType() == PieceType.piece) {
				return movePiece(playercolor, fromX, fromY, toX, toY);
			}
		}

		return false;
	}

	private boolean moveQueen(PlayerColor playercolor, int fromX, int fromY,
			int toX, int toY) {
		// Check the destination
		if (board[toX][toY].getPieceType() == PieceType.blank
				&& Math.abs(fromX - toX) == Math.abs(fromY - toY)) {

			changePieces(fromX, fromY, toX, toY);

			for (int x = 1; x < Math.abs(fromX - toX); x++) {
				Piece temp = board[fromX + x][fromY + 1];
				if (temp.getPieceType() != PieceType.blank
						&& temp.getPlayerColor() != playercolor) {
					takeOpponentPiece( fromX + x, fromY + 1 , playercolor);
				}
			}
			return true;
		}
		return false;
	}

	private boolean movePiece(PlayerColor playercolor, int fromX, int fromY,
			int toX, int toY) {

		if (Math.abs(fromX - toX) == 1) {
			// Check if destination is a piece
			if (board[toX][toY].getPieceType() == PieceType.blank) {
				changePieces(fromX, fromY, toX, toY);
				if ((playercolor == PlayerColor.black && toX == HIGH)
						|| (playercolor == PlayerColor.white && toX == 0)) {
					board[toX][toY].setPieceType(PieceType.queen);
				}
				return true;
			}

			// Take the opponent piece
		} else if (Math.abs(fromX - toX) == 2) {

			Piece midPiece = board[(fromX + toX) / 2][(fromY + toY) / 2];
			
			if (midPiece.getPlayerColor() != null	&& midPiece.getPlayerColor() != playercolor) {
				changePieces(fromX, fromY, toX, toY);
				takeOpponentPiece((fromX + toX) / 2, (fromY + toY) / 2, playercolor);
				return true;
			}
		}
		return false;
	}

	private void takeOpponentPiece(	int midx, int midy , PlayerColor curColor) {		
		board[midx][midy].setPieceType(PieceType.blank);
		board[midx][midy].setPlayerColor(null);
		
		if(curColor == PlayerColor.black)
			this.countOfWhitePieces--;
		else
			this.countOfBlackPieces--;
		
	}

	private void changePieces(int fromX, int fromY, int toX, int toY) {
		board[toX][toY] = board[fromX][fromY];
		board[fromX][fromY].setPieceType(PieceType.blank);
		board[fromX][fromY].setPlayerColor(null);
	}
}