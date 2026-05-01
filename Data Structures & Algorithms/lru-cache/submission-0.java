class Node{
    Node prev,next;
    int key,value;
    Node(int _key,int _val){
        key=_key;
        value=_val;
    }
}
class LRUCache {

    Map<Integer,Node> mp = new HashMap<>();
    int capacity;
    Node head = new Node(0,0), tail =new Node(0,0);

    LRUCache(int _capacity){
        capacity =_capacity;
        head.next=tail;
        tail.prev=head;

    }

    public void Remove(Node node){
      mp.remove(node.key);
      node.prev.next=node.next;
      node.next.prev=node.prev;
    }

    public void Insert(Node node){
        mp.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        node.prev=head;
        head.next=node;
    }

    public int get(int key) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            Remove(node);
            Insert(node);
            return node.value;
        } else{   
        return -1;
        }
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Remove(mp.get(key));
        }
        if(mp.size()==capacity){
            Remove(tail.prev);
        }
        Insert(new Node(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */