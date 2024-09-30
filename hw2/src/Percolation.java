import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//this a hw, or say small project, is more like a fiter system
//the top blue chuck drops when it meets the empty open site
//and when the blue chuck flows through the botttom, we succeed!
public WeightedQuickUnionUF board;
private WeightedQuickUnionUF counterpart;
private int[] opensites;
private int topnum;
private int bottomnum;
private int[] opensite;
private int onerow;
private  int numOfOpenSite;


public class Percolation {
    // TODO: Add any necessary instance variables.

    public Percolation(int N) {
        // TODO: Fill in this constructor.
        if(N<=0){
            throw new IllegalArgumentException();
        }
        board=new WeightedQuickUnionUF(N*N+2);
        counterpart=new WeightedQuickUnionUF(N*N+1);
        opensites=new int[N*N];
        topnum=N*N;
        bottomnum=N*N+1;
        onerow=N;
        numOfOpenSite=0;
    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
        validate(row,col);
        opensites[space(row,col)]=1;
        numOfOpenSite++;
                if(space(row,col)>=(topnum-onerow)){
                    board.union(space(row,col),topnum);
                    counterpart.union(space(row,col),topnum);
                    return ;
                }
                int[]x=new int[]{-1,0,1,0};
                int[]y=new int[]{0,1,0,-1};
                for(int i=0;1<x.length:i++){
                    int col_val=col+y[i];
                    int row_val=rwo+x[i];
                    if(space(row,col)<onerow){
                        board.union(space(row,col),topnum);
                        counterpart.union(space(row,col),topnum);
                        return;
            }
        }
    }

    public boolean isOpen(int row, int col) {
        // TODO: Fill in this method.
        if(space(row,col)<0|| space(row,col)>=topnum)
            return false;
        return opensites[space(row,col)]==1;
    }

    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        validate(row,col);
        return counterpart.connected(space(row,col),topnum);
    }

    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        return numOfOpenSite;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return board.connected(topnum,bottomnum);
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.
    private int space(int row, int col){
        return (onerow*row)+col;
    }
    private void validate(int row,int col){
        if(space(row,col)<0||space(row,col)>=topnum){
            throw new IndexOutOfBoundsException();
        }
    }

}
