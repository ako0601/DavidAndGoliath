import java.awt.Graphics;
import javax.swing.*;

public abstract class Sprite implements Drawable {
	
	protected Room currentRoom;
	protected ImageIcon sprite;
	
	public Sprite() {
		currentRoom = null;
		sprite = null;
	}
	
	public void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void draw(Graphics g) {
		if (currentRoom != null) {
			int x = currentRoom.pos.x;
			int y = currentRoom.pos.y;
			g.drawImage(sprite.getImage(),20+x,20+y, 30, 30,null);
		}
	}

	
	public void moveSouth() {
		if (currentRoom.hasSouthExit()==true) {
			currentRoom = currentRoom.getSouthExit();
		}
		
	}//This methods checks whether currentRoom has an exit to the south, and if so, updates currentRoom to the Room on the south exit. Use the methods you just added to the Room class to do this.
	
	public void moveNorth() {
		if (currentRoom.hasNorthExit()==true) {
			currentRoom = currentRoom.getNorthExit();
			
		}
		
	}//Just like moveSouth, but for the north.
	
	public void moveEast() {

		if (currentRoom.hasEastExit()==true) {
			currentRoom = currentRoom.getEastExit();
			
		}
	}//Just like moveSouth, but for the east.
	
	public void moveWest() {
		if (currentRoom.hasWestExit()==true) {
			currentRoom = currentRoom.getWestExit();
		}
		
	}//Just like moveSouth, but for the west.
	
//	@Override
//	public class equal {
//		
//	}
//	
	
}