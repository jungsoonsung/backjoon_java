import java.io.*;

class Main{
    static int DIVIDER = 10_007;
    static int[] mDp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        init(n);
        //bottumUp(n);
        //System.out.println(mDp[n]);

        System.out.println(topDown(n));
    }

    static void init(int n){
        mDp = new int[n+1];
        mDp[1] = 1;
        if(n>1)
            mDp[2] = 3;
    }

    static int topDown(int idx){
        if(mDp[idx] != 0){
            return mDp[idx];
        }

        mDp[idx] = (topDown(idx-2) + topDown(idx-2) + topDown(idx-1)) % DIVIDER;
        return mDp[idx];
    }

    static void bottumUp(int n){
        for(int i = 3; i <= n; i++){
            mDp[i] = (mDp[i-2] + mDp[i-2] + mDp[i-1]) % DIVIDER;
        }
    }
}