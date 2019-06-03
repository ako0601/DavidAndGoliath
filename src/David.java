
import javax.swing.ImageIcon;

public class David extends Sprite {
	
	private int numStones;
		
	
	public David() {
		super();
		numStones = 0;
		sprite = new ImageIcon("david.png");
	}	
	
	public void pickUpStone() {
		
		numStones += 1;
		
	} //This should increment numStones by 1.
	
	public boolean isArmed() {
		
		if (numStones == 5) {
			return true;
		} 
		else {
			return false;
		} 
	}
	// Returns true if David has 5 stones, false otherwise.
	
	public void reset() {
		numStones = 0;
	} // Resets numStones to zero.
}