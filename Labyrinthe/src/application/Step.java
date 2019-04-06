package application;


public class Step<E> {

	E own_box;
	Step<E> previous_box;
	char status;
	
	/** Constructor of Step
	 * @param own_box
	 * @param previous_box
	 * @param status
	 */
	public Step(E e) {
		super();
		own_box = e;
	}
	
	/**
	 * @return 
	 * @return the value of the hashcode of the actual box
	 */
	public E Get_Own_Box()
	{
		return this.own_box;
	}
	
	/**
	 * @return the value of the hashcode of the previous box
	 */
	public Step<E> Get_Previous_Box()
	{
		return this.previous_box;
	}

	public void Set_Previous_Box(Step<E> etape) {
		this.previous_box = etape;		
	}
}
