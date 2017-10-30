package map;

import max.soko.BoxMap;

public class BoxMap5 extends BoxMap {
	public BoxMap5(){
		super();
	}
	
	@Override
	public void setBox() {
		for (int i = 0; i < boxMap.length; i++) {
			for (int j = 0; j < boxMap[i].length; j++) {
				boxMap[i][j] = walls;
				if ((i == 7 && j == 5) || (i == 7 && j == 6) || (i == 8 && j == 7) || (i == 8 && j == 8)
						|| (i == 9 && j == 4) || (i == 9 && j == 7) || (i == 9 && j == 9) 
						|| (i == 10 && j == 4) || (i == 10 && j == 5) || (i == 10 && j == 6) || (i == 10 && j == 8)
						|| (i == 10 && j == 9) || (i == 11 && j == 8) || (i == 11 && j == 9) ) {
					boxMap[i][j] = field;
				} else if ((i == 8 && j == 6) || (i == 9 && j == 6) || (i == 9 && j == 8)) {
					boxMap[i][j] = box;
				} else if ((i == 8 && j == 4) || (i == 8 && j == 5) || (i == 8 && j == 9)) {
					boxMap[i][j] = boxTargetPosition;
				}
			}
		}
	}
	
	@Override
	public boolean getStop() {
		if (boxMap[8][4] != fullBoxTP || boxMap[8][5] != fullBoxTP || boxMap[8][9] != fullBoxTP) {
			return true;
		} else {
			return false;
		}
	}


}