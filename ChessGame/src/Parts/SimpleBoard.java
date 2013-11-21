package Parts;

public class SimpleBoard 
{
	
	private final String Emptyspace = "[-]";
	private static final  int BOARDSIZE = 8;
	private String[][] Board = new String[BOARDSIZE][BOARDSIZE];
	
	public SimpleBoard()
	{
		
	}
	
	public String toString()
	{
		int numfield = 8;
		String BoardPrint = "";
		for(int i = 0; i<Board[0].length; i++)
		{
			BoardPrint = BoardPrint + numfield;
			for(int j = 0; j<Board[0].length; j++)
			{
				if( Board[i][j] == null)
				{
					BoardPrint = BoardPrint + Emptyspace;
				}else
				{
					//BoardPrint = BoardPrint +"[" + Board[i][j].getReference().toUpperCase() + "]";
				}
			}
			BoardPrint = BoardPrint +"\n";
			numfield--;
		}
		char charfield ='a';
		for(int i = 0; i<Board[0].length; i++)
		{
			BoardPrint = BoardPrint + "  " + charfield;
			charfield++;
		}
		return BoardPrint;
		
	}

}
