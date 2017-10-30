package map;

import max.soko.BoxMap;

public class BoxMap2 extends BoxMap {
	
	public BoxMap2(){
		super();
	}
	
	@Override
	public void setBox() {
		for (int i = 0; i < boxMap.length; i++) {
			for (int j = 0; j < boxMap[i].length; j++) {
				boxMap[i][j] = walls;
				if ((i == 4 && j == 6) || (i == 4 && j == 7) || (i == 4 && j == 9) || (i == 4 && j == 10)
						|| (i == 4 && j == 11) || (i == 4 && j == 12) || (i == 4 && j == 13) || (i == 5 && j == 6)
						|| (i == 5 && j == 7) || (i == 5 && j == 9) || (i == 5 && j == 11) || (i == 5 && j == 12)
						|| (i == 5 && j == 14) || (i == 5 && j == 15) || (i == 6 && j == 6) || (i == 6 && j == 7)
						|| (i == 6 && j == 14) || (i == 6 && j == 15) || (i == 7 && j == 6) || (i == 7 && j == 7)
						|| (i == 7 && j == 8) || (i == 7 && j == 9) || (i == 7 && j == 10) || (i == 7 && j == 11)
						|| (i == 7 && j == 14) || (i == 7 && j == 15) || (i == 8 && j == 6) || (i == 8 && j == 7)
						|| (i == 8 && j == 9) || (i == 8 && j == 11) || (i == 8 && j == 12) || (i == 8 && j == 14)
						|| (i == 9 && j == 9) || (i == 9 && j == 13) || (i == 9 && j == 15) || (i == 10 && j == 6)
						|| (i == 10 && j == 8) || (i == 10 && j == 9) || (i == 10 && j == 11) || (i == 10 && j == 13)
						|| (i == 10 && j == 15) || (i == 11 && j == 6) || (i == 11 && j == 7) || (i == 11 && j == 8)
						|| (i == 11 && j == 9) || (i == 11 && j == 11) || (i == 11 && j == 12) || (i == 11 && j == 13)
						|| (i == 11 && j == 14) || (i == 11 && j == 15)) {
					boxMap[i][j] = field;
				} else if ((i == 5 && j == 10) || (i == 5 && j == 13) || (i == 6 && j == 9) || (i == 8 && j == 13)
						|| (i == 9 && j == 12) || (i == 9 && j == 14) || (i == 10 && j == 7) || (i == 10 && j == 10)
						|| (i == 10 && j == 12) || (i == 10 && j == 14)) {
					boxMap[i][j] = box;
				} else if ((i == 4 && j == 4) || (i == 4 && j == 5) || (i == 5 && j == 4) || (i == 5 && j == 5)
						|| (i == 6 && j == 4) || (i == 6 && j == 5) || (i == 7 && j == 4) || (i == 7 && j == 5)
						|| (i == 8 && j == 4) || (i == 8 && j == 5)) {
					boxMap[i][j] = boxTargetPosition;
				}
			}
		}
	}
	
	@Override
	public boolean getStop() {
		if (boxMap[4][4] != fullBoxTP || boxMap[4][5] != fullBoxTP || boxMap[5][4] != fullBoxTP || boxMap[5][5] != fullBoxTP
				|| boxMap[6][4] != fullBoxTP || boxMap[6][5] != fullBoxTP|| boxMap[7][4] != fullBoxTP || boxMap[7][5] != fullBoxTP
				|| boxMap[8][4] != fullBoxTP || boxMap[8][5] != fullBoxTP) {
			return true;
		} else {
			return false;
		}
	}


}
