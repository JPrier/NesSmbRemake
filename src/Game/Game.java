package Game;

import javax.swing.JFrame;
import java.awt.EventQueue;


@SuppressWarnings("serial")
public class Game extends JFrame {
	
	public Game() {
		
		add(new GamePanel());
		
		setResizable(false); //change to true -- first learn how to scale everything
		pack(); 
		
		setTitle("Super Mario Bros. Java Remake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		Game ex = new Game();
		ex.setVisible(true);
		
		/*
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Game ex = new Game();
				ex.setVisible(true);
			}
		});
		*/
	}

}
