package map;

import max.soko.Map1;

public class Map4 extends Map1{
	@Override
	public void setMap() {
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				map1[i][j] = walls;
				if ((i == 5 && j == 7) || (i == 5 && j == 8) || (i == 5 && j == 9) || (i == 6 && j == 10)
						|| (i == 7 && j == 8) || (i == 7 && j == 10) || (i == 8 && j == 7) || (i == 8 && j == 8)
						|| (i == 8 && j == 10)) {
					map1[i][j] = field;
				} else if ((i == 6 && j == 7) || (i == 6 && j == 8) || (i == 6 && j == 9)) {
					map1[i][j] = field;
				} else if ((i == 7 && j == 7) || (i == 8 && j == 9) || (i == 5 && j == 10)) {
					map1[i][j] = boxTargetPosition;
				}
			}
		}
	}

}
