package o0;

import java.util.Scanner;

public class RectsUI {

	RectsCore core = new RectsCore();
	
	void main() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Rect1: "+ core.rectangle2String(core.r1x1, core.r1y1, core.r1x2, core.r1y2));
			System.out.println("Rect2: "+ core.rectangle2String(core.r2x1, core.r2y1, core.r2x2, core.r2y2));
			System.out.print(" > ");
			String token = scanner.nextLine();

			if (token.equals("overlaps?")) {
				System.out.println(core.rectanglesOverlap());
			}
			else if (token.equals("exit")) {
				break;
			}	
			else {
				int pos = token.indexOf("=");
				if (pos >= 4) {
					double val = Double.parseDouble(token.substring(pos+1));
					if (token.startsWith("r1x1")) {
						core.r1x1 = val;
					}
					else if (token.startsWith("r1y1")) {
						core.r1y1 = val;
					}
					else if (token.startsWith("r1x2")) {
						core.r1x2 = val;
					}
					else if (token.startsWith("r1y2")) {
						core.r1y2 = val;
					}
					else if (token.startsWith("r2x1")) {
						core.r2x1 = val;
					}
					else if (token.startsWith("r2y1")) {
						core.r2y1 = val;
					}
					else if (token.startsWith("r2x2")) {
						core.r2x2 = val;
					}
					else if (token.startsWith("r2y2")) {
						core.r2y2 = val;
					}
				}
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		new RectsUI().main();
	}
}