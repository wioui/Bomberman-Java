import java.awt.*;

import edu.princeton.cs.introcs.StdDraw;

public class Bombes {
	




	private float bombx;
	private float bomby;
	private int blocx;
	private int blocy;
	private double timeDrop;
	private int explosiontime;
	private float range;
	private boolean escapeActive;
	
	
	
	
	public Bombes(float bombx, float bomby, double timeDrop,
			float range) {
		
		this.bombx = bombx;
		this.bomby = bomby;
		this.timeDrop = timeDrop;
		this.range = range;
		this.escapeActive=true;
		this.explosiontime=4;
		
	}
	

	
	public void explosion(Map laby, Perso joueur){
		
		boolean exploU=true;
		boolean exploD=true;
		boolean exploR=true;
		boolean exploL=true;

		 if (this.blocx == joueur.getBlocx() && this.blocy == joueur.getBlocy()) {
	            this.escapeActive = true;
	        }
	        else {
	            this.escapeActive = false;
	        }
		
		
		
		
		if (this.timeDrop+this.explosiontime < System.currentTimeMillis()/1000){
		for (int i=1; i<=this.range;i++){
			
			if (laby.getLaby()[this.getBlocx()][this.getBlocy()] !=0 ) {
				if(joueur.getBlocx()==this.getBlocx() && joueur.getBlocy()==this.getBlocy())
                laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
            }			
			if(this.getBlocy()+i<17){
				if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==0){
					exploR=false;
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==1 && exploR==true){
					laby.setLaby(this.getBlocx(), this.getBlocy()+i, 2);
					exploR=false;
					joueur.getBonus().activeBonus(laby, getBlocx(),getBlocy()+i);
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==2 && exploR==true){
					explosionOnPlayer(joueur,this.getBlocx() , this.getBlocy(), exploR);
				}
			}
			if(this.getBlocx()+i<17){
				if(laby.getLaby()[this.getBlocx()+i][this.getBlocy()]==0){
					exploU=false;
				}
				else if(laby.getLaby()[this.getBlocx()+i][this.getBlocy()]==1 && exploU==true){
					laby.setLaby(this.getBlocx()+i, this.getBlocy(), 2);
					exploU=false;
					joueur.getBonus().activeBonus(laby, getBlocx()+i,getBlocy());
				}
			}
			if(this.getBlocy()-i>0){
				if(laby.getLaby()[this.getBlocx()][this.getBlocy()-i]==0){
					exploL=false;
				}
				if(laby.getLaby()[this.getBlocx()][this.getBlocy()-i]==1 && exploL==true){
					laby.setLaby(this.getBlocx(), this.getBlocy()-i, 2);
					exploL=false;
					joueur.getBonus().activeBonus(laby, getBlocx(),getBlocy()-i);
			}
			}
			
			if(this.getBlocx()-i>0){
				if(laby.getLaby()[this.getBlocx()-i][this.getBlocy()]==0){
					exploD=false;
				}
			if(laby.getLaby()[this.getBlocx()-i][this.getBlocy()]==1 && exploD==true){
				laby.setLaby(this.getBlocx()-i, this.getBlocy(), 2);
				exploD=false;
				joueur.getBonus().activeBonus(laby, getBlocx()-i,getBlocy());
			}	
			}
			
			
			
			for(int j=0;j<joueur.listBomb.size();j++){
				if(joueur.listBomb.get(j)!=null){
					joueur.listBomb.set(j,null);
					break;
				}
					
			}
	}
		
		
//		
//		for(int i=0;i<21;i++){
//			for(int j=0;j<17;j++){
//				System.out.print(laby.getLaby()[j][i]+ " ");
//				if(j==16){
//					System.out.println(" ");
//				}
//				
//		 
//			}}
//		System.out.println("fin");
	}
	}

	public void explosionOnPlayer(Perso joueur, int blocx, int blocy, boolean explo){
		if(joueur.getBlocx()==blocx && joueur.getBlocy()==blocy){
			explo=false;
			joueur.setVie(joueur.getVie()-1);
			joueur.setX(1.5f);
			joueur.setY(2.5f);
		}
	}


	public boolean isEscapeActive() {
		return escapeActive;
	}



	public void setEscapeActive(boolean escapeActive) {
		this.escapeActive = escapeActive;
	}



	public double getExplosiontime() {
		return timeDrop;
	}




	public void setExplosiontime(double explosiontime) {
		this.timeDrop = explosiontime;
	}




	public float getRange() {
		return range;
	}




	public void setRange(float range) {
		this.range = range;
	}




	public void setBombx(float bombx) {
		this.bombx = bombx;
	}




	public void setBomby(float bomby) {
		this.bomby = bomby;
	}


	public float getBombx() {
		return bombx;
	}




	




	public float getBomby() {
		return bomby;
	}

	
	
	public int getBlocx() {
		return (int) Math.floor(bombx);
	}




	public void setBlocx(int blocx) {
		this.blocx = blocx;
	}




	public int getBlocy() {
		return (int) Math.floor(bomby);
	}




	public void setBlocy(int blocy) {
		this.blocy = blocy;
	}




	
	

	
}
