class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0;
        int high = 0;
        int maxLength = -1;
        int k = 2;
        HashMap<Integer, Integer> fruit = new HashMap<>();
        
        for (high = 0; high < n; high++) {
            
            fruit.put(fruits[high], fruit.getOrDefault(fruits[high], 0) + 1);
            
            while (fruit.size() > k) {
                
                fruit.put(fruits[low], fruit.get(fruits[low]) - 1);
                
                if (fruit.get(fruits[low]) == 0) {
                    fruit.remove(fruits[low]);
                }
                
                low++;
            }
            
            if (fruit.size() <= k) {
                int length = high - low + 1;

                maxLength = Math.max(maxLength, length);
            }
            
        }
        return maxLength;
    }
}