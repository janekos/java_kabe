import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.BlendMode;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.geometry.Point2D;
import java.util.*;
 
public class KabeUI extends Application {
    
    @Override
    public void start(Stage Stage) {
		//panes
		Pane root = new Pane();
		Pane option = new Pane();
        Pane game = new Pane();
		
		//scenes
		Scene scene = new Scene(root, 600, 600);
		Scene option_scene = new Scene(option, 600, 600);
		Scene game_scene = new Scene(game, 600, 600);
		
		//buttons
        Button btn = new Button();
        Button close_btn = new Button();
        Button option_btn = new Button();
        Button game_btn = new Button();
		Text pkiri = new Text();
		Text kumb = new Text();
		
		//Esileht
		pkiri.setText("Kabe");
		pkiri.setFont(new Font(140));
		pkiri.setFill(Color.WHITE);
		pkiri.setLayoutX(160);
		pkiri.setLayoutY(150);
		
        btn.setText("Mängi");
		btn.setMinSize(140, 50);
		btn.setFont(new Font(30));
		btn.setLayoutX(250);
		btn.setLayoutY(220);
		
		close_btn.setText("Sulge");
		close_btn.setMinSize(140, 50);
		close_btn.setFont(new Font(30));
		close_btn.setLayoutX(250);
		close_btn.setLayoutY(330);
		
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
			public void handle(ActionEvent event){
				Stage.setScene(game_scene);
                System.out.println("Switched to game");
			}
        });
		close_btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
			public void handle(ActionEvent event){
                System.out.println("Closed application");
				Stage.hide();
			}
        });
		
		//Game page
		game_btn.setText("Tagasi valikutesse");
		game_btn.setLayoutX(8);
		game_btn.setLayoutY(5);
		game_btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
				Stage.setScene(scene);
                System.out.println("Switched to Main Page");
            }
        });		
        
        //Element addon to pane
		BackgroundImage pilt= new BackgroundImage(new Image("images/kabe.jpg",600,600,false,true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		root.setBackground(new Background(pilt));
        root.getChildren().add(pkiri);
        root.getChildren().add(btn);
        root.getChildren().add(close_btn);
		game.setStyle("-fx-background-color: burlywood");
        game.getChildren().add(game_btn);
		
		//Draw Gamearea and eventlistener
		joonistaLaud(game);
		kelleK2ik(game, kumb, 0);
		Point2D v6lts = new Point2D(-1,-1);
		Circle[] v6lts_r = new Circle[12];
		Circle[] p1 =joonistaNupudp1(game, v6lts ,-1, v6lts_r);
		Circle[] p2 =joonistaNupudp2(game, v6lts ,-1, v6lts_r);
		m2nguJuht(game, p1, p2, kumb);
		
		//Stage
        Stage.setTitle("Kabe");
        Stage.setScene(scene);
		Stage.setResizable(false);
		Stage.sizeToScene();
        Stage.show();
    }
	
	public void joonistaLaud(Pane game){		
		int kumb = 0;
		int loendur = 0;
		for(int i=0;i<8;i++){
			if(i%2==1){
				kumb=1;
			}else{
				kumb=0;
			}
			for(int j=0;j<8;j++){
				Rectangle r = new Rectangle();
				r.setX(j*73+8);
				r.setY(i*69+40);
				r.setWidth(73);
				r.setHeight(69);
				if(kumb%2==0){
					r.setFill(Color.DARKGOLDENROD);
				}else if(kumb%2==1){
					r.setFill(Color.GOLD);					
				}				
				game.getChildren().add(r);
				kumb++;
			}
		}
	}
	
	public Circle[] joonistaNupudp1(Pane game, Point2D uusnupp, int koht, Circle[] ringid){
		Player p = new Player();
		Point2D[] p1_locs=p.player1();
		Circle[] p1_rings = new Circle[12];
		Circle[] new_rings = new Circle[12];
		if(koht==-1){
			for(int i=0; i<12;i++){
				Circle nupp1 = new Circle(p1_locs[i].getX(), p1_locs[i].getY(), 35, Color.WHITE);
				nupp1.setStroke(Color.BLACK);
				nupp1.setStrokeWidth(4);
				nupp1.setMouseTransparent(true);
				game.getChildren().add(nupp1);
				p1_rings[i]=nupp1;
			}
			return p1_rings;
		}else{
			for(int i=0; i<12;i++){
				if(i == koht){
					game.getChildren().removeAll(ringid[i]);
					Circle uus_nupp1 = new Circle(uusnupp.getX()+36, uusnupp.getY()+34, 35, Color.WHITE);
					uus_nupp1.setStroke(Color.BLACK);
					uus_nupp1.setStrokeWidth(4);
					uus_nupp1.setMouseTransparent(true);
					new_rings[i]=uus_nupp1;
					game.getChildren().add(uus_nupp1);
				}else{
					Circle nupp1 = new Circle(ringid[i].getCenterX(), ringid[i].getCenterY(), 35, Color.WHITE);
					game.getChildren().remove(ringid[i]);
					nupp1.setStroke(Color.BLACK);
					nupp1.setStrokeWidth(4);
					nupp1.setMouseTransparent(true);
					game.getChildren().add(nupp1);
					new_rings[i]=nupp1;
				}
			}
			return new_rings;
		}
	}
	
	public Circle[] joonistaNupudp2(Pane game, Point2D uusnupp, int koht, Circle[] ringid){
		Player p = new Player();
		Point2D[] p2_locs=p.player2();
		Circle[] p2_rings = new Circle[12];
		Circle[] new_rings = new Circle[12];
		if(koht==-1){
			for(int i=0; i<12;i++){
				Circle nupp2 = new Circle(p2_locs[i].getX(), p2_locs[i].getY(), 35, Color.BLACK);
				nupp2.setStroke(Color.WHITE);
				nupp2.setStrokeWidth(4);
				nupp2.setMouseTransparent(true);
				game.getChildren().add(nupp2);
				p2_rings[i]=nupp2;
			}
			return p2_rings;
		}else{
			for(int i=0; i<12;i++){
				if(i == koht){
					game.getChildren().removeAll(ringid[i]);
					Circle uus_nupp1 = new Circle(uusnupp.getX()+36, uusnupp.getY()+34, 35, Color.BLACK);
					uus_nupp1.setStroke(Color.WHITE);
					uus_nupp1.setStrokeWidth(4);
					uus_nupp1.setMouseTransparent(true);
					new_rings[i]=uus_nupp1;
					game.getChildren().add(uus_nupp1);
				}else{
					Circle nupp2 = new Circle(ringid[i].getCenterX(), ringid[i].getCenterY(), 35, Color.BLACK);
					game.getChildren().remove(ringid[i]);
					nupp2.setStroke(Color.WHITE);
					nupp2.setStrokeWidth(4);
					nupp2.setMouseTransparent(true);
					new_rings[i]=nupp2;
					game.getChildren().add(nupp2);
				}
			}
			return new_rings;
		}
	}
	
	public Circle[] liigutaNuppP1(Pane game, Point2D[] punktid, Circle[] p1){	
		int count=0;
		Point2D esiR = punktid[0];
		Point2D tesiR = punktid[1];
		Circle[] ringid = new Circle[12];		
		for(Circle p:p1){
			Point2D q = new Point2D(p.getCenterX(),p.getCenterY());
			if(q.subtract(36,34).equals(esiR)){
				ringid = joonistaNupudp1(game, tesiR, count, p1);
			}else{				
				count++;
			}
		}
		
		System.out.println((int)(esiR.distance(tesiR)));
		System.out.println("1.x,y = "+esiR.toString()+"   2.x,y = "+tesiR.toString());	
		return ringid;
	}
	
	public Circle[] liigutaNuppP2(Pane game, Point2D[] punktid, Circle[] p2){
		int count=0;
		Point2D esiR = punktid[0];
		Point2D tesiR = punktid[1];
		Circle[] ringid = new Circle[12];
		for(Circle p:p2){
			Point2D q = new Point2D(p.getCenterX(),p.getCenterY());
			if(q.subtract(36,34).equals(esiR)){
				ringid = joonistaNupudp2(game, tesiR, count, p2);
			}else{				
				count++;
			}
		}
		System.out.println((int)(esiR.distance(tesiR)));
		System.out.println("1.x,y = "+esiR.toString()+"   2.x,y = "+tesiR.toString());
		return ringid;
	}
	
	public void kelleK2ik(Pane game, Text kumb, int kes){
		try{
			game.getChildren().remove(kumb);
		}catch(Exception x){}
		kumb.setFont(new Font(30));
		kumb.setLayoutX(420);
		kumb.setLayoutY(30);
		if(kes==0){
			kumb.setText("Valgete käik");
			kumb.setFill(Color.WHITE);			
		}else if(kes==1){			
			kumb.setText("Mustade käik");
			kumb.setFill(Color.BLACK);
		}
		game.getChildren().add(kumb);
	}
	
	public void m2nguJuht(Pane game, Circle[] p1_1, Circle[] p2_1, Text kumbo){		
		game.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			
			int clicked = 0;
			Point2D[] punktid = new Point2D[2];
			Point2D esiP;
			Point2D tesiP_1;
			Point2D tesiP_2;
			Circle[] p1 = p1_1;
			Circle[] p2 = p2_1;
			Text kumb = kumbo;
			Rectangle kast1;
			Rectangle kast2;
			boolean vaba = false;
			int kes = 0;
			
			/*kumb.setFill(Color.BLACK);
			kumb.setText("Mustad käivad");*/
			
			public void handle(MouseEvent e){
				//System.out.println(((Rectangle)e.getTarget()).getBoundsInLocal());
				//System.out.println((p1[0].getX()-36)+" "+(p1[0].getY()-34));
							//double kasti_x = (((Rectangle)e.getTarget()).getX());
							//double kasti_y = (((Rectangle)e.getTarget()).getY());
									//System.out.println(p.subtract((double)36,(double) 34).toString());
										//System.out.println("seal on nupp");
										//System.out.println("seal ei ole nuppu");
									//System.out.println(p.subtract((double)36,(double) 34).toString());
										//System.out.println("seal on nupp");
										//System.out.println("seal ei ole nuppu");
							//System.out.println(e.getTarget());
							//System.out.println("x:"+((Rectangle)e.getTarget()).getX()+" y:"+((Rectangle)e.getTarget()).getY());
										//System.out.println("seal on nupp");
										//System.out.println("seal ei ole nuppu");
										//System.out.println("seal on nupp");
										//System.out.println("seal ei ole nuppu");
				if(clicked==0){					
					if(((Rectangle)e.getTarget()).getFill()!= Color.GOLD){							
						try{
							kast1=((Rectangle)e.getTarget());
							kast1.setStroke(Color.DARKSLATEBLUE);
							kast1.setStrokeWidth(3);
							punktid[0] = new Point2D((((Rectangle)e.getTarget()).getX()),(((Rectangle)e.getTarget()).getY()));
							if(kes==0){
								for(Circle p:p1){
									esiP = new Point2D(p.getCenterX(),p.getCenterY());
									if(esiP.subtract(36,34).equals(punktid[0])){
										vaba = false;
										break;
									}else{
										vaba = true;
									}
								}
							}else if(kes==1){
								for(Circle p:p2){
									esiP = new Point2D(p.getCenterX(),p.getCenterY());
									if(esiP.subtract(36,34).equals(punktid[0])){
										vaba = false;
										break;
									}else{
										vaba = true;
									}
								}
							}
							if(vaba == true){								
								clicked=2;
							}
						}catch(Exception ge){System.out.println(ge);}
					}
				}else if(clicked==1){
					if(((Rectangle)e.getTarget()).getFill()!= Color.GOLD){
						try{
							kast2=((Rectangle)e.getTarget());
							punktid[1] = new Point2D((((Rectangle)e.getTarget()).getX()), (((Rectangle)e.getTarget()).getY()));
							if(kes==0){
								//for(Circle p:p1){
								for(int i=0; i<12;i++){
									tesiP_1 = new Point2D(p1[i].getCenterX(),p1[i].getCenterY());
									tesiP_2 = new Point2D(p2[i].getCenterX(),p2[i].getCenterY());
									if(tesiP_1.subtract(36,34).equals(punktid[1]) || tesiP_2.subtract(36,34).equals(punktid[1])){
										vaba = false;
										break;
									}else{
										vaba = true;
									}
								}
								System.out.println(punktid[1].distance(punktid[0]));
								if(vaba==true){
									if((int)(punktid[1].distance(punktid[0]))==100 || (int)(punktid[1].distance(punktid[0]))==200){
										if(punktid[1].subtract(punktid[0]).getY()>0){
											System.out.println(punktid[1].subtract(punktid[0]));
											p1 = liigutaNuppP1(game, punktid, p1);
											kelleK2ik(game, kumb, 1);
											kes=1;
										}
									}
								}
							}else if(kes==1){
								//for(Circle p:p2){
								for(int i=0; i<12;i++){
									tesiP_1 = new Point2D(p1[i].getCenterX(),p1[i].getCenterY());
									tesiP_2 = new Point2D(p2[i].getCenterX(),p2[i].getCenterY());
									if(tesiP_2.subtract(36,34).equals(punktid[1]) || tesiP_1.subtract(36,34).equals(punktid[1])){									
										vaba = false;
										break;
									}else{
										vaba = true;
									}
								}
								//System.out.println(punktid[1].distance(punktid[0])+" "+ tesiP_2.distance(esiP));
								if(vaba==true){
									if((int)(punktid[1].distance(punktid[0]))==100 || (int)(punktid[1].distance(punktid[0]))==200){
										if(punktid[1].subtract(punktid[0]).getY()<0){
											System.out.println(punktid[1].subtract(punktid[0]));
											p2 = liigutaNuppP2(game, punktid, p2);
											kelleK2ik(game, kumb, 0);
											kes=0;
										}
									}
								}
							}
						}catch(Exception ge){System.out.println(ge);}
					}
				}
				clicked++;
				if(clicked>1){
					clicked=0;
					try{
						kast1.setStroke(Color.TRANSPARENT);
						kast2.setStroke(Color.TRANSPARENT);
					}catch(Exception ge){}
				}
			}
		});		
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}