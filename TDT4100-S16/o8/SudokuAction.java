package o8;

public class SudokuAction {
	
	private int x;
	private int y;
	private String valOld;
	private String valNew;
	
	public SudokuAction(int x, int y, String valOld, String valNew){
		this.x = x;
		this.y = y;
		this.valNew = valNew;
		this.valOld = valOld;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public String getValNew() {
		return this.valNew;
	}
	public String getValOld() {
		return this.valOld;
	}
}
