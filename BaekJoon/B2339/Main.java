package B2339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    //6:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        map = new int[tc][tc];

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < tc; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = partition(0, 0, tc, tc, -1);

        sb.append(result == 0 ? -1 : result);
        System.out.println(sb);
    }

    public static int partition(int xStart, int yStart, int xEnd, int yEnd, int direction) {
        int jewelCnt = 0;
        int impuritiesCnt = 0;
        for(int i = yStart; i < yEnd; i++){
            for(int j = xStart; j < xEnd; j++){
                if(map[i][j] == 1) impuritiesCnt++;
                else if(map[i][j] == 2) jewelCnt++;
            }
        }

        if(jewelCnt == 1 && impuritiesCnt == 0) return 1;
        else if(jewelCnt == 0) return 0;

        int answer = 0;
        for(int i = yStart; i < yEnd; i++){
            for(int j = xStart; j < xEnd; j++){
                if(map[i][j] == 1) {

                    // 가로
                    if(direction != 0){
                        boolean isValid = true;
                        for(int k = xStart; k <xEnd; k++){
                            if(map[i][k] == 2) isValid = false;
                        }
                        if(isValid){
                            answer += partition(xStart, yStart, xEnd, i, 0) *
                                    partition(xStart, i + 1, xEnd, yEnd, 0);
                        }
                    }

                    // 세로
                    if(direction != 1){
                        boolean isValid = true;
                        for(int k = yStart; k <yEnd; k++){
                            if(map[k][j] == 2) isValid = false;
                        }
                        if(isValid){
                            answer += partition(xStart, yStart, j, yEnd, 1) *
                                    partition(j + 1, yStart, xEnd, yEnd, 1);
                        }
                    }
                }
            }
        }

        return answer;
    }

    static class Point {
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
