
public class PerfectSquare {

	static boolean IsPowerPresented(int n)
    {
        if (n == 0)
            System.out.println("wrong input");
        if (n == 1)
            return true;

        if (n == 2)
            return true;

        int temp = n;
        for(int i=2; i*i <= n; i++)
        {
            temp = n;
            while(temp > 1)
            {
                if (temp % i != 0)
                    break;
                temp = temp / i;
            }

            if (temp == 1)
                return true;
        }

        return false;
    }
	
	public static void main(String args[]){
		System.out.println(IsPowerPresented(125));
	}
}
