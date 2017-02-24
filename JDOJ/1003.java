//c++部分可通过
#include <iostream>
using namespace std;
int main()
{
    int t;
    cin>>t;
    int z=0;
    while(t--)
    {
        //cout<<t<<endl;
        z++;
        int n;
        cin>>n;
        int a[100001];
        for(int i=1; i<=n; i++)
            cin>>a[i];
        int now=a[1],maxm=a[1];
        int start=1,end,mstart=1,mend=1;
        for(int i=2; i<=n; i++)
        {
            if(a[i]<=a[i]+now)
                now+=a[i];
            else
            {
                now=a[i];
                start=i;
            }
            if(now>maxm)
            {
                maxm=now;
                mstart=start;
                mend=i;
            }
        }
        cout<<"Case "<<z<<":"<<endl<<maxm<<" "<<mstart<<" "<<mend<<endl;
        if(t!=0)
        cout<<endl;
    }
    return 0;
}

// java部分没通过，但是自己验证没有问题
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
	    int z=0;
	    while(count-- >= 0)
	    {
	        z++;
	        int n;
	        n = cin.nextInt();
	        int []a = new int[100001];
	        for(int i=1; i<=n; i++)
	            a[i] = cin.nextInt();
	        int now=a[1],maxm=a[1];
	        int start=1,end,mstart=1,mend=1;
	        for(int i=2; i<=n; i++)
	        {
	            if(a[i]<=a[i]+now)
	                now+=a[i];
	            else
	            {
	                now=a[i];
	                start=i;
	            }
	            if(now>maxm)
	            {
	                maxm=now;
	                mstart=start;
	                mend=i;
	            }
	        }
	        System.out.println(String.format("Case %d:", z));
	        System.out.println(String.format("%d %d %d", maxm, mstart, mend));
	        if(count!=0)
	        	System.out.println();
	    }
	}
}
