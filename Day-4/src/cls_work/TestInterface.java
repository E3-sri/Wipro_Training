package cls_work;

interface Animal
{
	void sound();
}

/*interface Animal1
{
	void sound();
}*/
class Dog implements Animal
{
	public void sound()
	{
		System.out.println("***Barks***");
	}
}
class Cat implements Animal
{
	public void sound()
	{
		System.out.println("***Meow Meow***");
	}
}
public class TestInterface {

	public static void main(String[] args)
	{
			//Animal a=new Dog();  //UpCasting
			//a.sound();
			Dog d=new Dog();
			d.sound();
			//Animal a=new Cat();
			//a.sound();
	}

}


