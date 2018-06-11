package tutorials.ctci;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}
/**
 * Given an array of  Player objects, write a comparator that sorts them in order of decreasing score. 
 * 
 * If  or more players have the same score, sort those players alphabetically ascending by name. 
 * 
 * To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method. 
 * 
 * In short, when sorting in ascending order, a comparator function returns 1 if a > b, -1 if a < b, and 0 if a == b.
 * 
 * Solution for https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 * 
 * @author polymath
 *
 */
public class PlayerSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        PlayerComparator checker = new PlayerComparator();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

class PlayerComparator implements Comparator<Player> {
    @Override
	public int compare(Player a, Player b) {
		if (a != null && b != null) {
			if (a.score > b.score) {
				return -1;
			} else if (a.score < b.score) {
				return 1;
			} else {
				return a.name.compareTo(b.name);
			}
		}
		return 0;
	}
}