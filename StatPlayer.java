import java.awt.Color;

/*import edu.princeton.cs.introcs.StdDraw;*/

public class StatPlayer {

	Perso player ;
	
	public StatPlayer(Perso player) {
        this.player = player;
    }

    public void display(String name) {
    	for(int i=0;i<Main.listPerso.size();i++){
    		if(Main.listPerso.get(i)!=null){
    			if(Main.listPerso.get(i).getName()==name){
    				
    			
    			if(i==0){
    			StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(3,-1,Main.listPerso.get(i).getName());
                StdDraw.text(3,-2,String.valueOf("LIFE : "+Main.listPerso.get(i).getVie()));
                StdDraw.text(3,-3,String.valueOf("Nombre bombes : "+Main.listPerso.get(i).getNbBomb()));
                StdDraw.text(4.5,-4,String.valueOf("Vitesse : "+Main.listPerso.get(i).getVitesse()));
                

    		}
    		else if (i==1){

    		StdDraw.setPenColor(Color.BLACK);
            StdDraw.text(14.5,-1,Main.listPerso.get(i).getName());
            StdDraw.text(14.5,-2,String.valueOf("LIFE : "+Main.listPerso.get(i).getVie()));
            StdDraw.text(14.5,-3,String.valueOf("Nombre bombes : "+Main.listPerso.get(i).getNbBomb()));
            StdDraw.text(16,-4,String.valueOf("Vitesse : "+Main.listPerso.get(i).getVitesse()));
    		}
    	}
        	
        }}
       
}}


