package Entity;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;

import Game.GamePanel;

public class Player extends Entity{
	
	private int posX;
	private int posY;
	
	private int mapX;
	private int mapY;
	
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
		
		this.posX = 0;
		this.posY = 0;
	}
	public void update() {
		if(left && posX > 0) posX -= moveSpeed;
		
		if(right) {
			System.out.println("Tilem: " + ((mapX / 16) + 1));
			if(posX < (GamePanel.WIDTH / 2)){
				posX += moveSpeed;
			} else if(posX == (int)(GamePanel.WIDTH / 2)){
				if(mapX == 0) {
					mapX = posX;
				}
				posX += 1;
			}
			else {
				mapX += moveSpeed;
			}
		}
		
		/*//needs to be adjusted so it stays on jumping until it hits the apex
		if(jumping) {
			posY += moveSpeed;
			falling = true;
			jumping = false;
		}
		if(falling) {
			posY -= moveSpeed;
			falling = false;
		}*/
		
	}
	public void draw(Graphics2D g) {
		
		g.drawImage(image, (int)posX, (int)posY, null);
		
		super.draw(g);
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
	
	public int getX() {return posX;}
	public int getY() {return posY;}
	public int getMapX() {return mapX;}
	public int getMapY() {return mapY;}
}
