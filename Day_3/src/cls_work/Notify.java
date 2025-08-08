package cls_work;

public abstract class Notify
{
	abstract void send(String msg);
}
class Email extends Notify
{
	void send(String msg)
	{
		System.out.println("Sending Mail:"+msg);
	}
}
class SMS extends Notify
{
	void send(String msg)
	{
		System.out.println("Sent Through TextMessage"+msg);
	}
}

