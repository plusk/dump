package o1;

public class Location {
    
    public int x = 0;
    public int y = 0;
    
    public void up(){
        y--;
    }
    public void down(){
        y++;
    }
    public void left(){
        x--;
    }
    public void right(){
        x++;
    }
    public String toString() {
        return "Location: ("+x+", "+y+")";
    }
    public static void main(String[] args) {
        
        Location loc = new Location();

        System.out.println(loc.toString());
        loc.down();
        System.out.println(loc.toString());
        loc.right();
        System.out.println(loc.toString());
        loc.up();
        System.out.println(loc.toString());
        loc.left();
        System.out.println(loc.toString());

    }
}