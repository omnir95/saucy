package saucy;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
	@SuppressWarnings("unused")
	public static void main(String args[]){
		LinkedList<Node> graph = new LinkedList<Node>();

		
		
		try {

			Scanner scn = new Scanner(new FileReader("D:\\viz1.txt"));
			FileWriter writer = new FileWriter("D:\\outputt.txt");
			//BufferedWriter bfWriter = new BufferedWriter(writer);
			
			int nbVertices = scn.nextInt();
			Node initialNodes[] = new Node[nbVertices]; 
			for (int i = 0; i < nbVertices; i++) 
				initialNodes[i] = new Node(i);
			
			int nbEdges = scn.nextInt();
			int nbColors = scn.nextInt();
						
			int []startingColorsVertices = new int[nbColors];//contains each vertix which starts a color
			startingColorsVertices[0] = 0;
			for(int i = 1 ; i < nbColors ;i++)
				startingColorsVertices[i] = scn.nextInt();
			
			int ctr = 0;
			
			for (int i = 0; i < nbVertices; i++){
				System.out.println(ctr);
				if(ctr < startingColorsVertices.length && i == startingColorsVertices[ctr])
					ctr++;				
				initialNodes[i].setColor(ctr);//ctr = 1:first color , 2 : second ,etc..
				Node.addColoredVertix(i, ctr);
			}
			
			for(int i = 0 ; i < nbEdges ; i++){
				int index1 , index2;
				index1 = scn.nextInt();
				index2 = scn.nextInt();
				Node.addEdge(index1, index2);
				//because of the graph is not directed so I add each node as a child to the another one.
				initialNodes[index1].addChild(initialNodes[index2]);
				initialNodes[index2].addChild(initialNodes[index1]);
				
			}
			
			for(int i = 0 ; i < nbVertices ; i++)
				graph.addLast(initialNodes[i]);			
				
			writer.write("graph G {\nnode [style=solid]\n" + Node.allColorsString + Node.allEdgesString + "}");
			writer.close();
			scn.close();			
			
		} catch (Exception e) {
			System.out.println("error");
		}

		//the problem here that I need a function which executes a command 
		//in this command we can execute the  the GraphViz with the ouputfile.txt
		//output.txt contains the format in which the given graph can be defined in GraphViz process
		//the wished command we want to execute is : `gvedit.exe output.txt`
		//note that the output.txt is passed as an argument to the graphVis , then 
		//graphVis will draw it
		
		
		/*try {
			Process p = Runtime.getRuntime().exec("ps -ef");
			p.waitFor();
		} catch (IOException e1) {
			System.out.println("hi");
		}
		catch (InterruptedException e) {
			System.out.println("hello");
		}*/

	}
}


















