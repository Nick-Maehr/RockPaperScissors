/**
 * Plays rock 1st then whatever beat the opponent's last move
 */
public class BeatOpponent implements Player

{
    private static String name = "BeatOpponent";
    // private static String strategy = "Play rock then whatever beat the opponent's last move";

    public String move(String [] myMoves, String [] opponentMoves, int myScore, int opponentScore)
    {
      int index = findMoveIndex(myMoves);
      if(index == 0)
      {
        return "r";
      }
      String opponentMove = opponentMoves[index - 1];
      if(opponentMove.equals("r"))
      {
        return "p";
      }
      else if(opponentMove.equals("p"))
      {
        return "s";
      }
      else
      {
        return "r";
      }
    }

    public String getName()
    {
        return name;
    }

    private static int findMoveIndex(String [] moves)
    {
      for(int i=0; i < moves.length; i++) 
      {
        if(moves[i] == null)
        {
          return i;
        }
      }
      return moves.length;
    }
}
