public class squareTwoarray {
    public static void main(String[] args) {
        int n=8;
        String[][] array = new String[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==0 || j==0 || i==n-1 || j==n-1){
                    array[i][j]="*";
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }


}