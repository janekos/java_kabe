import javafx.geometry.Point2D;

public class Player{
	public static Point2D[] player1(){
		int rida1 = 0;
		int rida2 = 0;
		int rida3 = 0;
		Point2D[] piece_loc = new Point2D[12];
		for(int i=0;i<12;i++){
			if(i>=0 && i<=3){				
				piece_loc[i]=new Point2D((rida1*146+8+36), (40+34));
				rida1++;
			}else if(i>=4 && i<=7){
				piece_loc[i]=new Point2D((rida2*146+81+36), (109+34));
				rida2++;
			}else if(i>=8 && i<=11){
				piece_loc[i]=new Point2D((rida3*146+8+36), (178+34));
				rida3++;
			}
		}
		
		return piece_loc;
	}
	
	public static Point2D[] player2(){
		int rida1 = 0;
		int rida2 = 0;
		int rida3 = 0;
		Point2D[] piece_loc = new Point2D[12];
		for(int i=0;i<12;i++){
			if(i>=0 && i<=3){
				piece_loc[i]=new Point2D((rida1*146+81+36), (385+34));
				rida1++;
			}else if(i>=4 && i<=7){
				piece_loc[i]=new Point2D((rida2*146+8+36), (454+34));
				rida2++;
			}else if(i>=8 && i<=11){
				piece_loc[i]=new Point2D((rida3*146+81+36), (523+34));
				rida3++;
			}
		}
		
		return piece_loc;
	}
}