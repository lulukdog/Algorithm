import java.util.Scanner;

public class Main {
	static double maxNum(double a, double b, double c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}

	static double minNum(double a, double b, double c) {
		return a < b ? (a < c ? a : c) : (b < c ? b : c);
	}
	
	static boolean sameNum(double a, double b){
		if ((a-b)<0.00001 && (a-b)>-0.00001) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);

		double sm = (double)59 / 10, sh = (double)719 / 120, mh = (double)11 / 120;// 相对速度 °/s
		double ct_sm = (double)3600 / 59, ct_sh = (double)43200 / 719, ct_mh = (double)43200 / 11;// 两两再次回到初始位置的时间

		int d;
		
		while ((d = cin.nextInt()) != -1) {
			double sum = 0;
			double d_sm = d / sm, d_sh = d / sh, d_mh = d / mh;
			double not_d_sm = ct_sm - d / sm, not_d_sh = ct_sh - d / sh, not_d_mh = ct_mh - d / mh;
			double timeS = 0;maxNum(d_sm, d_sh, d_mh);
			double timeE = 0;minNum(not_d_sm, not_d_sh, not_d_mh);
			while (timeE < 43200 && timeS < 43200) {
				timeS = maxNum(d_sm, d_sh, d_mh);
				timeE = minNum(not_d_sm, not_d_sh, not_d_mh);
				if (timeS < timeE) {
					sum += timeE - timeS;
				}
				if (sameNum(timeE, not_d_sm)) {
					d_sm += ct_sm;
					not_d_sm += ct_sm;
				} else if (sameNum(timeE, not_d_sh)) {
					d_sh += ct_sh;
					not_d_sh += ct_sh;
				} else if (sameNum(timeE, not_d_mh)) {
					d_mh += ct_mh;
					not_d_mh += ct_mh;
				}
			}
			System.out.println(String.format("%.3f", (sum/43200)*100));
		}
	}
}
