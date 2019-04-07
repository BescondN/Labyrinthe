package application;


public class Step<E> implements Comparable<Step<E>>{

	private E own_box;
	private Step<E> previous_box;
	private int longueurDepart;
	private int longueurArrivee;

	
	
	/** Constructor of Step
	 * @param own_box
	 * @param previous_box
	 * @param status
	 */
	public Step(E e) {
		super();
		own_box = e;
		longueurDepart=0;
		longueurArrivee=0;
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
	
	public int getLongueurDepart() {
		return longueurDepart;
	}

	public void setLongueurDepart(int longueurDepart) {
		this.longueurDepart = longueurDepart;
	}

	public int getLongueurArrivee() {
		return longueurArrivee;
	}

	public void setLongueurArrivee(int longueurArrivee) {
		this.longueurArrivee = longueurArrivee;
	}
	public int getFValue()
	{
		return longueurDepart + longueurArrivee;
	}

	@Override
	public int compareTo(Step<E> o) {

		if (getFValue() < o.getFValue() ) return -1 ;
		else if ( getFValue() == o.getFValue()) return 0 ;
		else return 1 ;
	}

	
}
