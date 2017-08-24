package GameState;

import Handlers.Keys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import TileMap.*;

public class MenuState extends GameState {
	
	private BufferedImage shroom;
	private int shroomx = 75;
	private Background back;
	
	private int currentChoice = 0;
	private String[] options = {"P1", "P2", "Quit"};
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		
		try {
			
			back = new Background("/Menu/Titlebg.png", 0);
			
			shroom = ImageIO.read(getClass().getResourceAsStream("/Menu/shroom.png")).getSubimage(0, 0, 8, 8);
			
			font = new Font("Arial", Font.PLAIN, 10);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {}
	public void update() {
		
		handleInput();
	}
	public void draw(Graphics2D g) {
		
		//draw background
		back.draw(g);
		
		//draw shroom
		if(currentChoice == 0) g.drawImage(shroom, shroomx, 135, null);
		else if(currentChoice == 1) g.drawImage(shroom, 75, 151, null);
		else if(currentChoice == 2) g. drawImage(shroom, 75, 167,  null);
	}
	
	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.WORLD1);
			
		} else if (currentChoice == 1) {
			//gsm.setState(GameStateManager.P2);
			
		} else if (currentChoice == 2) {
			System.exit(0);
		}
		
	}
	
	private void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) select();
		if(Keys.isPressed(Keys.UP) || Keys.isPressed(Keys.W)) {
			if (currentChoice > 0) {
				currentChoice--;
			}
		}
		if(Keys.isPressed(Keys.DOWN) || Keys.isPressed(Keys.S)) {
			if(currentChoice < options.length - 1) {
				currentChoice++;
			} 
		}
	}

}
