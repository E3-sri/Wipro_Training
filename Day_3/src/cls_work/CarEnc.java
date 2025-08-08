package cls_work;

public class CarEnc
{
	private String model;
	private int speed;
	private int fuel_level;
	private boolean engine_status;
	
	
	public CarEnc()
	{
        engine_status = false;
        speed = 0;
    }
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String model)
	{
		if(!model.isEmpty())
		{
			this.model=model;
		}
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		if(speed>0)
		{
			this.speed=speed;
		}
		else
		{
			System.out.println("Speed cannot be Negative");
		}
	}
	public int getFuelLevel()
	{
		return fuel_level;
	}
	public void setFuelLevel(int fuel_level)
	{
		if(fuel_level>10)
		{
			this.fuel_level=fuel_level;
		}
		else
		{
			System.out.println("Fuel Level is low.");
		}
	}
	
	public boolean getEngineStatus()
	{
		return engine_status;
	}
	
	public void setEngineStatus(boolean engine_status)
	{
		this.engine_status=engine_status;
	}
	
	public void displayStatus() {
        System.out.println("Engine: " + (engine_status ? "ON" : "OFF"));
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel: " + fuel_level +"Liters");
        
        
    }
	
	
	
	 
	
	
	
}
