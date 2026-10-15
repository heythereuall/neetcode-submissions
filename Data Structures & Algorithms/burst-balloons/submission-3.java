public class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = newNums[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] memo = new int[newNums.length][newNums.length];
        return dfs(newNums, 0, newNums.length - 1, memo);
    }

    public int dfs(int[] nums, int left, int right, int[][] memo) {
        if (left + 1 >= right) {
            return 0;
        }
        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        int maxCoins = 0;
        for (int i = left + 1; i < right; i++) {
            int coins = nums[left] * nums[i] * nums[right]
                      + dfs(nums, left, i, memo)
                      + dfs(nums, i, right, memo);
            maxCoins = Math.max(maxCoins, coins);
        }
        memo[left][right] = maxCoins;
        return maxCoins;
    }
}