import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class largestCommands {
    public static void main(String[] args) {
        String[] commands = {
                "goto bucketA",
                "create file1",
                "create file2",
                "goto bucketB",
                "create file1",
                "create file2",
                "create file3",
        };
        System.out.println(largestCommand(commands));
    }

    public static String largestCommand(String[] commands) {
        Map<String, Set<String>> map = new HashMap<>();

        String currentCommand = null;

        for (String command : commands) {
            if (command.startsWith("goto")){
                currentCommand = command.substring(5);
                map.putIfAbsent(currentCommand, new HashSet<>());
            }else if (command.startsWith("create")){
                if (currentCommand != null){
                    String filename = command.substring(7);
                    map.get(currentCommand).add(filename);
                }
            }
        }

        String bucket = null;
        int largest = 0;

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            int cur = entry.getValue().size();
            if (cur > largest){
                largest = cur;
                bucket = entry.getKey();
            }
        }
        return bucket;
    }
}
