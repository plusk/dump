package o1;

public class Digit {

    public int value = 0;
    public int base = 0;

    public Digit(int startBase) {
        base = startBase;
    }

    public int getValue() {
        return value;
    }

    public boolean increment() {
    	value += 1;
    	if (value == base) {
            value = 0;
            return true;
        }
        else {
            return false;
        }
    }
    
    public String toString() {
    	String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	return String.valueOf(digits.charAt(getValue()));
    }
    
    public static void main (String[] args) {
    	
    	Digit dig = new Digit(16);

    	for (int i = 0; i < 20; i++) {
    		System.out.println(dig.toString());
    		dig.increment();
		}
    }
}