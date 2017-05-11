import java.awt.*;

import edu.princeton.cs.introcs.StdDraw;
public class Perso {
	
	protected String name;
	private float x;
	private float y;
	private int vie=3;
	private float vitesse=0.060f;
	private Color couleur;
	private float taille=0.6f;
	private int UP;
	private int DOWN;
	private int LEFT;
	private int RIGHT;
	private int ACTION;
	private Bombes bombe=new Bombes(getY(),getX(),2,3);
	private Bonus bonus=new Bonus();
	private int nbBomb=3;
	
	
	public int getNbBomb() {
		return nbBomb;
	}


	public void setNbBomb(int nbBomb) {
		this.nbBomb = nbBomb;
	}


	public Perso(String name, float x, float y,Color couleur) {
		super();
		this.name = name;
		
		this.x = x;
		this.y = y;
		this.couleur = couleur;
		UP = 38;
		DOWN = 40;
		LEFT = 37;
		RIGHT = 39;
		ACTION = 32;
	}
	
	
	public void Affichageperso(float x, float y){
		
		StdDraw.setPenColor(this.couleur);
		StdDraw.filledCircle(x, y, taille/2);
		
	}
	
	public boolean DetectionCol (Map laby,float x,float y){
		Contours contour =new Contours(x+(0.5f-taille +taille/2),y+(0.5f-taille+taille/2),taille,taille);
		for(int i=0;i<21;i++){
			for(int j=0;j<17;j++){
				if(laby.getLaby()[j][i]==0 || laby.getLaby()[j][i]==1){
					
					Contours obstacle =new Contours(j+0.5f,i+0.5f,1f,1f);
					if(contour.test(obstacle)){
					
						return true;
					}
					
				}	
			}	
			}
		return false;
		
	}
	
	public void Deplacement(Map laby){
		if (StdDraw.isKeyPressed(UP)){
			if(DetectionCol(laby,x,y+0.1f)){
				this.y+=0;
			}
			else{
			
			this.y+=vitesse;	
			}
			
		}
		
		if(StdDraw.isKeyPressed(DOWN)){
			if(DetectionCol(laby,x,y-0.1f)){
				this.y+=0;
			}
			else{
				
				this.y-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(LEFT)){
			if(DetectionCol(laby,x-0.1f,y)){
				this.x+=0;
			}
			else{
				
				this.x-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(RIGHT)){
			if(DetectionCol(laby,x+0.1f,y)){
				this.x+=0;
			}
			else{
				
				this.x+=vitesse;
			}
			
		}
		this.takeBonus(laby, getBlocy(), getBlocx());
		
	}
	
	public void PoserBomb(Map laby){
		
		if(StdDraw.isKeyPressed(ACTION)){
			Bombes bombe = new Bombes(this.x, this.y,1,3);
			bombe.Poser(laby);
			
			bombe.explosion(laby, this);
			
			
			
					
		}	
	}
	
	public void takeBonus(Map laby, int blocx, int blocy){
		
		if(laby.getLaby()[blocx][blocy] == 10){
			laby.setLaby(blocx,blocy,2);
            if (this.bombe.getRange() < 10) {
                this.bombe.setRange(this.bombe.getRange()- 1);
            }
        }
		if(laby.getLaby()[blocx][blocy] == 11){
			laby.setLaby(blocx,blocy,2);
            if (this.bombe.getRange() > 1) {
                this.bombe.setRange(this.bombe.getRange()- 1);
            }
        }
		if(laby.getLaby()[blocx][blocy] == 12){
			laby.setLaby(blocx,blocy,2);
                this.bombe.setRange(10);
            }
		
		if(laby.getLaby()[blocx][blocy] == 13){
			laby.setLaby(blocx,blocy,2);
            if (this.bombe.getRange() > 1) {
                this.bombe.setRange(this.bombe.getRange()- 1);
            }
        }
//		//if(laby.getLaby()[blocx][blocy] == 14){
//			laby.setLaby(blocx,blocy,2);
//            if (bombe.getRange() > 1) {
//                bombe.setRange(bombe.getRange()- 1);
//            }
//        }
		if(laby.getLaby()[blocx][blocy] == 15){
			laby.setLaby(blocx,blocy,2);
                this.setVie(this.getVie()+ 1);
            }
		if(laby.getLaby()[blocx][blocy] == 16){
			laby.setLaby(blocx,blocy,2);
			if(this.getVitesse()<0.130f){
                this.setVitesse((float) (this.getVitesse()+ 0.02f));
			}
            }
		if(laby.getLaby()[blocx][blocy] == 17){
			laby.setLaby(blocx,blocy,2);
			if(this.getVitesse()>0){
                this.setVitesse((float) (this.getVitesse()- 0.02f));
			}
            }
		if(laby.getLaby()[blocx][blocy] == 18){
			laby.setLaby(blocx,blocy,2);
			if(this.getNbBomb()<7){
				this.setNbBomb((this.getNbBomb()+ 2));
			}
                
            }
		if(laby.getLaby()[blocx][blocy] == 19){
			laby.setLaby(blocx,blocy,2);
			if(this.getNbBomb()>2){
				this.setNbBomb((this.getNbBomb()- 2));
			}
                
            }
		
		
		
        }
		
			
		
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}
	public int getUP() {
		return UP;
	}
	public void setUP(int uP) {
		UP = uP;
	}
	public int getDOWN() {
		return DOWN;
	}
	public void setDOWN(int dOWN) {
		DOWN = dOWN;
	}
	public int getLEFT() {
		return LEFT;
	}
	public void setLEFT(int lEFT) {
		LEFT = lEFT;
	}
	public int getRIGHT() {
		return RIGHT;
	}
	public void setRIGHT(int rIGHT) {
		RIGHT = rIGHT;
	}
	public int getACTION() {
		return ACTION;
	}
	public void setACTION(int aCTION) {
		ACTION = aCTION;
	}


	public Bombes getBombe() {
		return bombe;
	}


	public void setBombe(Bombes bombe) {
		this.bombe = bombe;
	}


	public Bonus getBonus() {
		return bonus;
	}


	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	
	public int getBlocx() {
		return (int) Math.floor(x);
	}
	
	public int getBlocy() {
		return (int) Math.floor(y);
	}
	
	
	
	
	
}
