import  java.awt.*;
import java.awt.event.KeyEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;


import edu.princeton.cs.introcs.StdDraw;

public class Main {
	public static void main(String[] args) {
		StdDraw.setCanvasSize(630,510);
		StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 17);
        
        
		Map laby=new Map();
		GameControl Conf1 =new GameControl(38,40,37,39,32);
		GameControl Conf2 =new GameControl(90,83,81,68,88);
		
		
		Perso J1=new Perso("Willi", 19.5f,15.5f,StdDraw.BLUE, Conf1);
		Perso J2= new Perso("Ad", 1.5f,2.5f,StdDraw.YELLOW,Conf2);
		
		
		while (true) {
		
		StdDraw.clear();
		laby.Affichage(); 
		J1.affichageperso(J1.getX(), J1.getY());
		J1.Deplacement(laby);
		J1.poserBomb(laby,System.currentTimeMillis()/1000);
		J2.affichageperso(J2.getX(), J2.getY());
		J2.Deplacement(laby);
		J2.poserBomb(laby,System.currentTimeMillis()/1000);
		
		StdDraw.show(50);
		
		}
		
		
		
		
		
}
}
