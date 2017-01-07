import java.util.Scanner;
import java.io.*;

public class ArrivalQueue{
	//instance variables
	private int numItems;
	private CustomerData firstCustomer;
	private CustomerData lastCustomer; 

	//constructors 
	public ArrivalQueue()
	{
	firstCustomer = null;
	lastCustomer = null;
	numItems = 0;
	}
	//methods
	
	//test code 
	public static void main (String[] args)
	{
		ArrivalQueue test = new ArrivalQueue();
		test.readFile();
		test.display();
		CustomerData temp = new CustomerData(1,1, "temp");
		test.addCustomer(temp);
		test.removeCustomer();
		test.display();
		//ask how to test peek 
	}

	public void addCustomer(CustomerData newFirstCustomer)
	{
		if(firstCustomer == null && lastCustomer == null)
		{
		firstCustomer = newFirstCustomer;
		lastCustomer = newFirstCustomer;
		numItems++;
		}
		else 
		{
			firstCustomer.setNext(newFirstCustomer);
			firstCustomer = newFirstCustomer;
			numItems++;
		}
	}
	
	public CustomerData removeCustomer()
	{
		CustomerData c = lastCustomer;
		lastCustomer = lastCustomer.getNext();
		numItems--;
		return c;
	}
	
	public void display()
	{
		CustomerData tempCustomer = lastCustomer;
		while(tempCustomer != null)
		{
			tempCustomer.display();
			tempCustomer = tempCustomer.getNext();
		}
	}
	
	public CustomerData peek()
	{
		if(!isEmpty())
			return lastCustomer;
		else
		{
			CustomerData temp = new CustomerData(1,1, "temp");
			return temp;
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
	

	public void readFile(){
	String inputLine;
		
		Scanner fileInput;
		File inFile = new File("Barber.txt");
		
		System.out.println("Opening and reading file");
		
		try{
			fileInput = new Scanner(inFile);

			while(fileInput.hasNext())
			{
				CustomerData temp = new CustomerData();
				temp.setArrivalTime(fileInput.nextInt());
				temp.setServiceTime(fileInput.nextInt());
				temp.setName(fileInput.nextLine());
				addCustomer(temp);
			}
			
			fileInput.close();
			
		} // end try
		
		catch (FileNotFoundException e)
		{
			System.out.println(e);
			System.exit(1);		// IO error; exit program
		} // end catch	
			
	}
}