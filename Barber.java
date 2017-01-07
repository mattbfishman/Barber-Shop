public class Barber{
	//instance variables
	private int serviceTime;
	private CustomerData customer;

	//constructors

	public Barber()
	{
		serviceTime = 0;
		customer = null;
	}

	//methods
	
	public boolean addCust(CustomerData newCust)
	{
		if(isEmpty())
		{
			customer = newCust;
			serviceTime = newCust.getServiceTime();
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isEmpty()
	{
		if(customer == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void performService()
	{
		serviceTime--;
		
		if(serviceTime == 0)
		{
		removeCust();
		}
	}
	
	public void removeCust()
	{
		customer = null;
	}

	public CustomerData peek()
	{
		return customer;
	}

	public void display()
	{
		if(isEmpty())
		{
			System.out.println("\nBarber's chair is empty");
		}
		else
		{
			System.out.println("\nBarber");
			System.out.println(customer.getName() + " is chair " + serviceTime + " left");
		}
	}
}