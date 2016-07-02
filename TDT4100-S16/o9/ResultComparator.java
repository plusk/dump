package o9;

import java.util.Comparator;

public class ResultComparator implements Comparator<Object>{
	@Override
	public int compare(Object arg0, Object arg1) {
		return Integer.valueOf(arg0.toString()).compareTo(Integer.valueOf(arg1.toString()));
	}
}
