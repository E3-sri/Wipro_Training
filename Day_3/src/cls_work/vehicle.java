package cls_work;

public abstract class vehicle 
{
	abstract void startEngine();

}
class Car extends vehicle
{
	void startEngine()
	{
		System.out.println("Car Started");
	}
}
class Bike extends vehicle
{
	void startEngine()
	{
		System.out.println("Bike Started with a kick");
	}
}
