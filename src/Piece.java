import java.util.ArrayList;

public class Piece {
	
	private String color;
	private Coordinate[] positions; // represents the components of a piece
	private int orientation;
	private int anchorPos; //index of anchor component (starting at 0)
	private Coordinate tlloc; //topleft 
	
	
	public Piece (String c) {
		this.color = c; //ID
		this.positions = null;
		this.orientation = 1;
		this.anchorPos = 0;
		this.tlloc = null;
	}
	
	
	public Piece (String c, Coordinate[] pos) {
		this.color = c; //ID
		this.positions = pos;
		this.orientation = 1;
		this.anchorPos = 0;
		this.tlloc = null;
	}
	
	public Piece (String c, Coordinate[] pos, int o, int a, Coordinate l) {
		this.color = c; //ID
		this.positions = pos;
		this.orientation = o;
		this.anchorPos = a;
		this.tlloc = l;
	}
	
	public static Piece copyPiece(Piece p) {
		return new Piece(p.getColor(), p.getPositions(), p.getOrientation(), p.getAnchorPos(), p.gettlloc());
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Coordinate[] getPositions() {
		return this.positions;
	}
	
	public int getOrientation() {
		return this.orientation;
	}
	
	public int getAnchorPos() {
		return this.anchorPos;
	}
	
	public Coordinate gettlloc() {
		return this.tlloc;
	}
	
	public void settlloc(Coordinate coord) {
		this.tlloc = coord;
	}
	
	public void setOrientation(int o) {
		this.orientation = o;
	}
	
	public void setAnchorPos(int a) {
		this.anchorPos = a;
	}
	
	
	public String printPositions() {
		Coordinate[] newpos = orient(this.getPositions(), 0, this.getOrientation());
		String output = "[ ";
		for (Coordinate c : newpos) {
			output += c.toString();
			output += " ";
		}
		output = output + "] with anchor being the " + this.getAnchorPos() + "th component";
		return output;
	}
	
	
	// To detail with reference issues
	public static Coordinate[] clonePos(Coordinate[] oldpos){
		Coordinate[] newpos = new Coordinate[oldpos.length];
		for(int i = 0; i < oldpos.length; i ++) {
			newpos[i] = oldpos[i];
		}
		return newpos;	
	}
	

	// return the rotated coordinates for the instance, does not change the instance field itself
	public static Coordinate[] orient(Coordinate[] pos, int anchorpos, int orientation) {// 4 * 2 possibilities
		Coordinate[] newpos = clonePos(pos);
		for(int i = 0; i < newpos.length; i ++) { //set the specified component as the anchor
			newpos[i] = Coordinate.subtract(pos[i], pos[anchorpos]);
		}
		if (orientation == 1) { //upright
		}else if (orientation == 2) { //rotate counterclockwise 90 degrees: y, -x
			for(int cI = 0; cI < newpos.length; cI ++) {
				newpos[cI] = new Coordinate(newpos[cI].getyI(), -1 * newpos[cI].getxI());
			}
		}else if (orientation == 3) { //rotate counterclockwise 180 degrees: -x, -y
			for(int cI = 0; cI < newpos.length; cI ++) {
				newpos[cI] = new Coordinate(-1 * newpos[cI].getxI(), -1 * newpos[cI].getyI());
			}
		}else if (orientation == 4) { //rotate counterclockwise 270 degrees: -y, x
			for(int cI = 0; cI < newpos.length; cI ++) {
				newpos[cI] = new Coordinate(-1 * newpos[cI].getyI(), newpos[cI].getxI());
			}
		}else if (orientation == 5) { //x, -y
			for(int cI = 0; cI < newpos.length; cI ++) {
				newpos[cI] = new Coordinate(newpos[cI].getxI(), -1 * newpos[cI].getyI());
			}
		}else if (orientation == 6) { //-y, -x
			for(int cI = 0; cI < newpos.length; cI ++) {
				newpos[cI] = new Coordinate(-1 * newpos[cI].getyI(), -1 * newpos[cI].getxI());
			}
		}else if (orientation == 7) { //-x, y
			for(int cI = 0; cI < newpos.length; cI ++) {
				newpos[cI] = new Coordinate(-1 * newpos[cI].getxI(), newpos[cI].getyI());
			}
		}else if (orientation == 8) { //y, x
			for(int cI = 0; cI < newpos.length; cI ++) {
				newpos[cI] = new Coordinate(newpos[cI].getyI(), newpos[cI].getxI());
			}
		}
		else {
			return null;
		}
		return newpos;
	}
	
	public static ArrayList<Piece> remove(ArrayList<Piece> list, String[] colors){
		for(String color: colors) {
			list.remove(new Piece(color));
		}
		return list;
	}
	
	// Equals by color
	@Override
	public boolean equals(Object o) {
        if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Piece)) { 
            return false; 
        } 
        Piece p = (Piece) o; 
        return p.getColor().equals(this.getColor());
	}
	
    @Override
    public int hashCode() {
        return this.getColor().hashCode();
    }
}
