/*
 *https://leetcode.com/problems/unique-paths/
 */
class Solution {
    int costs[][];
    public int uniquePaths(int m, int n) {

        costs = new int[m][n];
        return findCost(m - 1, n - 1);
    }

    public int findCost(int x, int y){

        if((x == 0 && y == 1) || (y == 0 && x == 1) || (x == 0 && y == 0)){
            return 1;
        }
        else{
            if(costs[x][y] == 0){

                int cost1 = 0, cost2 = 0;
                if(x > 0){
                    cost1 = findCost(x - 1, y);
                }
                if(y > 0){
                    cost2 = findCost(x, y - 1);
                }
                costs[x][y] = cost1 + cost2;
            }
            return costs[x][y];
        }
    }
}