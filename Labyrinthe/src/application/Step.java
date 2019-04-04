package application;


public class Step<E> {

	int own_box = 0;
	int previous_box = 0;
	char status;
	
	/** Constructor of Step
	 * @param own_box
	 * @param previous_box
	 * @param status
	 */
	public Step(int own_box, int previous_box, char status) {
		super();
		this.own_box = own_box;
		this.previous_box = previous_box;
		this.status = status;
	}
	
	/**Set the value of the actual box with his hashcode
	 * @param x coord X of the actual box
	 * @param y coord Y of the actual box
	 */
	public void Set_Own_Box(int x, int y)
	{
		this.own_box = Coordonnees.hashCode(x, y);
	}

	/**Set the value of the previous box with his hashcode
	 * @param x coord X of the previous box
	 * @param y coord Y of the previous box
	 */
	public void Set_Previous_Box(int x, int y)
	{
		this.previous_box = Coordonnees.hashCode(x, y);
	}
	
	/**Set the value of the previous box with his hashcode
	 * @param hash hashcode of the previous box
	 */
	public void Set_Previous_Box(int hash)
	{
		this.previous_box = hash;
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
	
	/**
	 * @return the value of status (char)
	 * sta = 'w' if the box is a wall
	 * sta = 'e' if the box is empty
	 * sta = 's' if the box is the start box
	 * sta = 'a' if the box is the finish box
	 */
	public char Get_Status()
	{
		return this.status;
	}
	
	/**
	 * @return the value of the hashcode of the actual box
	 */
	public int Get_Own_Box()
	{
		return this.own_box;
	}
	
	/**
	 * @return the value of the hashcode of the previous box
	 */
	public int Get_Previous_Box()
	{
		return this.previous_box;
	}
}
