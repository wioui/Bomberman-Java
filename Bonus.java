import java.util.Random;

public class Bonus {

	
	public boolean bonusOrNot(){
		Random random = new Random();
		int active=random.nextInt(5);
		if(active==1){
			return true;
		}
		return false;
		
	}
	
	public int chooseBonus(){
		int min=10;
		int max=19;
		Random random = new Random();
		int bonus=min+random.nextInt(max-min);
		
		return bonus;

}
	
	public void activeBonus(Map laby, int blocx, int blocy){
		int bonus=chooseBonus();
		if(bonusOrNot()){
			System.out.println(bonus);
			laby.setLaby(blocx, blocy, bonus);
		}
	}
	
	}

