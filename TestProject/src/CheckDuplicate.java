

public class CheckDuplicate {
	
	static String l_customerID = null;
	static long initialTimeOfRequest = 0l;
	public static boolean checkDuplicate(String customerID) 
	{
		boolean isExit = false;
		
		
		if(l_customerID != null && customerID.equals(l_customerID)) 
		{
			l_customerID = null;
			long l_currentTimeout = System.currentTimeMillis();
			long l_timeDifference = l_currentTimeout - initialTimeOfRequest;
			System.out.println("l_currentTimeout="+l_currentTimeout);
			System.out.println("l_timeDifference="+l_timeDifference);
			if(l_timeDifference <= 15000) 
			{
				System.out.println("Dulplicate Request as per developer");
				isExit = true;
			}
		}
		else 
		{
			l_customerID = customerID;
			initialTimeOfRequest = System.currentTimeMillis();
			System.out.println("initialTimeOfRequest="+initialTimeOfRequest);
		}
		
		
		return isExit ;
	}

	
	public static void main(String[] args) throws InterruptedException 
	{
		boolean isexit = checkDuplicate("777777");
		Thread.sleep(5);
		boolean isexit1 = checkDuplicate("7777771");
		Thread.sleep(5);
		isexit1 = checkDuplicate("777777");
	}
}
