import java.util.HashMap;
import java.util.Map;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise,
add the key-value pair to the cache. If the number of keys exceeds the capacity from
this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Constraints:
1 <= capacity <= 3000
0 <= key <= 10^4
0 <= value <= 10^5
At most 2 * 10^5 calls will be made to get and put.
 */
public class LRUCache_M {
  public static void main(String[] args) {
    LRUCache_M lruCache = new LRUCache_M(2);

    // Test case 1: Basic put and get operations
    lruCache.put(1, 1); // cache is {1=1}
    lruCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lruCache.get(1)); // returns 1

    // Test case 2: Exceeding capacity
    lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lruCache.get(2)); // returns -1 (not found)

    // Test case 3: Updating existing key
    lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lruCache.get(1)); // returns -1 (not found)
    System.out.println(lruCache.get(3)); // returns 3
    System.out.println(lruCache.get(4)); // returns 4

    // Test case 4: Accessing elements to change their order
    lruCache.put(5, 5); // LRU key was 3, evicts key 3, cache is {4=4, 5=5}
    System.out.println(lruCache.get(4)); // returns 4
    lruCache.put(6, 6); // LRU key was 5, evicts key 5, cache is {4=4, 6=6}
    System.out.println(lruCache.get(5)); // returns -1 (not found)
    System.out.println(lruCache.get(6)); // returns 6
  }

  private Map<Integer, Node> cache;
  private int capacity;
  private Node left = new Node(0, 0); // Least Recently Used LRU
  private Node right = new Node(0, 0); // Most Recently Used MRU

  public LRUCache_M(int capacity) {
    cache = new HashMap<>();
    this.capacity = capacity;
    left = new Node(0, 0); // Least Recently Used LRU
    right = new Node(0, 0); // Most Recently Used MRU
    left.setNext(right);
    right.setPrevious(left);
  }

  public int get(int key) {

    if (cache.containsKey(key)) {
      remove(cache.get(key));
      insert(cache.get(key));
      return cache.get(key).getValue();
    }
    return -1;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    cache.put(key, new Node(key, value));
    insert(cache.get(key));

    if (cache.size() > capacity) {
      // remove from the list and delete the LRU from the hashmap
      Node lru = left.getNext();
      remove(lru);
      cache.remove(lru.getKey());
    }
  }

  // remove Node from List
  public void remove(Node node) {
    Node prev = node.getPrevious();
    Node next = node.getNext();
    prev.setNext(next);
    next.setPrevious(prev);
  }

  // insert Node at the right
  public void insert(Node node) {

    Node prev = right.getPrevious();
    Node next = right;

    prev.setNext(node);
    next.setPrevious(node);

    node.setNext(next);
    node.setPrevious(prev);
  }

  public static class Node {
    private int key;
    private int value;
    private Node previous;
    private Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public int getKey() {
      return this.key;
    }

    public int getValue() {
      return this.value;
    }

    public Node getPrevious() {
      return this.previous;
    }

    public void setPrevious(Node previous) {
      this.previous = previous;
    }

    public Node getNext() {
      return this.next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }
}
