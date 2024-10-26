package hashmap;

import java.util.Collection;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private int size;
    private double loadFactor;
    private int initialCapacity;
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        this.initialCapacity=16;
        this.loadFactor=0.75;
        this.buckets=(Collection<Node>[]) new Collection[initialCapacity];
        for(i=0;i<initialCapacity;i++){
            buckets[i]=createBucket();
        }
        this.size=0;
    }

    public MyHashMap(int initialCapacity) {
        this.initialCapacity=16;
        this.loadFactor=0.75;
        this.buckets=(Collection<Node>[]) new Collection[initialCapacity];
        for(i=0;i<initialCapacity;i++){
            buckets[i]=createBucket();
        }
        this.size=0;
    }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor maximum load factor
     */
    public MyHashMap(int initialCapacity, double loadFactor) { }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *  Note that that this is referring to the hash table bucket itself,
     *  not the hash map itself.
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
        this.initialCapacity=16;
        this.loadFactor=0.75;
        this.buckets=(Collection<Node>[]) new Collection[initialCapacity];
        for(i=0;i<initialCapacity;i++){
        buckets[i]=createBucket();
    }
        this.size=0;
    protected Collection<Node> createBucket() {
        // TODO: Fill in this method.
        return ArrayList<>;
    }
    private int hash(K key){
        return Math.abs(key.hashCode())% buckets.length;
    }
    public void put (k key, V value){
        int index=hash(key);
        Collection<Node> bucket=buckets[index];
        //check if the key already exists and updaye its value
        for(Node node : bucket){
            node.value=value;
            return;
        }
        //if no key, new one
        bucket.add(new Node(key,value));
        size++;
        //resize when necessay
        if(size>bucket.length*loadFactor){
            resize();
        }
    }
    //get value by key
    public V get(K key){
        int index=hash(key);
        Collection<Node>bucket=buckets[index];
        for (Node node:bucket){
            if(node.key.equals(key)){
            return node.value;
            }
        }
        return null;// if key not found
    }
    public void remove(K key){
        int index=hash(key);
        Collection<Node>bucket=buckets[index];
        Iterator<Node>iterator=bucket.iterator();
        while(iterator.hasNext()){
            Node node =iterator.next();
            if(node.key.equals(key)){
                iterator.remove();
                size--;
                return;
            }
        }
    }
    //resize the hash table when the load factor threshhold is exceeded
    private void resize(){
        int newCapacity=buckets.length*2;
        Collection<Node>[] newBuckets=(Collection<Node>[]) new Collection[newCapacity]
                for (int i=0; i<newCapacity;i++){
                    newBuckets[i]=createBucket();
                }
                //rehash all existing entries
        for(Collection<Node> bucket: buckets){
            for(Node node:bucket){
                int newIndex=Math.abs(node.key.hashCode()) % newCapacity;
                newBuckets[newIndex].add(node);
            }
        }
        buckets=newBuckets;
    }
    //methodto retrieve the size of the map
    public int size(){
        return size;
    }
    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
}
