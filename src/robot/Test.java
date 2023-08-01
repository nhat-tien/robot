package robot;

public class Test {

	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.readFile("D:/02_WORKSPACE/robot/input.txt");
		robot.run(0,0);
		robot.printResult();
		robot.writeFile("D:/02_WORKSPACE/robot/output.txt");
	}

}
