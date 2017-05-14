import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
public class Perso {
	
	protected String name;
	private float x;
	private float y;
	private int vie=3;
	private float vitesse=0.10f;
	private Color couleur;
	private float taille=0.6f;
	private Bombes bombe;
	protected List<Bombes> listBomb;
	private Bonus bonus=new Bonus();
	private int nbBomb;
	private GameControl touches;

	
	
	
	
	
	public int getNbBomb() {
		return nbBomb;
	}


	public void setNbBomb(int nbBomb) {
		this.nbBomb = nbBomb;
	}


	public Perso(String name, float x, float y,Color couleur, GameControl conf) {
		super();
		this.name = name;
		
		this.x = x;
		this.y = y;
		this.couleur = couleur;
		this.listBomb= new LinkedList<>();
		this.nbBomb=3;
		this.bombe=new Bombes(x, y, System.currentTimeMillis(), 3);
		this.touches=conf;
	}
	
	
	public void affichageperso(float x, float y){
		
		StdDraw.setPenColor(this.couleur);
		StdDraw.filledCircle(x, y, taille/2);
		
	}
	
	private boolean detectionCol (Map laby,float x,float y){
		Contours contour =new Contours(x+(0.5f-taille +taille/2),y+(0.5f-taille+taille/2),taille,taille);
		for(int i=0;i<21;i++){
			for(int j=0;j<17;j++){
				if(laby.getLaby()[i][j]==0 || laby.getLaby()[i][j]==1){
					
					Contours obstacle =new Contours(i+0.5f,j+0.5f,1f,1f);
					
					if(contour.test(obstacle)){
					
						return true;
					}
					
				}
			}	
			}
		return false;
		
	}
	
	private boolean detectionColBomb (Map laby, float x, float y){
		Contours contour =new Contours(x+(0.5f-taille +taille/2),y+(0.5f-taille+taille/2),taille,taille);
		
		if(!listBomb.isEmpty()){
			for(int it=0;it<listBomb.size();it++){
			if (this.listBomb.get(it)!=null){
				if(!this.listBomb.get(it).isEscapeActive()){
							
							Contours obstacle =new Contours(this.listBomb.get(it).getBlocx()+0.5f,this.listBomb.get(it).getBlocy()+0.5f,1f,1f);
							if(contour.test(obstacle)){
							
								return true;
							}
					}
					}	
				}	
				}
			
		return false;
		
	
	}
	
	public void Deplacement(Map laby){
		if (StdDraw.isKeyPressed(this.touches.getUP())){
			if(detectionCol(laby,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f) ){
				this.y+=0;
			}
			else{
			
			this.y+=vitesse;	
			}
			
		}
		
		if(StdDraw.isKeyPressed(this.touches.getDOWN())){
			if(detectionCol(laby,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f) ){
				this.y+=0;
			}
			else{
				
				this.y-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(this.touches.getLEFT())){
			if(detectionCol(laby,x-0.1f,y) || detectionColBomb(laby,x-0.1f,y) ){
				this.x+=0;
			}
			else{
				
				this.x-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(this.touches.getRIGHT())){
			if(detectionCol(laby,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y) ){
				this.x+=0;
			}
			else{
				
				this.x+=vitesse;
			}
			
		}

		this.takeBonus(laby, getBlocx(), getBlocy());
		
	}
	
	
	private int nbBombList(){
		int compteur=0;
		for(int i=0;i<this.listBomb.size();i++){
			if(this.listBomb.get(i)!=null){
				compteur++;
			}
		}
		return compteur;
	}
	

	
	public void poserBomb(Map laby,long time){
		
		if(StdDraw.isKeyPressed(this.touches.getACTION())){
			if (laby.getLaby()[this.getBlocx()][this.getBlocy()]!=3){
				int compteur=this.nbBombList();
				if(compteur<this.getNbBomb()){
	            		Bombes bombe = new Bombes(this.x, this.y,time,3);
	                    this.listBomb.add(bombe);
	                    
	                   
	                    laby.setLaby(this.getBlocx(),this.getBlocy(),3);
	                    
	                    
				}
						
	                }
				}
		for(int i=0;i<listBomb.size();i++){
			if (listBomb.get(i) != null){
			listBomb.get(i).explosion(laby, this);
			}
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
			if(laby.getLaby()[blocx][blocy] == 14){
		laby.setLaby(blocx,blocy,2);
            if (bombe.getRange() > 1) {
                bombe.setRange(bombe.getRange()- 1);
            }
        }
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
