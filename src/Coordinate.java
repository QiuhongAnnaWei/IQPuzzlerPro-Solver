
public class Coordinate {
	private int xI; // col
	private int yI; // row

	
	public Coordinate(int x, int y) {
		this.xI = x;
		this.yI = y;
	}
	
	public int getxI() {
		return this.xI;
	}
	
	public int getyI() {
		return this.yI;
	}

	@Override
	public String toString() {
		return "( " + this.getxI() + " , " + this.getyI() + " )";
	}
	
	public static Coordinate subtract(Coordinate a, Coordinate b) {
		return new Coordinate(a.getxI()-b.getxI(), a.getyI()-b.getyI());
	}
}
