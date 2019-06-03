import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class Maze extends JPanel implements KeyListener {
	
	
	Sprite david1;
	Sprite goliath1;
	public static JFrame window;
	private AudioClip sound;
	
	// Array of stones
	private ArrayList<Stone> stones;
	private ArrayList<Room> Rooms;
	ArrayList<Drawable> many = new ArrayList<Drawable>();
	

//	Rooms
	Room Room1;
	Room Room2;
	Room Room3;
	Room Room4;
	Room Room5;
	Room Room6;
	Room Room7;
	Room Room8;
	Room Room9;
	Room Room10;
	Room Room11;
	Room Room12;
	Room Room13;
	Room Room14;
	Room Room15;
	Room Room16;
	Room Room17;
	Room Room18;
	Room Room19;
	Room Room20;
	Room Room21;
	Room Room22;
	Room Room23;
	Room Room24;
	Room Room25;	
	Room Room26;
	Room Room27;
	Room Room28;
	Room Room29;
	Room Room30;
	Room Room31;
	Room Room32;
	int dx;
	int dy;
	
	
	
//	Maze constructor
	public Maze() {
		
//		int boxX = 0;
//		int boxY = 0;
//		for (int i = 0; i < 32; i++) {
//			Room temp = new Room(boxX, boxY);
//			RGDS.add(temp);
//			if (boxY == 240) {
//				boxX += 60;
//				boxY = 0;
//			}
//			boxY += 60;
//		}
		
		try {
			File bgm = new File("C:\\myjavaprogramming\\CIS 202 Final project\\explo.wav");
			sound = Applet.newAudioClip(bgm.toURL());
			
		} catch(MalformedURLException e){
			
		}
		
		
		Rooms = new ArrayList<Room>();
		Room1 = new Room(0,0);
		Room2 = new Room(0,60);
		Room3 = new Room(0,120);
		Room4 = new Room(0,180);
		Room5 = new Room(0,240);
		Room6 = new Room(60,0);
		Room7 = new Room(60,60);
		Room8 = new Room(60,120);
		Room9 = new Room(60,180);
		Room10 = new Room(60,240);
		Room11 = new Room(120,0);
		Room12 = new Room(120,60);
		Room13 = new Room(120,120);
		Room14 = new Room(120,180);
		Room15 = new Room(120,240);
		Room16 = new Room(180,0);
		Room17 = new Room(180,60);
		Room18 = new Room(180,120);
		Room19 = new Room(180,180);
		Room20 = new Room(180,240);
		Room21 = new Room(240,0);
		Room22 = new Room(240,60);
		Room23 = new Room(240,120);
		Room24 = new Room(240,180);
		Room25 = new Room(240,240);
		Room26 = new Room(300,0);
		Room27 = new Room(300,240);
		Room28 = new Room(360,0);
		Room29 = new Room(360,60);
		Room30 = new Room(360,120);
		Room31 = new Room(360,180);
		Room32 = new Room(360,240);
		
		Rooms.add(Room1);
		Rooms.add(Room2);
		Rooms.add(Room3);
		Rooms.add(Room4);
		Rooms.add(Room5);
		Rooms.add(Room6);
		Rooms.add(Room7);
		Rooms.add(Room8);
		Rooms.add(Room9);
		Rooms.add(Room10);
		Rooms.add(Room11);
		Rooms.add(Room12);
		Rooms.add(Room13);
		Rooms.add(Room14);
		Rooms.add(Room15);
		Rooms.add(Room16);
		Rooms.add(Room17);
		Rooms.add(Room18);
		Rooms.add(Room19);
		Rooms.add(Room20);
		Rooms.add(Room21);
		Rooms.add(Room22);
		Rooms.add(Room23);
		Rooms.add(Room24);
		Rooms.add(Room25);
		Rooms.add(Room26);
		Rooms.add(Room27);
		Rooms.add(Room28);
		Rooms.add(Room29);
		Rooms.add(Room30);
		Rooms.add(Room31);
		Rooms.add(Room32);
		
		
//		Setting the exits and hallways.
		Room1.setSouthExit(Room2);
		Room2.setSouthExit(Room3);
		Room3.setSouthExit(Room4);
		Room4.setSouthExit(Room5);
		Room3.setEastExit(Room8);
		Room4.setEastExit(Room9);
		Room8.setSouthExit(Room9);
		Room9.setEastExit(Room14);
		Room14.setNorthExit(Room13);
		Room14.setEastExit(Room19);
		Room19.setEastExit(Room24);
		Room19.setNorthExit(Room18);
		Room19.setSouthExit(Room20);
		Room25.setNorthExit(Room24);
		Room25.setWestExit(Room20);
		Room5.setEastExit(Room10);
		Room10.setEastExit(Room15);
		Room18.setEastExit(Room23);
		Room23.setNorthExit(Room22);
		Room22.setWestExit(Room17);
		Room12.setEastExit(Room17);
		Room12.setWestExit(Room7);
		Room12.setNorthExit(Room11);
		Room11.setEastExit(Room16);
		Room11.setWestExit(Room6);
		Room16.setEastExit(Room21);
		Room27.setEastExit(Room32);
		Room25.setEastExit(Room27);
		Room31.setNorthExit(Room30);
		Room31.setSouthExit(Room32);
		Room29.setNorthExit(Room28);
		Room29.setSouthExit(Room30);
		Room26.setEastExit(Room28);
		
		stones = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			
			stones.add(new Stone());
		
		}
		
		
		int a[] = new int[7];
		Random random = new Random();
        for(int i = 0; i <= 6 ; i++) {
            a[i] = random.nextInt(31)+1; // save one random number into a
            for(int j = 0; j < i; j++) {// to get rid of same random number
            	if(a[i] == a[j]) {
                    i--;
                }
            }
        }	
		
		
//		Random random2 = new Random();
//		while (random1 == random2)
//		
		stones.get(0).setCurrentRoom(Rooms.get(a[0]));
		stones.get(1).setCurrentRoom(Rooms.get(a[1]));
		stones.get(2).setCurrentRoom(Rooms.get(a[2]));
		stones.get(3).setCurrentRoom(Rooms.get(a[3]));
		stones.get(4).setCurrentRoom(Rooms.get(a[4]));
		
		dx = 0;
		dy = 0;
		
		david1 = new David();
		david1.setCurrentRoom(Rooms.get(a[5]));
		goliath1 = new Goliath();
		goliath1.setCurrentRoom(Rooms.get(a[6]));
				
		
		for (int i = 0; i < Rooms.size(); i++) {
			many.add(Rooms.get(i));
		}
		for (int j = 0; j < stones.size(); j++) {
			many.add(stones.get(j));
		}
		many.add(david1);
		many.add(goliath1);
		
		addKeyListener(this);
	}
	
	
	public void move(int x, int y) {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		requestFocusInWindow();
		
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, w, h);		
		
		for (Drawable d : many) {
			d.draw(g);
		}
		
	}
		
	public static void main (String[] args) {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(450,350);
		window.setContentPane(new Maze());
		window.setVisible(true);
		
	}
	

	@Override
	
	// key input
	public void keyPressed(KeyEvent e) {
		int a = e.getKeyCode();
		switch(a) {
			case KeyEvent.VK_UP:
				
			case KeyEvent.VK_NUMPAD8:
				david1.moveNorth();
				break;
				
			case KeyEvent.VK_DOWN:
				david1.moveSouth();
				break;

			case KeyEvent.VK_LEFT:
				david1.moveWest();
				break;
				
			case KeyEvent.VK_RIGHT:
				david1.moveEast();;
				break;
				
			default:
				System.out.println("Use the arrow keys!");
				break;
			
			
		}
		for (Stone s: stones) {
			if (s.getCurrentRoom() == david1.getCurrentRoom()) {
				((David) david1).pickUpStone();
				s.setCurrentRoom(null);
			}
		}
		if (david1.getCurrentRoom() == goliath1.getCurrentRoom()) {
			if (((David) david1).isArmed() == true) {
				JOptionPane.showMessageDialog(null, "Congratulations David! You slew Goliath!", "Victory!", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (((David) david1).isArmed() == false) {
				JOptionPane.showMessageDialog(null, "Oh no David! Goliath got you! Try again.", "Defeat!", JOptionPane.INFORMATION_MESSAGE);

			}
			int result = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirm", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			}
			else if (result == JOptionPane.YES_OPTION) {
				reset();
			}
			else {
				System.exit(0);
			}
		}
		repaint();
		int b = e.getKeyChar();
		switch(b) {
			case KeyEvent.VK_W:
				
			case KeyEvent.VK_NUMPAD8:
				goliath1.moveNorth();
				break;
				
			case KeyEvent.VK_S:
				goliath1.moveSouth();
				break;
	
			case KeyEvent.VK_A:
				goliath1.moveWest();
				break;
				
			case KeyEvent.VK_D:
				goliath1.moveEast();;
				break;
				
			default:
				break;
		} repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void reset() {
		window.setVisible(false);
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(450,350);
		window.setContentPane(new Maze());
		window.setVisible(true);

	}
}
	
	