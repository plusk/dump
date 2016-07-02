package o9;

import java.util.ArrayList;
import java.util.Collections;

public class ObservableHighscoreList extends ObservableList{
	
	private int maxSize;
	
	public ObservableHighscoreList(int maxSize) {
		this.maxSize = maxSize;
		results = new ArrayList<Object>(maxSize);
	}
	public void addResult(int result){
		if(size() < maxSize || maxSize == 0){
			addElement(result);
		}
		else if(size() == maxSize && result < Integer.valueOf(getElement(maxSize-1).toString())){
			addElement(result);
			Collections.sort(results, new ResultComparator());
			removeElement(size()-1);
		}
	}
	
	@Override
	public boolean acceptsElement(Object obj) {
		if (obj instanceof Integer) {
			return true;
		}
		else{
			return false;
		}
	}
}
