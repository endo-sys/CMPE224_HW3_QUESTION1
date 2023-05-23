import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int vertices,edges,parkingfee;
        vertices=keyboard.nextInt();
        edges=keyboard.nextInt();
        parkingfee=keyboard.nextInt();
        Graph airport = new Graph(vertices,edges,parkingfee);
        int count =1;
        while (count<vertices+1){
            int capacity = keyboard.nextInt();
            airport.addtovertices(count,capacity);
            count++;
        }
        count =0;
        while (count<edges){
            int startvertex= keyboard.nextInt();
            int endvertex = keyboard.nextInt();
            int weight = keyboard.nextInt();
            airport.addedge(startvertex,endvertex,weight);
            count++;
        }
        int vecihles = keyboard.nextInt();
        airport.minumumspanninforall(vecihles);


    }
}