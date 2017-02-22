import java.util.Scanner;

public class Main {
	public static String addString(String a, String b) {
		String sumStr = "";
		int equalL = a.length() <= b.length() ? a.length() : b.length();
		String longStr = a.length() <= b.length() ? b : a;
		String shortStr = a.length() <= b.length() ? a : b;
		int tempByte = 0;
		for (int i = 0; i < equalL; i++) {
			int byteA = Integer.parseInt(longStr.substring(longStr.length() - i - 1, longStr.length() - i));
			int byteB = Integer.parseInt(shortStr.substring(shortStr.length() - i - 1, shortStr.length() - i));
			int sumByte = byteA + byteB + tempByte;
			if (sumByte > 9) {
				sumByte = sumByte % 10;
				tempByte = 1;
			} else {
				tempByte = 0;
			}
			sumStr = sumByte + sumStr;
		}
		if (sumStr.length() < longStr.length()) {
			if (tempByte == 1) {
				int nextByte = Integer.parseInt(
						longStr.substring(longStr.length() - sumStr.length() - 1, longStr.length() - sumStr.length()));
				StringBuilder aBuilder = new StringBuilder(longStr);
				if (nextByte == 9) {
					for (int i = 1; i <= longStr.length() - sumStr.length(); i++) {
						int nowByte = Integer.parseInt(longStr.substring(longStr.length() - sumStr.length() - i,
								longStr.length() - sumStr.length() - i + 1));
						if (nowByte == 9) {
							aBuilder.setCharAt(longStr.length() - sumStr.length() - i, (char) (0 + 48));
						} else {
							aBuilder.setCharAt(longStr.length() - sumStr.length() - i, (char) (nowByte + 1 + 48));
							break;
						}
						longStr = aBuilder.toString();
						if (i == (longStr.length() - sumStr.length())) {
							sumStr = 1 + longStr;
							return sumStr;
						}
					}
				} else {
					aBuilder.setCharAt(longStr.length() - sumStr.length() - 1, (char) (nextByte + 1 + 48));
				}
				longStr = aBuilder.toString();
			}
			sumStr = longStr.substring(0, longStr.length() - sumStr.length()) + sumStr;
		} else if (tempByte == 1) {
			sumStr = 1 + sumStr;
		}
		return sumStr;
	}

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		String[] strArr = new String[count * 2];
		for (int i = 0; i < count * 2; i = i + 2) {
			String a = cin.next();
			String b = cin.next();
			strArr[i] = a;
			strArr[i + 1] = b;
		}
		System.out.println(String.format("Case %d:", 1));
		System.out.println(String.format("%s + %s = %s", strArr[0], strArr[1], addString(strArr[0], strArr[1])));
		for (int i = 2; i < count * 2; i = i + 2) {
			System.out.println();
			System.out.println(String.format("Case %d:", (i / 2 + 1)));
			System.out.println(String.format("%s + %s = %s", strArr[i], strArr[i + 1], addString(strArr[i], strArr[i + 1])));
		}
	}

}
