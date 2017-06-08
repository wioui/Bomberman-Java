import edu.princeton.cs.introcs.StdDraw;

public class Ia extends Perso {
	private boolean dirE;
	private boolean dirW;
	private long debut;
	
	

	
	
	public Ia(String name, float initx, float inity, String couleur, GameControl conf) {
		super(name, initx, inity, couleur, conf);
		this.dirE = true;
		this.dirW = true;
	}
public void chemin(Map laby, float posx,float posy){
		
		// en haut à droite 
		if(Main.listPerso.get(0).getY()>=Main.listPerso.get(1).getY() && Main.listPerso.get(0).getX()>Main.listPerso.get(1).getX()){
			if (dirE == true){
				if(detectionCol(laby,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
					this.x+=0;
					if(detectionCol(laby,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
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
				if(detectionCol(laby,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
					this.y+=0;
					if(detectionCol(laby,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
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
				if(detectionCol(laby,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
					this.x+=0;
					if(detectionCol(laby,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
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
				if(detectionCol(laby,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
					this.y+=0;
					if(detectionCol(laby,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
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
				if(detectionCol(laby,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
					this.x+=0;
					if(detectionCol(laby,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
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
				if(detectionCol(laby,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
					this.y+=0;
					if(detectionCol(laby,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
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
				if(detectionCol(laby,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
					this.x+=0;
					if(detectionCol(laby,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
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
				if(detectionCol(laby,x,y-0.1f) || detectionColBomb(laby,x,y-0.1f,1) ){
					this.y+=0;
					if(detectionCol(laby,x-0.1f,y)|| detectionColBomb(laby,x-0.1f,y,2) ){
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


	
	//public void attaque(Map laby, long time){
		//if (joueurinrange==true){
			//poserBombIa(laby,time);
		//}
	//}

}
