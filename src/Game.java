import java.util.ArrayList;

public class Game {
	
	public static boolean[][] board; // initialized to false
	public static ArrayList<Piece> pieces;
	
	
	/**
	 * Finds the next empty spot on the board that is closest to the top left corner
	 * @return the coordinates of the next empty spot
	 */
	public static Coordinate nextEmptySpot(boolean[][] b) {
		for(int row = 0; row < b.length; row ++) {
			for (int col = 0; col < b[0].length; col ++) {
				if (b[row][col] == false) { //not filled
					return new Coordinate(col, row); //x, y
				}
			}
		}
		return new Coordinate(-1, -1); // did not find empty spot
		
	}
	
	public static Boolean fit(Coordinate topleft, boolean[][] b, Coordinate[] piecePos) {
		for (Coordinate c : piecePos) {
			int rowI = topleft.getyI() + c.getyI();
			int colI = topleft.getxI() + c.getxI();
			if (rowI >= b.length || rowI < 0 || colI >= b[0].length || colI < 0 || b[rowI][colI] == true) {
				return false;
			}
		}
		return true;
	}
	
	// currentBoard not changed
	public static boolean[][] putDownPiece(Coordinate topleft, boolean[][] cb, Coordinate[] piecePos){
		boolean[][] newboard = cloneBoard(cb);
		for(Coordinate c: piecePos) {
			int rowI = topleft.getyI() + c.getyI();
			int colI = topleft.getxI() + c.getxI();
			newboard[rowI][colI] = true;
		}
		return newboard;
	}
	
	public static boolean allFilled(boolean[][] b) {
		for(int row = 0; row < b.length; row ++) {
			for (int col = 0; col < b[0].length; col ++) {
				if (b[row][col] == false) { //not filled
					return false;
				}
			}
		}
		return true; //all filled
	}
	
	public static void printPieces(ArrayList<Piece> setPieces) {
		System.out.println("------------------------------SOLUTION BELOW------------------------------");
		System.out.println("Coordinates given in (x, y) with top left corner being (0, 0)");
		for(Piece p: setPieces) {
			System.out.println("Piece " + p.getColor() + " at " + p.gettlloc() + " with position: " + p.printPositions());
		}
	}
	
	// To detail with reference issues
	public static boolean[][] cloneBoard(boolean[][] oldBoard){
		boolean[][] newboard = new boolean[oldBoard.length][oldBoard[0].length];
		for(int row = 0; row < newboard.length; row ++) {
			for (int col = 0; col < newboard[0].length; col ++) {
				newboard[row][col] = oldBoard[row][col];
			}
		}
		return newboard;	
	}
	
	public static Boolean recursiveFit(boolean[][] currentBoard, ArrayList<Piece> remainingPieces, ArrayList<Piece> setPieces) {
		if (remainingPieces.isEmpty()) {
			if (allFilled(currentBoard)) { // board filled and no more pieces left
				printPieces(setPieces);
				return true;
			}else { //board not filled but no more pieces left
				System.out.println("Not possible: board not filled but no more pieces left");
				return false;
			}
		}else {
			if(allFilled(currentBoard)) { //board filled and more pieces left
				System.out.println("Not possible: board filled and more pieces left");
				return false;
			}
		}
		Coordinate currCoord = nextEmptySpot(currentBoard);
		//System.out.println("-----currCoord: " + currCoord + "-----");
		for(int i = 0; i < remainingPieces.size(); i ++) {
			Piece currPiece = Piece.copyPiece(remainingPieces.get(i));
			//System.out.println("currPiece: " + currPiece.getColor());
			
			for (int anchorPos = 0; anchorPos<currPiece.getPositions().length; anchorPos++) {
				//iterate through all the orientations for the current piece with its current anchor component
			for (int o = 1; o <= 8 ; o ++) {
				Coordinate[] piecePos = Piece.orient(currPiece.getPositions(), anchorPos, o); 
				if (fit(currCoord, currentBoard, piecePos)) {
					// successfully fit the piece into the current spot under the current orientation
					boolean[][] newBoard = putDownPiece(currCoord, currentBoard, piecePos);
					currPiece.setOrientation(o);
					currPiece.settlloc(currCoord);
					currPiece.setAnchorPos(anchorPos);
					ArrayList<Piece> newRP = new ArrayList(remainingPieces);
					newRP.remove(currPiece);
					ArrayList<Piece> newSP = new ArrayList(setPieces);
					newSP.add(currPiece);
					
					// if the rest of the pieces fit
					if (recursiveFit(newBoard, newRP, newSP)){
						return true;
					// if the rest of the pieces could not fit, try next orientation
					}
				}else {
					int a = 0;
				}
			}
			}
			
			//if currPiece does not fit in currCoord, try next piece
			
		}
		
		//if nothing fits in the current Coordinate
		//System.out.println("Not possible: exhausted all pieces");
		return false;
		
	}
	
	// nextFit
	public static void main(String[] args)
    {
		board = Test.initializeBoard1();
		pieces = Test.initializePieces1();
		long start = System.currentTimeMillis();
		recursiveFit(board, pieces, new ArrayList<Piece>());
		long end = System.currentTimeMillis();
		System.out.println(String.format("Results found in %o ms", end-start));
    }
}
