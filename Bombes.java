import java.awt.*;

import edu.princeton.cs.introcs.StdDraw;

public class Bombes {
	




	private float bombx;
	private float bomby;
	private int blocx;
	private int blocy;
	private boolean explosion;
	private double explosiontime=4;
	private float range=3;
	
	
	
	
	public Bombes(float bombx, float bomby, double explosiontime,
			float range) {
		
		this.bombx = bombx;
		this.bomby = bomby;
		this.explosiontime = explosiontime;
		this.range = range;
	}
	
	public void Poser(Map laby){
		
		laby.setLaby(this.getBlocy(),this.getBlocx(),3);
	}
	
	
	public void explosion(Map laby, Perso joueur){
		
		boolean exploU=true;
		boolean exploD=true;
		boolean exploR=true;
		boolean exploL=true;
		
		for (int i=1; i<=this.range;i++){
			
			if(this.getBlocx()+i<21){
				if(laby.getLaby()[this.getBlocy()][this.getBlocx()+i]==0){
					exploR=false;
				}
				if(laby.getLaby()[this.getBlocy()][this.getBlocx()+i]==1 && exploR==true){
					laby.setLaby(this.getBlocy(), this.getBlocx()+i, 2);
					exploR=false;
					joueur.getBonus().activeBonus(laby, getBlocy(),getBlocx()+i);
				}		
			}
			if(this.getBlocy()+i<17){
				if(laby.getLaby()[this.getBlocy()+i][this.getBlocx()]==0){
					exploU=false;
				}
				if(laby.getLaby()[this.getBlocy()+i][this.getBlocx()]==1 && exploU==true){
					laby.setLaby(this.getBlocy()+i, this.getBlocx(), 2);
					exploU=false;
					joueur.getBonus().activeBonus(laby, getBlocy()+i,getBlocx());
				}
			}
			if(this.getBlocx()-i>0){
				if(laby.getLaby()[this.getBlocy()][this.getBlocx()-i]==0){
					exploL=false;
				}
				if(laby.getLaby()[this.getBlocy()][this.getBlocx()-i]==1 && exploL==true){
					laby.setLaby(this.getBlocy(), this.getBlocx()-i, 2);
					exploL=false;
					joueur.getBonus().activeBonus(laby, getBlocy(),getBlocx()-1);
			}
			}
			
			if(this.getBlocy()-i>0){
				if(laby.getLaby()[this.getBlocy()-i][this.getBlocx()]==0){
					exploD=false;
				}
			if(laby.getLaby()[this.getBlocy()-i][this.getBlocx()]==1 && exploD==true){
				laby.setLaby(this.getBlocy()-i, this.getBlocx(), 2);
				exploD=false;
				joueur.getBonus().activeBonus(laby, getBlocy()-i,getBlocx());
			}	
			}
			
	}
		
		
		
		for(int i=0;i<21;i++){
			for(int j=0;j<17;j++){
				System.out.print(laby.getLaby()[j][i]+ " ");
				if(j==16){
					System.out.println(" ");
				}
				
		 
			}}
		System.out.println("fin");
	}





	public boolean isExplosion() {
		return explosion;
	}




	public void setExplosion(boolean explosion) {
		this.explosion = explosion;
	}




	public double getExplosiontime() {
		return explosiontime;
	}




	public void setExplosiontime(double explosiontime) {
		this.explosiontime = explosiontime;
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
