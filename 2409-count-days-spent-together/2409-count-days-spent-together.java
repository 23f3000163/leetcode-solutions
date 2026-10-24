class Solution {
    
    private int findDaysOfYear(String day, int[] totalMonthDays) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date  = Integer.parseInt(day.substring(3));
        return totalMonthDays[month - 1] + date;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int[] totalMonthDays = new int[13];
        totalMonthDays[1] = 31;
        for (int i = 2; i <= 12; i++) {
            totalMonthDays[i] = totalMonthDays[i - 1] + month[i - 1]; 
        }

        int arriveAliceDay = findDaysOfYear(arriveAlice, totalMonthDays); 
        int leaveAliceDay  = findDaysOfYear(leaveAlice, totalMonthDays);
        int arriveBobDay   = findDaysOfYear(arriveBob, totalMonthDays);
        int leaveBobDay    = findDaysOfYear(leaveBob, totalMonthDays);         

        int overlap = Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1;

        return Math.max(overlap, 0);
    }
}