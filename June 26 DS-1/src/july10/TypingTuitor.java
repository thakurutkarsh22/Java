package july10;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.net.ssl.HandshakeCompletedListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TypingTuitor extends JFrame implements ActionListener{

	boolean running ;
	int timeRemaining;
	int score;
	Timer timer ;
	
	String [] data ;
	
	JLabel lbltimer ;
	JLabel lblscore ; 
	JLabel lblword ;
	JTextField txtword ;
	JButton btnstart ;
	JButton btnstop ;
	
	public TypingTuitor(String[] data) {
		
		this.data =data ;
		super.setTitle("TyPing MasTer ");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setExtendedState(MAXIMIZED_BOTH);
		GridLayout layout = new GridLayout(3,2) ;
		super.setLayout(layout);
		
		Font font = new Font("Chiller" , 1 , 50 );
		
		lbltimer = new JLabel() ;
		lbltimer.setFont(font);
		super.add(lbltimer);
		
		lblscore = new JLabel() ;
		lblscore.setFont(font);
		super.add(lblscore);
		
		lblword = new JLabel( );
		lblword.setFont(font);
		super.add(lblword);
		
		txtword = new JTextField() ;
		txtword.setFont(font);
		super.add(txtword);
		
		btnstart = new JButton() ;
		btnstart.setFont(font);
		btnstart.addActionListener(this);
		super.add(btnstart);
		
		btnstop = new JButton() ;
		btnstop.setFont(font);
		btnstop.addActionListener(this);
		super.add(btnstop);
		
		
		
		
		GameStart();
		
		super.setVisible(true);
	}

	public void GameStart () {
		
		
		 running = false;
		 timeRemaining = 50;
		 score = 0;
		 timer = new Timer(2000, this);
		 
		 lbltimer.setText("Time :" + timeRemaining ); 
		 lblscore.setText("Score " ); ; 
		 lblword.setText("Word") ;
		 txtword.setText(""); 
		 txtword.setEnabled(false);
		
		 btnstart.setText("Start") ;
		 btnstop.setText("Stop");
		 btnstop.setEnabled(false) ;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnstart) {
			handleStart();
		}else if(e.getSource() == btnstop) {
			handleStop();
		}else if(e.getSource()==timer) {
			handleTimer();
		}
		
	}

	private void handleTimer() {
		if(timeRemaining>0) {
			this.timeRemaining--;
			lbltimer.setText("Timer :" + timeRemaining);
		
			String expected = lblword.getText();
			String actual = txtword.getText() ;
			
			if(expected.equals(actual) && actual.length() > 0) {
				
				this.score++;
			}
			
			lblword.setText(data[(int)(Math.random() * data.length)]);
			lbltimer.setText("Timer : " + timeRemaining);
			lblscore.setText("Score : " + score);
			txtword.setText("");
			txtword.setFocusable(true);
					
		}else {
			
			handleStop();
		}
		
	}

	private void handleStop() {
	
		timer.stop();
		
		int choice = JOptionPane.showConfirmDialog(this, "Replay?");
		
		if(choice == JOptionPane.YES_OPTION ) {
			
			GameStart();
			
		}else if(choice == JOptionPane.NO_OPTION) {
			this.dispose();
			
		}else {
			
//			btnstart.setEnabled(true);
//			btnstart.setText("Start");
		//	GameStart();
			running = true ;
			timer.start();
			txtword.setEnabled(true);
			btnstart.setText("Pause");
			btnstop.setEnabled(true);
			
		}
		
				
	}

	private void handleStart() {
		
		if(running == false ) {
			running = true ;
			timer.start();
			txtword.setEnabled(true);
			btnstart.setText("Pause");
			btnstop.setEnabled(true);
			
		}else {
			
			running = false ;
			timer.stop();
			txtword.setEnabled(false);
			btnstart.setText("Start");
			btnstop.setEnabled(true);
			
		}
		
	}
	
	
	
	
	
	
}
