import  java.awt.*;
import java.awt.event.KeyEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;


import edu.princeton.cs.introcs.StdDraw;

public class Main {
	
	 public static LinkedList<Perso> listPerso = new LinkedList<>();
	 static Map laby=new Map();
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(630,510);
		StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 17);
        
        
		
		GameControl Conf1 =new GameControl(38,40,37,39,32);
		GameControl Conf2 =new GameControl(90,83,81,68,88);
		
		
		Perso J1=new Perso("Willi", 19.5f,15.5f,"blue", Conf1);
		Perso J2= new Perso("Away", 1.5f,1.5f,"black",Conf2);
		listPerso.add(J1);
		listPerso.add(J2);
		
		
		
		while (true) {
		
		StdDraw.clear();
		laby.Affichage(); 
		J1.affichageperso(J1.getX(), J1.getY());
		J1.Deplacement(laby);
		J1.poserBomb(laby,System.currentTimeMillis()/1000);
		J2.affichageperso(J2.getX(), J2.getY());
		J2.Deplacement(laby);
		J2.poserBomb(laby,System.currentTimeMillis()/1000);
		
		
		StdDraw.show(16);
		
		}
		
		
		
		
		
}
}

