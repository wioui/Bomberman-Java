import java.awt.*;

import edu.princeton.cs.introcs.StdDraw;
public class Perso {
	
	protected String name;
	private float x;
	private float y;
	private int vie=3;
	private float vitesse=0.080f;
	private Color couleur;
	private float taille=0.6f;
	private int UP;
	private int DOWN;
	private int LEFT;
	private int RIGHT;
	private int ACTION;
	
	
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
	
	public void Deplacement(Map Laby){
		if (StdDraw.isKeyPressed(UP)){
			if(DetectionCol(Laby,x,y+0.1f)){
				this.y+=0;
			}
			else{
			
			this.y+=vitesse;	
			}
			
		}
		
		if(StdDraw.isKeyPressed(DOWN)){
			if(DetectionCol(Laby,x,y-0.1f)){
				this.y+=0;
			}
			else{
				
				this.y-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(LEFT)){
			if(DetectionCol(Laby,x-0.1f,y)){
				this.x+=0;
			}
			else{
				
				this.x-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(RIGHT)){
			if(DetectionCol(Laby,x+0.1f,y)){
				this.x+=0;
			}
			else{
				
				this.x+=vitesse;
			}
			
		}
		
	}
	
	private void PoserBomb(){
		
		if(StdDraw.isKeyPressed(ACTION)){
			
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
	
	
	
	
	
	
}
