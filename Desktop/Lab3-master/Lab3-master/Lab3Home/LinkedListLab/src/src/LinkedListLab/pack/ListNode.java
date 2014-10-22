package src.LinkedListLab.pack;

public class ListNode {
	
	private ListNode next;
	private ListNode previous;
	
	private int data;
	
	public ListNode (int newData, ListNode nextData, ListNode previousData) //constructor
	{
		data = newData;
		next = nextData;
		previous = previousData;
	}
	
	
	public int getNodeData ()
	{
		return data; 
	}
	
	public void setNodeData (int newData)
	{
		data = newData;
	}
	
	public ListNode getPreviousNode ()
	{
		return previous;
	}
	
	public ListNode getNextNode ()
	{
		return next;
	}
	
	public void setPreviousNode (ListNode node) //sets the value of the node before this node in the list
	{
		previous = node;
	}
	
	public void setNextNode (ListNode node) //sets the value of the node after this node in the list
	{
		next = node;
	}
	
	
}
