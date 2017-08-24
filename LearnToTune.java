import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;



public class LearnToTune {

	private JFrame frame;
	private JTextField answerField;
	static File explosion = new File("sounds/explosion.wav");
	private final Action action = new SwingAction();
	private String[] arr = new String[5];
	private int index; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LearnToTune window = new LearnToTune();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
	}
	
	static void playSound(File sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		} catch (Exception e){
			System.err.print("hello");
		}
	}
	
	

	/**
	 * Create the application.
	 */
	public LearnToTune() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 280, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox chooseBox = new JComboBox();
		chooseBox.setBounds(139, 4, 99, 61);
		frame.getContentPane().add(chooseBox);
		chooseBox.addItem("LowE");
		chooseBox.addItem("A");
		chooseBox.addItem("D");
		chooseBox.addItem("G");
		chooseBox.addItem("B");
		chooseBox.addItem("HighE");
		
		JLabel chooseText = new JLabel("Choose String:");
		chooseText.setBounds(36, 25, 99, 16);
		frame.getContentPane().add(chooseText);
		
		JButton playString = new JButton("Play String");
		playString.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String soundVal = (String)chooseBox.getSelectedItem();
				//File explosion = new File("sounds/explosion.wav");
				String temp = "sounds/";
				temp += soundVal;
				temp += ".wav";
				File chosenString = new File(temp);
				playSound(chosenString);
			}
		});

		playString.setBounds(78, 53, 117, 29);
		frame.getContentPane().add(playString);
		
		JButton btnNewButton = new JButton("Higher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index == 4){
					index = 0;
					String temp = arr[index];
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					System.out.println(finalProd);
				}
				else{
					index++;
					String temp = arr[index];
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					System.out.println(finalProd);
				}
			}
		});
		btnNewButton.setBounds(145, 130, 93, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lower");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index == 0){
					index = 4;
					String temp = arr[index];
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
				}
				else{
					index--;
					String temp = arr[index];
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
				}
			}
		});
		btnNewButton_1.setBounds(36, 130, 93, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//change if more sound bytes added
				if(index == 2){
					answerField.setText("Correct");
				}
				else{
					answerField.setText("Wrong");
				}
			}
		});
		btnSubmit.setBounds(91, 161, 88, 29);
		frame.getContentPane().add(btnSubmit);
		
		answerField = new JTextField();
		answerField.setBounds(78, 202, 117, 28);
		frame.getContentPane().add(answerField);
		answerField.setColumns(10);
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String soundVal = (String)chooseBox.getSelectedItem();
				if(soundVal.equals("LowE")){
					arr[0]="LowE1.wav";
					arr[1]="LowE2.wav";
					arr[2]="LowE.wav";
					arr[3]="LowE3.wav";
					arr[4]="LowE4.wav";
					int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
					String temp = "LowE";
					temp += randomNum;
					temp += ".wav";
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					index = Arrays.asList(arr).indexOf(temp);
				}
				else if (soundVal.equals("A")){
					arr[0]="A1.wav";
					arr[1]="A2.wav";
					arr[2]="A.wav";
					arr[3]="A3.wav";
					arr[4]="A4.wav";
					int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
					String temp = "A";
					temp += randomNum;
					temp += ".wav";
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					index = Arrays.asList(arr).indexOf(temp);
				}
				else if (soundVal.equals("D")){
					arr[0]="D1.wav";
					arr[1]="D2.wav";
					arr[2]="D.wav";
					arr[3]="D3.wav";
					arr[4]="D4.wav";
					int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
					String temp = "D";
					temp += randomNum;
					temp += ".wav";
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					index = Arrays.asList(arr).indexOf(temp);
				}
				else if (soundVal.equals("G")){
					arr[0]="G1.wav";
					arr[1]="G2.wav";
					arr[2]="G.wav";
					arr[3]="G3.wav";
					arr[4]="G4.wav";
					int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
					String temp = "G";
					temp += randomNum;
					temp += ".wav";
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					index = Arrays.asList(arr).indexOf(temp);
				}
				else if (soundVal.equals("B")){
					arr[0]="B1.wav";
					arr[1]="B2.wav";
					arr[2]="B.wav";
					arr[3]="B3.wav";
					arr[4]="B4.wav";
					int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
					String temp = "B";
					temp += randomNum;
					temp += ".wav";
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					index = Arrays.asList(arr).indexOf(temp);
				}
				else{
					arr[0]="HighE1.wav";
					arr[1]="HighE2.wav";
					arr[2]="HighE.wav";
					arr[3]="HighE3.wav";
					arr[4]="HighE4.wav";
					int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
					String temp = "HighE";
					temp += randomNum;
					temp += ".wav";
					String finalProd = "sounds/";
					finalProd += temp;
					File path = new File(finalProd);
					playSound(path);
					index = Arrays.asList(arr).indexOf(temp);
				}
			}
		});
		start.setBounds(36, 89, 93, 29);
		frame.getContentPane().add(start);
		
		JButton btnNewButton_2 = new JButton("Replay");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String finalProd = "sounds/";
				finalProd += arr[index];
				File path = new File(finalProd);
				playSound(path);
			}
		});
		btnNewButton_2.setBounds(144, 89, 93, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("tuneHelp.txt");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        System.out.println("no application registered for PDFs");
				    }
				}
			}
		});
		button.setBounds(252, 244, 22, 16);
		frame.getContentPane().add(button);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
