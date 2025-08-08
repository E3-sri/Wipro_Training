package cls_work;

public abstract class remote 
{
	abstract void turnOn();
	abstract void turnOff();
}
class smartRemote extends remote
{
	void turnOn()
	{
		System.out.println("Fan is ON");
	}
	void turnOff()
	{
		System.out.println("Fan is OFF");
	}
}
class acRemote extends remote
{
	void turnOn()
	{
		System.out.println("AC is ON");

	}
	void turnOff()
	{
		System.out.println("AC is OFF");
	}
}
