package game;

import java.awt.EventQueue;

import game.logic.Logic;
import game.logic.TwentyFourLogic;
import helpers.BasicGenerater;
import helpers.BasicVerifier;
import helpers.Generater;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
					frame.setVisible(true);
					Generater gn=new BasicGenerater(new BasicVerifier());
					Logic lgc=new TwentyFourLogic(frame,gn);
					lgc.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
