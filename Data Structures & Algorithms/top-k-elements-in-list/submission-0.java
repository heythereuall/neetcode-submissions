class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();

        // count freq
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // max heap based on freq
        PriorityQueue<Integer> heap =
            new PriorityQueue<>(
                (a, b) -> count.get(b) - count.get(a)
            );

        // add all unique nums
        for(int num : count.keySet()){
            heap.add(num);
        }

        // get top k freq nums
        int[] result = new int[k];

        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }

        return result;
    }
}