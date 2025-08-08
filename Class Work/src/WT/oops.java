package WT;

public class oops
{
	String color;
	String model;
	int speed;
	void start()
	{
		System.out.println("****Car Starts*****");
	}
	void display()
	{
		System.out.println("Color:"+color);
		System.out.println("Model:"+model);
		System.out.println("Speed:"+speed);

	}
	public static void main(String[] args)
	{
		//object Creation
		oops o=new oops();
		o.color="Blue";
		o.model="Maruthi";
		o.speed=100;
		o.start();
		
		o.display();
	}

}
