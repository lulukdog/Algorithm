import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int end;

        while(cin.hasNextInt())
        {
        	end = cin.nextInt();
        	int sum = 0;
            for (int i = 1; i <= end; i++) {
				sum = sum + i;
			}
            System.out.println(sum);
            System.out.println();
        }
    }
}