package max.soko;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Authorization {
	
	public static final int SCALE = 20;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 15;

	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	public Menu menu;
	
	public ImageIcon img = new ImageIcon("img/soko.png");
	public JLabel fo = new JLabel();

	public JPanel panel = new JPanel();
	public JFrame f = new JFrame("SOKOBAN MAKSYM OLIINYK");
	public JLabel login = new JLabel("User name: ");
	JLabel password = new JLabel("Password: ");
	JTextField log = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);
	JButton b = new JButton("Login");
	JButton create = new JButton("Create");

	public Authorization(Menu menu) {
		this.menu=menu;
		connect();
		frame();
	}

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SOKOBAN?user=root");
			st = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void frame() {
		panel.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		f.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		JPanel panel = new JPanel();
		panel.add(login);
		login.setSize(100, 30);
		login.setLocation(40, 38);
		panel.add(log);
		log.setSize(200, 30);
		log.setLocation(140, 38);
		panel.add(password);
		password.setSize(100, 30);
		password.setLocation(40, 76);
		panel.add(pass);
		pass.setSize(200, 30);
		pass.setLocation(140, 76);
		panel.add(b);
		b.setSize(150, 40);
		b.setLocation(125, 140);
		panel.add(create);
		create.setSize(150, 40);
		create.setLocation(125,190);
		panel.setLayout(null);

		fo.setIcon(img);
		fo.setSize(400, 400);
		fo.setLocation(2, -50);
		panel.add(fo);
		
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String user = log.getText().trim();
					@SuppressWarnings("deprecation")
					String pas = pass.getText().trim();
					String sql = "INSERT INTO users (login, password,timestamp,datestamp)" + " VALUES ('" + user + "','" + pas + "', NOW(),NOW());";

					String qq = "SELECT login, password FROM users WHERE login = '" + user + "' and password = '" + pas
							+ "'";
					rs = st.executeQuery(qq);
					try {
						if (rs.next() == false) {
							st.executeUpdate(sql);
							JOptionPane.showMessageDialog(panel, "New user have been created!");
						} else {
							JOptionPane.showMessageDialog(panel, "Duplicate user!");
						}
					} catch (HeadlessException | SQLException z) {
						z.printStackTrace();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

		});

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user = log.getText().trim();
					@SuppressWarnings("deprecation")
					String pas = pass.getText().trim();
					String sql = "SELECT login, password FROM users WHERE login = '" + user + "' and password = '" + pas
							+ "'";
					rs = st.executeQuery(sql);

					try {
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(panel, "Invalid Username Or Password !");
						} else {
							JOptionPane.showMessageDialog(panel, "Users Found, Access Granted");
							menu.setVisible(true);
							f.setVisible(false);
							rs.close();
							st.close();
							con.close();
						}
					} catch (HeadlessException | SQLException z) {
						z.printStackTrace();
					}
				} catch (Exception ex) {

				}
			}
		});
		f.add(panel);
	}
}