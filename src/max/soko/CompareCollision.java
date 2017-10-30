package max.soko;

public class CompareCollision {
	protected String[][] prototypeOfMap = new String[15][20];
	protected BoxMap box = new BoxMap();
	protected Map1 map = new Map1();
	
	protected int i;
	protected int j;
	private int i1;
	private int j1;
	public String collision;
	
	boolean push = false;
	
	CompareCollision(Map1 map, BoxMap box) {
		this.map = map;
		this.box = box;
		prototypeOfMap = box.getMap();
	}
	
	
	public boolean getBox(Map1 map, BoxMap box, int i, int j, String collision) {
		prototypeOfMap = box.getMap();
		this.collision = collision;
		this.map = map;
		this.box = box;
		this.i = i;
		this.j = j;
		switch(collision){
		case "LC": 
			i1 = i-1;
			j1 = j;
			break;
		case "RC": 
			i1 = i+1;
			j1 = j;
			break;
		case "UC": 
			i1 = i;
			j1 = j-1;
			break;
		case "DC": 
			i1 = i;
			j1 = j+1;
			break;
		}

		if (map.getMap(i, j).equals(map.field) && box.getBox(i, j).equals(box.field)
				|| (map.getMap(i, j).equals(map.boxTargetPosition) && box.getBox(i, j).equals(box.boxTargetPosition))) {
			push = false;
			return true;
		}else if( box.getBox(i, j).equals(box.fullBoxTP) && map.getMap(i1, j1).equals(map.boxTargetPosition)
				&& !box.getBox(i1, j1).equals(box.fullBoxTP)){
			prototypeOfMap[j][i] = box.boxTargetPosition;
			prototypeOfMap[j1][i1] = box.fullBoxTP;
			push = true;
			return true;
		}else if( box.getBox(i, j).equals(box.fullBoxTP) && map.getMap(i1, j1).equals(map.field)
				&& !box.getBox(i1, j1).equals(box.box)){
			prototypeOfMap[j][i] = box.boxTargetPosition;
			prototypeOfMap[j1][i1] = box.box;
			push = true;
			return true;
		} else if (map.getMap(i1, j1).equals(map.boxTargetPosition)
				&& box.getBox(i1, j1).equals(box.boxTargetPosition)){
				if((map.getMap(i, j).equals(map.field))){
			prototypeOfMap[j][i] = box.field;
			prototypeOfMap[j1][i1] = box.fullBoxTP;
			push = true;
			return true;
				} else if(map.getMap(i, j).equals(map.boxTargetPosition)
				&& box.getBox(i, j).equals(box.boxTargetPosition) && !box.getBox(i1, j1).equals(box.boxTargetPosition)){
			prototypeOfMap[j][i] = box.boxTargetPosition;
			prototypeOfMap[j1][i1] = box.fullBoxTP;
			push = true;
			return true;
				}
				push = false;
				return false;
		} else if (map.getMap(i, j).equals(map.field) && box.getBox(i, j).equals(box.box)
				&& !box.getBox(i1, j1).equals(box.walls) && !box.getBox(i, j).equals(box.getBox(i1, j1))
				&& !box.getBox(i1, j1).equals(box.fullBoxTP)) {
			prototypeOfMap[j][i] = box.field;
			prototypeOfMap[j1][i1] = box.box;
			push = true;
			return true;
		} else if (box.getBox(i, j).equals(box.box)&&(box.getBox(i1, j1).equals(box.box))) {
			push = false;
			return false;
		} else if (map.getMap(i1, j).equals(map.field) && box.getBox(i, j).equals(box.fullBoxTP)
				&& !box.getBox(i1, j1).equals(box.box)) {
			prototypeOfMap[j][i] = box.boxTargetPosition;
			prototypeOfMap[j1][i1] = box.box;
			push = true;
			return true;
		} else {
			push = false;
			return false;
		}
	}
}