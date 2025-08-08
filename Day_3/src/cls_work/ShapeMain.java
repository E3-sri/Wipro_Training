package cls_work;

public class ShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeExample circle=new Circle(5);
		ShapeExample rectangle=new Rectangle(4,2);
		System.out.println("Area of circle:"+circle.area());
		System.out.println("Area of rectangle:"+rectangle.area());		

	}

}
