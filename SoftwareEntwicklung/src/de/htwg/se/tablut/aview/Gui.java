package de.htwg.se.tablut.aview;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Scanner;

import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.dutil.*;
import de.htwg.se.tablut.dutil.Event;


public class Gui extends JFrame implements IObserver {
	
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private Icon angreiferIMG;
	private Icon koenigIMG;
	private Icon verteidigerIMG;
	private Icon burgIMG;
	private ImageIcon rammstein;
	private int state = 0;
	private boolean setByTextUI = false;
	private int xStart;
	private int yStart;
	private int xZiel;
	private int yZiel;
	
	private final JFrame enterGamefield;
		private final JButton size9;
		private final JButton size11;
		private final JButton size13;
		private final JPanel start;
		private final JTextField playTablut;
		private final JLabel picture;
	
	private final JFrame enterPlayername;
		private final JPanel playerNamePanel;
		private final JTextArea whoAttacks;
		private final JTextField attackName;
		private final JTextArea whoDefense;
		private final JTextField defenseName;
		private final JButton goOn;
	
	private final JFrame playTheGame;
		private final JPanel playerInformation;
		private final JTextField playerOne;
		private final JTextField playerTwo;
		private JPanel gamefield;
		private Insets buttonMargin;
		private JButton[][] chessbord;
		private final JPanel info;
		private final JLabel gameinformation;
		private final JPanel main;
		private final String playTablutString = "PLAY TABLUT";
	
	public Gui(Controller c){
		controller = c;
		controller.addObserver(this);
		angreiferIMG = new ImageIcon("Angreifer.jpg");
		verteidigerIMG = new ImageIcon("Verteidiger.jpg");
		koenigIMG = new ImageIcon("Koenig.jpg");
		burgIMG = new ImageIcon("Burg.jpg");
		rammstein = new ImageIcon("rammstein");
		
		enterGamefield = new JFrame("Spielfeld waehlen");
		enterPlayername = new JFrame("Spielernamen eingeben");
		playTheGame = new JFrame("Tablut the Game");
		
		//JFrame
				enterGamefield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				enterGamefield.setPreferredSize(new Dimension(800, 550));
				enterPlayername.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				enterPlayername.setPreferredSize(new Dimension(515, 420));
				playTheGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				playTheGame.setPreferredSize(new Dimension(800, 800));
				GuiMenuBar menuBar = new GuiMenuBar(enterGamefield, enterPlayername, playTheGame);
				
//______________________________________________________________________________________________________________________				
		
		//Panel start
				start = new JPanel(null);
				start.setBackground(Color.ORANGE.darker());
				Dimension size;
				Insets insets = start.getInsets();
				playTablut = new JTextField(playTablutString);
					playTablut.setEditable(false);
					playTablut.setBackground(Color.BLACK);
					playTablut.setForeground(Color.RED);
					playTablut.setFont(new Font("PLAY TABLUT",Font.ITALIC, 110));
					playTablut.setPreferredSize(new Dimension(760, 200));
					size = playTablut.getPreferredSize();
					playTablut.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
				
				size = new Dimension(200, 40);
				picture = new JLabel("bsl");
					picture.setBounds(100 + insets.left, 350, size.width, size.height);
					picture.setIcon(rammstein);
				size9 = new JButton("Tablut 9x9");
					size9.setBounds(390 + insets.left, 250 , size.width, size.height);
				size11 = new JButton("Hnefatafl 11x11");
					size11.setBounds(390 + insets.left, 300 , size.width, size.height);
				size13 = new JButton("Tablut XL 13x13");
					size13.setBounds(390 + insets.left, 350 , size.width, size.height);
				size9.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(controller.getMatrixSize() == 0){
							setButtonField(9);
							controller.setMatrixSize(9);
						}
						enterGamefield.dispose();
						enterPlayername.setJMenuBar(menuBar.getMenuBar());
						enterPlayername.pack();
						enterPlayername.setVisible(true);
					}
				});
				size11.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(controller.getMatrixSize() == 0){
							setButtonField(11);
							controller.setMatrixSize(11);
						}
						enterGamefield.dispose();
						enterPlayername.setJMenuBar(menuBar.getMenuBar());
						enterPlayername.pack();
						enterPlayername.setVisible(true);
					}
				});
				size13.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(controller.getMatrixSize() == 0){
							setButtonField(13);
							controller.setMatrixSize(13);
						}
						enterGamefield.dispose();
						enterPlayername.setJMenuBar(menuBar.getMenuBar());
						enterPlayername.pack();
						enterPlayername.setVisible(true);
					}
				});
				
				start.add(playTablut);
				start.add(picture);
				start.add(size9);
				start.add(size11);
				start.add(size13);
				
				enterGamefield.add(start);
//_______________________________________________________________________________________________________________________
				
		//Panel enterPlayername
				playerNamePanel = new JPanel(null);
				playerNamePanel.setBackground(Color.ORANGE.darker());
				insets = playerNamePanel.getInsets();
				whoAttacks = new JTextArea("Du wagst es deinen Koenig anzugreifen?\nSo nenne deinen Namen");
					whoAttacks.setBackground(Color.BLACK.darker());
					whoAttacks.setForeground(Color.RED.brighter());
					whoAttacks.setEditable(false);
					whoAttacks.setBounds(20, 10, 455, 100);
					whoAttacks.setFont(new Font("",Font.ITALIC, 25));
				attackName = new JTextField("Spieler1");
					attackName.setBackground(Color.BLACK.darker());
					attackName.setForeground(Color.WHITE.brighter());
					attackName.setBounds(20, 120, 200, 50);
					attackName.addFocusListener(new FocusListener() {
						
						@Override
						public void focusLost(FocusEvent e) {
							
						}
						
						@Override
						public void focusGained(FocusEvent e) {
							attackName.selectAll();
							
						}
					});
				whoDefense = new JTextArea("Dein Koenig ist in Gefahr,\nVerteidige ihn!");
					whoDefense.setBackground(Color.BLACK.darker());
					whoDefense.setForeground(Color.RED.brighter());
					whoDefense.setEditable(false);
					whoDefense.setBounds(20, 180, 455, 100);
					whoDefense.setFont(new Font("PLAY TABLUT",Font.ITALIC, 35));
				defenseName = new JTextField("Spieler2");
					defenseName.setBackground(Color.BLACK.darker());
					defenseName.setForeground(Color.WHITE.brighter());
					defenseName.setBounds(20, 290, 200, 50);
					defenseName.addFocusListener(new FocusListener() {
						
						@Override
						public void focusLost(FocusEvent e) {
							
						}
						
						@Override
						public void focusGained(FocusEvent e) {
							defenseName.selectAll();
							
						}
					});
					
				goOn = new JButton("Weiter zum Spiel.");
					goOn.setBounds(330, 290, 150, 50);
				goOn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						enterPlayername.dispose();
						playTheGame.setJMenuBar(menuBar.getMenuBar());
						playTheGame.pack();
						playTheGame.setVisible(true);
						playerOne.setText(attackName.getText()+" ist am Zug!");
						playerTwo.setText(defenseName.getText()+" ist am Zug!");
					}
				});
				
				playerNamePanel.add(whoAttacks);
				playerNamePanel.add(attackName);
				playerNamePanel.add(whoDefense);
				playerNamePanel.add(defenseName);
				playerNamePanel.add(goOn);
				
				enterPlayername.add(playerNamePanel);
				
//_______________________________________________________________________________________________________________________
				
		//Panel playerInformation
				playerInformation = new JPanel();
				Border border2 = BorderFactory.createTitledBorder("Spieler");
				playerInformation.setBorder(border2);
				playerInformation.setLayout(new BorderLayout(1, 2));
						
				playerOne = new JTextField();
					playerOne.setBackground(Color.GREEN);
					playerOne.setEditable(false);
				playerTwo = new JTextField();
					playerTwo.setBackground(Color.WHITE);
					playerTwo.setEditable(false);
							
							
				playerInformation.add(playerOne, BorderLayout.LINE_START);
				playerInformation.add(playerTwo, BorderLayout.LINE_END);
							
		//Panel Info
				info = new JPanel(new GridLayout(1, 1));
				Border border = BorderFactory.createTitledBorder("Zuginformation");
				info.setBorder(border);
					gameinformation = new JLabel("Waehle eine Figur!");
					info.add(gameinformation);
				
		//Panel Main
				main = new JPanel(new BorderLayout(3 , 3));
				main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				main.add(playerInformation, BorderLayout.PAGE_START);
				main.add(info, BorderLayout.PAGE_END);
				playTheGame.add(main);
				
		
		
		enterGamefield.setJMenuBar(menuBar.getMenuBar());
		enterGamefield.pack();
	    enterGamefield.setVisible(true);
	}
	
	public void setButtonField(int fieldSize){
		gamefield = new JPanel(new GridLayout(0, fieldSize));
		buttonMargin = new Insets(0, 0, 0, 0);
		chessbord = new JButton[fieldSize][fieldSize];
		for(int i = 0; i < chessbord.length; i++){
			for(int j = 0; j < chessbord[i].length; j++){
				chessbord[i][j] = new JButton("");
				chessbord[i][j].setMargin(buttonMargin);
				chessbord[i][j].setActionCommand(j+ " " + i);
						
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
				chessbord[i][j].setIcon(icon);
						
				if((j % 2 == 0 || !(i % 2 == 0)) && ((i % 2 == 0 || !(j % 2 == 0)))) {
					chessbord[i][j].setBackground(Color.WHITE);
				} else {
					chessbord[i][j].setBackground(Color.BLACK);
				}
						
				chessbord[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String s = e.getActionCommand();
						Scanner sc = new Scanner(s);
						if(state == 0){
							gameinformation.setText("Wohin soll die Figur laufen?");
							xStart = sc.nextInt();
							yStart = sc.nextInt();
							state = 1;
						} else if(state == 1){
							gameinformation.setText("Waehle eine Figur!");
							xZiel = sc.nextInt();
							yZiel = sc.nextInt();
							state = 0;
							controller.move(xStart, yStart, xZiel, yZiel);
						}
					}
				});
				gamefield.add(chessbord[i][j]);
			}
		}
		main.add(gamefield, BorderLayout.CENTER);
	}
	

	@Override
	public void update(Event e) {
		if(controller.getPlayerTurn()){
			playerOne.setBackground(Color.GREEN);
			playerTwo.setBackground(Color.GRAY);
		}else{
			playerOne.setBackground(Color.GRAY);
			playerTwo.setBackground(Color.GREEN);
		}
		if(!controller.winGameAttack() || !controller.winGame()){
			JOptionPane.showMessageDialog(info, "Gewonnen");
		}
		if(controller.getMatrixSize() != 0 && !setByTextUI){
			setButtonField(controller.getMatrixSize());
			setByTextUI = true;
		}
		for (int i = 0; i < controller.getGamefield().getSizeOfGameField(); i++){
			for (int j = 0; j< controller.getGamefield().getSizeOfGameField(); j++){
				
				if(controller.getGamefield().getField(j, i).toString().trim().equals("X")){
					chessbord[i][j].setIcon(burgIMG);
				} else if(controller.getGamefield().getField(j, i).toString().trim().equals("A")){
					chessbord[i][j].setIcon(angreiferIMG);
				} else if(controller.getGamefield().getField(j, i).toString().trim().equals("K")){
					chessbord[i][j].setIcon(koenigIMG);
				} else if(controller.getGamefield().getField(j, i).toString().trim().equals("D")){
					chessbord[i][j].setIcon(verteidigerIMG);
				} else if(controller.getGamefield().getField(j, i).toString().trim().equals("_")){
					chessbord[i][j].setIcon(null);
				}
			}
		}
	}
}
