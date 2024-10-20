import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mentionStatics {
    public static void main(String[] args) {
        String[] members = {"id123", "id7"};
        String[] messages = {
                "Hey @id123,@id7 this",
                "@id7 this"
        };
        System.out.println(mentioned(members, messages));
    }

    public static List<String> mentioned(String[] members, String[] messages){
        Map<String, Integer> mentionCount = new HashMap<>();

        // Initialize the mention count for all members to 0
        for (String member : members) {
            mentionCount.put(member, 0);
        }

        // Regular expression to extract mentioned ids
        Pattern mentionPattern = Pattern.compile("@(id\\d{1,3})(,id\\d{1,3})*");

        for (String message : messages) {
            Matcher matcher = mentionPattern.matcher(message);
            Set<String> mentionedInThisMessage = new HashSet<>();

            // Find all mentions in the message
            while (matcher.find()) {
                // Split mentions by commas and add to the set
                String[] ids = matcher.group().substring(1).split(",");
                mentionedInThisMessage.addAll(Arrays.asList(ids));
            }

            // Update mention counts, counting each mentioned user only once per message
            for (String id : mentionedInThisMessage) {
                if (mentionCount.containsKey(id)) {
                    mentionCount.put(id, mentionCount.get(id) + 1);
                }
            }
        }

        // Create a list of results in the required format
        List<String> result = new ArrayList<>();
        for (String member : mentionCount.keySet()) {
            result.add(member + " = " + mentionCount.get(member));
        }

        // Sort the result: first by mention count (descending), then by user id (lexicographically)
        result.sort((a, b) -> {
            int countA = Integer.parseInt(a.split(" = ")[1]);
            int countB = Integer.parseInt(b.split(" = ")[1]);
            if (countA != countB) {
                return Integer.compare(countB, countA); // Sort by count in descending order
            } else {
                return a.compareTo(b); // Sort by user id lexicographically
            }
        });

        return result;
//        // List to String array
//         String[] array = list.toArray(new String[0]);
    }
}
