package Parts;

public abstract class Piece
{

	/**
	 * @param args
	 */
	public enum Side {d,l}
	private Side Color;
	private String  Location;
	private char Symbol;
	private String Name;
	boolean hasmoved = false;
	public Piece(char color, String location, String name, char symbol)
	{
		if(color == 'l')
		{
			Color = Side.l;
		}else
		{
			Color = Side.d;
		}
		Location = location;
		Symbol = symbol;
		Name = name;
	}
	
	public char getSymbol()
	{
		if(Color.equals( Side.d))
		{
			Character.toLowerCase(Symbol);
		}else
		{
			Character.toUpperCase(Symbol);
		}
		return Symbol;
	}
	
	public String getColor()
	{
		String colors = "";
		if(Color.equals( Side.d))
		{
			colors="Dark";
		}else
		{
			colors="light";
		}
		return colors;
	}
	
	public String getName()
	{
		return Name;
	}
	
	//Location will be changed from a string in future modules, it is merely starting as a string to 
	//make sure current code can work until true location is implemented.
	public String getLocation()
	{
		return Location;
	}

	public void setLocation(String loc)
    {

		Location = loc;
	    
    }
	public void move(String loc)
	{
		if(!hasmoved)
		{
			hasmoved = true;
		}
		setLocation(loc);
	}
	
	public boolean hasMoved()
	{
		return hasmoved;
	}
}
