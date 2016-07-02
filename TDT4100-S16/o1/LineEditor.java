package o1;

public class LineEditor {
    public String text = "";
    public int insertionIndex = 0;
    
    public void left(){
        if(insertionIndex > 0) {
            insertionIndex--;
        }
    }
    public void right() {
        if(insertionIndex < text.length()) {
            insertionIndex++;
        }
    }
    public void insertString(String s){
        text = text.substring(0, insertionIndex) + s + text.substring(insertionIndex);
        insertionIndex += s.length();
    }
    public void deleteLeft() {
        if(insertionIndex > 0) {
            text = text.substring(0, insertionIndex - 1) + text.substring(insertionIndex);
            insertionIndex--;
        }
    }
    public void deleteRight() {
    	if(insertionIndex < text.length()) {
    		text = text.substring(0, insertionIndex) + text.substring(insertionIndex + 1);
    		System.out.println(text);
    	}
    }
    public String toString() {
        if(!text.contains("|")) {
            text = text.substring(0, insertionIndex) + "|" + text.substring(insertionIndex);
        }
        else {
            text = text.replace("|", "");
            text = text.substring(0, insertionIndex) + "|" + text.substring(insertionIndex);
        }
        return text;
    }
    
    public static void main(String[] args) {
        
        LineEditor le = new LineEditor();
        
        le.deleteRight();
        System.out.println("1: " + le.toString());
        
        le.insertString("J");
        le.left();
        System.out.println("\n2: " + le.toString());
        le.deleteRight();
        System.out.println("2: " + le.toString());
    }
}