package B11727;

import java.io.*;
import java.util.*;

public class Ex11727 {
	// 11 : 31
	
	static long[] dp = new long[1001];
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i < tc+1; i++) {
			dp[i] = dp[i-1]%10007 + 2*(dp[i-2]%10007);
			dp[i] %= 10007;
		}
		
		System.out.println(dp[tc]);
		
	}
}