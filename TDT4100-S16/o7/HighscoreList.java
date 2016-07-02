package o7;

import java.util.ArrayList;
import java.util.Collections;

public class HighscoreList {
	
	private int maxSize;
	private ArrayList<Integer> results;
	private ArrayList<HighscoreListListener> listeners = new ArrayList<HighscoreListListener>();

	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
		results = new ArrayList<Integer>(maxSize);
	}
	
	public int size(){
		return this.results.size();
	}
	
	public int getElement(int pos){
		return this.results.get(pos);
	}
	public void addResult(int result){
		if(size() < maxSize || maxSize == 0){
			this.results.add(result);
			Collections.sort(this.results);
			int index = results.indexOf(result);
			sendChanges(index);
		}
		else if(size() == maxSize && result < getElement(maxSize-1)){
			this.results.add(result);
			Collections.sort(this.results);
			this.results.remove(size()-1);
			int index = results.lastIndexOf(result);
			sendChanges(index);
		}
	}
	
	public void addHighscoreListListener(HighscoreListListener listener){
		if(!this.listeners.contains(listener)){
			this.listeners.add(listener);
		}
	}
	public void removeHighscoreListListener(HighscoreListListener listener){
		if(this.listeners.contains(listener)){
			this.listeners.remove(listener);
		}
	}
	public void sendChanges(int index) {
		if(!this.listeners.isEmpty()){
			for (int i = 0; i < this.listeners.size(); i++) {
				this.listeners.get(i).listChanged(this, index);
			}
		}
	}
}
