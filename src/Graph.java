import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {
    int vertices;
    int edges;
    int parkingfee;
    ArrayList<Edge>[] adjancenylist;
    Vertex[] verticearray;
    public ArrayList<Vehicle>[] parkingstation;
    public Graph(int vertices,int edges,int parkingfee){
        this.vertices=vertices;
        this.edges=edges;
        this.parkingfee=parkingfee;
        this.verticearray= new Vertex[vertices+1];
      this.adjancenylist= new ArrayList[vertices+1];
      for (int i =1;i<vertices+1;i++){
          this.adjancenylist[i]= new ArrayList<>();

      }
    }
    public  void create_parking_station(){
        for(int i=0;i<verticearray.length;i++){
            parkingstation[i]= new ArrayList<>();
        }
    }
    private int  findtotalspace(){
        int sum =0;
        for (int  i=1;i<verticearray.length;i++){
            sum += verticearray[i].capacity;
        }
        return sum;
    }
    public void addtovertices(int id,int capacity){
        verticearray[id]= new Vertex(capacity,id);
    }
    public void addedge(int startvertex,int endvertex,int weight){
        adjancenylist[startvertex].add(new Edge(startvertex,endvertex,weight));
    }
    public void  showvertices(){
        for (int i =1;i<verticearray.length;i++){
            System.out.println(verticearray[i].id +" "+ verticearray[i].capacity);
        }
    }
    public void showconnections(){
        for (int i =1;i<vertices+1;i++){
            for (Edge a : adjancenylist[i]){
                System.out.println(a.startvertex+ ""+ a.endvertex+ ""+a.weight);
            }
        }
    }
    public void minumumspanninforall(int vehicles){
        int tempvechicles = vehicles;
        int []minumumcostforcar = new int[vehicles+1];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(0,1,parkingfee));
        int count =1;
        int tempstatiton = priorityQueue.peek().endvertex;
int totalspace = findtotalspace();
if(totalspace<tempvechicles){
    tempvechicles=totalspace;
}
while (tempvechicles>0){
    int parkingstation = priorityQueue.peek().endvertex;
    int cost = priorityQueue.peek().weight;
    priorityQueue.remove();
    int capacity = verticearray[parkingstation].capacity;
    while (capacity>=1){
        minumumcostforcar[count]= cost;
        count++;
        capacity--;
        tempvechicles--;
    }
    for (Edge a: adjancenylist[parkingstation]){
         int tempcost = a.weight;
        int endvertex = a.endvertex;
        int totalcost = tempcost+cost;
        priorityQueue.add(new Edge(parkingstation,endvertex,totalcost));
    }
}
for (int i =1;i<vehicles+1;i++){
    if(minumumcostforcar[i]==0){
        minumumcostforcar[i]=-1;
    }
    System.out.print(minumumcostforcar[i]+" ");
}
            }
        }








