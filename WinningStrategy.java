/**
 * Calls Main.main() for each round. Uses the simulated opponents' moves to beat the real opponents
 * Will print to the terminal, the real and false outputs are labled as such
 */
public class WinningStrategy implements Player {

  private String name = "WinningStrategy";
  private String strategy = "Simulate opponents' moves and play what beats them";
  private static int rounds;
  private static int depth = 0;
  private static int minorTweak = 0;
  private static String[] moveLogs;
  private int oppIndex = -1;
  private int selfDepth;

  public WinningStrategy() {
    selfDepth = depth;
    depth++;
    // System.out.println(selfDepth);

  }

  public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore)
  {
    int roundIndex = roundIndex(myMoves);


    if(selfDepth == 0)
    {
      firstPlay(myMoves, roundIndex);
    }

    if(roundIndex > rounds)
    {
      return "r";
    }

    if(selfDepth == -1)
    {
      if(roundIndex == 0)
      {
        oppIndex++;
      }
      moveLogs = new String[oppIndex + 1];
      for(int i=0; i < oppIndex + 1; i++)
      {
        String tempString = "";
        for(int k = 0; k < rounds + 1; k++)
        {
          tempString += "r";
        }
        moveLogs[i] = tempString;
      }
    }

    else if(selfDepth != 0)
    {


      if(roundIndex == 0)
      {
        oppIndex++;
        if(myMoves.length < selfDepth && oppIndex == 0)
        {
          minorTweak--;
          depth--;
        }
      }

      else if(roundIndex == selfDepth)
      {
        String oppLastMove = opponentMoves[roundIndex - 1];
        moveLogs[oppIndex] = setAtIndex(moveLogs[oppIndex], selfDepth - 1, moveThatBeats(oppLastMove));
      }
    }
    return moveLogs[oppIndex].substring(roundIndex, roundIndex + 1);
  }

  public String getName() {return name;}

  public String getStrategy() {return strategy;}


  private void firstPlay(String[] myMoves, int roundIndex)
  {
    rounds = myMoves.length;
    if(roundIndex == 0)
    {
      oppIndex++;
      makeMoveLogs();
      // for(int i = 0; i < moveLogs.length; i++)
      // {
      //   System.out.println(moveLogs[i]);
      // }
      System.out.println("\n\n=============\nEND OF SIMULATE GAMES\nEverything printed after this is not from " + name + ".\n=============\n\n");
    }
  }

  private static int roundIndex(String[] moves)
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

  private static String moveThatBeats(String move)
  {
    String options = "rps";
    if(options.indexOf(move) == -1)
    {
      return "r";
    }
    
    else if(move.equals("s"))
    {
      return "r";
    }
    else
    {
      return options.substring(options.indexOf(move) + 1, options.indexOf(move) + 2);
    }
  }

  private String setAtIndex(String a, int i, String b)
  {
    String str = a.substring(0, i);
    str += b + a.substring(i + 1);
    return str;
  }

  private static void simulateMain(boolean incrementDepth)
  {
    if(!incrementDepth)
    {
      depth = -1;
    }
    Main.main(new String[0]);
    if(!incrementDepth)
    {
      depth = 1;
    }
  }

  private void makeMoveLogs()
  {
    System.out.println("\nIgnore next score output. It is a simulated copy - NOT THE ORIGINAL GAME (see WinningStrategy.simulateMain())");
    simulateMain(false);

    for(int i = 0; i < rounds + 2; i++)
    {
      minorTweak = 0;
      System.out.println("\nIgnore next score output. It is a simulated copy - NOT THE ORIGINAL GAME (see WinningStrategy.simulateMain()) " + i);
      simulateMain(true);
      i += minorTweak;
    }
  }

}
