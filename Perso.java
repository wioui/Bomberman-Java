import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
public class Perso {
	
	protected String name;
	private float initx;
	private float inity;
	private float x;
	private float y;
	private int vie=3;
	private float vitesse=0.04f;
	private String couleur;
	private float taille=0.6f;
	private Bombes bombe;
	protected List<Bombes> listBomb;
	private Bonus bonus=new Bonus();
	private int nbBomb;
	private GameControl touches;
	public boolean die;
	protected boolean crossWall;
    protected boolean canPushBomb;
	
	
	
	
	
	

	public Perso(String name, float initx, float inity,String couleur, GameControl conf) {
		super();
		this.name = name;
		this.die=false;
		this.initx=initx;
		this.inity=inity;
		this.x = initx;
		this.y = inity;
		this.couleur = couleur;
		this.listBomb= new LinkedList<>();
		this.nbBomb=3;
		this.bombe=new Bombes(x, y, System.currentTimeMillis(), 3);
		this.touches=conf;
		this.canPushBomb=false;
	}
	
	
	public void affichageperso(float x, float y){
		double beforex=(int)this.getX();
		double beforey=(int)this.getY();
//		StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B11.PNG");
//		if (StdDraw.isKeyPressed(this.touches.getRIGHT())){
//		if (this.getX() <= beforex + 0.125) {
//			StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B1.PNG");
//        }
//        else if (beforex + 0.125 < this.getX()  && this.getX() <= beforex + 0.25 ) {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B2.PNG");
//        }
//        else if (beforex + 0.25 < this.getX()  && this.getX() <= beforex + 0.375)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B3.PNG");
//        }
//        else if (beforex + 0.375 < this.getX()  && this.getX() <= beforex + 0.5)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B4.PNG");
//        }
//        else if (beforex + 0.5 < this.getX()  && this.getX() <= beforex + 0.625)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B5.PNG");
//        }
//        else if (beforex + 0.625 < this.getX()  && this.getX() <= beforex + 0.75)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B6.PNG");
//        }
//        else if (beforex + 0.75 < this.getX()  && this.getX() <= beforex + 0.875)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B7.PNG");
//        }
//        else {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B8.PNG");
//        }
//		
//		}
//		if (StdDraw.isKeyPressed(this.touches.getLEFT())){
//		if (this.getX() <= beforex + 0.125) {
//			StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B10.PNG");
//        }
//        else if (beforex + 0.125 < this.getX()  && this.getX() <= beforex + 0.25 ) {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B20.PNG");
//        }
//        else if (beforex + 0.25 < this.getX()  && this.getX() <= beforex + 0.375)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B30.PNG");
//        }
//        else if (beforex + 0.375 < this.getX()  && this.getX() <= beforex + 0.5)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B40.PNG");
//        }
//        else if (beforex + 0.5 < this.getX()  && this.getX() <= beforex + 0.625)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B50.PNG");
//        }
//        else if (beforex + 0.625 < this.getX()  && this.getX() <= beforex + 0.75)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B60.PNG");
//        }
//        else if (beforex + 0.75 < this.getX()  && this.getX() <= beforex + 0.875)  {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B70.PNG");
//        }
//        else {
//        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B80.PNG");
//        }
//		
//		}
//		if (StdDraw.isKeyPressed(this.touches.getUP())){
//			if (this.getY() <= beforey + 0.125) {
//				StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B110.PNG");
//	        }
//	        else if (beforey + 0.125 < this.getY()  && this.getY() <= beforey + 0.25 ) {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B210.PNG");
//	        }
//	        else if (beforey + 0.25 < this.getY()  && this.getY() <= beforey + 0.375)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B310.PNG");
//	        }
//	        else if (beforey + 0.375 < this.getY()  && this.getY() <= beforey + 0.5)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B410.PNG");
//	        }
//	        else if (beforey + 0.5 < this.getY()  && this.getY() <= beforey + 0.625)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B510.PNG");
//	        }
//	        else if (beforey + 0.625 < this.getY()  && this.getY() <= beforey + 0.75)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B610.PNG");
//	        }
//	        else if (beforey + 0.75 < this.getY()  && this.getY() <= beforey + 0.875)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B710.PNG");
//	        }
//	        else {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B810.PNG");
//	        }
//			
//			}
//			if (StdDraw.isKeyPressed(this.touches.getDOWN())){
//			if (this.getY() <= beforey + 0.125) {
//				StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B11.PNG");
//	        }
//	        else if (beforey + 0.125 < this.getY()  && this.getY() <= beforey + 0.25 ) {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B21.PNG");
//	        }
//	        else if (beforey + 0.25 < this.getY()  && this.getY() <= beforey + 0.375)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B31.PNG");
//	        }
//	        else if (beforey + 0.375 < this.getY()  && this.getY() <= beforey + 0.5)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B41.PNG");
//	        }
//	        else if (beforey + 0.5 < this.getY()  && this.getY() <= beforey + 0.625)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B51.PNG");
//	        }
//	        else if (beforey + 0.625 < this.getY()  && this.getY() <= beforey + 0.75)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B61.PNG");
//	        }
//	        else if (beforey + 0.75 < this.getY()  && this.getY() <= beforey + 0.875)  {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B71.PNG");
//	        }
//	        else {
//	        	StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+"B81.PNG");
//	        }
//			}
        	
		if(this.couleur=="white"){
			StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+".PNG");
		}
		if(this.couleur=="black"){
			StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+".PNG");
		}
		if(this.couleur=="green"){
			StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+".PNG");
		}
		if(this.couleur=="blue"){
			StdDraw.picture(x, y, "///C:/Users/wioui/Documents/Bomberman/src/Image/"+this.couleur+".PNG");
		}
		
		
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
	
	private boolean detectionColBomb (Map laby, float x, float y, int direction){
		Contours contour =new Contours(x+(0.5f-taille +taille/2),y+(0.5f-taille+taille/2),taille,taille);
		
		if(!listBomb.isEmpty()){
			for(int it=0;it<listBomb.size();it++){
			if (this.listBomb.get(it)!=null){
				if(!this.listBomb.get(it).isEscapeActive()){
							
							Contours obstacle =new Contours(this.listBomb.get(it).getBlocx()+0.5f,this.listBomb.get(it).getBlocy()+0.5f,1f,1f);
							
							if(contour.test(obstacle)){
								
							 if(this.canPushBomb){
								 this.listBomb.get(it).setDirection(direction);
							 }
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
			if(detectionCol(laby,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
				this.y+=0;
			}
			else{
			
			this.y+=vitesse;	
			}
			
		}
		
		if(StdDraw.isKeyPressed(this.touches.getDOWN())){
			if(detectionCol(laby,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,3) ){
				this.y+=0;
			}
			else{
				
				
				this.y-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(this.touches.getLEFT())){
			if(detectionCol(laby,x-0.1f,y) || detectionColBomb(laby,x-0.1f,y,4) ){
				this.x+=0;
			}
			else{
				
				this.x-=vitesse;
			}
			
		}
		
		if(StdDraw.isKeyPressed(this.touches.getRIGHT())){
			if(detectionCol(laby,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
				this.x+=0;
			}
			else{
				
				this.x+=vitesse;
			}
			
		}

		this.takeBonus(laby, getBlocx(), getBlocy());
		
	}
	
	
	private int nbBombList(){
		int compteur=1;
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
				System.out.println(compteur);
				if(compteur<=this.getNbBomb()){
					
	            		Bombes bombe = new Bombes((int)this.x+0.5f, (int)this.y+0.5f,time,3);
	            		bombe.setId((listBomb.size()+1));
	                    this.listBomb.add(bombe);
	                    bombe.putBomb(laby);
	                    
	                  
	                    
	                    
				}
						
	                }
				}
		for(int i=0;i<listBomb.size();i++){

			if (this.listBomb.get(i) != null){
			listBomb.get(i).explosion(laby, this);
			}
			}

		
		
	}
	
	public void takeBonus(Map laby, int blocx, int blocy){
	
		if(laby.getLaby()[blocx][blocy] == 10){
		laby.setLaby(blocx,blocy,2);
		for(int i=0;i<this.listBomb.size();i++){
			if(this.listBomb.get(i)!=null){
				if (this.listBomb.get(i).getRange() < 10) {
	                this.listBomb.get(i).setRange(this.listBomb.get(i).getRange()+ 1);
	           }
			}
		}
           
        }
		if(laby.getLaby()[blocx][blocy] == 11){
			laby.setLaby(blocx,blocy,2);
			for(int i=0;i<this.listBomb.size();i++){
				if(this.listBomb.get(i)!=null){
					if (this.listBomb.get(i).getRange() > 1) {
		                this.listBomb.get(i).setRange(this.listBomb.get(i).getRange()- 1);
		           }
				}
			}
        }
		if(laby.getLaby()[blocx][blocy] == 12){
			laby.setLaby(blocx,blocy,2);
			for(int i=0;i<this.listBomb.size();i++){
				if(this.listBomb.get(i)!=null){
					this.listBomb.get(i).setRange(10);
		      
				}
			}
		
		}
		
	if(laby.getLaby()[blocx][blocy] == 13){
			laby.setLaby(blocx,blocy,2);
               this.setVie(this.getVie()+ 1);
           }
	if(laby.getLaby()[blocx][blocy] == 14){
		laby.setLaby(blocx,blocy,2);
		if(this.getVitesse()<0.130f){
                this.setVitesse((float) (this.getVitesse()+ 0.005f));
			}
            }
	if(laby.getLaby()[blocx][blocy] == 15){
			laby.setLaby(blocx,blocy,2);
			if(this.getVitesse()>0){
                this.setVitesse((float) (this.getVitesse()- 0.005f));
			}
           }
		if(laby.getLaby()[blocx][blocy] == 16){
		laby.setLaby(blocx,blocy,2);
		if(this.getNbBomb()<7){
		this.setNbBomb((this.getNbBomb()+ 2));
			}
                
            }
		if(laby.getLaby()[blocx][blocy] == 17){
			laby.setLaby(blocx,blocy,2);
			if(this.getNbBomb()>2){
			this.setNbBomb((this.getNbBomb()- 2));
			}
                
            }
		if(laby.getLaby()[blocx][blocy]==18){
			laby.setLaby(blocx, blocy, 2);
			this.setCanPushBomb(true);
		}
	}
		
	public void die(){
		if (this.getVie()<=0){
			this.die=true;
		}
	}
		
        
	
			
		
	public boolean isDie() {
		return die;
	}


	public void setDie(boolean die) {
		this.die = die;
	}


	public int getNbBomb() {
		return nbBomb;
	}


	public void setNbBomb(int nbBomb) {
		this.nbBomb = nbBomb;
	}

	
	
	
	public float getInitx() {
		return initx;
	}


	public void setInitx(float initx) {
		this.initx = initx;
	}


	public float getInity() {
		return inity;
	}


	public void setInity(float inity) {
		this.inity = inity;
	}

	




	public boolean isCrossWall() {
		return crossWall;
	}


	public void setCrossWall(boolean crossWall) {
		this.crossWall = crossWall;
	}


	public boolean isCanPushBomb() {
		return canPushBomb;
	}


	public void setCanPushBomb(boolean canPushBomb) {
		this.canPushBomb = canPushBomb;
	}


	public float getTaille() {
		return taille;
	}


	public void setTaille(float taille) {
		this.taille = taille;
	}


	public List<Bombes> getListBomb() {
		return listBomb;
	}


	public void setListBomb(List<Bombes> listBomb) {
		this.listBomb = listBomb;
	}


	public GameControl getTouches() {
		return touches;
	}


	public void setTouches(GameControl touches) {
		this.touches = touches;
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