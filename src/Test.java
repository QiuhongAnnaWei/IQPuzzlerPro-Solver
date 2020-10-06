import java.util.ArrayList;

public class Test {
	
	// full set:
	
	public static ArrayList<Piece> fullPieces(){
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece("Blue", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(2, 0),
				new Coordinate(2, 1),
				new Coordinate(2, 2)}));
		pieces.add(new Piece("Grass", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(1, 2),
				new Coordinate(0, 2)}));
		pieces.add(new Piece("Orange", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(2, 1),
				new Coordinate(1, 2)}));
		pieces.add(new Piece("Purple", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(2, 1),
				new Coordinate(2, 2)}));
		pieces.add(new Piece("Red", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(1, 2),
				new Coordinate(1, 3)}));
		pieces.add(new Piece("Sky", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1)}));
		pieces.add(new Piece("DarkBlue", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(1, 2)}));
		pieces.add(new Piece("Maroon", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(2, 1)}));
		pieces.add(new Piece("Yellow", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(2, 0),
				new Coordinate(3, 0)}));
		pieces.add(new Piece("Pink", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(2, 0),
				new Coordinate(2, 1),
				new Coordinate(3, 1)}));
		pieces.add(new Piece("Mint", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(2, 0),
				new Coordinate(2, 1)}));
		pieces.add(new Piece("Green", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(2, 0)}));
		return pieces;
		
	}
	public static boolean[][] initializeBoard1() {
		boolean[][] board = new boolean[5][11];
		//row col
		board[0][0] = true;
		board[0][1] = true;
		board[0][2] = true;
		board[0][3] = true;
		board[0][4] = true;
		board[0][5] = true;
		board[1][2] = true;
		board[1][3] = true;
		board[1][4] = true;
		board[2][2] = true;
		board[2][3] = true;
		board[2][4] = true;
		board[3][3] = true;
		board[3][4] = true;
		return board;
	}
	
	public static ArrayList<Piece> initializePieces1() {
		ArrayList<Piece> pieces = Piece.remove(fullPieces(),
				new String[]{"Pink", "Green", "Mint"});
		return pieces;
	}
	
	public static boolean[][] initializeBoard2() {
		boolean[][] board = new boolean[3][3];
		board[0][0] = true;
		board[1][1] = true;
		return board;
	}
	public static ArrayList<Piece> initializePieces2() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece("Two", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0)}));
		pieces.add(new Piece("One", new Coordinate[]{
				new Coordinate(0, 0)}));
		pieces.add(new Piece("Four", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(1, 2)}));
		return pieces;
		}
	
	
	public static boolean[][] initializeBoard3() {
		boolean[][] board = new boolean[3][3];
		board[0][0] = true;
		board[1][1] = true;
		return board;
	}
	public static ArrayList<Piece> initializePieces3() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece("Two", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0)}));
		pieces.add(new Piece("One", new Coordinate[]{
				new Coordinate(0, 0)}));
		pieces.add(new Piece("Five", new Coordinate[]{
				new Coordinate(0, 0),
				new Coordinate(1, 0),
				new Coordinate(1, 1),
				new Coordinate(1, 2),
				new Coordinate(1, 3)}));
		return pieces;
		}
	
	
	public static boolean[][] initializeBoard4() {
		boolean[][] board = new boolean[5][6];
		board[0][0] = true;
		board[0][1] = true;
		board[0][2] = true;
		board[1][2] = true;
		board[1][3] = true;
		return board;
	}
	
	public static ArrayList<Piece> initializePieces4() {
		ArrayList<Piece> pieces = Piece.remove(fullPieces(),
				new String[]{"Pink", "Green", "Purple", "Orange", "Blue", "Yellow"});
		return pieces;
	}
	
	
	public static boolean[][] initializeBoard5() { //Master level No. 40
		boolean[][] board = new boolean[5][11];
		//row col
		board[0][0] = true;
		board[1][0] = true;
		board[1][1] = true;
		board[2][0] = true;
		board[2][1] = true;
		board[2][2] = true;
		board[2][3] = true;
		board[2][4] = true;
		board[2][5] = true;
		board[3][4] = true;
		return board;
	}
	
	public static ArrayList<Piece> initializePieces5() {
		ArrayList<Piece> pieces = Piece.remove(fullPieces(),
				new String[]{"Mint","Yellow"});
		return pieces;
	}

}
