public class WaitingChairs{
	//instance variables
	private int numItems = 0;
	private int firstCus;
	private int lastCus;
	private int size = 3;
	private CustomerData[] customer;

	//constructor
	public WaitingChairs()
	{
		size = 3;
		customer =  new CustomerData[size];
		lastCus = 0;
		firstCus = 0;
	}
	
	public static void main (String[] args)
	{
		WaitingChairs temp = new WaitingChairs();
		temp.display();
		CustomerData test = new CustomerData(1,2,"jon");
		temp.addCustomer(test);
		temp.display();
		CustomerData test2 = new CustomerData(1,3,"matt");
		temp.addCustomer(test2);
		temp.display();
		//ask how to test peek 
	}

	

	//methods

	public void addCustomer(CustomerData firstCustomer)
	{
		if(!isFull())
		{
			customer[firstCus] = firstCustomer;
			firstCus = (firstCus+1)%size;
			numItems++;
		}
		else
		{
			System.out.println("Queue is full!");
		}
	}

	public CustomerData removeCustomer()
	{
		CustomerData lastCustomer = customer[lastCus];
		lastCus = (lastCus+1) %size;
		numItems--;
		return lastCustomer;
	}

	public CustomerData peek()
	{
		return customer[lastCus];
	}	

	public void display()
	{
		if(!isEmpty())
		{
			System.out.println("\nChairs");
			for(int i = 0;i < numItems; i++){
				customer[(lastCus+i)%size].display();
			}
		}
		else
		{
			System.out.println("\nChairs are empty");
		}
	}

	public boolean isFull()
	{
		if(numItems == size)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isEmpty()
	{
		if(numItems == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}