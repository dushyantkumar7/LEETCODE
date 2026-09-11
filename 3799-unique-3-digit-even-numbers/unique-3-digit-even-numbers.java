class Solution {

    
    public int totalNumbers(int[] digits) {
     int[] count = new int[10];
     for(int digit : digits){
        count[digit]++;
     }
     int validCount = 0;

     for(int num = 100; num <= 998; num += 2){
        int[] requiredCount = new int[10];
        int temp = num;

        while ( temp > 0){
            requiredCount[temp % 10]++;
            temp /= 10;
        }

        boolean canForm = true;
        for(int i = 0; i < 10; i++){
            if(requiredCount[i] > count[i]){
                canForm = false;
                break;
            }
        }
        if(canForm){
            validCount++;
        }
     }
     return validCount;
    }
}