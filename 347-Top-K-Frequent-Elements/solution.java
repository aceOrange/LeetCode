public class Solution {
    public class Pair {
        int val;
        int freq;
        
        public Pair (int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    
    public class PQ_ORDER implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.freq - b.freq;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }
        
        
        //construct the minHeap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k + 1, new PQ_ORDER());
      
        for (Integer key : count.keySet()) {
            Pair p = new Pair(key, count.get(key));
            pq.add(p);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        
        
        List<Integer> ans = new ArrayList<Integer>();
        
        while (!pq.isEmpty()) {
            Pair p = (Pair)(pq.poll());
            ans.add(p.val);
        }
        
        Collections.reverse(ans);
        
        return ans;
        
    }
}