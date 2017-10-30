package map;

import max.soko.Map1;

public class Map8 extends Map1  {
	@Override
	public void setMap() {
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				map1[i][j] = walls;
				if ((i == 5 && j == 8) || (i == 5 && j == 9)|| (i == 5 && j == 10) 
						|| (i == 7 && j == 6) || (i == 7 && j == 7) || (i == 7 && j == 8) 
						|| (i == 7 && j == 10) || (i == 7 && j == 12) || (i == 7 && j == 13) || (i == 7 && j == 14)
						|| (i == 8 && j == 6) || (i == 8 && j == 12) || (i == 8 && j == 13) || (i == 8 && j == 14)
						|| (i == 9 && j == 6) || (i == 9 && j == 7) || (i == 9 && j == 8) || (i == 9 && j == 10)
						|| (i == 10 && j == 8) || (i == 10 && j == 10) || (i == 11 && j == 8) || (i == 11 && j == 9)
						|| (i == 11 && j == 10)) {
					map1[i][j] = field;
				} else if ((i == 6 && j == 8) || (i == 6 && j == 10) || (i == 7 && j == 11)|| (i == 8 && j == 9)) {
					map1[i][j] = field;
				} else if ((i == 6 && j == 9) || (i == 7  && j == 9) || (i ==9 && j == 9)|| (i ==10 && j == 9)) {
					map1[i][j] = boxTargetPosition;
				}
			}
		}
	}
}
