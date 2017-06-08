import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Ia extends Perso {
	private boolean dirE;
	private boolean dirW;
	private boolean dirN;
	private boolean dirS;
	private long debut;
	private Bombes bombes;
	private Map map;
	
	

	
	
	
	
	public Ia(String name, float initx, float inity, String couleur, GameControl conf) {
		super(name, initx, inity, couleur, conf);
		this.dirE = true;
		this.dirW = true;
		this.dirN = false;
		this.dirS = false;
	}
public void chemin(Map laby,Map copy, float posx,float posy){
		
		// en haut à droite 
		if(posy>=Main.listPerso.get(1).getY() && posx>Main.listPerso.get(1).getX()){
			if (dirE == true){
				if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
						this.y+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
					
					this.y+=vitesse;
					dirE = false;
					dirN = true;
					}
				}
				else{
					
					this.x+=vitesse;
					dirE = false;
					dirN = true;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
						this.x+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
						
						this.x+=vitesse;
						dirE=true;
						dirN = false;
					}
					
				}
				else{
				
				this.y+=vitesse;
				dirE=true;
				dirN = false;
				}
			}
		}
		
		//En haut à gauche
		if(posy>=Main.listPerso.get(1).getY() && posx<Main.listPerso.get(1).getX()){
			if (dirW == true){
				if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
						this.y+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
					
					this.y+=vitesse;
					dirW = false;
					dirN = true;
					}
				}
				else{
					
					this.x-=vitesse;
					dirW = false;
					dirN = true;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
						this.x+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
						
						this.x-=vitesse;
						dirW=true;
						dirN = false;
					}
					
				}
				else{
				
				this.y+=vitesse;
				dirW=true;
				dirN = false;
				
				}
			}
		}
		// en bas à droite
		if(posy<=Main.listPerso.get(1).getY() && posx>Main.listPerso.get(1).getX()){
			if (dirE == true){
				if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
						this.y+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
					
					this.y-=vitesse;
					dirE = false;
					dirS = true;
					}
				}
				else{
					
					this.x+=vitesse;
					dirE = false;
					dirS = true;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
						this.x+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
						
						this.x+=vitesse;
						dirE=true;
						dirS = false;
					}
					
				}
				else{
				
				this.y-=vitesse;
				dirE=true;
				dirS = false;
				
				}
			}
		}
		// en bas à gauche
		if(posy<=Main.listPerso.get(1).getY() && posx<Main.listPerso.get(1).getX()){
			if (dirW== true){
				if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
						this.y+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
					
					this.y-=vitesse;
					dirW = false;
					dirS = true;
					}
				}
				else{
					
					this.x-=vitesse;
					dirW = true;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
						this.x+=0;
						poserBombi(laby,System.currentTimeMillis()/1000);
					}
					else{
						
						this.x-=vitesse;
						dirW=true;
						dirS = false;
					}
					
				}
				else{
				
				this.y-=vitesse;
				dirW=true;
				dirS = false;
				
				}
			}
		}
	}


public void poserBombi(Map laby, long time) {

   
        if (laby.getLaby()[this.getBlocx()][this.getBlocy()] != 3) {
            int compteur = this.nbBombList();
            System.out.println(compteur);
            if (compteur <= this.getNbBomb()) {
                nbBombInMoment -=1;
                Bombes bombe = new Bombes((int) this.x + 0.5f, (int) this.y + 0.5f, time, this.range);

                this.listBomb.add(bombe);
                bombe.setId((listBomb.size() - 1));

                bombe.putBomb(laby);


            }

        }
    
    for (int i = 0; i < listBomb.size(); i++) {

        if (this.listBomb.get(i) != null) {
            listBomb.get(i).explosion(laby, this);
        }
    }
}
public void changementMap(Map copy){
	if (Main.listPerso.size()!=0){
		
	
		for (int i =0; i< Main.listPerso.size(); i++){
			
			if(Main.listPerso.get(i).listBomb.size()!=0){
				if (listBomb.size()!=0){
				for (int j =0; j < listBomb.size(); j++) {
					
					if ( Main.listPerso.get(i).listBomb.get(j)!=null){
						
					for (int k = 0; k < Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.size(); k++){
						
						if(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)!= null){
							for (int l = 0; l<Main.listPerso.get(i).listBomb.get(j).getRange();l++){
								copy.setCopy(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[0]+l,Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[1],3);	
								copy.setCopy(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[0],Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[1]+l,3);
								copy.setCopy(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[0]-l,Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[1],3);
								copy.setCopy(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[0],Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[1]-l,3);
					}
					
				}
			}}}}}}}}  
	

public void escape(Map laby, Map copy){
	while (copy.getCopy()[(int) Main.listPerso.get(1).getX()][(int)Main.listPerso.get(1).getY()]==3){
		Random random = new Random();
		int x=random.nextInt(4);
			if (x==0 && detectionColIa(laby,copy,x+0.1f,y)==false && detectionColBomb(laby,x+0.1f,y,2) ==false && dirE ==false){
				chemin(laby,copy,Main.listPerso.get(1).getX()+vitesse,Main.listPerso.get(1).getY());
				dirW =true;
			}
			if (x==1 && detectionColIa(laby,copy,x,y+0.1f)==false && detectionColBomb(laby,x,y+0.1f,2) ==false && dirN ==false){
				chemin(laby,copy,Main.listPerso.get(1).getX(),Main.listPerso.get(1).getY()+vitesse);
				dirS =true;
			}
			if (x==2 && detectionColIa(laby,copy,x-0.1f,y)==false && detectionColBomb(laby,x-0.1f,y,2) ==false && dirW ==false){
				chemin(laby,copy,Main.listPerso.get(1).getX()-vitesse,Main.listPerso.get(1).getY());
				dirE =true;
			}
			if (x==3 && detectionColIa(laby,copy,x,y-0.1f)==false && detectionColBomb(laby,x,y-0.1f,2) ==false && dirS ==false){
				chemin(laby,copy,Main.listPerso.get(1).getX(),Main.listPerso.get(1).getY()-vitesse);
				dirN =true;
			}
			else{
				dirN = false;
				dirS = false;
				dirW = false;
				dirE = false;
			}
		
	}
}
public void attaque (Map laby, float posx,float posy){
	for (int i=0; i<(int)bombes.getRange(); i++){
		if ((int)posx==(int)Main.listPerso.get(1).getX()+i &&(int)posy==(int)Main.listPerso.get(1).getX()){
			poserBombi(laby,System.currentTimeMillis()/1000);
		}
		if ((int)posx==(int)Main.listPerso.get(1).getX()-i &&(int)posy==(int)Main.listPerso.get(1).getX()){
			poserBombi(laby,System.currentTimeMillis()/1000);
		}
		if ((int)posx==(int)Main.listPerso.get(1).getX() &&(int)posy==(int)Main.listPerso.get(1).getX()+i){
			poserBombi(laby,System.currentTimeMillis()/1000);
		}
		if ((int)posx==(int)Main.listPerso.get(1).getX() &&(int)posy==(int)Main.listPerso.get(1).getX()-i){
			poserBombi(laby,System.currentTimeMillis()/1000);
		}
}
}
protected boolean detectionColIa(Map laby,Map copy, float x, float y) {



	   

    Contours contour = new Contours(x + (0.5f - taille + taille / 2), y + (0.5f - taille + taille / 2), taille, taille);
    for (int i = 0; i < 21; i++) {
        for (int j = 0; j < 17; j++) {
            if (laby.getLaby()[i][j] == 0 || laby.getLaby()[i][j] == 1 || laby.getLaby()[i][j] == 9 || laby.getCopy()[i][j]==3) {

                Contours obstacle = new Contours(i + 0.5f, j + 0.5f, 1f, 1f);

                if (contour.test(obstacle)) {

                    return true;
                }

            }
        }
    }
    return false;

}
public boolean isDirE() {
	return dirE;
}
public void setDirE(boolean dirE) {
	this.dirE = dirE;
}
public boolean isDirW() {
	return dirW;
}
public void setDirW(boolean dirW) {
	this.dirW = dirW;
}
public long getDebut() {
	return debut;
}
public void setDebut(long debut) {
	this.debut = debut;
}
public Bombes getBombes() {
	return bombes;
}
public void setBombes(Bombes bombes) {
	this.bombes = bombes;
}
public Map getMap() {
	return map;
}
public void setMap(Map map) {
	this.map = map;
}
	

}
