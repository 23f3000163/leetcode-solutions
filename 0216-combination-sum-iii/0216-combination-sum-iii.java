class Solution {

     public void solve (int[] candidates,int index,int target,List<Integer> current,List<List<Integer>> result, int count, int k) {

        if (count > k) {
            return;
        }
        if (count == k && target == 0) {
            result.add(new ArrayList<>(current)); 
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        current.add(candidates[index]);

        solve (candidates, index + 1, target - candidates[index], current, result, count + 1, k);

        //BACKTRACK
        current.remove(current.size() - 1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }

        solve (candidates, index + 1, target, current, result, count, k);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        int target = n;
        int count = 0;
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        solve (candidates, 0, target, current, result, count, k);
        
        return result;
    }
}