public class UnionFind {
    // TODO: Instance variables
    int[]parents;
    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        parents=new int[N];
        for(int i=0;i<N;i++){
            parents[i]=-1
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE
        return Math.abs(parent(find(v)))
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        // TODO: YOUR CODE HERE
        return parents[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        return find(v1)=find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) throws IllegalArgumentException {
        // TODO: YOUR CODE HERE
        if(v<0||v>=parents.length){
            throw new IllegalArgumentException("something comment to describe the reason for throwing ");
        }
        if(parent(v)<0){
            return v;
        }
        parents[v]=find(parent(v));
        return find(parent(v));
    }
    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        if(v1=v2){
            return 1;
        }
        if(sizeOf(v1)>sizeOf(v2)){
            parent[find(v2)]=find(v1);
            parent[find(v1)]--;
        }
        else{
            parent[find(v1)]=find(v2);
            parent[find(v2)]--;
        }
    }
}
