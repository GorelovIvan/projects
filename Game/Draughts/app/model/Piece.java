package model;

public class Piece {
	private PieceType pieceType = PieceType.blank;
	private PlayerColor playerColor = null;
	
	public Piece(PieceType pieceType , PlayerColor playerColor){
		this.pieceType = pieceType;
		this.playerColor = playerColor;
	}
	
	public PieceType getPieceType() {
		return pieceType;
	}
	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	public PlayerColor getPlayerColor() {
		return playerColor;
	}
	public void setPlayerColor(PlayerColor playerColor) {
		this.playerColor = playerColor;
	}	
}