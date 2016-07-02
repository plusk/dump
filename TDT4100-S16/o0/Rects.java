package o0;

import java.util.Scanner;

public class Rects {
	
	public static double r1x1 = 0, r1y1 = 0, r1x2 = 2, r1y2 = 2;
	public static double r2x1 = 1, r2y1 = 1, r2x2 = 3, r2y2 = 3;
	
	public static boolean intervalsOverlap(double n1, double n2, double m1, double m2) {
		return !(n1 > m2 || n2 < m1);
	}

	public static boolean rectanglesOverlap() {
		return (intervalsOverlap(r1x1, r1x2, r2x1, r2x2) && (intervalsOverlap(r1y1, r1y2, r2y1, r2y2)));
	}
	
	public static String rectangle2String(double x1, double y1, double x2, double y2) {
		return ("("+x1+","+y1+"),("+x2+","+y2+")");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Rect1: "+ rectangle2String(r1x1, r1y1, r1x2, r1y2));
			System.out.println("Rect2: "+ rectangle2String(r2x1, r2y1, r2x2, r2y2));

			System.out.print(" > ");
			String token = scanner.next();

			if (token.equals("overlaps?")) {
				System.out.println(rectanglesOverlap());
			}
			else if (token.equals("exit")) {
				break;
			}	
			else {
				int pos = token.indexOf("=");
				if (pos >= 4) {
					double val = Double.parseDouble(token.substring(pos+1));
					if (token.startsWith("r1x1")) {
						r1x1 = val;
					}
					else if (token.startsWith("r1y1")) {
						r1y1 = val;
					}
					else if (token.startsWith("r1x2")) {
						r1x2 = val;
					}
					else if (token.startsWith("r1y2")) {
						r1y2 = val;
					}
					else if (token.startsWith("r2x1")) {
						r2x1 = val;
					}
					else if (token.startsWith("r2y1")) {
						r2y1 = val;
					}
					else if (token.startsWith("r2x2")) {
						r2x2 = val;
					}
					else if (token.startsWith("r2y2")) {
						r2y2 = val;
					}
				}
			}
		}
		scanner.close();
	}
}