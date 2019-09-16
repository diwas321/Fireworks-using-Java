import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Canvas extends JFrame implements ChangeListener, ActionListener { //implementing ChangeListener and ActionListener

    private static final long serialVersionUID = 1L;
    
    Firework newFirework = new Firework();
    JPanel canvaspanel = new JPanel();
    JPanel buttons = new JPanel();
    
    String[] explosions = {"Lines", "Squares", "Circles","Bubbles"}; //Array to store the type of explosion
    String[] colors = {"Black","Red","Orange","Green"}; 
   
    JComboBox<String> explosion = new JComboBox<String>(explosions);
    JComboBox<String> color = new JComboBox<String>(colors); 
    
    JSlider angleslider = new JSlider(30, 60, 45); //slider for angle, min=30, max=60, default 45
    JSlider velocityslider = new JSlider(200,320,250); //slider for velocity, 100<v<300, default =200
    
    JLabel anglesliderlabel = new JLabel("Angle: " + Integer.toString(angleslider.getValue())); //Angle label
    JLabel velocitysliderlabel = new JLabel("Velocity: " + Integer.toString(velocityslider.getValue())); //Velocity label
    
    JButton Fire = new JButton("Fire!"); //Button to launch the projectile and display explosion
    
    public static int velocity = 250;
    public static int angle = 45;
    public static boolean draw=false;
    public static int whatType=1;
    public static int explosionTime=2;
    public static Color projectilecolor=Color.BLACK;
    
    public void start() {
    	
    	this.setTitle("Welcome to Firework Canvas");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

//JPanel button to display all the buttons 
        buttons.setLayout(new FlowLayout());
//adding all the components to JPanel
        buttons.add(anglesliderlabel);
        buttons.add(angleslider);
        buttons.add(velocitysliderlabel);
        buttons.add(velocityslider);
        buttons.add(new JLabel("Colour: "));
        buttons.add(color);
        buttons.add(new JLabel("Explosions: "));
        buttons.add(explosion);
        
        buttons.add(Fire);
        

        //adding the listener into the canvas
        angleslider.addChangeListener(this);
        velocityslider.addChangeListener(this);
        Fire.addActionListener(this);
        color.addActionListener(this);
        explosion.addActionListener(this);

        //canvas to draw the firework
        canvaspanel.add(newFirework);
        newFirework.setPreferredSize(new Dimension(800,800));
            
        //setting position of the pannels
        this.getContentPane().add(buttons, BorderLayout.NORTH);
        this.getContentPane().add(newFirework, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);  
        

               
    }

    @Override
    public void stateChanged(ChangeEvent event) {
    	Object state = event.getSource();

//To store angle value from slider
    	if (state==angleslider) {
    		angle = angleslider.getValue();
    		anglesliderlabel.setText("Angle: " + Integer.toString(angleslider.getValue()));
    	}
//To store velocity value from slider
    	else if (state==velocityslider) {
    		velocity = velocityslider.getValue();
    		velocitysliderlabel.setText("Velocity: " + Integer.toString(velocityslider.getValue()));
    	}
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		Object status = event.getSource();
		System.out.println(event);
		if (status==Fire) {
			draw=true; //the firwork only run when the draw is true,so pressing this button will make that ture
			newFirework.repaint(); //drawing new projectile everytime the fire button is pressed
		}
		//storing the value of the explosion type
				else if(status==explosion) {
					if (explosion.getSelectedItem().equals("Lines")) {
						whatType=1;
					}
					else if (explosion.getSelectedItem().equals("Squares")) {
						whatType=2;
					}
					else if (explosion.getSelectedItem().equals("Circles")) {
						whatType=3;
					}
					else if (explosion.getSelectedItem().equals("Bubbles")) {
						whatType=4;
					}
				}
		//storing value of the color selected
		else if (status==color) {
			if (color.getSelectedItem().equals("Black")){
				projectilecolor=Color.BLACK;				
			}else if (color.getSelectedItem().equals("Green")){
				projectilecolor=Color.GREEN;		
			}else if (color.getSelectedItem().equals("Red")){
				projectilecolor=Color.RED;				
			}else if (color.getSelectedItem().equals("Orange")){
				projectilecolor=Color.ORANGE;				
			}
		}

		
	}
	
	//main method to start a canvas and fill it with the sliders and buttons
	public static void main(String[] args) {
		new Canvas().start();
    }

}