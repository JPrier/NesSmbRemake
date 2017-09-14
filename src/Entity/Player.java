package Entity;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;

public class Player extends Entity{
	
	private int posX;
	private int posY;
	
	private int moveSpeed = 5;
	
	private boolean jumping;
	private boolean falling;
	private boolean left;
	private boolean right;
	private boolean crouching;
	
	private BufferedImage image;
	
	public Player() {
		
		init();
	}
	public void init() {
		//load static state image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Entities/Mario1.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(left) posX -= moveSpeed;
		if(right) posX += moveSpeed;
		
		//needs to be adjusted so it stays on jumping until it hits the apex
		if(jumping) {
			posY += moveSpeed;
			falling = true;
			jumping = false;
		}
		if(falling) {
			posY -= moveSpeed;
			falling = false;
		}
		
	}
	public void draw(Graphics2D g) {
		
		g.drawImage(image, (int)posX, (int)posY, null);
	}
	
	public void setPosition(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public void setUp() {
		if(!jumping && !falling) {
			jumping = true;
		}
	}
	
	public void setDown(boolean crouch) {
		crouching = crouch;
	}
	
	public void setLeft(boolean left) {
		this.left = left;
	}
	
	public void setRight(boolean right) {
		this.right = right;
	}
}
