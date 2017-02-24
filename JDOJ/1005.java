import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int a = 0, b = 0, n = 0, arr[] = new int[100];
		arr[0] = arr[1] = 1;
		while (true) {
			a = cin.nextInt();
			b = cin.nextInt();
			n = cin.nextInt();
			if (a == 0 && b == 0 && n == 0) {
				break;
			}
			for (int i = 2; i < 49; i++) {
				arr[i] = (a * arr[i - 1] + b * arr[i - 2]) % 7;
			}
			System.out.println(arr[(n-1) % 48]);
		}
	}
}
