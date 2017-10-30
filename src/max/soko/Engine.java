package max.soko;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Engine extends KeyAdapter{
	private Map1 map;
	private WarehouseKeeper wKeeper;
	private BoxMap box;
	private CompareCollision com;
	Engine(Map1 map,BoxMap box,WarehouseKeeper wKeeper,CompareCollision com){
		super();
		this.com=com;
		//com = new CompareCollision(map, box);
		this.box = box;
		this.map = map;
		this.wKeeper = wKeeper;
	}

	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_LEFT) {
			if (box.getBox(wKeeper.getX() - 1, wKeeper.getY()).equals(box.box)
					&& (box.getBox(wKeeper.getX() - 2, wKeeper.getY()).equals(box.walls))) {
				wKeeper.move(0, 0);
			} else if (!map.getMap(wKeeper.getX() - 1, wKeeper.getY()).equals(map.walls)) {
				if (com.getBox(map, box, wKeeper.getX() - 1, wKeeper.getY(), "LC")) {
					wKeeper.move(-1, 0);
				} else {
					wKeeper.move(0, 0);
				}
			}
		} else if (keycode == KeyEvent.VK_RIGHT) {
			if (box.getBox(wKeeper.getX() + 1, wKeeper.getY()).equals(box.box)
					&& (box.getBox(wKeeper.getX() + 2, wKeeper.getY()).equals(box.walls))) {
				wKeeper.move(0, 0);
			} else if (!map.getMap(wKeeper.getX() + 1, wKeeper.getY()).equals(map.walls)) {
				if (com.getBox(map, box, wKeeper.getX() + 1, wKeeper.getY(), "RC")) {
					wKeeper.move(1, 0);
				} else {
					wKeeper.move(0, 0);
				}
			}
		} else if (keycode == KeyEvent.VK_UP) {
			if (box.getBox(wKeeper.getX(), wKeeper.getY()-1).equals(box.box)
					&& (box.getBox(wKeeper.getX(), wKeeper.getY()-2).equals(box.walls))) {
				wKeeper.move(0, 0);
			} else if (!map.getMap(wKeeper.getX(), wKeeper.getY()-1).equals(map.walls)) {
				if (com.getBox(map, box, wKeeper.getX(), (wKeeper.getY()-1), "UC")) {
					wKeeper.move(0, -1);
				} else {
					wKeeper.move(0, 0);
				}
			}
		} else if (keycode == KeyEvent.VK_DOWN) {
			if (box.getBox(wKeeper.getX(), wKeeper.getY() + 1).equals(box.box)
					&& (box.getBox(wKeeper.getX(), wKeeper.getY() + 2).equals(box.walls))) {
				wKeeper.move(0, 0);
			} else if (!map.getMap(wKeeper.getX(), wKeeper.getY() + 1).equals(map.walls)) {
				if (com.getBox(map, box, wKeeper.getX(), wKeeper.getY() + 1, "DC")) {
					wKeeper.move(0, 1);
				} else {
					wKeeper.move(0, 0);
				}

			}
		} 

	}

	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_LEFT) {
			wKeeper.move(0, 0);
		} else if (keycode == KeyEvent.VK_RIGHT) {
			wKeeper.move(0, 0);
		} else if (keycode == KeyEvent.VK_UP) {
			wKeeper.move(0, 0);
		} else if (keycode == KeyEvent.VK_DOWN) {
			wKeeper.move(0, 0);
		}
	}
}

