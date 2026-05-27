/**
 * Always paper
 * 
 */
public class AlwaysPaper implements Player
{
    private static String name = "AlwaysPaper";

    public String move(String [] myMoves, String [] opponentMoves, int myScore, int opponentScore)
    {
        
        return "p";
    }

    public String getName()
    {
        return name;
    }
}

