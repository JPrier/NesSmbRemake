package GameState;

import java.awt.Graphics2D;

import Entity.Goomba;
import Entity.Player;
import Handlers.Keys;
import TileMap.Background;
import TileMap.TileMap;
import Game.GamePanel;

public class World1 extends GameState {
	
	private Background back;
	
	private TileMap tileMap;
	
	private Goomba goobas[];
	private Player player;
	
	public World1(GameStateManager gsm) {
		super(gsm);
		init();
	}
	
	public void init() {
		
		try {
			//set Background
			back = new Background("/World1/world1bg.png", 1);
			
			//load world tiles
			tileMap = new TileMap(16); //TODO: recheck the size of the tiles
			tileMap.loadTiles("/WorldTiles/Tiles.png");
			tileMap.loadMap("/Maps/W1.map"); //TODO: create the map
			tileMap.setLocation(0, 40); //TODO: is this where the tiles start drawing? if so figure where it should be
			tileMap.setBounds(tileMap.getWidth() - 1 * tileMap.getTileSize(), tileMap.getHeight() - 2 * tileMap.getTileSize(), 0, 0);
			tileMap.setTween(1); //movement of the map to the player
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//set character start location and load images
		player = new Player();
		player.setPosition(42, 185);
		
		//set enemy start location and load images
		populateEnemies();
	}
	
	public void update() {
		
		handleInput();
		
		back.setPosition(tileMap.getx(), tileMap.gety());
		
		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getMapX(), GamePanel.HEIGHT / 2 - player.getMapY());
		tileMap.update();
		
		//for loop -- enemy.draw();
	}
	
	public void draw(Graphics2D g) {
		//update background
		back.draw(g);
		
		//draw tileMap
		tileMap.draw(g);
		
		//draw player
		player.draw(g);
	}
	
	private void populateEnemies() {
		//set locations of enemies and put them into the enemie array
	}
	
	public void handleInput() {
		
		//pause game
		if(Keys.isPressed(Keys.ESCAPE)) gsm.setPaused(true);
		
		//deal with player movement (lots of various control methods...maybe set this at the beginning)
		//D & right arrow = right movement
		// || Keys.isPressed(Keys.RIGHT)) {
		player.setRight(Keys.keyState[Keys.D]);
		//A & left arrow= left movement
		// || Keys.isPressed(Keys.LEFT)) {
		player.setLeft(Keys.keyState[Keys.A]);

		//W & up arrow = jump
		if(Keys.isPressed(Keys.W)){// || Keys.isPressed(Keys.UP)) {
			player.setUp();
		}
		//S & ctrl & c & down arrow = crouch
		// || Keys.isPressed(Keys.DOWN) || Keys.isPressed(Keys.CTRL) || Keys.isPressed(Keys.C)) {
		player.setDown(Keys.keyState[Keys.S]);
		
		//shoot button (SPACE)
		
		//update player
		player.update();
	}
}
