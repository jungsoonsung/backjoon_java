import java.io.*;

class Main {
    static int DIV = 10_007;
    static int[] mDp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        init(n);
        bottumUp(n);

        System.out.println(mDp[n]);
    }
    
    static void init(int n){
        mDp = new int[n + 1];
        mDp[1] = 1;
        if(n > 1)
            mDp[2] = 2;
    }

    static void bottumUp(int n){
        for(int i = 3; i <= n; i++){
            mDp[i] = (mDp[i-1] + mDp[i-2]) % DIV;
        }
    }
}