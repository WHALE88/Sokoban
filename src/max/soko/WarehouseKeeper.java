package max.soko;

import java.awt.Image;

import javax.swing.ImageIcon;

public class WarehouseKeeper {
	private String wKeeper;
	private Image warKeeper;
	
	private int CurrentPositionX = 11;
	private int CurrentPositionY = 8;
	

	public WarehouseKeeper(int CurrentPositionX , int CurrentPositionY) {
		this.CurrentPositionX = CurrentPositionX;
		this.CurrentPositionY = CurrentPositionY;
		wKeeper = "@"; // символ обозначающий кладовщика
	
		ImageIcon img = new ImageIcon("img/fPlayer.png");
		warKeeper = img.getImage();
	}
	
	
	public Image getPlayer(){
		return warKeeper;
	}
	
	
	public void move(int dx, int dy){
		CurrentPositionX += dx;
		CurrentPositionY += dy;
	}
	

	/**
	 * @param 
	 * Returns the symbol denoting the storekeeper;
	 * @return string;
	 */
	protected String getWKeeper() {
		return wKeeper;
	}
	
	

	/**
	 * @param 
	 * Set the position of the storekeeper. Moving along the X axis;
	 */
	protected void setCurrentPositionX(int CurrentPositionX) {
		this.CurrentPositionX = CurrentPositionX;
	}

	/**
	 * @return int;
	 * @param 
	 * Return the position of the storekeeper. Moving along the X axis;
	 */
	protected int getX() {
		return CurrentPositionX;
	}

	/**
	 * @param 
	 * Set the position of the storekeeper. Moving along the Y axis;
	 */
	protected void setCurrentPositionY(int CurrentPositionY) {
		this.CurrentPositionY = CurrentPositionY;
	}
	
	/**
	 * @return int; 
	 * @param 
	 * Return the position of the storekeeper. Moving along the Y axis;
	 */
	protected int getY() {
		return CurrentPositionY;
	}

	protected void getInfo() {
		System.out.println(wKeeper);
	}
	
}
