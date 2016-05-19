import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.geometry.Point2D;

public class Logic{
	public boolean vahed(Point2D[] punktid, Circle[] p1, Circle[] p2){
		
		Point2D point1;
		Point2D point2;
		Point2D check;
		
		if((int)(punktid[1].distance(punktid[0]))==100){
			return true;			
		}else if((int)(punktid[1].distance(punktid[0]))==200){
			//liikus vasakule
			if(punktid[0].getX()>punktid[1].getX()){
				//liikus üles vasakule
				if(punktid[0].getY()>punktid[1].getY()){
					for(int i=0;i<12;i++){
						point1 = new Point2D(p1[i].getCenterX(),p1[i].getCenterY());
						point2 = new Point2D(p2[i].getCenterX(),p2[i].getCenterY());
						check = new Point2D(punktid[0].getX()-73,punktid[0].getY()-69);
						if(point1.subtract(36,34).equals(check)){
							System.out.println("liikus üles vasakule");
							return true;
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus üles vasakule");
							return true;
						}						
					}
				//liikus alla vasakule				
				}else if(punktid[0].getY()<punktid[1].getY()){
					for(int i=0;i<12;i++){
						point1 = new Point2D(p1[i].getCenterX(),p1[i].getCenterY());
						point2 = new Point2D(p2[i].getCenterX(),p2[i].getCenterY());
						check = new Point2D(punktid[0].getX()-73,punktid[0].getY()+69);
						if(point1.subtract(36,34).equals(check)){
							System.out.println("liikus alla vasakule");
							return true;
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus alla vasakule");
							return true;
						}	
					}
				}
			//liikus paremale	
			}else if(punktid[0].getX()<punktid[1].getX()){
				//liikus üles paremale
				if(punktid[0].getY()>punktid[1].getY()){
					for(int i=0;i<12;i++){
						point1 = new Point2D(p1[i].getCenterX(),p1[i].getCenterY());
						point2 = new Point2D(p2[i].getCenterX(),p2[i].getCenterY());
						check = new Point2D(punktid[0].getX()+73,punktid[0].getY()-69);
						if(point1.subtract(36,34).equals(check)){
							System.out.println("liikus üles paremale");
							return true;
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus üles paremale");
							return true;
						}	
					}
				//liikus alla paremale			
				}else if(punktid[0].getY()<punktid[1].getY()){
					for(int i=0;i<12;i++){
						point1 = new Point2D(p1[i].getCenterX(),p1[i].getCenterY());
						point2 = new Point2D(p2[i].getCenterX(),p2[i].getCenterY());
						check = new Point2D(punktid[0].getX()+73,punktid[0].getY()+69);
						if(point1.subtract(36,34).equals(check)){
							System.out.println("liikus alla paremale");
							return true;
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus alla paremale");
							return true;
						}	
					}
				}
			}
		}
		return false;
	}
	
	public boolean tahad(Point2D[] punktid, int kumb){
		if(kumb==0){
			if(punktid[1].subtract(punktid[0]).getY()>0){
				return true;
			}else{
				return false;
			}			
		}else if(kumb==1){
			if(punktid[1].subtract(punktid[0]).getY()<0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
//x= 73 y=69