PROJECT CODE
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class Main {

public static void main(String[] args) {
System.out.println ("\t\t\t\t\t\tWelcome To Snakes And Ladders\n\n");
System.out.println ("\t\t\t\t\t\t\tInstructions:");
System.out.println ("\t\t\t This program will simulate a regular snakes and ladders
game, where you will be");
System.out.println ("\t\t\t facing the computer. You and the computer start at
square 1, and the first one to");
System.out.println ("\t\t\t square 100 wins, however, there will be preset squares
which will be the snakes or ladders.");
System.out.println ("\t\t\t Once you land on top of a snake you go down a few
squares, and move up if you land");
System.out.println ("\t\t\t\t\t\t on the bottom of a ladder. Good Luck and Have
FUN!!!");
SnakeNLadder s = new SnakeNLadder();
s.startGame();
}
}
class SnakeNLadder
{
final static int WINPOINT = 100;
static Map<Integer,Integer> snake = new HashMap<Integer,Integer>();
static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();
{
snake.put(99,54);
snake.put(70,55);
snake.put(52,42);
snake.put(25,2);
snake.put(95,72);
ladder.put(6,25);
ladder.put(11,40);
ladder.put(60,85);
ladder.put(46,90);
PROJECT CODE
ladder.put(17,69);
}
public int rollDice()
{
int n = 0;
Random r = new Random();
n=r.nextInt(7);
return (n==0?1:n);
}
public void startGame()
{
int player1 =0, player2=0;
int currentPlayer=-1;
Scanner s = new Scanner(System.in);
String str;
int diceValue =0;
do
{
System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER
TURN":"\n\nSECOND PLAYER TURN");
System.out.println("Press r to roll Dice");
str = s.next();
diceValue = rollDice();
if(currentPlayer == -1)
{
player1 = calculatePlayerValue(player1,diceValue);
System.out.println("First Player :: " + player1);
System.out.println("Second Player :: " + player2);
System.out.println("------------------");
if(isWin(player1))
{
System.out.println("First player wins");
return;
}
}
else
{
player2 = calculatePlayerValue(player2,diceValue);
System.out.println("First Player :: " + player1);
System.out.println("Second Player :: " + player2);
PROJECT CODE
System.out.println("------------------");
if(isWin(player2))
{
System.out.println("Second player wins");
return;
}
}
currentPlayer= -currentPlayer;
}while("r".equals(str));
}
public int calculatePlayerValue(int player, int diceValue)
{
player = player + diceValue;
if(player > WINPOINT)
{
player = player - diceValue;
return player;
}
if(null!=snake.get(player))
{
System.out.println("swallowed by snake");
player= snake.get(player);
}
if(null!=ladder.get(player))
{
System.out.println("climb up the ladder");
player= ladder.get(player);
}
return player;
}
public boolean isWin(int player)
{
return WINPOINT == player;
}
}
