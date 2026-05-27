import java.util.Random;
/**
 * Sample2 player will first play rock, then all scissors
 */
public class Sample2 implements Player

{
    private static String name = "Sample2";
    // private static String strategy = "Start with paper, random every 4th move, then algortihm";

    public String move(String [] myMoves, String [] opponentMoves, int myScore, int opponentScore)
    {
        Random rand = new Random();
        int count = 0;
        int rockCount = 0;
        int paperCount = 0;
        String finalMove = "";
            if(count == 0){
                finalMove = "p";
            }
            if(count % 4 == 0){
                int randomMove = rand.nextInt(3);
                if(randomMove == 1){
                    finalMove = "r";
                }
                if(randomMove == 2){
                    finalMove = "p";
                }
                if(randomMove == 3){ 
                    finalMove = "s";
                }
            }
            if(opponentMoves[count] == "r"){
                rockCount++;
                if(rockCount % 2 == 0){
                    finalMove = "r";
                }
                finalMove = "s";
            }
            if(opponentMoves[count] == "p"){
                paperCount++;
                if(paperCount % 3 == 0){
                    finalMove = "s";
                }
                finalMove = "r";
            }
            if(opponentMoves[count] == "s"){
                if((count > 1) && opponentMoves[count-1] == "r"){
                    finalMove = "p";
                }
                finalMove = "r";
            }
        count++;
        return finalMove;
    }

    public String getName()
    {
        return name;
    }
}
