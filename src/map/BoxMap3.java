package map;

import max.soko.BoxMap;

public class BoxMap3 extends BoxMap {
	public BoxMap3(){
		super();
	}
	
	@Override
	public void setBox() {
		
		for (int i = 0; i < boxMap.length; i++) {
			for (int j = 0; j < boxMap[i].length; j++) {
				boxMap[i][j] = walls;
				if ((i == 5 && j == 7) || (i == 5 && j == 8) || (i == 6 && j == 7) || (i == 6 && j == 8)
						|| (i == 6 && j == 9) || (i == 7 && j == 8) || (i == 7 && j == 10) 
						|| (i == 8 && j == 8) || (i == 8 && j == 11) || (i == 9 && j == 7) || (i == 9 && j == 8)
						|| (i == 9 && j == 10)) {
					boxMap[i][j] = field;
				} else if ((i == 7 && j == 7) || (i == 7 && j == 9) || (i == 8 && j == 10)) {
					boxMap[i][j] = box;
				} else if ((i == 8 && j == 7) || (i == 9 && j == 9) || (i == 9 && j == 11)) {
					boxMap[i][j] = boxTargetPosition;
				}
			}
		}
	}
	
	@Override
	public boolean getStop() {
		if (boxMap[8][7] != fullBoxTP || boxMap[9][9] != fullBoxTP || boxMap[9][11] != fullBoxTP) {
			return true;
		} else {
			return false;
		}
	}


}