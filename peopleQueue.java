import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class peopleQueue {
    public static void main(String[] args) {
        int[] times = {4, 400, 450, 500};
        int[] result = people(times);
        System.out.println(Arrays.toString(result));
    }

    public static int[] people(int[] times) {
        int[] result = new int[times.length];
        Queue<Integer> queue = new LinkedList<>();

        int processos = 0;

        result[0] = times[0]+300;
        for (int i = 1; i < times.length; i++) {
            int currentTime = times[i];
            int lastFinishTime = result[i-1];

            if (queue.size() >= 10){
                result[i] = currentTime;
                continue;
            }
            if (currentTime >= lastFinishTime) {
                result[i] = currentTime+300;
                if (processos != 0) {
                    processos--;
                }
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            }else {
                result[i] = lastFinishTime+300;
                queue.offer(currentTime);
                processos++;
            }
        }

        return result;
    }
}
