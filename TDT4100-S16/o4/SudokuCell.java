package o4;

public class SudokuCell {
	private int x;
	private int y;
	private String val;
	
	public SudokuCell(int x, int y, String val) {
		checkValue(val);
		this.x = x;
		this.y = y;
		this.val = val;
	}
	
	public String getValue() {
		return this.val;
	}
	
	private void checkValue(String value) throws IllegalArgumentException{
		if(!value.equals(" . ")) {
			try {
				int intValue = Integer.parseInt(value.substring(1, 2));
				if(intValue > 9 || intValue < 1) {
					throw new IllegalArgumentException(value + " is not an integer between 1 and 9");
				}
			}
			catch (NumberFormatException e){
				throw new IllegalArgumentException(value + " is not a period or an integer");
			}
		}
	}
	
	public void setValue(String value) {
		checkValue(value);
		this.val = value;
	}
}