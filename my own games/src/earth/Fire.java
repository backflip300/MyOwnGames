package earth;

import java.util.Random;

public class Fire {

	public Fire() {
	
	}
	
	
	public static int[] coordinates(){
		int xr,yr;
		Random r = new Random();
		int rand2 = r.nextInt(1000) + 1;
		 int rand = r.nextInt(100) + 1;
		if (rand > 50){
			 yr = rand2;
			if (rand > 75){
				 xr = 1000;
				 
			}else {
				xr = 0;

			}
		}else {
			xr = rand2;
			if (rand < 25){
				yr = 1000;
			}else{
				yr = 0;
			}
		}
		
		
		
		return new int[]{xr,yr};
		
	}
	
	
}
