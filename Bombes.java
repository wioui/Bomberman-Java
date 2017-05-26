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
	private int id;
	public  List<Integer[]> listCoordExplosion = new LinkedList<>();
	int direction;
	
	
	
	
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
		
		StdDraw.picture(this.bombx, this.bomby, "///C:/Users/wioui/Documents/Bomberman/src/Image/Bomb.PNG");
		
		 if(joueur.canPushBomb) {
	            bonusPushBomb(joueur,laby);
	        }
		 
		 
		 while ((((joueur.getX()>this.getBombx()+1.1) || (joueur.getX()<this.getBombx()-1.1)) || (((joueur.getY()>this.getBomby()+1.1) || (joueur.getY()<this.getBomby()-1.1))))&& this.escapeActive) {
	            this.escapeActive = false;
	        }

		
		
		if (this.timeDrop+this.explosiontime < System.currentTimeMillis()/1000){
		for (int i=1; i<=this.range;i++){
			
			if (laby.getLaby()[this.getBlocx()][this.getBlocy()]==2){
				addPosToList(this.getBlocx(), this.getBlocy());
				exploall=explosionOnPlayer(joueur,this.getBlocx() , this.getBlocy(), exploall);
			}
			if (laby.getLaby()[this.getBlocx()][this.getBlocy()] ==3 ) {
				
                laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
				
            }
			if(this.getBlocy()+i<17){
				
				if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==0){
					exploU=false;
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==1 && exploU){
					addPosToList(this.getBlocx(), this.getBlocy()+i);
					laby.setLaby(this.getBlocx(), this.getBlocy()+i, 2);
					
					exploU=false;
					joueur.getBonus().activeBonus(laby, getBlocx(),getBlocy()+i);
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()+i]==3){
					addPosToList(this.getBlocx(), this.getBlocy()+i);
					explosionOnBomb(laby, this.getBlocx(), this.getBlocy()+i);
				}

				explosionOnPlayer(joueur,this.getBlocx() , this.getBlocy()+i, exploU);
				
			}
			if(this.getBlocx()+i<21){
				
				if(laby.getLaby()[this.getBlocx()+i][this.getBlocy()]==0){
					exploR=false;
				}
				else if(laby.getLaby()[this.getBlocx()+i][this.getBlocy()]==1 && exploR){
					addPosToList(this.getBlocx()+i, this.getBlocy());
					laby.setLaby(this.getBlocx()+i, this.getBlocy(), 2);
					
					exploR=false;
					joueur.getBonus().activeBonus(laby, getBlocx()+i,getBlocy());
				}
				else if(laby.getLaby()[this.getBlocx()+i][this.getBlocy()]==3){
					addPosToList(this.getBlocx()+i, this.getBlocy());
					explosionOnBomb(laby, this.getBlocx()+i, this.getBlocy());
				}
				explosionOnPlayer(joueur,this.getBlocx()+i , this.getBlocy(), exploR);
				
			}
			if(this.getBlocy()-i>0){
				
				if(laby.getLaby()[this.getBlocx()][this.getBlocy()-i]==0){
					exploD=false;
				}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()-i]==1 && exploD){
					addPosToList(this.getBlocx(), this.getBlocy()-i);
					laby.setLaby(this.getBlocx(), this.getBlocy()-i, 2);
					exploD=false;
					joueur.getBonus().activeBonus(laby, getBlocx(),getBlocy()-i);
			}
				else if(laby.getLaby()[this.getBlocx()][this.getBlocy()-i]==3){
					addPosToList(this.getBlocx(), this.getBlocy()-i);
					explosionOnBomb(laby, this.getBlocx(), this.getBlocy()-i);
				}

				explosionOnPlayer(joueur,this.getBlocx() , this.getBlocy()-i, exploD);
				
			}
			
			if(this.getBlocx()-i>0){
				
				if(laby.getLaby()[this.getBlocx()-i][this.getBlocy()]==0){
					exploL=false;
				}
			if(laby.getLaby()[this.getBlocx()-i][this.getBlocy()]==1 && exploL){
				addPosToList(this.getBlocx()-i, this.getBlocy());
				laby.setLaby(this.getBlocx()-i, this.getBlocy(), 2);
				
				exploL=false;
				joueur.getBonus().activeBonus(laby, getBlocx()-i,getBlocy());
			}
			
			else if(laby.getLaby()[this.getBlocx()-i][this.getBlocy()]==3){
				addPosToList(this.getBlocx()-i, this.getBlocy());
				
				explosionOnBomb(laby, this.getBlocx()-i, this.getBlocy());
			}
			explosionOnPlayer(joueur,this.getBlocx()-i , this.getBlocy(), exploL);
			
			}
			
//			Animation bombeAnimation = new Animation(this, this.id);
//            Main.listAnimationBomb.add(this.id,bombeAnimation);			
			
			for(int j=0;j<joueur.listBomb.size();j++){
				if(joueur.listBomb.get(j)!=null){
					if(joueur.listBomb.get(j).getId()==this.getId()){
						joueur.listBomb.set(j,null);
						break;
					}
					
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
		
	public void bonusPushBomb(Perso player, Map laby) {
    	if (this.direction == 1) {
    	    if (laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==1 ||laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==0 ||laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==3) {
    	        /*this.direction = 3;*/
    	        this.bomby+=0;

            }
            else {
            	laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
            	laby.setLaby(this.getBlocx(), this.getBlocy()+1, 3);
                this.bomby+=1;

            }
        }
        else if (this.direction == 3) {
            if (laby.getLaby()[this.getBlocx()][this.getBlocy()-1]==1 ||laby.getLaby()[this.getBlocx()][this.getBlocy()-1]==0 ||laby.getLaby()[this.getBlocx()][this.getBlocy()-1]==3) {
                /*this.direction = 1;*/
                this.bomby-=0;
            }
            else {
            	laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
            	laby.setLaby(this.getBlocx(), this.getBlocy()-1, 3);
                this.bomby-=1;
            }


        }
        else if (direction == 2) {
            if (laby.getLaby()[this.getBlocx()+1][this.getBlocy()]==1 ||laby.getLaby()[this.getBlocx()+1][this.getBlocy()]==0 ||laby.getLaby()[this.getBlocx()+1][this.getBlocy()]==3) {
                /*this.direction = 4;*/
                this.bombx += 0;
            }
            else {
            	laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
            	laby.setLaby(this.getBlocx()+1, this.getBlocy(), 3);
                this.bombx += 1;

            }


        }

        else if (direction == 4) {
            if (laby.getLaby()[this.getBlocx()-1][this.getBlocy()]==1 ||laby.getLaby()[this.getBlocx()-1][this.getBlocy()]==0 ||laby.getLaby()[this.getBlocx()-1][this.getBlocy()]==3) {
                /*this.direction = 2;*/
                this.bombx -= 0;
            }
            else {
            	laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
            	laby.setLaby(this.getBlocx()-1, this.getBlocy(), 3);
                this.bombx -= 1;

            }


        }


    }

	



	



	private boolean explosionOnPlayer(Perso joueur, int blocx, int blocy, boolean explo){
		for(int i=0;i< Main.listPerso.size();i++){
			if(Main.listPerso.get(i).getBlocx()==blocx && Main.listPerso.get(i).getBlocy()==blocy &&explo){
	
				explo=false;
				Main.listPerso.get(i).setVie(Main.listPerso.get(i).getVie()-1);
				Main.listPerso.get(i).setX(Main.listPerso.get(i).getInitx());
				Main.listPerso.get(i).setY(Main.listPerso.get(i).getInity());

			}
		}
		return explo;
		
	}
	
	private void explosionOnBomb(Map laby,int blocx,int blocy){
		for (int i=0; i<Main.listPerso.size();i++){
			if(Main.listPerso.get(i)!=null){
				for(int j=0; j<Main.listPerso.get(i).listBomb.size();j++){
					if(Main.listPerso.get(i).listBomb.get(j)!=null){
						
						if(Main.listPerso.get(i).listBomb.get(j).getBlocx()==blocx && Main.listPerso.get(i).listBomb.get(j).getBlocy()==blocy){
							
							Main.listPerso.get(i).listBomb.get(j).setExplosiontime(0);
						}
					}
					
				}
			}
			
		}
	}
	
	private void addPosToList(int blocX, int blocY) {
        Integer arrayPos [] = new Integer[2];
        arrayPos[0] = blocX;
        arrayPos[1] = blocY;
        boolean addToList = true;

        if (this.listCoordExplosion.isEmpty()) {
            this.listCoordExplosion.add(arrayPos);
        }
        else {
            for (int item = 0; item < this.listCoordExplosion.size(); item++) {
                int inListBlocX = this.listCoordExplosion.get(item)[0];
                int inListBlocY = this.listCoordExplosion.get(item)[1];
                if (blocX == inListBlocX && blocY == inListBlocY) {
                    addToList = false;
                }
            }
            if (addToList) {
                this.listCoordExplosion.add(arrayPos);
            }
        }
    }


	public boolean isEscapeActive() {
		return escapeActive;
	}

	 public void putBomb(Map laby){
	        laby.setLaby(this.getBlocx(),this.getBlocy(),3);
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

	public double getTimeDrop() {
		return timeDrop;
	}



	public void setTimeDrop(double timeDrop) {
		this.timeDrop = timeDrop;
	}



	public void setExplosiontime(int explosiontime) {
		this.explosiontime = explosiontime;
	}



	public List<Integer[]> getListCoordExplosion() {
		return listCoordExplosion;
	}



	public void setListCoordExplosion(List<Integer[]> listCoordExplosion) {
		this.listCoordExplosion = listCoordExplosion;
	}


	public int getDirection() {
		return direction;
	}



	public void setDirection(int direction) {
		this.direction = direction;
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



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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
