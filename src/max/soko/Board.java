package max.soko;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import map.*;

public class Board extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private Map1 map;
	private WarehouseKeeper wKeeper;
	private BoxMap box;
	public int counter = 1;
	private int step = 0;
	protected int pushes = 0;
	

	public Board(Map1 map, BoxMap box, WarehouseKeeper wKeeper, int counter) {
		super();
		this.counter = counter;
		this.box = box;
		this.map = map;
		this.wKeeper = wKeeper;
		
		addKeyListener(new All());
		setFocusable(true);
		timer = new Timer(25, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 15; j++) {
				if (map.getMap(i, j).equals(map.field)) {
					g.drawImage(map.getPath(), i * 40, j * 40, null);
				}
				if (map.getMap(i, j).equals(map.walls)) {
					g.drawImage(map.getWall(), i * 40, j * 40, null);
				}
				if (map.getMap(i, j).equals(map.box)) {
					g.drawImage(map.getBox(), i * 40, j * 40, null);
				}
				if (map.getMap(i, j).equals(map.boxTargetPosition)) {
					g.drawImage(map.getBoxTP(), i * 40, j * 40, null);
				}
				if (box.getBox(i, j).equals(box.box)) {
					g.drawImage(box.getBox(), i * 40, j * 40, null);
				} else if (box.getBox(i, j).equals(box.fullBoxTP)) {
					g.drawImage(box.getFullBoxTP(), i * 40, j * 40, null);
				}

			}
		}
		g.drawImage(wKeeper.getPlayer(), wKeeper.getX() * 40, wKeeper.getY() * 40, null);
		g.setColor(Color.WHITE);
		Font font = new Font("Jokerman",Font.BOLD,30) ;
		g.setFont(font);
		g.drawString("LEVEL: " + counter + "   MOVES: " + step + "   PUSHES: " + pushes + "", 50,550);
	}
	
	
	public void database() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
	   "jdbc:mysql://localhost:3306/SOKOBAN?user=root");
		Statement st= conn.createStatement();
	//	String qq = "SELECT u_id FROM users JOIN achievements ON users.u_id = achievements.users_id WHERE users.login = 'whale'";
	//	ResultSet rs = st.executeQuery(qq);
		String sql = "INSERT INTO ach(a_level, a_moves, a_pushes) VALUES ('"+counter+"', '" + step +"', '"+ pushes+"');";
		st.executeUpdate(sql);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!box.getStop()){
			repaint();
			try {
				database();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(getStep());
			int answer = JOptionPane.showConfirmDialog(null,"Start next round?",null, JOptionPane.YES_NO_CANCEL_OPTION);
			 if (answer == JOptionPane.YES_OPTION){
	                counter++;
			 }else if (answer == JOptionPane.NO_OPTION){
				 	counter = counter;
			 } else if (answer == JOptionPane.CANCEL_OPTION  || counter > 8){
				 timer.stop();
			 }
			getStep();
			setMappp(counter);
		}
		repaint();
		requestFocusInWindow() ;
	}
	
	public int getStep(){
		return step;
	}
	
	public int getPushes(){
		return pushes;
	}

	public void setMappp(int counter) {
		this.counter = counter;
		switch (counter) {
		case 1:
			map = new Map1();
			wKeeper = new WarehouseKeeper(11, 10);
			box = new BoxMap();
			step = 0;
			pushes = 0;
			break;
		case 2:
			map = new Map2();
			wKeeper = new WarehouseKeeper(10, 7);
			box = new BoxMap2();
			step = 0;
			pushes = 0;
			break;
		case 3:
			map = new Map3();
			wKeeper = new WarehouseKeeper(10, 7);
			box = new BoxMap3();
			step = 0;
			pushes = 0;;
			break;
		case 4:
			map = new Map4();
			wKeeper = new WarehouseKeeper(7, 5);
			box = new BoxMap4();
			step = 0;
			pushes = 0;
			break;
		case 5:
			map = new Map5();
			wKeeper = new WarehouseKeeper(4, 10);
			box = new BoxMap5();
			step = 0;
			pushes = 0;
			break;
		case 6:
			map = new Map6();
			wKeeper = new WarehouseKeeper(11, 5);
			box = new BoxMap6();
			step = 0;
			pushes = 0;
			break;
		case 7:
			map = new Map7();
			wKeeper = new WarehouseKeeper(9, 7);
			box  = new BoxMap7();
			step = 0;
			pushes = 0;
			break;
		case 8:
			map = new Map8();
			wKeeper = new WarehouseKeeper(11, 5);
			box  = new BoxMap8();
			step = 0;
			pushes = 0;
			break;
		}

	}
	
	private class All extends KeyAdapter {
		CompareCollision com = new CompareCollision(map, box);

		public void countPushes(){
			if(com.push){
				pushes++;
			}
		}
		
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
			if (keycode == KeyEvent.VK_LEFT) {
				if (box.getBox(wKeeper.getX() - 1, wKeeper.getY()).equals(box.box)
						&& (box.getBox(wKeeper.getX() - 2, wKeeper.getY()).equals(box.walls))) {
					wKeeper.move(0, 0);
				} else if (!map.getMap(wKeeper.getX() - 1, wKeeper.getY()).equals(map.walls)) {
					if (com.getBox(map, box, wKeeper.getX() - 1, wKeeper.getY(), "LC")) {
						wKeeper.move(-1, 0);
						step++;
						countPushes();
					} else {
						wKeeper.move(0, 0);
					}
				}
			} else if (keycode == KeyEvent.VK_RIGHT) {
				if (box.getBox(wKeeper.getX() + 1, wKeeper.getY()).equals(box.box)
						&& (box.getBox(wKeeper.getX() + 2, wKeeper.getY()).equals(box.walls))) {
					wKeeper.move(0, 0);
				} else if (!map.getMap(wKeeper.getX() + 1, wKeeper.getY()).equals(map.walls)) {
					if (com.getBox(map, box, wKeeper.getX() + 1, wKeeper.getY(), "RC")) {
						wKeeper.move(1, 0);
						step++;
						countPushes();
					} else {
						wKeeper.move(0, 0);
					}
				}
			} else if (keycode == KeyEvent.VK_UP) {
				if (box.getBox(wKeeper.getX(), wKeeper.getY()-1).equals(box.box)
						&& (box.getBox(wKeeper.getX(), wKeeper.getY()-2).equals(box.walls))) {
					wKeeper.move(0, 0);
				} else if (!map.getMap(wKeeper.getX(), wKeeper.getY()-1).equals(map.walls)) {
					if (com.getBox(map, box, wKeeper.getX(), (wKeeper.getY()-1), "UC")) {
						wKeeper.move(0, -1);
						step++;
						countPushes();
					} else {
						wKeeper.move(0, 0);
					}
				}
			} else if (keycode == KeyEvent.VK_DOWN) {
				if (box.getBox(wKeeper.getX(), wKeeper.getY() + 1).equals(box.box)
						&& (box.getBox(wKeeper.getX(), wKeeper.getY() + 2).equals(box.walls))) {
					wKeeper.move(0, 0);
				} else if (!map.getMap(wKeeper.getX(), wKeeper.getY() + 1).equals(map.walls)) {
					if (com.getBox(map, box, wKeeper.getX(), wKeeper.getY() + 1, "DC")) {
						wKeeper.move(0, 1);
						step++;
						countPushes();
					} else {
						wKeeper.move(0, 0);
					}
				}
			} 

		}

		public void keyReleased(KeyEvent e) {
			int keycode = e.getKeyCode();
			if (keycode == KeyEvent.VK_LEFT) {
				wKeeper.move(0, 0);
			} else if (keycode == KeyEvent.VK_RIGHT) {
				wKeeper.move(0, 0);
			} else if (keycode == KeyEvent.VK_UP) {
				wKeeper.move(0, 0);
			} else if (keycode == KeyEvent.VK_DOWN) {
				wKeeper.move(0, 0);
			}
		}
	}
}
