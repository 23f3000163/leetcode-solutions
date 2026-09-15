class Solution {

    public void solve (int[] candidates,int index,int target,List<Integer> current,List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); 
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        current.add(candidates[index]);

        solve (candidates, index, target - candidates[index], current, result);

        //BACKTRACK
        current.remove(current.size() - 1);
        solve (candidates, index + 1, target, current, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve (candidates, 0, target, current, result);
        return result;
    }
}