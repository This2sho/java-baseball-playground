public class ResultView {

	public static void printMessage(int ballCount, int strikeCount) {
		if (strikeCount == GameNumbers.NUMBER_SIZE) {
			System.out.println("3스트라이크");
			return;
		}
		if (ballCount == 0 && strikeCount == 0) {
			System.out.println("낫싱");
			return;
		}
		if (ballCount > 0) {
			System.out.print(ballCount + "볼 ");
		}
		if (strikeCount > 0) {
			System.out.print(strikeCount + "스트라이크");
		}
		System.out.println();
	}
}
