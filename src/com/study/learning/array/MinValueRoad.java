package study.learning.array;

public class MinValueRoad {
    public static void main(String[] args) {
        int[][] road=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        method(road);
    }
    public static int method(int[][] road){
        int min=0;
        int[][] minRoad = new int[road.length][road[0].length];
        minRoad[0][0]=road[0][0];
        for(int i=1;i<minRoad[0].length;i++){
            minRoad[i][0]=minRoad[i-1][0]+road[i][0];
        }
        for(int j=1;j<minRoad.length;j++){
            minRoad[0][j]=minRoad[0][j-1]+road[0][j];
        }
        for(int i=1;i<minRoad.length;i++){
            for(int j=1;j<minRoad[0].length;j++){
                minRoad[i][j]=Math.min(minRoad[i-1][j],minRoad[i][j-1])+road[i][j];
            }
        }
        min=minRoad[minRoad.length-1][minRoad[0].length-1];
        return min;
    }
}
