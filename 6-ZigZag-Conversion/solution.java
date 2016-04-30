public class Solution {
    public static String convert(String str,int r)
	{	
		if (r==1) return  str;
		
		StringBuilder str_new=new StringBuilder(str.length());
		int index,len,skip1,skip2;
		len=str.length();
		
		skip1=2*r-2;
		skip2=skip1;
		
		for(int i=0;i<r;i++)
		{
			index=i;
			
			if(i!=0 && i!=r-1) skip2 -= 2;
			while(index<len)
			{
				str_new.append(str.charAt(index));
				if (i!=0 && i!=r-1 && index+skip2<len) 
				    str_new.append(str.charAt(index+skip2));
				index += skip1;
			}
		}
		return str_new.toString();
	}
}