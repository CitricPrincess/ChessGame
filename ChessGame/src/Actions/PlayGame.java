package Actions;

import java.util.ArrayList;

import Parts.*;

public class PlayGame 
{

	/**
	 * @param args
	 */
	public static ArrayList<Piece> Pieces;
	public static void main(String[] args) 
	{
		Pieces = new ArrayList<Piece>();
		//SimpleBoard board = new SimpleBoard();
	//	System.out.print(board.toString());
		String filename = args[0];
		for(String move: CommandTranslator.ManyCommands(filename))
		{
			System.out.println(move);
		}
		
	}

}
