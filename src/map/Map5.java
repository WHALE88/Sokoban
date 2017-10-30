package map;

import max.soko.Map1;

public class Map5 extends Map1 {
	@Override
	public void setMap() {
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				map1[i][j] = walls;
				if ((i == 7 && j == 5) || (i == 7 && j == 6) || (i == 8 && j == 7) || (i == 8 && j == 8)
						|| (i == 9 && j == 4) || (i == 9 && j == 7) || (i == 9 && j == 9) 
						|| (i == 10 && j == 4) || (i == 10 && j == 5) || (i == 10 && j == 6) || (i == 10 && j == 8)
						|| (i == 10 && j == 9) || (i == 11 && j == 8) || (i == 11 && j == 9) ) {
					map1[i][j] = field;
				} else if ((i == 8 && j == 6) || (i == 9 && j == 6) || (i == 9 && j == 8)) {
					map1[i][j] = field;
				} else if ((i == 8 && j == 4) || (i == 8 && j == 5) || (i == 8 && j == 9)) {
					map1[i][j] = boxTargetPosition;
				}
			}
		}
	}

}