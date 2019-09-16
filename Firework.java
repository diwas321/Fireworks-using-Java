import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Firework extends JComponent{

	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	
	int type=Canvas.whatType; //variable to store user's input for explosion type

	public void paintComponent(Graphics g) {
		
		type=Canvas.whatType;
		g.setColor(Canvas.projectilecolor);
		
		//variables to control the projectile
		double gravity =9.8;
		double x1=0,y1=0; //initial place to fire projectile from
		double x,y; //dynamics location found using the formula given
		double velocity=Canvas.velocity;
		double angle=Canvas.angle;
		double time= 2*velocity*Math.sin(Math.toRadians(angle))/gravity;
		
		//statement to draw the projectile before explosion
		if (Canvas.draw) {
			for (double i=0; i<Canvas.explosionTime; i+=(time)/9999) {
				x = (velocity*Math.cos(Math.toRadians(angle))*i);
				y = (velocity*Math.sin(Math.toRadians(angle))*i-1/2*gravity*i*i);
				
				g.drawString("*", (int) x, (int) Math.abs(getHeight()-y));
				//updating current position
				x1=(int)x;
				y1=getHeight()-(int)y;
			}

			//drawing lines
			if (type==1) {
				for (int i = 0; i<50; i++) {
					g.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
					g.drawLine((int) x1,(int) y1,(int) (x1+(int) (50*Math.cos(Math.toRadians((360/60)*(i))))),(int) (y1+(int) (50*Math.sin(Math.toRadians((360/60)*(i))))));
					g.drawLine((int) x1,(int) y1,(int) (x1+(int) (300*Math.cos(Math.toRadians((360/30)*(i))))),(int) (y1+(int) (300*Math.sin(Math.toRadians((360/30)*(i))))));
					g.drawLine((int) x1,(int) y1,(int) (x1+(int) (100*Math.cos(Math.toRadians((360/50)*(i))))),(int) (y1+(int) (100*Math.sin(Math.toRadians((360/50)*(i))))));
					g.drawLine((int) x1,(int) y1,(int) (x1+(int) (200*Math.cos(Math.toRadians((360/40)*(i))))),(int) (y1+(int) (200*Math.sin(Math.toRadians((360/40)*(i))))));
				}
			}
			//drawing squares
			else if (type==2) {
				for (int i=1;i<=15;i++) {
					g.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
					g.drawRect((int)(x1-(10*i)),(int)(y1-(10*i)),15*i,15*i);
					g.drawRect((int)(x1+10*i),(int)(y1+10*i),10*i,10*i);
					g.drawRect((int)(x1),(int)(y1),15*i,15*i);
				}
			}
			//drawing Circles
			else if (type==3) {
				for (int i=1;i<=55;i++) {
					g.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
					
					g.drawOval((int)(x1-(10*i)), (int) y1, (10*i),(10*i));
					g.drawOval((int)x1,(int)y1,(10*i),(10*i));
					
					g.drawOval((int)(x1-(10*i)),(int)((y1-(10*i))),(10*i),(10*i));
					g.drawOval((int) x1, (int)((y1-(10*i))), (10*i), (10*i));
					
				}
			}		

			//drawing Bubbles
			else if(type==4) {
				for (int i=1;i<=60;i++) {
					g.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
					g.drawOval((int)((rand.nextInt(800)-200)+x1),(int)(y1-(rand.nextInt(400))),8,8);
					g.drawOval((int)((rand.nextInt(800)-500)+x1),(int)(y1+(rand.nextInt(600))),4,4);
					g.drawOval((int)((rand.nextInt(800)+250)+x1),(int)(y1-(rand.nextInt(400))),12,12);
					g.drawOval((int)((rand.nextInt(60)-20)+x1),(int)(y1-(rand.nextInt(60))),10,10);
					g.drawOval((int)((rand.nextInt(600)-250)+x1),(int)(y1-(rand.nextInt(600))),12,12);
					g.drawOval((int)((rand.nextInt(800)+500)+x1),(int)(y1+(rand.nextInt(200))+200),5,5);
				}
			}

		}

	}

}