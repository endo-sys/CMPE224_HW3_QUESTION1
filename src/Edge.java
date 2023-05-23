public class Edge implements Comparable<Edge> {
    int startvertex;
    int endvertex;
    int weight;
public Edge(int startvertex,int endvertex,int weight){
    this.startvertex=startvertex;
    this.endvertex=endvertex;
    this.weight=weight;
}


    public int compareTo(Edge o) {
        if(this.weight>o.weight){
            return 1;
        }
        return -1;
    }
}
