public class canCompleteCircuit {
    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost){
        int n = gas.length;
        int count1 = 0;
        int count2 = 0;
        int current = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            count1+=gas[i];
            count2+=cost[i];
        }
        if (count1 != count2){
            return -1;
        }else{

            for (int i = 0; i < n; i++) {
                current += gas[i] - cost[i];
                if (current < 0){
                   start = i+1;
                   current = 0;
                }
            }
        }
        return start;

    }
}
