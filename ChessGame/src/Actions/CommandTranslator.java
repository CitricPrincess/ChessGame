package Actions;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Parts.*;

public class CommandTranslator
{

	/**
	 * @param args
	 */
	
	public static ArrayList<String> ManyCommands(String file)
	{
		ArrayList<String> allCommands = new ArrayList<String>();
		try
        {
	        Scanner Scan = new Scanner(new File(file));
	        while(Scan.hasNext())
	        {
	        	allCommands.add(acceptCommands(Scan.nextLine()));
	        }
        } catch (FileNotFoundException e)
        {
	        System.out.println("Could not find file");
        }
		
		return allCommands;
		
	}

		public static String acceptCommands(String command)
		{
			String result = "";
			Pattern tomatch = Pattern.compile("[QKNRBPqknrbp][dl][a-h][1-8]");
			Matcher piece = tomatch.matcher(command);
			if(piece.matches())
			{
				result = placePiece(command);
			}
			tomatch = Pattern.compile("[a-h][1-8] [a-h][1-8]");
			piece = tomatch.matcher(command);
			if(piece.matches())
			{
				result = movePiece(command);
			}
			if(result.equals(""))
			{
				result = otherMove(command);
			}
					
					return result;
		}
		
		private static String placePiece(String command)
		{
			char Type = command.charAt(0);
			char Color = command.charAt(1);
			String loc = command.substring(2);
			Piece placed = pieceaddition(Type,Color,loc);
			return placed.getColor() + " " + placed.getName() + " has been placed at " + placed.getLocation();
		}
		private static String movePiece(String command)
		{
			String happened = "";
			String primeloc = command.substring(0,2);
			String secondloc = command.substring(3);
			boolean valid = false;
			Piece moved = null;
			for(Piece p : PlayGame.Pieces)
			{
				if( p.getLocation().equals(primeloc))
				{
					valid = true;
					moved = p;
				}
			}
			if(valid)
			{
				happened = "piece on " + primeloc + " moved to " + secondloc;
				moved.move(secondloc);
			}else
			{
				happened = "There is no piece to move!";
			}
			
			return happened;
		}
		private static String otherMove(String command)
		{
			String complete = "";
			boolean valid = false;
			Pattern tomatch = Pattern.compile("[a-h][1-8] [a-h][1-8] [a-h][1-8] [a-h][1-8]");
			Matcher piece = tomatch.matcher(command);
			if(piece.matches())
			{
				String primeloc1 = command.substring(0,2);
				String secondloc1 = command.substring(3);
				String primeloc2 = command.substring(3,5);
				String secondloc2 = command.substring(6);
				boolean validrook = false;
				boolean validking = false;
				Piece movedfirst = null;
				for(Piece p : PlayGame.Pieces)
				{
					if( p.getLocation().equals(primeloc1) || p.getLocation().equals(primeloc2))
					{
							if(p.getName().equals("Rook") && !p.hasMoved())
							{
								validrook = true;
							}
							if(p.getName().equals("King") && !p.hasMoved())
							{
								validking = true;
							}
					}
				}
				if(validking && validrook)
				{
					complete = "The castling move is used. " +
							"\n The king and rook on " + primeloc1 + " and " + primeloc2 + 
							" have moved to " + secondloc1 + " and " + secondloc2;
				}

			}
			if(complete.equals(""))
			{
				complete = "This is not a valid move";
			}
			return complete;
		}
		private static Piece pieceaddition(char type, char side, String loc)
		{
			Piece toadd;
			switch(Character.toUpperCase(type))
			{
				case 'Q':
					toadd= new Queen(side,loc);
					break;
				case 'K':
					toadd= new King(side,loc);
					break;
				case 'N':
					toadd= new Knight(side,loc);
					break;
				case 'R':
					toadd = new Rook(side,loc);
					break;
				case 'B':
					toadd = new Bishop(side,loc);
					break;
				default:
					toadd = new Pawn(side,loc);
					break;	
			}
			PlayGame.Pieces.add(toadd);
			return toadd;
		}

}
