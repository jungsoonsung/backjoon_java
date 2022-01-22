import java.io.*;

class Main{
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        
        // buttom up
        //bottumUp(n);
        //System.out.println(dp[n]);

        // top down
        if(n == 1){
            System.out.println(0);
            return;
        }
        dp[2] = 1;
        System.out.println(topDown(n));
    }

    static int topDown(int idx){
        if(idx < 2){
            return 0;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        
        if(idx % 3 == 0){
            dp[idx] = getMin(dp[idx], 1 + topDown(idx / 3));
        }
        if(idx % 2 == 0){
            dp[idx] = getMin(dp[idx], 1 + topDown(idx / 2));
        }
        dp[idx] = getMin(dp[idx], 1 + topDown(idx - 1));

        return dp[idx];
    }

    static void bottumUp(int n){
        for(int i=2; i<=n; i++){
            if(i % 3 == 0){
                dp[i] = getMin(dp[i], 1 + dp[i / 3]);
            }
            if(i % 2 == 0){
                dp[i] = getMin(dp[i], 1 + dp[i / 2]);
            }
            dp[i] = getMin(dp[i], 1 +  dp[i-1]);
        }
    }

    static int getMin(int a, int b){
        if(a == 0){
            return b;
        }
        return a > b ? b : a;
    }
}