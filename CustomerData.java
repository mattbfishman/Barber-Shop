
public class CustomerData{
	//instance variables
	private int arrivalTime; 
	private String name;
	private int serviceTime;
 	private CustomerData next; 

 	//constructor
 	public CustomerData(int conArrivalTime, int conServiceTime, String conName)
 	{
 		arrivalTime = conArrivalTime;
 		serviceTime = conServiceTime;
 		name = conName;
 		next = null; 
 	}
 	
 	public CustomerData()
 	{
 		arrivalTime = 0;
 		serviceTime = 0;
 		name = null;
 		next = null;
 	}
	//methods 

	public CustomerData getNext()
	{
		return next;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getArrivalTime()
	{
		return arrivalTime;
	}

	public int getServiceTime()
	{
		return serviceTime;
	}

	public void setNext(CustomerData nextCustomer)
	{
		next = nextCustomer;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
 	
 	public void setArrivalTime(int newArrivalTime)
 	{
 		arrivalTime = newArrivalTime;
 	}

 	public void setServiceTime(int newServiceTime)
 	{
 		serviceTime = newServiceTime;
 	}
	
	public void display()
	{
		System.out.println("\t" + name + ": " + "arrival = " + arrivalTime + ':' + " service = " + serviceTime);
	}
	
	public boolean hasNext()
	{
		return next == null;
	}
}

	
