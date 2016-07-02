package o0;

public class RectsCore {

	double r1x1 = 0, r1y1 = 0, r1x2 = 2, r1y2 = 2;
	double r2x1 = 1, r2y1 = 1, r2x2 = 3, r2y2 = 3;
	
	boolean intervalsOverlap(double n1, double n2, double m1, double m2) {
		return !(n1 > m2 || n2 < m1);
	}
	
	boolean rectanglesOverlap() {
		return (intervalsOverlap(r1x1, r1x2, r2x1, r2x2) && (intervalsOverlap(r1y1, r1y2, r2y1, r2y2)));
	}
	
	String rectangle2String(double x1, double y1, double x2, double y2) {
		return ("(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")");
	}
	
}