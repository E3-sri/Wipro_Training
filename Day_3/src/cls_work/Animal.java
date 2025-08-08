package cls_work;

public abstract class Animal
{
	abstract void sound(); //abstract method doesn't have body
	
	//all the methods written in abstract class comes under abstract. Even though you don't mention the keyword.
}	
	class Cat extends Animal
	{
		void sound()
		{
			System.out.println("Meow Meow");
		}
	}

