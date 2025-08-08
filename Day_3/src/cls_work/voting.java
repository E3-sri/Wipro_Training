package cls_work;

public class voting
{
	private String name;
	private String voterId;
	private boolean status;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(!name.isEmpty())
		{
			this.name=name;
		}
		else
		{
			System.out.println("Name shouldnot be EMPTY");
		}
	}
	public String getVoterId()
	{
		return voterId;
	}
	
	public void setVoterId(String voterId)
	{
		if(!voterId.isEmpty())
		{
			this.voterId=voterId;
		}
		else
		{
			System.out.println("Invalid VoterID");
		}
	}
	public boolean getStatus()
	{
		return status;
	}
	public void vote()
	{
	        if (!status)
	        {
	            status = true;
	            System.out.println("Vote recorded:-" + name);
	        } 
	        else
	        {
	            System.out.println("You have already voted:-" + name);
	        }
	}
	
	
	
	
	

}
