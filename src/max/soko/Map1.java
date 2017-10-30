package max.soko;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Map1 {

	public static final int SCALE = 20;
	public static final int WIDTH = 40;
	public static final int HEIGHT = 40;

	private Image wall;
	private Image path;
	private Image boxTP;
	private Image boxes;

	protected String[][] map1 = new String[15][20];
	protected String box;
	protected String field;
	protected String boxTargetPosition;
	protected String walls;
	protected String fullBoxTP;
	
	

	public Image getPath() {
		return path;
	}

	public Image getWall() {
		return wall;
	}

	public Image getBox() {
		return boxes;
	}

	public Image getBoxTP() {
		return boxTP;
	}

	public Map1() {
		field = " "; 
		box = "\u00A4"; // символ ящика: u00A4(круг), u07DB(квадрат)
		boxTargetPosition = "*"; // символ позиции куда нужно разместить ящик
		walls = "#"; // символ отображения стен
		fullBoxTP = "$"; // символ, когда ящик находится на нужной позиции; 
		

		setMap();
		ImageIcon img = new ImageIcon("img/wall.png");
		wall = img.getImage();
		img = new ImageIcon("img/field.png");
		path = img.getImage();
		img = new ImageIcon("img/box.png");
		boxes = img.getImage();
		img = new ImageIcon("img/boxTarget.png");
		boxTP = img.getImage();
	}

	public void setMap() {
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				map1[i][j] = walls;
				if ((i == 3 && j == 5) || (i == 3 && j == 6) || (i == 3 && j == 7) || (i == 4 && j == 6)
						|| (i == 4 && j == 7) || (i == 5 && j == 5) || (i == 5 && j == 6) || (i == 6 && j == 3)
						|| (i == 6 && j == 4) || (i == 6 && j == 6) || (i == 6 && j == 8) || (i == 7 && j == 3)
						|| (i == 7 && j == 5) || (i == 7 && j == 8) || (i == 8 && j == 1) || (i == 8 && j == 2)
						|| (i == 8 && j == 3) || (i == 8 && j == 5) || (i == 8 && j == 8) || (i == 8 && j == 14)
						|| (i == 8 && j == 15) || (i == 9 && j == 1) || (i == 9 && j == 3) || (i == 9 && j == 4)
						|| (i == 9 && j == 6) || (i == 9 && j == 7) || (i == 9 && j == 8) || (i == 9 && j == 9)
						|| (i == 9 && j == 10) || (i == 9 && j == 11) || (i == 9 && j == 12) || (i == 9 && j == 13)
						|| (i == 9 && j == 14) || (i == 9 && j == 15) || (i == 10 && j == 5) || (i == 10 && j == 9)
						|| (i == 10 && j == 11) || (i == 10 && j == 14) || (i == 10 && j == 15) || (i == 11 && j == 5)
						|| (i == 11 && j == 6) || (i == 11 && j == 7) || (i == 11 && j == 8) || (i == 11 && j == 9)) {
					map1[i][j] = field;
				} else if ((i == 4 && j == 5) || (i == 5 && j == 7) || (i == 6 && j == 5) || (i == 6 && j == 7)
						|| (i == 9 && j == 2) || (i == 9 && j == 5)) {
					map1[i][j] = field;
				} else if ((i == 8 && j == 16) || (i == 8 && j == 17) || (i == 9 && j == 16) || (i == 9 && j == 17)
						|| (i == 10 && j == 16) || (i == 10 && j == 17)) {
					map1[i][j] = boxTargetPosition;
				}
			}
		}
	}
	

	public String getMap(int x, int y) {
		String index = map1[y][x];
		return index;
	}

	protected String[][] getMap() {
		return map1;
	}

}
