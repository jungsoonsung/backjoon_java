import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        for(int i=2;i<=n;i++){
            if(i % 3 == 0){
                setDp(i, 3);
            }

            if(i % 2 == 0){
                setDp(i, 2);
            }
            
            if(dp[i] == 0){
                dp[i] = 1 + dp[i-1];
            }
            else{
                dp[i] = min(dp[i], 1 + dp[i-1]);
            }
        }
        System.out.println(dp[n]);

    }

    // static void calc(int n, int cnt){
    //     if(dp[n] != 0){
    //         return dp[n];
    //     }

    //     if(n == 1){
    //         return ;
    //     }

    //     if(n % 3 == 0){
    //         setDp(n, 3);
    //     }
    //     else if(n % 2 == 0){
    //         setDp(n, 2);
    //     }
    //     else{
    //         if(dp[n] == 0){
    //             dp[n] = 1 + dp[n-1];
    //         }
    //         else{
    //             dp[n] = min(dp[n], 1 + dp[n-1]);
    //         }
    //     }
    // }

    static int min(int n1, int n2){
        return n1 <= n2 ? n1 : n2;
    }

    static void setDp(int n, int div){
        if(dp[n] == 0){
            dp[n] = 1 + dp[n/div];
        }
        else{
            dp[n] = min(dp[n], 1 + dp[n/div]);
        }
    }
}