public class Solution {
    private static final int MAXdiv10=Integer.MAX_VALUE/10;
	
	public static int myAtoi(String str)
	{
		int i, sign= +1, N=str.length(),val=0;
		i=0;
		while(i<N && Character.isWhitespace(str.charAt(i))) i++;
		
		if (i<N && str.charAt(i) == '+')
		{	
			sign = +1;
			i++;
		}
		else if (i<N && str.charAt(i)=='-')
		{
			sign=-1;
			i++;
		}
		while(i<N && Character.isDigit(str.charAt(i)))
		{	
			int digit=Character.getNumericValue(str.charAt(i));
			if (val > MAXdiv10 || val == MAXdiv10 && digit>7) 
				return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
			val=val*10+digit;
			i++;
		}
		return val*sign;
	}
}