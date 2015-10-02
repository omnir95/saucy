package saucy;

import java.util.Vector;

public class Node {
    static String allEdgesString = "";
    static String allColorsString = "";
	private int number;
	private int color;
	private Vector<Node> children = new Vector<Node>();
	
	Node(int num){
		number = num;
	}
	static void addEdge(int index1 , int index2){
		allEdgesString += "" + index1 + "--" + index2 + ";\n";
	}
	static void addColoredVertix(int index , int color){
		allColorsString += "" + index + "[color=" + color + "]\n";
	}
	void setColor(int clr){
		color =  clr;
	}
	int getNumber(){return number;}
	void addChild(Node child){
		children.addElement(child);
	}
	void display(){
		System.out.println("NO. : " + number + " .\nChildren:");
		for(int i = 0 ; i< children.size() ; i++)
			System.out.println("" + children.elementAt(i).getNumber() + " , ");
	}
}
