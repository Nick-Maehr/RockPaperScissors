import java.util.*;
/**
 * This file was provided by the competition host.
 * Driver class, sets up game
 * Look to comments to see what you need to do to test your game
 */
public class Main
{
    public static void main(String [] args)
    {
        Player [] players = new Player[6];  //need to update array based on number of players
        boolean printsRun = false;   //printsRun is a boolean set to display moves as game goes, used for debugging
        
        //add players to game
        players[0] = new AllRandom();
        players[1] = new BeatOpponent();
        players[2] = new Sample1();
        players[3] = new Sample2();
        players[4] = new AlwaysPaper();
        players[5] = new WinningStrategy();
   
        //construct the game with the classes in the players array, calls on play and displays the score
        //DO NOT CHANGE
        Game newGame = new Game(players, printsRun);
        newGame.play();
        newGame.displayScore();
    }
}