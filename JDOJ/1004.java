import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int count = 0;
		Map<String, Integer> colorMap = new HashMap();
		while ((count = cin.nextInt()) > 0) {
			for (int i = 0; i < count; i++) {
				String colorStr = cin.next();
				if (colorMap.get(colorStr) != null) {
					int temp = colorMap.get(colorStr);
					colorMap.put(colorStr,++temp);
				}else{
					colorMap.put(colorStr, 1);
				}
			}
			int maxValue = 0;
			String maxKey = "";
			for(Map.Entry<String, Integer> entry : colorMap.entrySet()){
				if (entry.getValue()>maxValue) {
					maxValue = entry.getValue();
					maxKey = entry.getKey();
				}
			}
			System.out.println(maxKey);
			colorMap.clear();
		}
	}
}
