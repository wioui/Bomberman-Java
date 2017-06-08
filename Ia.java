
public class Ia extends Perso {
	private boolean dirE;
	private boolean dirW;
	
	

	
	
	public Ia(String name, float initx, float inity, String couleur, GameControl conf) {
		super(name, initx, inity, couleur, conf);
		this.dirE = true;
		this.dirW = true;
	}
public void chemin(Map laby, float posx,float posy){
		
		
		if(Main.listPerso.get(0).getY()>=Main.listPerso.get(1).getY() && Main.listPerso.get(0).getX()>Main.listPerso.get(1).getX()){
			if (dirE == true){
				if(detectionCol(laby,x+0.1f,y)|| detectionColBomb(laby,x+0.1f,y,2) ){
					this.x+=0;
					if(detectionCol(laby,x,y+0.1f) || detectionColBomb(laby,x,y+0.1f,1) ){
						this.y+=0;
						poserBombIa(laby,time);
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
						poserBombIa(laby,time,timer);
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
	}

public void poserBombIa(Map laby, long time,long timer){// la fonction qui permet à l'ia de poser des bombes
		poserBomb(laby,time);
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
		while(timer !=0 ){
			chemin(laby,Main.listPerso.get(1).getInitx(),Main.listPerso.get(1).getInity());
		}
		chemin(laby,Main.listPerso.get(0).getInitx(),Main.listPerso.get(0).getInity()); 
		}
		
	
	public void attaque(Map laby, long time){
		if (joueurinrange==true){
			poserBombIa(laby,time);
		}
	}

}
