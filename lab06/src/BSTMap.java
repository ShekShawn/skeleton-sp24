import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BSTMap <K extends Comparable<K>, V> implements Map61B<K,V>{
    private Node;
    K key;
    V value;
    Node left, right;

    Node(K key, V value){
        this.key=key;
        this.value=value;
    }
    //BST initialization
    public BSTMap(){
        root=null;
        size=0;
    }
    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; // Update the value if the key already exists
        }
        return node;
    }
        @Override
        public V get(K key){
          return get(root,key);
        }
        public V get(Node node, K key){
            if(node==null){
                size++;
                return new Node(key,value)
            }
            int cmp=key.compareTo(node.key);
            if(cmp<0){
                node.left=put(node.left,key,value)
            }
            else {
                node.right = put(node.right, key, value)
            }
             else{
                node.value=value;
            }
        }
        @Override
    public boolean containKey(K key){
        return get(key)!=null;//key exists if get() does not return null
        }
        @Override
    public int size(){
        return size;//size of the map
        }
        @Override
    public void clear(){
        root=null;
        size=0;
        }
        public void printInOder(){
        printInOder(root);
        }
        private void printInOrder(Node node){
         if(node!=null){
             printInOder(node.left);
             System.out.println(node.key,+":"+node.value);
             printInOder(node.right);
         }
        }
        @Override
        private void collctKey(Node node, Set<K> keys){
          Set<K> keys=new HashSet<>();
          collctKey(root, keys);
          return keys;
        }
        private void collectKeys(Node node, Set<K> keys){
         if(node!=null){
             collctKey(node.left, keys);
             keys.add(node.key);
             collctKey(node.right,keys);
         }
        }
        @Override
    public V remove(K key){
        // not to implement, throw exception if called
            throw new UnsupportedOperationException("Remove not supported");
        }
        @Override
    public Iterator<K> iterator(){
        return new BSTMapIterator();
        }
        public class BSTMapIterator implements Iterator<K>{
          private Stack<Node> stack;
          public BSTMapIterator(){
              stack=new Stack<>();
              pushLeft(root);
          }
          private void pushLeft(Node node){
              while(node!=null){
                  stack.push(node);
                  node=node.lefy;
              }
          }
          @Override
            public boolean hasNext(){
              return !stack.isEmpty();
          }
          @Override
            public K next(){
              if(!hasNext()){
                  throw new NoSuchElementException();
              }
              Node node=stack.pop();
              pushLeft(node.right);
              return node.key;
          }
    }
}