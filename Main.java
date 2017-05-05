import  java.awt.*;
import java.awt.event.KeyEvent;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;


import edu.princeton.cs.introcs.StdDraw;

public class Main {
	public static void main(String[] args) {
		StdDraw.setCanvasSize(840,680);
		StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 17);
        
				
		Map Laby=new Map();
		for(int i=0;i<21;i++){
			for(int j=0;j<17;j++){
				
				
			}}
		
		Perso J1=new Perso("Willi", 1.5f,2.5f,StdDraw.BLUE);
		
		
		while (true) {
		StdDraw.clear();
		Laby.Affichage(); 
		J1.Affichageperso(J1.getX(), J1.getY());
		J1.Deplacement(Laby);
		
		StdDraw.show(20);
		
		}
		
		
		
		
		
}
}
