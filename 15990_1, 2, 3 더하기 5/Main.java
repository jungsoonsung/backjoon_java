import java.io.*;

class Main {

    static int DIV = 1000000009;
    static int MAX = 100000;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] DP = new int[MAX+1][4];
        DP[1][1] = DP[2][2] = DP[3][3] = DP[3][1] = DP[3][2] = 1;
        for(int n=4; n<MAX+1; n++){
            DP[n][1] = DP[n-1][2] + DP[n-1][3];
            DP[n][2] = DP[n-2][1] + DP[n-2][3];
            DP[n][3] = DP[n-3][1] + DP[n-3][2];
        }

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=0; t<TC; t++){
            int n = Integer.parseInt(br.readLine());
            int res = (DP[n][1] + DP[n][2] + DP[n][3]) % DIV;
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());

        br.close();
    }
}