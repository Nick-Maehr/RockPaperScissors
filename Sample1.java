import java.util.HashMap;
import java.util.Map;

public class Sample1 implements Player

{
    private static String name = "Sample1";
    // private static String strategy = "Diagnose, analyze responses, and counter";

    private int totalMoves = 0; 
    private int diagnosisLimit = 10; 
    private int analysisInterval = 10; 

    private Map<String, Integer> opponentMoveCounts = new HashMap<>(); 
    private Map<String, String> lastRoundOutcome = new HashMap<>(); 

    public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
        totalMoves++;

        if (totalMoves <= diagnosisLimit) {
            String diagnosticMove = cycleMoves(totalMoves);
            recordOpponentMoves(opponentMoves);
            return diagnosticMove;
        }
       
        if (totalMoves % analysisInterval == 0 && totalMoves > diagnosisLimit) {
            analyzeOpponentReactions(myMoves, opponentMoves);
        }
        recordOpponentMoves(opponentMoves);
        String predictedResponse = predictOpponentMove();
        return counterMove(predictedResponse);
    }

    public String getName() {
        return name;
    }

    private String cycleMoves(int moveNumber) {
        switch (moveNumber % 3) {
            case 1:
                return "r";
            case 2:
                return "p";
            default:
                return "s";
        }
    }

    private void recordOpponentMoves(String[] opponentMoves) {
        for (String move : opponentMoves) {
            if (move != null) {
                opponentMoveCounts.put(move, opponentMoveCounts.getOrDefault(move, 0) + 1);
            }
        }
    }

    private void analyzeOpponentReactions(String[] myMoves, String[] opponentMoves) {
        for (int i = 1; i < myMoves.length && i < opponentMoves.length; i++) {
            String myMove = myMoves[i - 1];
            String opponentMove = opponentMoves[i - 1];
    
            if (myMove == null || opponentMove == null) {
                continue; 
            }
    
            String outcome = determineOutcome(myMove, opponentMove);
    
            if (i < opponentMoves.length - 1 && opponentMoves[i] != null) {
                lastRoundOutcome.put(outcome, opponentMoves[i]);
            }
        }
    }

    private String determineOutcome(String myMove, String opponentMove) {
        if (myMove == null || opponentMove == null) {
            return "unknown"; 
        }
    
        if (myMove.equals(opponentMove)) return "tie";
        if ((myMove.equals("r") && opponentMove.equals("s")) ||
            (myMove.equals("p") && opponentMove.equals("r")) ||
            (myMove.equals("s") && opponentMove.equals("p"))) {
            return "win";
        }
        return "lose";
    }

    private String predictOpponentMove() {
        String lastOutcome = "win"; 
        return lastRoundOutcome.getOrDefault(lastOutcome, findMostCommon(opponentMoveCounts));
    }

    private String findMostCommon(Map<String, Integer> counts) {
        String mostCommon = "r"; 
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommon;
    }

    private String counterMove(String move) {
        switch (move) {
            case "r":
                return "p"; 
            case "p":
                return "s"; 
            case "s":
                return "r"; 
            default:
                return "r"; 
        }   
    }
}
