package o1;

public class Rectangle {
	
	public int minX = 0;
	public int minY = 0;
	public int maxX = 0;
	public int maxY = 0;
	
	public int getMinX() {
		if(isEmpty()) {
			return 0;
		}
		else{
			return minX;
		}
	}
	public int getMinY() {
		if(isEmpty()) {
			return 0;
		}
		else{
			return minY;
		}
	}
	public int getMaxX() {
		if(isEmpty()) {
			return 0;
		}
		else{
			return maxX;
		}
	}
	public int getMaxY() {
		if(isEmpty()) {
			return 0;
		}
		else{
			return maxY;
		}
	}
	public int getWidth() {
		return maxX - minX;
	}
	public int getHeight() {
		return maxY - minY;
	}
	public boolean isEmpty() {
		if (getWidth() == 0 && getHeight() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		if(isEmpty()) {
			return false;
		}
		else if(x >= minX && x <= maxX && y >= minY && y <= maxY){
			return true;
		} else {
			return false;
		}
	}
	public boolean contains(Rectangle rect) {
		return true;
	}
	
	public boolean add(int x, int y) {
		if(contains(x, y)) {
			return false;
		}
		
		// if contains, false
		// else if x > maxX, maxX += x-maxX
		
		
		return true;
	}
	public boolean add(Rectangle rect) {
		return true;
	}
	
	public Rectangle union(Rectangle rect) {
		Rectangle rektangle = new Rectangle();
		return rektangle;
	}
	public String toString() {
		return "";
	}
	public static void main(String[] args) {
		
	}
}
