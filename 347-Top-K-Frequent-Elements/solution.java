public class Solution {
    public class Pair {
        int val;
        int freq;
        
        public Pair (int val, int freq) {
            this.val = val;
            this.freq = freq;
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
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.freq - b.freq;
            }
        });
      
        Iterator it = count.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry p = (Map.Entry)(it.next());
            Pair data = new Pair((int)p.getKey(), (int)p.getValue());
            pq.add(data);
            
            if (pq.size() > k) {
                pq.poll();
            }
            it.remove();
        }
        
        
        
        List<Integer> ans = new ArrayList<Integer>();
        it = pq.iterator();
        
        while (it.hasNext()) {
            Pair p = (Pair)(it.next());
            ans.add(p.val);
        }
        
        Collections.reverse(ans);
        
        return ans;
        
    }
}