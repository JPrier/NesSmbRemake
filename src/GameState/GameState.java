package GameState;

import java.awt.Graphics2D;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public void init() {}
	public void update() {}
	public void draw(Graphics2D g) {}
}
