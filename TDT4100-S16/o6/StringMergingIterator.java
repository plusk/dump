package o6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second){
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();
	}

	@Override
	public String next() {
		
		if(!hasNext()){
			throw new NoSuchElementException(); 
		}

		String result = null;
		
		if(first.hasNext() && turnSwitch){ // added turnSwitch condition, removed !
			result = first.next();
			turnSwitch = false;
		} 
		else if(second.hasNext() && !turnSwitch){ // added turnSwitch condition, removed !
			result = second.next();
			turnSwitch = true;
		} 
		else {
			if(!turnSwitch){ // switched !
				result = first.next(); // removed changing of turnSwitch variable
			}
			else if(turnSwitch){ // switched !
				result = second.next(); // removed changing of turnSwitch variable
			}
		}
		return result;
	}
}


