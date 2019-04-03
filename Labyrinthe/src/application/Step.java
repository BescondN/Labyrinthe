package application;

public class Step {
	
	int own_box = 0;
	int previous_box = 0;
	char status;
	
	public void Set_Own_Box(int x, int y)
	{
		
	}

	public void Set_Previous_Box(int x, int y)
	{
		
	}
	
	public void Set_Previous_Box(int hash)
	{
		
	}
	
	/**
	 * @param sta
	 * sta = 'w' if the box is a wall
	 * sta = 'e' if the box is empty
	 * sta = 's' if the box is the start box
	 * sta = 'a' if the box is the finish box
	 */
	public void Set_Status(char sta)
	{
		this.status = sta;
	}
}
