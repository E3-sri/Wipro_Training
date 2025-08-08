package cls_work;

public class RemoteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		remote s_obj=new smartRemote();
		remote	a_obj=new acRemote();
		s_obj.turnOn();
		a_obj.turnOff();
		
		s_obj.turnOff();
		a_obj.turnOn();
	}

}
