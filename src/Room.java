import java.awt.*;

public class Room implements Drawable {
	
	public static final int SIZE = 50;
	public Point pos;
	private Room exitEast;
	private Room exitWest;
	private Room exitNorth;
	private Room exitSouth;
	
	public Room(int x, int y) {	
		pos = new Point();
		exitEast = null;
		exitWest = null;
		exitNorth = null;
		exitSouth = null;
		pos.x = x;
		pos.y = y;
	}
	
	public void draw(Graphics g) {
		int x = pos.x;
		int y = pos.y;
		g.setColor(Color.WHITE);
		g.drawRect(10+x, 10+y, 50, 50);
		
//		If exit variable is not empty, do the command.
		if (exitNorth != null) {
			g.setColor(Color.GRAY);
			g.drawLine(30+x, 10+y, 40+x, 10+y);
			g.setColor(Color.WHITE);
			g.drawLine(30+x, 10+y, 30+x, y);
		}
		if (exitSouth != null) {
			g.setColor(Color.GRAY);
			g.drawLine(30+x, 60+y, 40+x, 60+y);	
			g.setColor(Color.WHITE);
			g.drawLine(40+x, 60+y, 40+x, 70+y);
		}
		if (exitWest != null) {
			g.setColor(Color.GRAY);
			g.drawLine(10+x, 30+y, 10+x, 40+y);
			g.setColor(Color.WHITE);
			g.drawLine(10+x, 40+y, x, 40+y);
		}
		if (exitEast != null) {
			g.setColor(Color.GRAY);
			g.drawLine(60+x, 30+y, 60+x, 40+y);
			g.setColor(Color.WHITE);
			g.drawLine(60+x, 30+y, 70+x, 30+y);
		}
		
	}
	
	
//	methods
	public void setEastExit(Room r) {
		exitEast = r;
		r.exitWest = this;
	}
	
	public void setNorthExit(Room r) {
		exitNorth = r;
		r.exitSouth = this;
	}
	
	public void setWestExit(Room r) {
		exitWest = r;
		r.exitEast = this;
	}
	
	public void setSouthExit(Room r) {
		exitSouth = r;
		r.exitNorth = this;
	}
	
	public boolean hasNorthExit() {
		
		if (exitNorth == null) {
			return false;
		} else {
			return true;
		}
	}//This method returns false if (northExit == null), or true otherwise.
	
	public boolean hasSouthExit() {
		
		if (exitSouth == null) {
			return false;
		} else {
			return true;
		}
		
	}//This method returns false if (southExit == null), or true otherwise.
	
	public boolean hasEastExit() {
		if (exitEast == null) {
			return false;
		} else {
			return true;
		}
		
	}//This method returns false if (eastExit == null), or true otherwise.
	
	public boolean hasWestExit() {
		if (exitWest == null) {
			return false;
		} else {
			return true;
		}
		
	}//This method returns false if (westExit == null), or true otherwise.
	
	public Room getNorthExit() {
		return exitNorth;
		
	}//This method returns exitNorth. That's it! Just one line of code.
	
	public Room getSouthExit() {
		return exitSouth;
		
	}//Same as the above, but for the south exit.
	
	public Room getEastExit() {
		return exitEast;
		
	}//Same as the above, but for the east exit.
	
	public Room getWestExit() {
		return exitWest;
		
	}//Same as the above, but for the west exit.
	
	
}