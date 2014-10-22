package src.LinkedListLab.pack;

/*
 * Name: Hayden Lowes
 * Student ID: 200307093
 * Project Name: Lab 3 Doubly Linked List Program
 * 
 * Still to do: "Print list from tail to head" function
 */

import java.util.Scanner;

public class LinkedList {
	
	ListNode head;
	ListNode tail;
	
	protected int listSize;
	
	
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
	
	public boolean IsListEmpty ()
	{
		if (head == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public void AddNode (int newData)
	{
		ListNode temp = new ListNode (newData, null, null);
		
		if (head == null)
		{
			head = temp;
			tail = head;
		}
		
		else
		{
			head.setPreviousNode(temp);
			temp.setNextNode(head);
			head = temp;
		}
		
		listSize ++;
	}
	
	public void DeleteNode (int position)
	{		
		
		if (position == 1)
		{
			if (listSize == 1)
			{
				head = null;
				tail = null;
				listSize = 0;
			}
			
			else
			{
				head = head.getNextNode();
				head.setPreviousNode(null);
				listSize --;	
			}
		}
		
		if (position == listSize)
		{
			tail = tail.getPreviousNode();
			tail.setNextNode(null);
			
			listSize --;
		}
		
		ListNode iterator = head.getNextNode();
		
		for (int i = 2; i <= listSize; i ++) //find a node at a position between the first and last node
		{
			
			if (i == position)
			{
				ListNode previousNode = iterator.getPreviousNode();
				ListNode nextNode = iterator.getNextNode();
				
				previousNode.setNextNode(nextNode);
				nextNode.setPreviousNode (previousNode);
				
				listSize --;
			}
			
			iterator = iterator.getNextNode();
		}
		
	}
	
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
				
				if (i < listSize)
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
	
	public void ReversePrintList ()
	{
		System.out.println ("The Doubly Linked List: ");
		
		if (listSize == 0)
		{
			System.out.println ("The List is Empty. ");
		}
		
		if (tail.getPreviousNode() == null)
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
            	
            	dLinkedList.AddNode(menuPauser.nextInt());
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
            		dLinkedList.DeleteNode(position);
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
            		ListNode temp = dLinkedList.RetrieveNode(nodePosition);
            		
            		System.out.println ("the node at position " + nodePosition + " has the value " + temp.getNodeData());
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
