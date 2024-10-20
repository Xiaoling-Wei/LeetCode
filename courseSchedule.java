import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSchedule {
    public static void main(String[] args) {
        int num = 3;
        int[][] pre = {{0,1},{2,0}};
        System.out.println(canFinish(num, pre));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        int[] ine = new int[numCourses];
        for(int i=0;i< prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            ine[a]++;
            edges.get(b).add(a);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if (ine[i] == 0){
                queue.offer(i);
            }
        }

        int visisted = 0;
        while(!queue.isEmpty()){
            visisted++;
               int cur = queue.poll();
            for (Integer e : edges.get(cur)) {
                ine[e]--;
                if (ine[e] == 0){
                    queue.offer(e);
                }
            }
            edges.get(cur).clear();
        }
        return visisted == numCourses;

    }
}
