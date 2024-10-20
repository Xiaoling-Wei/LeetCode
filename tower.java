public class tower {
    public static void main(String[] args) {
        int[] tower = {5,7,9,4,11};
        System.out.println(minNumber(tower));
    }

    public static int minNumber(int[] tower){
        int n = tower.length;
        int[] cT = new int[n];
        for (int i = 0; i < n; i++) {
            cT[i] = tower[i];
        }
        int index = 128;
        int min=0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (tower[i] > max){
                max = tower[i];
                index = i;
            }
        }
        if(index == 0){
            for (int i = 1; i < n; i++){
                while(tower[i]+1 != tower[i-1]){
                    tower[i]++;
                    min++;
                }
            }
        } else if (index == n-1) {
            for (int i = n-2; i >= 0; i--){
                while(tower[i]+1 != tower[i+1]){
                    tower[i]++;
                    min++;
                }
            }
        }else {
            int des=0;
            for (int i = 1; i <= index; i++){
                while(tower[i-1] != tower[i]+1){
                    tower[i-1]++;
                    des++;
                }
            }
            for (int i = index; i < n; i++){
                while(tower[i]+1 != tower[i-1]){
                    tower[i]++;
                    des++;
                }
            }
            int asc = 0;
            for (int i = 1; i <= index; i++){
                while(cT[i-1]+1 != cT[i] && cT[i] <= max+n){
                    cT[i-1]++;
                    asc++;
                }
            }
            for (int i = index; i < n; i++ ){
                while (cT[i-1]+1 != cT[i] && cT[i] <= max+n){
                    cT[i]++;
                    asc++;
                }
            }
            min = Math.min(asc,des);
        }
        return min;
    }
}