package src.LinkedListLab.pack;

/*
 * Name: Hayden Lowes
 * Student ID: 200307093
 * Project Name: Lab 3 Doubly Linked List Program
 */

import java.util.Scanner; //needed for user to interact with the menu of options

public class LinkedList {
	
	ListNode head;
	ListNode tail;
	
	protected int listSize; //variable used to store and update the number of elements in the linked list
	
	
	public LinkedList () //constructor
	{
		head = null;
		tail = null;
		listSize = 0;
	}
	
	public int getListSize ()
	{
		return listSize;
	}
	
	
	public void AddNode (ListNode temp) //function to insert a new node at the head of the list
	{
		
		if (head == null)
		{
			head = temp;
			tail = head;
		}
		
		else
		{
			head.setPreviousNode(temp);
			temp.setNextNode(head);
			head = temp; //the new node becomes the head of the list, making the old head come next to it
		}
		
		listSize ++;
	}
	
	public ListNode DeleteNode (int position)
	{		
		
		ListNode temp = new ListNode (0, null, null);
		
		if (position == 1)
		{
			if (listSize == 1) //if the node at the specified position is the only node in the list,
							   //clear everything
			{
				temp = head;
				head = null;
				tail = null;
				listSize = 0;
				
				return temp;
			}
			
			else
			{
				temp = head;
				head = head.getNextNode();
				head.setPreviousNode(null);
				listSize --;
				
				return temp;
			}
		}
		
		else if (position == listSize) //if the node at the specified position is the last node in the list,
								  //the node before it becomes the new tail node
		{
			temp = tail;
			tail = tail.getPreviousNode();
			tail.setNextNode(null);
			
			listSize --;
			
			return temp;
		}
		
		else
		{
		
			ListNode iterator = head.getNextNode();
			
			for (int i = 2; i <= listSize; i ++) //find a node at a position between the first and last node
			{
				
				if (i == position)
				{
					temp = iterator;
					ListNode previousNode = iterator.getPreviousNode();
					ListNode nextNode = iterator.getNextNode();
					
					previousNode.setNextNode(nextNode);
					nextNode.setPreviousNode (previousNode);
					
					listSize --;
					
					return temp;
				}
				
				iterator = iterator.getNextNode();
			}
			
			return temp;
		
		}
		
	}
	/**
	 * This Retreives a node.
	 * @param position
	 * @return ListNode
	 */
	public ListNode RetrieveNode (int position)
	{
		ListNode retriever = head;
		
		if (position == 1)
		{
			return head;
		}
		
		if (position == listSize)
		{
			return tail;
		}
		
		else
		{
			retriever = retriever.getNextNode();
			
			for (int i = 2; i <= listSize; i ++)
			{
				if (i == position)
				{
					return retriever;
				}
				
				if (i < listSize) //if the iterator (i) isn't looking at the tail node, set the retriever to be
								  //the following node.
				{
					retriever = retriever.getNextNode();
				}
				
			}
			
			retriever = null;
			return retriever;
		}
		
	}
	
	public void PrintList ()
	{
		System.out.println ("The Doubly Linked List: ");
		
		if (listSize == 0)
		{
			System.out.println ("The List is Empty. ");
		}
		
		if (head.getNextNode() == null)
		{
			System.out.println (head.getNodeData());
		}
		
		else
		{
		
		ListNode iterator = head;
		
		System.out.print (head.getNodeData() + " <----> ");
		
		iterator = head.getNextNode();
		
		while (iterator.getNextNode() != null)
		{
			System.out.print (iterator.getNodeData() + " <----> ");
			
			iterator = iterator.getNextNode();
		}
		
		System.out.print (iterator.getNodeData());
		System.out.println ("");
		
		}
	}
	
	public void ReversePrintList () //print the linked list starting from the tail
	{
		System.out.println ("The Doubly Linked List: ");
		
		if (listSize == 0)
		{
			System.out.println ("The List is Empty. ");
		}
		
		else if (tail.getPreviousNode() == null)
		{
			System.out.println (tail.getNodeData());
		}
		
		else
		{
			ListNode iterator = tail;
			
			System.out.print (tail.getNodeData() + " <----> ");
			
			iterator = tail.getPreviousNode();
			
			while (iterator.getPreviousNode() != null)
			{
				System.out.print (iterator.getNodeData() + " <----> ");
				
				iterator = iterator.getPreviousNode();
			}
			
			System.out.print (iterator.getNodeData());
			System.out.println ("");
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner menuPauser = new Scanner (System.in);
		
		System.out.println ("Doubly Linked List Manipulator");
		
		LinkedList dLinkedList = new LinkedList ();
		
		char keepGoing;
		
		do
		{
            System.out.println("1. add a node");

            System.out.println("2. delete a node");

            System.out.println("3. print head first");
            
            System.out.println("4. retrieve a node");
            
            System.out.println("5. print tail first");
            
            int userChoice = menuPauser.nextInt();
            
            switch (userChoice)

            {
            
            case 1:
            	System.out.println ("enter the number to add to the list:");
            	
            	int nodeValue = menuPauser.nextInt(); //get desired value for the new node
            	
            	ListNode temp = new ListNode (nodeValue, null, null);
            	
            	dLinkedList.AddNode(temp);
            	break;
 
            case 2:
            	System.out.println ("enter the position to delete a node from:");
            	
            	int position = menuPauser.nextInt();
            	
            	if (position < 0 || position > dLinkedList.getListSize())
            	{
            		System.out.println ("Invalid Position");
            	}
            	
            	else
            	{
            		ListNode deletedNode = dLinkedList.DeleteNode(position);
            		System.out.println ("The node containing the value " + deletedNode.getNodeData() + " has been removed from the list.");
            	}
            	break;
            	
            case 3:
            	dLinkedList.PrintList();
            	break;
            	
            case 4:
            	System.out.println ("enter the position to retrieve a node from:");
            	
            	int nodePosition = menuPauser.nextInt();
            	
            	if (nodePosition < 0 || nodePosition > dLinkedList.getListSize())
            	{
            		System.out.println ("Invalid Position");
            	}
            	
            	else
            	{
            		ListNode temp1 = dLinkedList.RetrieveNode(nodePosition);
            		
            		System.out.println ("the node at position " + nodePosition + " has the value " + temp1.getNodeData());
            	}
            	break;
            	
            case 5:
            	dLinkedList.ReversePrintList();
            	break;
            	
            default:
            	System.out.println ("Invalid Entry");
            	break;
            
            }
            
            System.out.println ("Continue List Manipulation? (y or n)");
            
            keepGoing = menuPauser.next().charAt(0);
        
		} while (keepGoing == 'y' || keepGoing == 'Y');
		
		menuPauser.close(); //close off user input utility
	}

}
