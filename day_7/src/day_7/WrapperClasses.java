package day_7;

public class WrapperClasses 
{
	  public static void main(String[] args)
	  {
		int n=10;
		Integer obj=Integer.valueOf(n);
		System.out.println(obj.getClass().getSimpleName());
	  }
}
