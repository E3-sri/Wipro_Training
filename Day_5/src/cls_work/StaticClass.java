package cls_work;

public class StaticClass 
{
	    static class StaticNestedClass
	    {
	        void display()
	        {
	            System.out.println("Inside static nested class.");
	        }
	    }
	public static void main(String[] args)
	{
	
		//StaticClass.StaticNestedClass.display();
		StaticClass.StaticNestedClass obj = new StaticClass.StaticNestedClass();
		obj.display();
	}
		

}
