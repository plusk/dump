package o9;

import java.util.ArrayList;

public abstract class ObservableList {
	public ArrayList<Object> results = new ArrayList<Object>();
	
	protected ArrayList<ObservableListListener> listeners = new ArrayList<ObservableListListener>();
	
	public int size(){
		return this.results.size();
	}
	public Object getElement(int pos){
		return this.results.get(pos);
	}
	
	public abstract boolean acceptsElement(Object obj);
	
	public void addElement(int pos, Object obj)throws IllegalArgumentException, IndexOutOfBoundsException{
		if(acceptsElement(obj)){
			if(pos >= 0 && pos <= size()){
				results.add(pos, obj);
				sendChanges(pos);
			}
			else{
				throw new IndexOutOfBoundsException("That is not a valid position.");
			}
		}
		else {
			throw new IllegalArgumentException("That is not an accepted element.");
		}
	}
	
	public void addElement(Object obj)throws IllegalArgumentException{
		if(acceptsElement(obj)){
			results.add(obj);
			sendChanges(results.lastIndexOf(obj));
		}
		else {
			throw new IllegalArgumentException("That is not an accepted element.");
		}
	}
	
	public void removeElement(int pos) throws IndexOutOfBoundsException{
		if(pos >= 0 && pos < size()){
			results.remove(pos);
		}
		else{
			throw new IndexOutOfBoundsException("That is not a valid position.");
		}
	}
	
	protected void sendChanges(int index) {
		if(!listeners.isEmpty()){
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).listChanged(this, index);
			}
		}
	}
	
	public void addObservableListListener(ObservableListListener listener){
		if(!this.listeners.contains(listener)){
			this.listeners.add(listener);
		}
	}
	public void removeObservableListListener(ObservableListListener listener){
		if(this.listeners.contains(listener)){
			this.listeners.remove(listener);
		}
	}
}
