package ui;
import java.util.Scanner;
import model.*;

public class Main {
	
	private Program information;
	private Scanner reader;
	
	public Main() {
		information = new Program();
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main m = new Main();
	}

}
