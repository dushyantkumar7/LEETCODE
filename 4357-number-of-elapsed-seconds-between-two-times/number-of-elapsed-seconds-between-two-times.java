class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return toSeconds(endTime) - toSeconds(startTime);
    }
    private int toSeconds(String t){
        return (t.charAt(0) - '0') * 36000
        +(t.charAt(1) - '0') * 3600
        +(t.charAt(3) - '0') * 600
        +(t.charAt(4) - '0') * 60
        +(t.charAt(6) - '0') * 10
        +(t.charAt(7) - '0');
    }
}