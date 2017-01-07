public class BarberShop{
	
	public static void main (String[] args){
	
		//instance variables
		CustomerData next, arriving;
		WaitingChairs waitingChair;
		ArrivalQueue arrivalQueue;
		Barber barber;
		int time;
	
		arrivalQueue = new ArrivalQueue();
		arrivalQueue.readFile();
		waitingChair = new WaitingChairs();
		barber = new Barber();
		time = 0;

		while(!arrivalQueue.isEmpty() || !waitingChair.isEmpty() || !barber.isEmpty())
		{
			System.out.println("Time = " + time + "\n");
			
			
			if(barber.isEmpty() && !waitingChair.isEmpty())
			{
				barber.addCust(waitingChair.peek());
				waitingChair.removeCustomer();
			}
			
			if(arrivalQueue.peek().getArrivalTime() == time)
			{
				if(waitingChair.isFull())
				{
					System.out.println("All chairs are full");
					System.out.println("\t" + arrivalQueue.peek().getName() + " leaves");
				}
				else
				{
					waitingChair.addCustomer(arrivalQueue.peek());
					System.out.println("A chair is available");
					System.out.println("\t" + arrivalQueue.peek().getName() + " sits");
				}
				arrivalQueue.removeCustomer();
			}
			
			waitingChair.display();


			barber.display();

			System.out.println("\nArrival List");
			arrivalQueue.display();

			time++;
			barber.performService();

			System.out.println("\n-----------------------------\n");
		}
	



	}
}