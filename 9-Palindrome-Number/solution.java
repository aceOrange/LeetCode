public class Solution {
    public static boolean isPalindrome(int x)
	{
		if (x<0) return false;
		if (Math.abs(x) > Integer.MAX_VALUE) return false;
		
		int val=0, num=x;
		while (num > 0)
		{
			val = val*10 + num%10;
			num=num/10;
		}
		if (val == x)	return true;
		else 			return false;
	}
}