import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.geometry.Point2D;

public class Logic{
	public Circle[][] vahed(Pane game, Point2D[] punktid, Circle[] p1, Circle[] p2){
		
		KabeUI kui = new KabeUI();
		Circle[][] k6ik_nupud = new Circle[2][12];
		Point2D point1;
		Point2D point2;
		Point2D check;
		
		if((int)(punktid[1].distance(punktid[0]))==100){
			k6ik_nupud[0]=p1;
			k6ik_nupud[1]=p2;
			return k6ik_nupud;			
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
							game.getChildren().remove(p1[i]);
							p1[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;	
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus üles vasakule");
							game.getChildren().remove(p2[i]);
							p2[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;
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
							game.getChildren().remove(p1[i]);
							p1[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus alla vasakule");
							game.getChildren().remove(p2[i]);
							p2[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;
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
							game.getChildren().remove(p1[i]);
							p1[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus üles paremale");
							game.getChildren().remove(p2[i]);
							p2[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;
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
							game.getChildren().remove(p1[i]);
							p1[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;
						}else if(point2.subtract(36,34).equals(check)){
							System.out.println("liikus alla paremale");
							game.getChildren().remove(p2[i]);
							p2[i]= new Circle(-1,-1,-1);
							k6ik_nupud[0]=p1;
							k6ik_nupud[1]=p2;
							return k6ik_nupud;
						}	
					}
				}
			}
		}
		k6ik_nupud[0]=p1;
		k6ik_nupud[0][0]=new Circle(-1,-1, 1);
		k6ik_nupud[1]=p2;
		k6ik_nupud[1][0]=new Circle(-1,-1, 1);
		return k6ik_nupud;
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