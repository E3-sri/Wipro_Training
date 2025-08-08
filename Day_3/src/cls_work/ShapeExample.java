package cls_work;

public abstract class ShapeExample
{
	abstract double area();
}
	
	class Circle extends ShapeExample
	{
		double radius;
		Circle(double radius)
		{
			this.radius=radius;
		}
		
		double area()
		{
			return Math.PI * radius *radius;
		}
	}
	
	class Rectangle extends ShapeExample
	{
		int length;
		int breadth;
		Rectangle(int length,int breadth)
		{
			this.length=length;
			this.breadth=breadth;
		}
		double area()
		{
			return length*breadth;
		}
	}


