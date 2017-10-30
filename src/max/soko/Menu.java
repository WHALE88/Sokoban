package max.soko;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import map.*;

public class Menu extends JFrame {

	private static final long serialVersionUID = 3L;
	int counter = 1;
	public static final int SCALE = 41;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 15;
	private JButton butMap1;
	private JButton butMap2;
	private JButton butMap3;
	private JButton butMap4;
	private JButton butMap5;
	private JButton butMap6;
	private JButton butMap7;
	private JButton butMap8;
	protected JPanel levelsGrid;

	JMenuBar menuBar ;
	JMenu menu1 ;
	JMenuItem menuItem1 ;
	JMenuItem exit;
	

	private Map1 map;
	private WarehouseKeeper wKeeper;
	private BoxMap bomap;
	private Board board;

	Menu(Map1 map, BoxMap bomap, WarehouseKeeper wKeeper, int counter) {
		this.bomap = bomap;
		this.counter = counter;
		this.map = map;
		this.wKeeper = wKeeper;
		
		menuBar = new JMenuBar();
		menu1 = new JMenu("Menu");
		menuItem1 = new JMenuItem("SELECT MAP");
		exit = new JMenuItem("EXIT");

		levelsGrid = new JPanel();

		butMap1 = new JButton("1");
		butMap1.setSize(150, 150);
		butMap1.setLocation(80, 150);
		butMap1.setBackground(new Color(255, 102, 102));

		butMap2 = new JButton("2");
		butMap2.setSize(150, 150);
		butMap2.setLocation(240, 150);
		butMap2.setBackground(new Color(255, 102, 102));

		butMap3 = new JButton("3");
		butMap3.setSize(150, 150);
		butMap3.setLocation(400, 150);
		butMap3.setBackground(new Color(255, 102, 102));

		butMap4 = new JButton("4");
		butMap4.setSize(150, 150);
		butMap4.setLocation(560, 150);
		butMap4.setBackground(new Color(255, 102, 102));

		butMap5 = new JButton("5");
		butMap5.setSize(150, 150);
		butMap5.setLocation(80, 320);
		butMap5.setBackground(new Color(255, 102, 102));

		butMap6 = new JButton("6");
		butMap6.setSize(150, 150);
		butMap6.setLocation(240, 320);
		butMap6.setBackground(new Color(255, 102, 102));

		butMap7 = new JButton("7");
		butMap7.setSize(150, 150);
		butMap7.setLocation(400, 320);
		butMap7.setBackground(new Color(255, 102, 102));

		butMap8 = new JButton("8");
		butMap8.setSize(150, 150);
		butMap8.setLocation(560, 320);
		butMap8.setBackground(new Color(255, 102, 102));

		levelsGrid.setLayout(null);
		// levelsGrid.setLayout(new GridLayout(4,4,0,0));
		levelsGrid.add(butMap1);
		levelsGrid.add(butMap2);
		levelsGrid.add(butMap3);
		levelsGrid.add(butMap4);
		levelsGrid.add(butMap5);
		levelsGrid.add(butMap6);
		levelsGrid.add(butMap7);
		levelsGrid.add(butMap8);
		
		menu1.add(menuItem1);
		menu1.addSeparator();
		menu1.add(exit);
		menuBar.add(menu1);

		levelsGrid.setBackground(new Color(0, 255, 255));
		setContentPane(levelsGrid);
		setJMenuBar(menuBar);
		setTitle("SOKOBAN_MAKSYM OLIINYK v.1.0.1");
		setSize(WIDTH * SCALE - 15, HEIGHT * SCALE + 15);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initListeners();
	}
	

	private void initListeners() {
		menuItem1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(levelsGrid);
				board.setVisible(false);
				levelsGrid.setVisible(true);
				
			}
			
		});
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		butMap1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(1);

			}
		});
		butMap2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(2);
			}
		});
		butMap3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(3);
			}
		});
		butMap4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(4);
			}
		});
		butMap5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(5);
			}
		});
		butMap6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(6);
			}
		});
		butMap7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(7);
			}
		});
		butMap8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				toMap(8);
			}
		});
	}

	public void toMap(int counter) {
		this.counter = counter;
		setMappp(counter);
		board = new Board(map, bomap, wKeeper, counter);
		levelsGrid.setVisible(false);
		setContentPane(board);
		board.setVisible(true);

	}

	public void setMappp(int counter) {
		this.counter = counter;
		switch (counter) {
		case 1:
			map = new Map1();
			wKeeper = new WarehouseKeeper(11, 10);
			bomap = new BoxMap();
			break;
		case 2:
			map = new Map2();
			wKeeper = new WarehouseKeeper(10, 7);
			bomap = new BoxMap2();
			break;
		case 3:
			map = new Map3();
			wKeeper = new WarehouseKeeper(10, 7);
			bomap = new BoxMap3();
			break;
		case 4:
			map = new Map4();
			wKeeper = new WarehouseKeeper(7, 5);
			bomap = new BoxMap4();
			break;
		case 5:
			map = new Map5();
			wKeeper = new WarehouseKeeper(4, 10);
			bomap = new BoxMap5();
			break;
		case 6:
			map = new Map6();
			wKeeper = new WarehouseKeeper(11, 5);
			bomap = new BoxMap6();
			break;
		case 7:
			map = new Map7();
			wKeeper = new WarehouseKeeper(9, 7);
			bomap = new BoxMap7();
			break;
		case 8:
			map = new Map8();
			wKeeper = new WarehouseKeeper(14, 8);
			bomap = new BoxMap8();
			break;
		}

	}

}