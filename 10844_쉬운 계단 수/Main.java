import java.io.*;

class Main{
    static int DIV = 1_000_000_000;
    static long DP[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        DP = new long[n+1][10];
        for(int i=1; i<=9; i++){
            DP[1][i] = 1;
        }

        long res = 0;
        for(int i=0; i<=9; i++){
            res += recursive(n, i);
        }

        System.out.println(res % DIV);
    }

    static long recursive(int idx, int v){
        if(idx == 1){
            return DP[idx][v];
        }

        if(DP[idx][v] > 0){
            return DP[idx][v];
        }

        if(v == 0){
            DP[idx][v] = recursive(idx-1, v+1);
        } 
        else if(v == 9){
            DP[idx][v] = recursive(idx-1, v-1);
        } 
        else{
            DP[idx][v] = recursive(idx-1, v-1) + recursive(idx-1, v+1);
        }
        
        return DP[idx][v] % DIV;
    }
}