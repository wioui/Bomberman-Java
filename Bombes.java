import java.awt.*;
import java.util.LinkedList;
import java.util.List;

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
		boolean exploall=true;
		

		 while (((joueur.getBlocx()==this.getBlocx()+2) || (joueur.getBlocx()==this.getBlocx()-2)) && this.escapeActive) {
	            this.escapeActive = false;
	        }
		 while (((joueur.getBlocy()==this.getBlocy()+2) || (joueur.getBlocy()==this.getBlocy()-2)) && this.escapeActive) {
	            this.escapeActive = false;
	        }
	        
	        
		
		
		
		if (this.timeDrop+this.explosiontime < System.currentTimeMillis()/1000){
		for (int i=1; i<=this.range;i++){
			
			if (laby.getLaby()[this.getBlocx()][this.getBlocy()]==2 || laby.getLaby()[this.getBlocx()][this.getBlocy()]==5){
				exploall=explosionOnPlayer(joueur,this.getBlocx() , this.getBlocy(), exploall);
			}
			if (laby.getLaby()[this.getBlocx()][this.getBlocy()] ==3 ) {
				
                laby.setLaby(this.getBlocx(), this.getBlocy(), 5);
				
            }			
			if(this.getBlocy()+i<17){
				
				if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==0){
					exploU=false;
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==1 && exploU){
					laby.setLaby(this.getBlocx(), this.getBlocy()+i, 5);
					
					exploU=false;
					joueur.getBonus().activeBonus(laby, getBlocx(),getBlocy()+i);
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==3){
					
				}

				explosionOnPlayer(joueur,this.getBlocx() , this.getBlocy()+i, exploU);
				
			}
			if(this.getBlocx()+i<21){
				
				if(laby.getLaby()[this.getBlocx()+i][this.getBlocy()]==0){
					exploR=false;
				}
				else if(laby.getLaby()[this.getBlocx()+i][this.getBlocy()]==1 && exploR){
					laby.setLaby(this.getBlocx()+i, this.getBlocy(), 5);
					
					exploR=false;
					joueur.getBonus().activeBonus(laby, getBlocx()+i,getBlocy());
				}
				explosionOnPlayer(joueur,this.getBlocx()+i , this.getBlocy(), exploR);
				
			}
			if(this.getBlocy()-i>0){
				
				if(laby.getLaby()[this.getBlocx()][this.getBlocy()-i]==0){
					exploD=false;
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()-i]==1 && exploD){
					laby.setLaby(this.getBlocx(), this.getBlocy()-i, 5);
					exploD=false;
					joueur.getBonus().activeBonus(laby, getBlocx(),getBlocy()-i);
			}

				explosionOnPlayer(joueur,this.getBlocx() , this.getBlocy()-i, exploD);
				
			}
			
			if(this.getBlocx()-i>0){
				
				if(laby.getLaby()[this.getBlocx()-i][this.getBlocy()]==0){
					exploL=false;
				}
			if(laby.getLaby()[this.getBlocx()-i][this.getBlocy()]==1 && exploL){
				laby.setLaby(this.getBlocx()-i, this.getBlocy(), 5);
				
				exploL=false;
				joueur.getBonus().activeBonus(laby, getBlocx()-i,getBlocy());
			}	
			explosionOnPlayer(joueur,this.getBlocx()-i , this.getBlocy(), exploL);
			
			}
			
			Animation explo=new Animation((long) ((System.currentTimeMillis())/1000),1,"j");
			if(explo.getDelay()+explo.getStartTime()< System.currentTimeMillis()/1000){
			explo.animationExplo(laby);}			
			
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
		

	private boolean explosionOnPlayer(Perso joueur, int blocx, int blocy, boolean explo){
		for(int i=0;i< Main.listPerso.size();i++){
			if(Main.listPerso.get(i).getBlocx()==blocx && Main.listPerso.get(i).getBlocy()==blocy &&explo){
				System.out.println("touché");
				explo=false;
				Main.listPerso.get(i).setVie(Main.listPerso.get(i).getVie()-1);
				Main.listPerso.get(i).setX(Main.listPerso.get(i).getInitx());
				Main.listPerso.get(i).setY(Main.listPerso.get(i).getInity());

			}
		}
		return explo;
		
	}
	
	private void explosionOnBomb(Map laby,int blocx,int blocy, boolean explo){
		if(laby.getLaby()[blocx][blocy]==3){
			laby.setLaby(blocx, blocy,2);
			laby.setLaby(blocx, blocy,2);
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
