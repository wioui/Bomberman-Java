import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;


public class Animation extends Main {
	
	
	public int compteur ;
	
	
	
	boolean isCoordCalulate;
	
    private Bombes bombe;
    private int animationID;
    
    int minX, posInListMinX;
	int maxX, posInListMaxX;
	
	int minY, posInListMinY ;
	int maxY, posInListMaxY;
	
	Integer minRangeCoordX[];
	Integer maxRangeCoordX[];
	
	Integer minRangeCoordY[];
	Integer maxRangeCoordY[];
	
	
	List<Integer[]> leftRange ;
	
	Integer middleCoord[];
    


    public Animation(Bombes bombe, int animationID) {
    	
    	this.bombe = bombe;



        
    	this.isCoordCalulate = false;
    	
        
        this.animationID= animationID;
        
        this.minX = 21;
        this.posInListMinX = 0;
    	this.maxX = 0;
    	this.posInListMaxX = 0;
    	
    	this.minY = 17;
    	this.posInListMinY = 0;
    	this.maxY = 0; 
    	this.posInListMaxY = 0;
    	
    	this.minRangeCoordX = new Integer[2];
    	this.maxRangeCoordX = new Integer[2];
    	
    	this.minRangeCoordY = new Integer[2];
    	this.maxRangeCoordY = new Integer[2];
    	
    	this.middleCoord = new Integer[2];
        
    }

    public Animation ()
    {
    	
    }
    
    
    public void prepareCoordForAnimation() {
    	if (this.bombe.getAnimationTime() > System.currentTimeMillis()) {
            if (!this.bombe.getListCoordExplosion().isEmpty()) {
            	
                for (int pos = 0; pos < this.bombe.getListCoordExplosion().size(); pos++) {
                	if (this.bombe.getListCoordExplosion().get(pos)[0] <= minX) {
                		minX = this.bombe.getListCoordExplosion().get(pos)[0]; // on récupère le plus petit x de la liste et son indice
                		posInListMinX = pos;
                	}
                	if (this.bombe.getListCoordExplosion().get(pos)[0] >= maxX) {
                		maxX = this.bombe.getListCoordExplosion().get(pos)[0]; 
                		posInListMaxX = pos;
                	}
                	if (this.bombe.getListCoordExplosion().get(pos)[1] <= minY) {
                		minY = this.bombe.getListCoordExplosion().get(pos)[1]; 
                		posInListMinY = pos;
                	}
                	if (this.bombe.getListCoordExplosion().get(pos)[1] >= maxY) {
                		maxY = this.bombe.getListCoordExplosion().get(pos)[1]; 
                		posInListMaxY = pos;
                	}
                	
                	
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledSquare(this.bombe.getListCoordExplosion().get(pos)[0] +0.5, (this.bombe.getListCoordExplosion().get(pos)[1]+0.5), 0.5);
                }
                minRangeCoordX = this.bombe.getListCoordExplosion().get(posInListMinX);
                maxRangeCoordX = this.bombe.getListCoordExplosion().get(posInListMaxX);
                
                minRangeCoordY = this.bombe.getListCoordExplosion().get(posInListMinY);
                maxRangeCoordY = this.bombe.getListCoordExplosion().get(posInListMaxY);    
                
                
                if (minRangeCoordX[1] == middleCoord[1]) {
                	minRangeCoordX = null;
                	maxRangeCoordX = null;
                }
                if (minRangeCoordY[0] == middleCoord[0]) {
                	minRangeCoordY = null;
                	maxRangeCoordY = null;
                }
            }
    	}
            	
            
        
        else {
            Main.listAnimationBomb.set(animationID,null);
            
        }
    	
    }

    public void startAnimationBomb() {
    	
    	// on récupère les coord max / min pour pouvoir changer leurs images
    	if (!isCoordCalulate) {
    		prepareCoordForAnimation();
    		middleCoord = this.bombe.getMiddleCoord(); 
    		leftRange = this.bombe.getListCoordExplosion();

    		leftRange.remove(middleCoord);
            leftRange.remove(minRangeCoordX);
            leftRange.remove(maxRangeCoordX);
            leftRange.remove(maxRangeCoordY);
            leftRange.remove(minRangeCoordY);
    		isCoordCalulate = true;
    		
    	}
    	
        if (this.bombe.getAnimationTime() > System.currentTimeMillis()) {
        	
             for (int pos = 0; pos < leftRange.size(); pos++) {
            	 
            	
               
                StdDraw.picture(leftRange.get(pos)[0]   + 0.5, (leftRange.get(pos)[1]  + 0.5), "Image/explo.png");
             }
             StdDraw.setPenColor(Color.black);
             StdDraw.picture(minRangeCoordX[0]   + 0.5, (minRangeCoordX[1]  + 0.5), "Image/explo.png");
             StdDraw.picture(minRangeCoordY[0]   + 0.5, (minRangeCoordY[1]  + 0.5), "Image/explo.png");
             StdDraw.picture(maxRangeCoordX[0]   + 0.5, (maxRangeCoordX[1]  + 0.5), "Image/explo.png");
             StdDraw.picture(maxRangeCoordY[0]   + 0.5, (maxRangeCoordY[1]  + 0.5), "Image/explo.png");
             
             
             StdDraw.picture(middleCoord[0]   + 0.5, (middleCoord[1]  + 0.5),"Image/epicentre.png");
             
             
        }
        else {
            Main.listAnimationBomb.set(animationID,null);
        }
    }

//    public void startAnimationBomb() {
//    	
//    	if (this.bombe.getAnimationTime() > System.currentTimeMillis()){
//    	for (int item = 0; item < this.bombe.getListCoordExplosion().size(); item++) {
//           int X= this.bombe.getListCoordExplosion().get(item)[0];
//           int Y= this.bombe.getListCoordExplosion().get(item)[1]; 
//           int a=X;
//           int b=Y;
//           StdDraw.picture(X+0.5, Y+0.5 ,"Image/item.png");//           
//         
//       
//           if(this.bombe.getListCoordExplosion().size()==1){
//        	   for (int i=0;i<this.bombe.getRange();i++){
//        		   for(int j=0;j<this.bombe.getRange();j++){
//        			   if((X+i>1 && X+i<20) && (Y+j<16 && Y+j>1)){
//        				   StdDraw.picture(X+0.5+i,Y+0.5+j,"Image/item.png");
//        			   }
//        			   
//        		   }
//        		   
//        	   }
//           }
//           while(a!=this.bombe.getBlocx()){
//        	   if(this.bombe.getBlocx()>a){
//        		   StdDraw.picture(a+0.5,b+0.5,"Image/item.png");
//        		   a++;
//        	   }
//        	   else if(this.bombe.getBlocx()<a){
//        		   StdDraw.picture(a+0.5,b+0.5,"Image/item.png");
//        		   a--;
//        	   }
//           }
//           
//           while(b!=this.bombe.getBlocy()){
//        	   if(this.bombe.getBlocx()>b){
//        		   StdDraw.picture(a+0.5,b+0.5,"Image/item.png");
//        		   b++;
//        	   }
//        	   else if(this.bombe.getBlocy()<b){
//        		   StdDraw.picture(a+0.5,b+0.5,"Image/item.png");
//        		   b--;
//        	   }
//           }
//           
//         
//    	}
//        Main.listAnimationBomb.set(animationID,null);
//    	}   
//    }
       
    
    
    
    
    
//    // j'ai 2 fonctions une pour les X et une pour les Y
//    public int getSpriteNumberY(Personnage player) {
//    	int spaceBetweenWalk = 45; // c'est le nombre de pixel pour faire les 8 animations
//    	double getFloatNumber = player.getPosY()/spaceBetweenWalk; // ça me donne ma case sur laquelle je suis
//    	double before = (int)getFloatNumber; 
//    	
//    	
//    	// j'ai 8 case, donc 1/8 = 0.125, tout les 125 je change d'image
//    	// en gros je renvoie le numéro du sprite que je veux afficher
//    	
//    	int spriteNumber;
//    	
//    	if (getFloatNumber <= before + 0.125) {
//    		spriteNumber = 0;
//    	}
//    	else if (before + 0.125 < getFloatNumber  && getFloatNumber <= before + 0.25 ) {
//    		spriteNumber = 1;
//    	}
//    	else if (before + 0.25 < getFloatNumber  && getFloatNumber <= before + 0.375)  {
//    		spriteNumber = 2;
//    	}
//    	else if (before + 0.375 < getFloatNumber  && getFloatNumber <= before + 0.5)  {
//    		spriteNumber = 3;
//    	}
//    	else if (before + 0.5 < getFloatNumber  && getFloatNumber <= before + 0.625)  {
//    		spriteNumber = 4;
//    	}
//    	else if (before + 0.625 < getFloatNumber  && getFloatNumber <= before + 0.75)  {
//    		spriteNumber = 5;
//    	}
//    	else if (before + 0.75 < getFloatNumber  && getFloatNumber <= before + 0.875)  {
//    		spriteNumber = 6;
//    	}
//    	else {
//    		spriteNumber = 7;
//    	}
//    	return spriteNumber;
//    }
//    
//    
//    // la c'est pareille mais pour les Y
//    public int getSpriteNumberX(Personnage player) {
//    	int spaceBetweenWalk = 45;
//    	double getFloatNumber = player.getPosX()/spaceBetweenWalk;
//    	double before = (int)getFloatNumber;
//    	
//    	int spriteNumber;
//    	
//    	if (getFloatNumber <= before + 0.125) {
//    		spriteNumber = 0;
//    	}
//    	else if (before + 0.125 < getFloatNumber  && getFloatNumber <= before + 0.25 ) {
//    		spriteNumber = 1;
//    	}
//    	else if (before + 0.25 < getFloatNumber  && getFloatNumber <= before + 0.375)  {
//    		spriteNumber = 2;
//    	}
//    	else if (before + 0.375 < getFloatNumber  && getFloatNumber <= before + 0.5)  {
//    		spriteNumber = 3;
//    	}
//    	else if (before + 0.5 < getFloatNumber  && getFloatNumber <= before + 0.625)  {
//    		spriteNumber = 4;
//    	}
//    	else if (before + 0.625 < getFloatNumber  && getFloatNumber <= before + 0.75)  {
//    		spriteNumber = 5;
//    	}
//    	else if (before + 0.75 < getFloatNumber  && getFloatNumber <= before + 0.875)  {
//    		spriteNumber = 6;
//    	}
//    	else {
//    		spriteNumber = 7;
//    	}
//    	return spriteNumber;
//    }
//    
    
    // ici j'affiche les sprite, je charge l'image
    
//    public void drawSpritePerso(Perso player,int direction) {
//    	
//    	//01 / 02 / 03 / 04 immobile   
//    	//1 up
//    	//2 right
//    	//3 down
//    	//4 left
//
//		if (animation ) {
//
//			String spritePlayerType = new String();
//
//
//			// la je charge le bon dossier selon l'id du player
//			if (player.getPlayerID() == 10) {
//				spritePlayerType = "player-white";
//			} else if (player.getPlayerID() == 11) {
//				spritePlayerType = "player-blue";
//			}
//
//
//			if (direction == 1) {
//				switch (getSpriteNumberY(player)) {
//					case 0:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up1.png");
//						break;
//					case 1:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up2.png");
//						break;
//					case 2:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up3.png");
//						break;
//					case 3:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up4.png");
//						break;
//					case 4:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up5.png");
//						break;
//					case 5:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up6.png");
//						break;
//					case 6:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up7.png");
//						break;
//					case 7:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up8.png");
//						break;
//				}
//
//			} else if (direction == 2) {
//				switch (getSpriteNumberX(player)) {
//					case 0:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right1.png");
//						break;
//					case 1:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right2.png");
//						break;
//					case 2:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right3.png");
//						break;
//					case 3:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right4.png");
//						break;
//					case 4:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right5.png");
//						break;
//					case 5:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right6.png");
//						break;
//					case 6:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right7.png");
//						break;
//					case 7:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right8.png");
//						break;
//				}
//			} else if (direction == 3) {
//				switch (getSpriteNumberY(player)) {
//					case 0:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down1.png");
//						break;
//					case 1:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down2.png");
//						break;
//					case 2:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down3.png");
//						break;
//					case 3:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down4.png");
//						break;
//					case 4:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down5.png");
//						break;
//					case 5:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down6.png");
//						break;
//					case 6:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down7.png");
//						break;
//					case 7:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down8.png");
//						break;
//				}
//			} else if (direction == 4) {
//				switch (getSpriteNumberX(player)) {
//					case 0:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left1.png");
//						break;
//					case 1:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left2.png");
//						break;
//					case 2:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left3.png");
//						break;
//					case 3:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left4.png");
//						break;
//					case 4:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left5.png");
//						break;
//					case 5:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left6.png");
//						break;
//					case 6:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left7.png");
//						break;
//					case 7:
//						StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left8.png");
//						break;
//				}
//			} else {
//				if (direction == 10 || (player.getDirectionSprite() == -1 && player.getPlayerID() == 10)) { // pour l'init perso 10
//					StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/up1.png");
//				} else if (direction == 20) {
//					StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/right1.png");
//				} else if (direction == 30 || (player.getDirectionSprite() == -1 && player.getPlayerID() == 11)) { // pour l'init perso 11
//					StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/down1.png");
//				} else if (direction == 40) {
//					StdDraw.picture(player.getPosX(), player.getPosY() + 10, "ressources/" + spritePlayerType + "/left1.png");
//				}
//			}
//		}
//		else {
//			StdDraw.setPenColor(Color.blue);
//			StdDraw.filledCircle(player.getPosX(), player.getPosY(),SIZE_PLAYER/2);
//		}
//    }
    public void drawSpriteBombe(double posX, double posY, Bombes bombe) {
		
			
			double currentTime = System.currentTimeMillis();
			double duringTime = currentTime - bombe.getTimeDrop() * 1000;

			double seconde = 1;
			double image = 10;
			double imageParSeconde = seconde / image;


			float leftMilli = (float) duringTime / 1000 - (int) duringTime / 1000;

			

			if (leftMilli <= imageParSeconde * 1) {
    		StdDraw.picture(posX ,posY ,"bombe/bombe1.png");
				StdDraw.picture(posX  , posY  , "bombe/bombe1.png");
			} else if (leftMilli > imageParSeconde * 1 && leftMilli <= imageParSeconde * 2){
    		StdDraw.picture(posX , posY ,"bombe/bombe2.png");
				StdDraw.picture(posX  , posY  , "bombe/bombe2.png");}
			else if (leftMilli > imageParSeconde * 2 && leftMilli <= imageParSeconde * 3){
    		StdDraw.picture(posX   , posY   ,"bombe/bombe3.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe3.png");}
			else if (leftMilli > imageParSeconde * 3 && leftMilli <= imageParSeconde * 4){
    		StdDraw.picture(posX  , posY  ,"bombe/bombe4.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe4.png");}
			else if (leftMilli > imageParSeconde * 4 && leftMilli <= imageParSeconde * 5){
    		StdDraw.picture(posX   , posY   ,"bombe/bombe5.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe5.png");}
			else if (leftMilli > imageParSeconde * 5 && leftMilli <= imageParSeconde * 6){
    		StdDraw.picture(posX   , posY   ,"bombe/bombe6.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe6.png");}
			else if (leftMilli > imageParSeconde * 6 && leftMilli <= imageParSeconde * 7){
    		StdDraw.picture(posX  , posY  ,"bombe/bombe5.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe5.png");}
			else if (leftMilli > imageParSeconde * 7 && leftMilli <= imageParSeconde * 8){
    		StdDraw.picture(posX  ,posY  ,"bombe/bombe4.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe4.png");}
			else if (leftMilli > imageParSeconde * 8 && leftMilli <= imageParSeconde * 9){
    		StdDraw.picture(posX   , posY   ,"bombe/bombe3.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe3.png");}
			else if (leftMilli > imageParSeconde * 9 && leftMilli <= (imageParSeconde * 10) - 0.01){
    		StdDraw.picture(posX   , posY   ,"bombe/bombe2.png");
				StdDraw.picture(posX    , posY    , "bombe/bombe2.png");}


		
		else {
			StdDraw.setPenColor(Color.red);
			StdDraw.filledCircle(posX,posY,0.5);
		}
	}
    
    
}

