/**
 * ---------------------------------------------------------------------------
 * File name: Gui2.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 18, 2012<br/>
 * Date of Last Modification: Apr 18, 2012
 * ---------------------------------------------------------------------------
 */

package july10;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import laserDefense.LaserCanvas;

/**
 * Runs the gui of the program. Contains all other pieces of the code. The timing
 * algorithm was coded by Gudradain on 
 * http://www.java-gaming.org/index.php?PHPSESSID=sdq8f3rbfsdgupc2cn008jt0q6&topic=21919.0<br>
 *
 * <hr>
 * Date created: Apr 18, 2012<br>
 * Date last modified: Apr 18, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Gui implements Runnable
{
	
	
//////////////////
//
//FIELDS
//
//////////////////
	
	
	private static String FRAME_TITLE = "Laser Defense";

	//	The width of the game window. Controls the outer frame size
	public static final int	WIDTH	= 600;
//	the height of the game window. Controls the outer frame size
	public static final int	HEIGHT	= 600;
	
//	The TutorCanvas that the game screen will be written on
	TutorCanvas canvas;
	
//	The frame and panel that holds the canvas
	JFrame frame;
	JPanel panel;
	
//	menu bar for the gui
	JMenuBar menuBar;
	
//	menus for the gui
	JMenu fileMenu,
		  gameMenu,
		  aboutMenu;
	
//	menu items for the gui
	JMenuItem resetOption,
			  changeFileOption,
			  quitOption,
			  laserOption,
			  speedOption,
			  aboutOption;
	
//	image for the custom icon
	BufferedImage icon;
	
//	file for the custom icon
	File iconFile = new File("resources/laserIcon.gif");
	
//	the FPS that I want to have
	long desiredFPS = 60;
	
//	how long my ticks can be and get the FPS I want
	long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;

//	running allows me to stop execution
	boolean running = true;
	
	File wordFile = new File("/TypingTutor/resources/wordList.txt");

	
//////////////////
//
//CONSTRUCTORS
//
//////////////////
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 */
	public Gui()
	{
//		create a frame with the title 
		frame = new JFrame(FRAME_TITLE + " - " + wordFile.getName( ));
		
//		load and set the custom icon
		loadIcon();
		frame.setIconImage(icon);

//		create the panel with the dimension constants
		panel = (JPanel) frame.getContentPane( );

		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);

//		create a new laser canvas
		canvas = new LaserCanvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);
		
//		build the menu bar
		buildMenuBar( );

//		add the canvas to the panel
		panel.add(canvas);

//		add the specialized key listener to the canvas to handle keyboard input
		canvas.addKeyListener(new TutorKeyListener());
		canvas.addMouseListener(new TutorMouseClickListener( ));

//		set the frame to exit on close, pack it, then display it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
//		add a focus listener to the canvas to check if the user is paying attention
		canvas.addFocusListener(new TutorFocusListener());
		
//		create the buffer strategy and ask for the focus
		canvas.setBufferStrategy( );
		canvas.requestFocus();
	}
	
	
//////////////////
//
//METHODS
//
//////////////////
	

	/**
	 * Load the custom icon. Outputs the error to the console if ther is one <br>        
	 *
	 * <hr>
	 * Date created: Apr 20, 2012 <br>
	 * Date last modified: Apr 20, 2012 <br>
	 *
	 * <hr>
	 */
	private void loadIcon()
	{
		try
		{
			icon = ImageIO.read(iconFile);
		}
		catch (IOException e)
		{
			System.out.println("Error loading the custom icon! " + e.getMessage( ));
		}
	}


	/**
	 * Builds the menu bar for the GUI. Creates the menu. It registers a TutorMenuListener with the buttons. <br>        
	 *
	 * <hr>
	 * Date created: Apr 20, 2012 <br>
	 * Date last modified: Apr 20, 2012 <br>
	 *
	 * <hr>
	 */
	private void buildMenuBar()
	{
		menuBar = new JMenuBar( );
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		resetOption = new JMenuItem("Reset Game");
		resetOption.addActionListener(new TutorMenuListener( ));
		resetOption.setMnemonic(KeyEvent.VK_R);
		
		changeFileOption = new JMenuItem("Load File");
		changeFileOption.addActionListener(new TutorMenuListener( ));
		changeFileOption.setMnemonic(KeyEvent.VK_F);
		
		quitOption = new JMenuItem("Quit Game");
		quitOption.addActionListener(new TutorMenuListener( ));
		quitOption.setMnemonic(KeyEvent.VK_Q);
		
		fileMenu.add(resetOption);
		fileMenu.add(changeFileOption);
		fileMenu.add(quitOption);
		
		aboutMenu = new JMenu("About");
		aboutMenu.setMnemonic(KeyEvent.VK_A);
		
		aboutOption = new JMenuItem("About Us");
		aboutOption.addActionListener(new TutorMenuListener( ));
		aboutOption.setMnemonic(KeyEvent.VK_A);
		
		aboutMenu.add(aboutOption);
		

		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		
		frame.setJMenuBar(menuBar);
	}
	
	
	/**
	 * Private inner class to handle the menus<br>
	 *
	 * <hr>
	 * Date created: Apr 20, 2012<br>
	 * Date last modified: May 14, 2012<br>
	 * <hr>
	 * @author Matthew Paul
	 */
	private class TutorMenuListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
//			if the button clicked was the reset, call the canvas's reset method
			if(e.getSource( ) == resetOption)
			{
				canvas.reset(wordFile);
			}
			
//			Activate the change file dialog if the change File button is clicked
			if(e.getSource( ) == changeFileOption)
			{
				changeWordFile();
			}
			
//			if its the quit button, close the JVM
			else if (e.getSource( ) == quitOption)
			{
				System.exit(0);
			}
//			if about, create our AWESOME dialog frame
			else if (e.getSource( ) == aboutOption)
			{
				new AboutDialog(frame);				
			}
		}

		
	}
	
	/**
	 * Focus listener to check to make sure the player is paying attention<br>
	 *
	 * <hr>
	 * Date created: Apr 20, 2012<br>
	 * Date last modified: Apr 20, 2012<br>
	 * <hr>
	 * @author Matthew Paul
	 */
	private class TutorFocusListener implements FocusListener
	{

//		if you look at the screen, unpause the game
		@Override
		public void focusGained(FocusEvent arg0)
		{
			canvas.setPause(false);
		}

//		if you look away, pause the game
		@Override
		public void focusLost(FocusEvent arg0)
		{
			canvas.setPause(true);
		}
		
	}

	/**
	 * Key listener to handle all the keypresses<br>
	 *
	 * <hr>
	 * Date created: Apr 20, 2012<br>
	 * Date last modified: Apr 20, 2012<br>
	 * <hr>
	 * @author Matthew Paul
	 */
	private class TutorKeyListener implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e)
		{
			//			do nothing
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			//			do nothing
		}

//		when a key is typed, pass it through the canvas to the game
		@Override
		public void keyTyped(KeyEvent e)
		{
			canvas.processCharacter(e);
		}

	}
	
	
	/**
	 * Mouse click listener to enable hotspots.<br>
	 *
	 * <hr>
	 * Date created: May 9, 2012<br>
	 * Date last modified: May 9, 2012<br>
	 * <hr>
	 * @author Matthew Paul
	 */
	private class TutorMouseClickListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			canvas.mouseClicked(e);
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}

	/**
	 * Calculates and times the render and update methods for the game. Originally
	 * coded by Gudradain; I changed the code to fit my needs. <br>        
	 *
	 * <hr>
	 * Date created: Apr 20, 2012 <br>
	 * Date last modified: Apr 20, 2012 <br>
	 *
	 * <hr>
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
//		variables related to timing
		long beginLoopTime;
		long endLoopTime;
		long currentUpdateTime = System.nanoTime();
		long lastUpdateTime;
		long deltaLoop;

		while(running)
		{
			
			beginLoopTime = System.nanoTime();
			
			canvas.render( );

			lastUpdateTime = currentUpdateTime;
			currentUpdateTime = System.nanoTime();
			
//			update the game
			canvas.update((int) ((currentUpdateTime - lastUpdateTime)/(1000*1000)));

			
			endLoopTime = System.nanoTime();
			deltaLoop = endLoopTime - beginLoopTime;

			if(deltaLoop <= desiredDeltaLoop)
			{
				try
				{
					Thread.sleep((desiredDeltaLoop - deltaLoop)/(1000*1000));
				}
				catch(InterruptedException e)
				{
					System.out.println(e.getMessage( ));
				}
			}
			else
			{
				//Do nothing. We are already late.
			}
		}
	}
	
	private void changeWordFile()
	{
		int choice = JOptionPane.showConfirmDialog(canvas,
						"Are you sure you want to change word files? Doing so will reset the game.",
						"Change Word",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		
		if (choice == JOptionPane.YES_OPTION)
		{
			JFileChooser chooser = new JFileChooser( );
			
			choice = chooser.showOpenDialog(canvas);
			if (choice == JFileChooser.APPROVE_OPTION)
			{
				wordFile = chooser.getSelectedFile( );
				
				frame.setTitle(FRAME_TITLE + " - " + wordFile.getName( ));
				canvas.reset(wordFile);
			}
		}
	}

	/**
	 * Main method of the program. Instantiates a gui object and sets it to run <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 */
	public static void main(String [ ] args)
	{
//		create an instance and set it running
		Gui gui = new Gui();
		new Thread(gui).start( );
	}

}