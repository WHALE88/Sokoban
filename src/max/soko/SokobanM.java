package max.soko;

public class SokobanM {

	public static void main(String[] args) {
		Map1 map = new Map1();
		WarehouseKeeper wKeeper = new WarehouseKeeper(11, 8);
		BoxMap bomap = new BoxMap();
		int counter = 1;
		Menu  menu = new Menu(map,bomap,wKeeper, counter);
		new Authorization(menu);
	}

}

