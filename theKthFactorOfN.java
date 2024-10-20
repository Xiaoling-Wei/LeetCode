public class theKthFactorOfN {
    public static void main(String[] args) {
        int n=7, k=2;
        System.out.println(kthFactor(n, k));
    }

    public static int kthFactor(int n, int k) {
        int[] res = new int[100];

        int m=0;

            for(int i=1;i<=n;i++){
                if(n%i == 0){
                    res[m++] = i;
                }
            }
        return res[k-1]==0? -1 : res[k-1];
    }
}
