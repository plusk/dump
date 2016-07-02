package o1;

public class UpOrDownCounter {
	
	public int counter;
	
	public int startValue;
	public int endValue;
	
	void checkEqual(int start, int end) throws IllegalArgumentException {
		if(start == end) {
			throw new IllegalArgumentException(start + " and " + end + " are equal");
		}
	}
	
	public UpOrDownCounter(int start, int end){
		checkEqual(start, end);
		
		startValue = start;
		endValue = end;	
		
		counter = startValue;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		
		if(startValue < endValue && getCounter() != endValue){
			counter++;
		}
		else if(startValue > endValue && getCounter() != endValue) {
			counter--;
		}
		
		if(getCounter() == endValue) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main (String[] args) {
		
		UpOrDownCounter cou = new UpOrDownCounter(5, 1);
		
		System.out.println(cou.getCounter());
		cou.count();
		System.out.println(cou.getCounter());
		cou.count();
		System.out.println(cou.getCounter());
		cou.count();
		System.out.println(cou.getCounter());
		cou.count();
		System.out.println(cou.getCounter());
		cou.count();
		System.out.println(cou.getCounter());
		cou.count();
		System.out.println(cou.getCounter());
	}
}
