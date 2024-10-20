import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingScheduler {

    public static int findEarliestMeetingTime(List<List<int[]>> schedules, int length) {
        List<int[]> mergedMeetings = new ArrayList<>();
        for (List<int[]> employeeSchedule : schedules) {
            for (int[] meeting : employeeSchedule) {
                mergedMeetings.add(meeting);
            }
        }
        Collections.sort(mergedMeetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] current = mergedMeetings.get(0);
        for (int i = 1; i < mergedMeetings.size(); i++) {
            int[] next = mergedMeetings.get(i);
            if (current[1] >= next[0]) {  // If the meetings overlap, merge them
                current[1] = Math.max(current[1], next[1]);
            } else {  // Otherwise, add the current merged meeting and move to the next
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);  // Add the last meeting block

        int dayStart = 0;
        int dayEnd = 24 * 60;

        if (merged.get(0)[0] - dayStart >= length) {
            return dayStart;
        }

        for (int i = 1; i < merged.size(); i++) {
            int gapStart = merged.get(i - 1)[1];
            int gapEnd = merged.get(i)[0];
            if (gapEnd - gapStart >= length) {
                return gapStart;  // Return the earliest gap that fits
            }
        }

        if (dayEnd - merged.get(merged.size() - 1)[1] >= length) {
            return merged.get(merged.size() - 1)[1];
        }


        return -1;
    }

    public static void main(String[] args) {
        List<List<int[]>> schedules = new ArrayList<>();
        schedules.add(Arrays.asList(new int[]{60,150}, new int[]{180,240}));
        schedules.add(Arrays.asList(new int[]{0,210}, new int[]{360, 420}));

        int length = 120;
        int earliestTime = findEarliestMeetingTime(schedules, length);

        if (earliestTime != -1) {
            System.out.println("Earliest possible meeting time: " + earliestTime);
        } else {
            System.out.println("No available time slot for the meeting.");
        }
    }
}
