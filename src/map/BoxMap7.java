package map;

import max.soko.BoxMap;

public class BoxMap7 extends BoxMap{
	public BoxMap7(){
		super();
	}
	
	@Override
	public void setBox() {
		for (int i = 0; i < boxMap.length; i++) {
			for (int j = 0; j < boxMap[i].length; j++) {
				boxMap[i][j] = walls;
				if ((i == 2 && j == 2) || (i == 2 && j == 3)|| (i == 2 && j == 4) 
						|| (i == 3 && j == 2) || (i == 3 && j == 4) || (i == 3 && j == 6) 
						|| (i == 3 && j == 8) || (i == 4 && j == 4) || (i == 4 && j == 6) || (i == 4 && j == 8)
						|| (i == 5 && j == 4) || (i == 5 && j == 6) || (i == 5 && j == 7) || (i == 5 && j == 8)
						|| (i == 6 && j == 4) || (i == 6 && j == 8) || (i == 7 && j == 3) || (i == 7 && j == 9)
						|| (i == 8 && j == 3) || (i == 8 && j == 5) || (i == 8 && j == 7) || (i == 8 && j == 8)
						|| (i == 9 && j == 3) || (i == 9 && j == 7) || (i == 10 && j == 3) || (i == 10 && j == 4)
						|| (i == 10 && j == 5) || (i == 10 && j == 6) || (i == 10 && j == 7)) {
					boxMap[i][j] = field;
				} else if ((i == 3 && j == 3) || (i == 3 && j == 5) || (i == 3 && j == 7)|| (i == 8 && j == 4)
						|| (i == 8 && j == 6)) {
					boxMap[i][j] = box;
				} else if ((i == 7 && j == 4) || (i == 7 && j == 5) || (i ==7 && j == 6)|| (i ==7 && j == 7)
						|| (i ==7 && j == 8)) {
					boxMap[i][j] = boxTargetPosition;
				}
			}
		}
	}
	
	@Override
	public boolean getStop() {
		if (boxMap[7][4] != fullBoxTP || boxMap[7][5] != fullBoxTP || boxMap[7][6] != fullBoxTP|| boxMap[7][7] != fullBoxTP
				|| boxMap[7][8] != fullBoxTP) {
			return true;
		} else {
			return false;
		}
	}


}
