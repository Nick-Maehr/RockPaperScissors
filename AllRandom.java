/**
 * Always pick random
 */
public class AllRandom {
  
  private static String[] items = {"r", "p", "s"};
  private static String name = "Always Random";

  /** 
   * returns a random choice from list of "r", "p", and "s"
  */
  public String move(String [] myMoves, String [] opponentMoves, int myScore, int opponentScore)
  {
    return items[(int) (Math.random() * 3)];
  }

  public String getName()
    {
        return name;
    }
}
