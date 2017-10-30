package map;

import max.soko.BoxMap;

public class BoxMap8 extends BoxMap {
	public BoxMap8(){
		super();
	}
	
	@Override
	public void setBox() {
		for (int i = 0; i < boxMap.length; i++) {
			for (int j = 0; j < boxMap[i].length; j++) {
				boxMap[i][j] = walls;
				if ((i == 5 && j == 8) || (i == 5 && j == 9)|| (i == 5 && j == 10) 
						|| (i == 7 && j == 6) || (i == 7 && j == 7) || (i == 7 && j == 8) 
						|| (i == 7 && j == 10) || (i == 7 && j == 12) || (i == 7 && j == 13) || (i == 7 && j == 14)
						|| (i == 8 && j == 6) || (i == 8 && j == 12) || (i == 8 && j == 13) || (i == 8 && j == 14)
						|| (i == 9 && j == 6) || (i == 9 && j == 7) || (i == 9 && j == 8) || (i == 9 && j == 10)
						|| (i == 10 && j == 8) || (i == 10 && j == 10) || (i == 11 && j == 8) || (i == 11 && j == 9)
						|| (i == 11 && j == 10)) {
					boxMap[i][j] = field;
				} else if ((i == 6 && j == 8) || (i == 6 && j == 10) || (i == 7 && j == 11)|| (i == 8 && j == 9)) {
					boxMap[i][j] = box;
				} else if ((i == 6 && j == 9) || (i == 7  && j == 9) || (i ==9 && j == 9)|| (i ==10 && j == 9)) {
					boxMap[i][j] = boxTargetPosition;
				}
			}
		}
	}
	
	@Override
	public boolean getStop() {
		if (boxMap[6][9] != fullBoxTP || boxMap[7][9] != fullBoxTP || boxMap[9][9] != fullBoxTP|| boxMap[10][9] != fullBoxTP){
			return true;
		} else {
			return false;
		}
	}


}
