import edu.princeton.cs.introcs.StdDraw;

public class Ia extends Perso {
	private boolean dirE;
	private boolean dirW;
	private long debut;
	private Bombes bombes;
	private Map map;
	
	

	
	
	
	
	public Ia(String name, float initx, float inity, String couleur, GameControl conf) {
		super(name, initx, inity, couleur, conf);
		this.dirE = true;
		this.dirW = true;
	}
public void chemin(Map laby,Map copy, float posx,float posy){
		
		// en haut à droite 
		if(Main.listPerso.get(0).getY()>=Main.listPerso.get(1).getY() && Main.listPerso.get(0).getX()>Main.listPerso.get(1).getX()){
			if (dirE == true){
				if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
						this.y+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
					
					this.y+=vitesse;
					dirE = false;
					}
				}
				else{
					
					this.x+=vitesse;
					dirE = false;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
						this.x+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
						
						this.x+=vitesse;
						dirE=true;
					}
					
				}
				else{
				
				this.y+=vitesse;
				dirE=true;
				
				}
			}
		}
		
		//En haut à gauche
		if(Main.listPerso.get(0).getY()>=Main.listPerso.get(1).getY() && Main.listPerso.get(0).getX()<Main.listPerso.get(1).getX()){
			if (dirW == true){
				if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
						this.y+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
					
					this.y+=vitesse;
					dirW = false;
					}
				}
				else{
					
					this.x-=vitesse;
					dirW = false;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
						this.x+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
						
						this.x-=vitesse;
						dirW=true;
					}
					
				}
				else{
				
				this.y+=vitesse;
				dirW=true;
				
				}
			}
		}
		// en bas à droite
		if(Main.listPerso.get(0).getY()<=Main.listPerso.get(1).getY() && Main.listPerso.get(0).getX()>Main.listPerso.get(1).getX()){
			if (dirE == true){
				if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
						this.y+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
					
					this.y-=vitesse;
					dirE = false;
					}
				}
				else{
					
					this.x+=vitesse;
					dirE = false;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
						this.x+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
						
						this.x+=vitesse;
						dirE=true;
					}
					
				}
				else{
				
				this.y-=vitesse;
				dirE=true;
				
				}
			}
		}
		// en bas à gauche
		if(Main.listPerso.get(0).getY()<=Main.listPerso.get(1).getY() && Main.listPerso.get(0).getX()<Main.listPerso.get(1).getX()){
			if (dirW== true){
				if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
					this.x+=0;
					if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
						this.y+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
					
					this.y-=vitesse;
					dirW = false;
					}
				}
				else{
					
					this.x-=vitesse;
					dirW = false;
				}
			}
			else{
				if(detectionColIa(laby,copy,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
					this.y+=0;
					if(detectionColIa(laby,copy,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
						this.x+=0;
						poserBombIa(laby,System.currentTimeMillis()/1000,System.currentTimeMillis());
					}
					else{
						
						this.x-=vitesse;
						dirW=true;
					}
					
				}
				else{
				
				this.y-=vitesse;
				dirW=true;
				
				}
			}
		}
	}

public void poserBombIa(Map laby, long time,long timer){// la fonction qui permet à l'ia de poser des bombes
		poserBombi(laby,time);
		long debut = timer;
		
		if (dirE = false){
			dirW = false;
		}
		else{
			dirW =true;
		}
		if (dirW = false){
			dirE = false;
		}
		else{
			dirE =true;
		}//mettre un timer
		//if(this.debut + 4000 >= System.currentTimeMillis() ){
			//chemin(laby,Main.listPerso.get(1).getInitx(),Main.listPerso.get(1).getInity());
		//}
		//else{
		//chemin(laby,Main.listPerso.get(0).getX(),Main.listPerso.get(0).getY()); }
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
				
				for (int j =0; j < listBomb.size(); j++) {
					if(Main.listPerso.get(i).listBomb.get(j)==null){
						System.out.println("sdkgjhjklg");
					}
					if ( Main.listPerso.get(i).listBomb.get(j)!=null){
						System.out.println("idriss");
					for (int k = 0; k < Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.size(); k++){
						
						if(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)!= null){
						System.out.println(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[0]+" po"+Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[1]);
						copy.setLaby(Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[0],Main.listPerso.get(i).listBomb.get(j).listCoordExplosion.get(k)[1],3);
					}
					
				}
			}}}}}}
	


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
	//public void attaque(Map laby, long time){
		//if (joueurinrange==true){
			//poserBombIa(laby,time);
		//}
	//}

}
