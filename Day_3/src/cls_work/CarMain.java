package cls_work;

public class CarMain
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarEnc obj = new CarEnc();

        obj.setEngineStatus(true);
        obj.setSpeed(100);
        obj.setFuelLevel(20);

        obj.displayStatus();
        obj.setSpeed(-10);    
        obj.setFuelLevel(5);  
    }
}


