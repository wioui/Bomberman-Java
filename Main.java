import  java.awt.*;
import java.awt.event.KeyEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.princeton.cs.introcs.StdDraw;


import edu.princeton.cs.introcs.StdDraw;

public class Main {
	
	 public static LinkedList<Perso> listPerso = new LinkedList<>();
	 static Map laby=new Map();
	 static LinkedList<Animation> listAnimationBomb = new LinkedList<>();


	public static void main(String[] args) {
		
		StdDraw.setCanvasSize(630,660);
		StdDraw.setXscale(0, 21);
        StdDraw.setYscale(-5, 17);
        StdDraw.picture(10.5,8.5, "Image/bomberman1.png");
        
       
        
		while(!StdDraw.isKeyPressed(81)){
			
		if(StdDraw.isKeyPressed(32)){
			 
			 String choixPerso1=null;
			 String choixPerso2=null;
			 
			StdDraw.clear();
			StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
			while (choixPerso1==null || choixPerso2==null){
				
				
				
				
				if((5<StdDraw.mouseY()&& 7>StdDraw.mouseY()) && (7.2<StdDraw.mouseX()&& 8.8>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso1=="white"){
						StdDraw.picture(9, 7.2, "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso1="white";
					
				}
				if((5.5<StdDraw.mouseY()&& 7.5>StdDraw.mouseY()) && (4.5<StdDraw.mouseX()&& 6.1>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso1=="blue"){
						StdDraw.picture(6.3, 7.2, "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso1="blue";
				}
				if ((9<StdDraw.mouseY()&& 11.5>StdDraw.mouseY()) && (4.2<StdDraw.mouseX()&& 6.2>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso1=="green"){
						StdDraw.picture(6.2, 11.5 , "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso1="green";
				}
				if((9<StdDraw.mouseY()&& 11.5>StdDraw.mouseY()) && (7.2<StdDraw.mouseX()&& 8.8>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso1=="black"){
						StdDraw.picture(8.8, 11.5, "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso1="black";
				}
				
				if((5.4<StdDraw.mouseY()&& 7.7>StdDraw.mouseY()) && (17.5<StdDraw.mouseX()&& 19>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso2=="white"){
						StdDraw.picture(19, 7.7, "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso2="white";
				}
				if((5.5<StdDraw.mouseY()&& 7.5>StdDraw.mouseY()) && (14.6<StdDraw.mouseX()&& 16.2>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso2=="blue"){
						StdDraw.picture(16.2, 7.5, "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso2="blue";
				}
				if ((9<StdDraw.mouseY()&& 11.5>StdDraw.mouseY()) && (14.7<StdDraw.mouseX()&& 16.2>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso2=="green"){
						StdDraw.picture(16.2, 11.5, "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso2="green";
				}
				if((9<StdDraw.mouseY()&& 11.5>StdDraw.mouseY()) && (17.5<StdDraw.mouseX()&& 19>StdDraw.mouseX())  && StdDraw.mousePressed()){
					if(choixPerso2=="black"){
						StdDraw.picture(19, 11.5, "Image/Bomb.PNG");
					}
					else{
						StdDraw.picture(10.5,8.5, "Image/bomberman2.png");
					}
					 
					choixPerso2="black";
				}
			
			
			
		}
			GameControl Conf1 =new GameControl(38,40,37,39,32);
			GameControl Conf2 =new GameControl(90,83,81,68,88);
			
			
			Perso J1=new Perso("J1", 19.5f,15.5f,choixPerso1, Conf1);
			Perso J2= new Perso("J2", 1.5f,1.5f,choixPerso2,Conf2);
			
			 StatPlayer statPlayer1 = new StatPlayer(J1);
		     StatPlayer statPlayer2 = new StatPlayer(J2);
		     
		    Animation animation = new Animation(); 
		    
			listPerso.add(J1);
			listPerso.add(J2);
			
			StdDraw.enableDoubleBuffering();
			
			while (!J1.isDie() && !J2.isDie()) {
				
			
			
			laby.Affichage(); 
			J1.affichageperso(J1.getX(), J1.getY());
			J1.Deplacement(laby);
			J1.poserBomb(laby,System.currentTimeMillis()/1000);
			J2.affichageperso(J2.getX(), J2.getY());
			J2.Deplacement(laby);
			J2.poserBomb(laby,System.currentTimeMillis()/1000);
			
			if (!listAnimationBomb.isEmpty()) {
                for (int animationBomb = 0; animationBomb < listAnimationBomb.size(); animationBomb++) {
                    if (listAnimationBomb.get(animationBomb) != null) {
                        listAnimationBomb.get(animationBomb).startAnimationBomb();
                    }
                }
            }
			J1.die();
			J2.die();
			statPlayer1.display("J1");
            statPlayer2.display("J2");		
			
			StdDraw.show(16);
			StdDraw.clear();
		}
		
		
		
		
		}
		
		
		
				
		}}}

	

