package recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

    public static void main(String[] args) {
        String input = "1221622121";
        List<String> result = restoreIpAddresses(input);
        result.stream().forEach(s->System.out.println(s));

    }

    public static List<String> restoreIpAddresses(String rawIpString) {
        List<String> restoredIps = new ArrayList<>();
        restoreIps(0, 0, new int[4], rawIpString, restoredIps);

        return restoredIps;
    }

    private static void restoreIps(
            int progressIndex,
            int currentSegment,
            int[] ipAddressSegments,
            String rawIpString,
            List<String> restoredIps
    ) {
        if (currentSegment == 4 && progressIndex == rawIpString.length()) {
            restoredIps.add(buildIpStringFromSegments(ipAddressSegments));
        } else if (currentSegment == 4) {
            return;
        }
        for (int segLength = 1; segLength <= 3 && progressIndex + segLength <= rawIpString.length(); segLength++) {

            // Calculate 1 index past where the segment ends index-wise in the original raw ip string
            int onePastSegmentEnd = progressIndex + segLength;

            // Extract int value from our snapshot from the raw ip string
            String segmentAsString = rawIpString.substring(progressIndex, onePastSegmentEnd);
            int segmentValue = Integer.parseInt(segmentAsString);

            // Check the "snapshot's" validity - if invalid break iteration
            if (segmentValue > 255 || segLength >= 2 && segmentAsString.charAt(0) == '0') {
                break;
            }

            // Add the extracted segment to the working segments
            ipAddressSegments[currentSegment] = segmentValue;

            // Recurse on the segment choice - when finished & we come back here, the next loop iteration will try another segment
            restoreIps(progressIndex + segLength, currentSegment + 1, ipAddressSegments, rawIpString, restoredIps);
        }
    }

    private static String buildIpStringFromSegments(int[] ipAddressSegments) {
        return ipAddressSegments[0] + "." + ipAddressSegments[1] + "." + ipAddressSegments[2] + "." + ipAddressSegments[3];
    }



}
