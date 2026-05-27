/**
 * Play random, paper, rock, then repeat
 */
public class RandomThird implements Player {

  private String[] items = {"r", "p", "s"};
  private String name = "Random every third";
  
  @Override
  public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
    int roundIndex = roundIndex(myMoves);
    if(roundIndex % 3 == 0)
    {
      int place = (int) (Math.random() * 3);
      // System.out.println(place);
      return items[place];
    }
    if((roundIndex + 1) % 3 == 0)
    {
      return "r";
    }
    return "p";
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return name;
  }

  private int roundIndex(String[] moves)
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
