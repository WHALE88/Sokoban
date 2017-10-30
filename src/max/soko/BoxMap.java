package max.soko;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BoxMap {
	public static final int SCALE = 20;
	public static final int WIDTH = 40;
	public static final int HEIGHT = 40;

	private Image boxes;
	private Image fBoxTP;

	protected String[][] boxMap = new String[15][20];
	protected String box;
	protected String field;
	protected String boxTargetPosition;
	protected String walls;
	protected String fullBoxTP;
	
	public Image getBox() {
		return boxes;
	}
	public Image getFullBoxTP() {
		return fBoxTP;
	}


	public BoxMap() {
		field = " "; 
		box = "\u00A4"; 
		boxTargetPosition = "*"; 
		walls = "#";
		fullBoxTP = "$"; 
		

		setBox();
		ImageIcon img = new ImageIcon("img/box.png");
		boxes = img.getImage();
		img = new ImageIcon("img/fullBoxT.png");
		fBoxTP = img.getImage();
	
	}

	public void setBox() {
		for (int i = 0; i < boxMap.length; i++) {
			for (int j = 0; j < boxMap[i].length; j++) {
				boxMap[i][j] = walls;
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
					boxMap[i][j] = field;
				} else if ((i == 4 && j == 5) || (i == 5 && j == 7) || (i == 6 && j == 5) || (i == 6 && j == 7)
						|| (i == 9 && j == 2) || (i == 9 && j == 5)) {
					boxMap[i][j] = box;
				} else if ((i == 8 && j == 16) || (i == 8 && j == 17) || (i == 9 && j == 16) || (i == 9 && j == 17)
						|| (i == 10 && j == 16) || (i == 10 && j == 17)) {
					boxMap[i][j] = boxTargetPosition;
				}
			}
		}
	}
	
	public boolean getStop() {
		if (boxMap[8][16] != fullBoxTP || boxMap[8][17] != fullBoxTP || boxMap[9][16] != fullBoxTP || boxMap[9][17] != fullBoxTP
				|| boxMap[10][16] != fullBoxTP || boxMap[10][17] != fullBoxTP) {
			return true;
		} else {
			return false;
		}
	}
	

	public String getBox(int x, int y) {
		String index = boxMap[y][x];
		return index;
	}

	protected String[][] getMap() {
		return boxMap;
	}

}
