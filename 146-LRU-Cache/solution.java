

public class LRUCache {
    
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;
    
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        
        //initialize;
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node curr = map.get(key);
        
        //delete the curr Node;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        //mave the curr Node to the tail;
        move_to_tail(curr);
        
        return curr.value;
    }
    
    public void set(int key, int value) {
        
        // if the key exist in the cache, update it and move it to the tail;
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        
        if (map.size() == this.capacity) {
            //delete the head.next node;
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
            
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        move_to_tail(newNode);
        
    }
    
    public void move_to_tail(Node curr) {
        curr.prev = tail.prev;
        tail.prev.next = curr;
        
        tail.prev = curr;
        curr.next = tail;
    }
}