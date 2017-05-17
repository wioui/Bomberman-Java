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


	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		StdDraw.setCanvasSize(630,510);
		StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 17);
//        StdDraw.picture(10.5,8.5, "///C:/Users/wioui/Documents/Bomberman/src/Image/bomberman1.png");
//       
//        
//		while(!StdDraw.isKeyPressed(81)){
//			
//		if(StdDraw.isKeyPressed(32)){
//			 
//			 String choixPerso1=null;
//			 String choixPerso2=null;
//			 String namePerso1=null;
//			 String namePerso2=null;
//			 StdDraw.clear();
//			 StdDraw.picture(10.5,8.5, "///C:/Users/wioui/Documents/Bomberman/src/Image/testname.png");
//			while(namePerso1==null || namePerso2==null){
//				
//				Contours name1=new Contours(2.6f,10.4f,3,3);
//				StdDraw.filledSquare(3.1f,10.9f,3);
//				Contours name2=new Contours(12.5f,10.7f,3,3);
//				StdDraw.filledSquare(12.5f,10.9f,3);
//				
//				if(name1.test(StdDraw.mouseX(),StdDraw.mouseY(),name1) && StdDraw.mousePressed()){
//					System.out.println("ok");
//					namePerso1=sc.nextLine();
//					StdDraw.text(10.5, 7.5, namePerso1);
//					
//				}
//
//				if(name2.test(StdDraw.mouseX(),StdDraw.mouseY(),name2) && StdDraw.mousePressed()){
//					System.out.println("ok");
//					namePerso2=sc.nextLine();
//					StdDraw.text(10.5, 7.5, namePerso2);
//					
//				}
//			}
//			StdDraw.clear();
//			StdDraw.picture(10.5,8.5, "///C:/Users/wioui/Documents/Bomberman/src/Image/Bomberman.png");
//			while (choixPerso1==null || choixPerso2==null){
//				Contours red1=new Contours(2.6f,10.4f,3,3);
//				Contours blue1=new Contours(2.6f,10.4f,3,3);
//				Contours green1=new Contours(2.6f,10.4f,3,3);
//				Contours black1=new Contours(2.6f,10.4f,3,3);
//				Contours red2=new Contours(2.6f,10.4f,3,3);
//				Contours blue2=new Contours(2.6f,10.4f,3,3);
//				Contours green2=new Contours(2.6f,10.4f,3,3);
//				Contours black2=new Contours(2.6f,10.4f,3,3);
//				
//				if(red1.test(StdDraw.mouseX(),StdDraw.mouseY(),red1) && StdDraw.mousePressed()){
//					choixPerso1="red";
//				}
//				if(blue1.test(StdDraw.mouseX(),StdDraw.mouseY(),blue1) && StdDraw.mousePressed()){
//					choixPerso1="blue";
//				}
//				if (green1.test(StdDraw.mouseX(),StdDraw.mouseY(),green1) && StdDraw.mousePressed()){
//					choixPerso1="green";
//				}
//				if(black1.test(StdDraw.mouseX(),StdDraw.mouseY(),black1) && StdDraw.mousePressed()){
//					choixPerso1="black";
//				}
//				
//				if(red2.test(StdDraw.mouseX(),StdDraw.mouseY(),red2) && StdDraw.mousePressed()){
//					choixPerso2="red";
//				}
//				if(blue2.test(StdDraw.mouseX(),StdDraw.mouseY(),blue2) && StdDraw.mousePressed()){
//					choixPerso2="blue";
//				}
//				if (green2.test(StdDraw.mouseX(),StdDraw.mouseY(),red2) && StdDraw.mousePressed()){
//					choixPerso2="green";
//				}
//				if(black2.test(StdDraw.mouseX(),StdDraw.mouseY(),red2) && StdDraw.mousePressed()){
//					choixPerso2="black";
//				}
//			
//			
//			
//		}
			GameControl Conf1 =new GameControl(38,40,37,39,32);
			GameControl Conf2 =new GameControl(90,83,81,68,88);
			
			
			Perso J1=new Perso("yo", 19.5f,15.5f,"red", Conf1);
			Perso J2= new Perso("op", 1.5f,1.5f,"red",Conf2);
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

	

