import java.util.LinkedList;
import java.util.List;

/*import edu.princeton.cs.introcs.StdDraw;*/

public class Bombes {
	




	private float bombx;
	private float bomby;
	private int blocx;
	private int blocy;
	private double timeDrop;
	private int explosiontime;
	private float range;
	private boolean escapeActive;
	private boolean canTakeLife = true;
	private int id;
	public  List<Integer[]> listCoordExplosion = new LinkedList<>();
	int direction;
	 private Integer middleCoord[] = new Integer[2];
	private long animationTime;
	
	
	
	
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
		
		
		this.animationTime = System.currentTimeMillis()+500;
		
		 if(joueur.canPushBomb) { 
	            bonusPushBomb(joueur,laby);
	        }
		 
		 
		 while ((((joueur.getX()>this.getBombx()+1.1) || (joueur.getX()<this.getBombx()-1.1)) || (((joueur.getY()>this.getBomby()+1.1) || (joueur.getY()<this.getBomby()-1.1))))&& this.escapeActive) {
	            this.escapeActive = false;
	        }
		
		 Animation bombeAnimation = new Animation(this, this.id);
		 bombeAnimation.drawSpriteBombe(this.getBombx(), this.getBomby(), this);
		
		if (this.timeDrop+this.explosiontime < System.currentTimeMillis()/1000){
			int nbBomb = joueur.getNbBombInMoment();
			joueur.setNbBombInMoment(nbBomb+=1);
			System.out.println(nbBomb);
			for (int range = 1; range <= this.getRange(); range ++) {

                if (laby.getLaby()[this.getBlocx()][this.getBlocy()] !=0 ) {
                    laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
                    addPosToList(this.getBlocx(), this.getBlocy());
                }
                explosionOnplayer(joueur, this.getBlocx(),this.getBlocy(), exploU);

               if ((this.getBlocy()+range) < 17) {

                    if ((laby.getLaby()[this.getBlocx()][this.getBlocy() + range] == 0)) {
                        exploU = false;

                    }

                    else if ((laby.getLaby()[this.getBlocx()][this.getBlocy() + range] == 1 && exploU)) {

                        addPosToList(this.getBlocx(), this.getBlocy() + range);
                        laby.setLaby(this.getBlocx(), this.getBlocy() + range, 2);
                        joueur.getBonus().activeBonus(laby, this.getBlocx(),this.getBlocy()+range);
                        if (!joueur.crossWall) {
                            exploU = false;
                        }
                    }
                    else if  (laby.getLaby()[this.getBlocx()][this.getBlocy() + range] == 3 && exploU) {
                    	explosionOnBomb(laby,this.getBlocx(),this.getBlocy()+range);
                        exploU = false;

                    }
                    else if ((laby.getLaby()[this.getBlocx()][this.getBlocy() + range] == 2  && exploU)) {
                        addPosToList(this.getBlocx(), this.getBlocy() + range);
                    }

                    explosionOnplayer(joueur, this.getBlocx(),this.getBlocy()+range, exploU);
                }




                if (this.getBlocy()-range >= 0){
                	if ((laby.getLaby()[this.getBlocx()][this.getBlocy() - range] == 0)) {
                        exploD = false;

                    }

                    else if ((laby.getLaby()[this.getBlocx()][this.getBlocy() - range] == 1 && exploD)) {

                        addPosToList(this.getBlocx(), this.getBlocy() - range);
                        laby.setLaby(this.getBlocx(), this.getBlocy() - range, 2);
                        joueur.getBonus().activeBonus(laby, this.getBlocx(),this.getBlocy()-range);
                        if (!joueur.crossWall) {
                            exploD = false;
                        }
                    }
                    else if  (laby.getLaby()[this.getBlocx()][this.getBlocy() - range] == 3 && exploD) {
                    	explosionOnBomb(laby,this.getBlocx(),this.getBlocy()-range);
                        exploD = false;

                    }
                    else if ((laby.getLaby()[this.getBlocx()][this.getBlocy() - range] == 2  && exploD)) {
                        addPosToList(this.getBlocx(), this.getBlocy() - range);
                    }

                    explosionOnplayer(joueur, this.getBlocx(),this.getBlocy()-range, exploD);
                }

                if (this.getBlocx()-range >= 0){
                    if ((laby.getLaby()[this.getBlocx()-range][this.getBlocy()] == 0)) {
                        exploL = false;
                    }
                    else if ((laby.getLaby()[this.getBlocx()-range][this.getBlocy() ] == 1 && exploL)) {
                        addPosToList(this.getBlocx() -range, this.getBlocy());
                        laby.setLaby(this.getBlocx()-range, this.getBlocy(), 2);
                        joueur.getBonus().activeBonus(laby, this.getBlocx()-range,this.getBlocy());
                        if (!joueur.crossWall) {
                            exploL = false;
                        }
                    }
                    else if (laby.getLaby()[this.getBlocx() - range][this.getBlocy()] == 3 && exploL) {
                        explosionOnBomb(laby,this.getBlocx() - range,this.getBlocy());
                        exploL = false;
                    }
                    else if ((laby.getLaby()[this.getBlocx()-range][this.getBlocy()] == 2  && exploL)) {
                        addPosToList(this.getBlocx() -range, this.getBlocy());
                    }
                    explosionOnplayer(joueur,this.getBlocx() -range,this.getBlocy(), exploL);
                }

                if (this.getBlocx()+range < 21){
                    if ((laby.getLaby()[this.getBlocx()+range][this.getBlocy()] == 0)) {
                        exploR = false;
                    }
                    else if ((laby.getLaby()[this.getBlocx()+range][this.getBlocy() ] == 1 && (exploR))) {
                        addPosToList(this.getBlocx() + range, this.getBlocy());
                        laby.setLaby(this.getBlocx()+range, this.getBlocy(), 2);
                        joueur.getBonus().activeBonus(laby, this.getBlocx()+range,this.getBlocy());
                        if (!joueur.crossWall) {
                            exploR = false;
                        }
                    }
                    else if (laby.getLaby()[this.getBlocx() + range][this.getBlocy()] == 3 && exploR) {
                        explosionOnBomb(laby,this.getBlocx() + range,this.getBlocy());
                        exploR = false;
                    }
                    else if ((laby.getLaby()[this.getBlocx() + range][this.getBlocy()] == 2  && exploR)) {
                        addPosToList(this.getBlocx() + range, this.getBlocy());
                    }
                    explosionOnplayer(joueur,this.getBlocx() +range,this.getBlocy(), exploR);
                }

            }
			
			Animation animationExplo = new Animation(this, this.id);
			Main.listAnimationBomb.add(this.id, animationExplo);
            
           
        
			
			for(int j=0;j<joueur.listBomb.size();j++){
				if(joueur.listBomb.get(j)!=null){
					if(joueur.listBomb.get(j).getId()==this.getId()){
						joueur.listBomb.set(j,null);
						
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
		
		
		
	public void bonusPushBomb(Perso joueur, Map laby) {
    	if (this.direction == 1) {
    	    if (laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==1 ||laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==0 ||laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==3 || laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==9) {
    	        /*this.direction = 3;*/
    	        this.bomby+=0;

            }
            else {
            	laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
            	laby.setLaby(this.getBlocx(), this.getBlocy()+1, 3);
                this.bomby+= 1;

            }
        }
        else if (this.direction == 3) {
            if (laby.getLaby()[this.getBlocx()][this.getBlocy()-1]==1 ||laby.getLaby()[this.getBlocx()][this.getBlocy()-1]==0 ||laby.getLaby()[this.getBlocx()][this.getBlocy()-1]==3 || laby.getLaby()[this.getBlocx()][this.getBlocy()+1]== 9) {
                /*this.direction = 1;*/
                this.bomby-= 0;
            }
            else {
            	laby.setLaby(this.getBlocx(), this.getBlocy(), 2);
            	laby.setLaby(this.getBlocx(), this.getBlocy()-1, 3);
                this.bomby-= 0.3;
            }


        }
        else if (direction == 2) {
            if (laby.getLaby()[this.getBlocx()+1][this.getBlocy()]==1 ||laby.getLaby()[this.getBlocx()+1][this.getBlocy()]==0 ||laby.getLaby()[this.getBlocx()+1][this.getBlocy()]==3 || laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==9) {
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
            if (laby.getLaby()[this.getBlocx()-1][this.getBlocy()]==1 ||laby.getLaby()[this.getBlocx()-1][this.getBlocy()]==0 ||laby.getLaby()[this.getBlocx()-1][this.getBlocy()]==3 || laby.getLaby()[this.getBlocx()][this.getBlocy()+1]==9) {
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

	



	



	private boolean explosionOnplayer(Perso joueur, int blocx, int blocy, boolean explo){
		for(int i=0;i< Main.listPerso.size();i++){
			if(Main.listPerso.get(i).getBlocx()==blocx && Main.listPerso.get(i).getBlocy()==blocy &&explo){
				if(Main.listPerso.get(i).isBouclier()==false){
					explo=false;
					if (this.canTakeLife) {
						Main.listPerso.get(i).setVie(Main.listPerso.get(i).getVie() - 1);
						canTakeLife = false;
					}

						/*Main.listPerso.get(i).setCanDie(false);*/
					/*}*/

					Main.listPerso.get(i).setX(Main.listPerso.get(i).getInitx());
					Main.listPerso.get(i).setY(Main.listPerso.get(i).getInity());

				}
				else if(Main.listPerso.get(i).isBouclier()==true) {
					Main.listPerso.get(i).setBouclier(false);
				}
	
				
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
	
	public void addPosToList(int blocX, int blocY) {
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

	  public Integer[] getMiddleCoord() {
	        middleCoord[0] = this.getBlocx();
	        middleCoord[1] = this.getBlocy();
	        return middleCoord ;
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

	

	public long getAnimationTime() {
		return animationTime;
	}



	public void setAnimationTime(long animationTime) {
		this.animationTime = animationTime;
	}



	public void setMiddleCoord(Integer[] middleCoord) {
		this.middleCoord = middleCoord;
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
