import java.util.Scanner;  // Import the Scanner class for user input

public class LinkedList
{
	ListElement head = new ListElement();
	int numNodes = 0;
	
	// Purpose: add an element to the linked list
	// Parameter(s): 
	// (1) ListElement le - ListElement to be added to the list
	// Precondition(s): N/A
	// Returns: void
	// Side effect(s): 
	// (1) adds le to the end of the linked list
	// (2) changes the former last ListElement next value to be that of le
	public void addElement(ListElement le)
	{
		if(numNodes == 0)
		{
			head = le;
			numNodes++;
		}
		else
		{
			ListElement temp = this.head;
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(le);
			numNodes++;
		}
		return;
	}
	
	// Purpose: Retrieve a ListElement from the linked list given the elements index number
	// Parameter(s): 
	// (1) int index - index number of the ListElement to retrieve
	// Precondition(s): 
	// (1) index number must be valid
	// Returns: ListElement - the ListElement located at the provided index
	// Side effect(s): 
	// (1) Returns empty ListElement if the provided index number is invalid
	public ListElement getElement(int index)
	{
		if(index >= numNodes)
		{
			ListElement temp = new ListElement();
			return temp;
		}
		else
		{
			ListElement temp = this.head;
			int i = 0;
			while(i < index)
			{
				temp = temp.getNext();
				i++;
			}
			return temp;
		}
	} 
	
	// Purpose: Remove a ListElement
	// Parameter(s): 
	// (1) int index - index value of ListElement to remove
	// Precondition(s): 
	// (1) index value must be valid (index starts at 0)
	// Returns: void
	// Side effect(s): 
	// (1) removes a ListElement from the LinkedList
	// (2) changes next value of previous ListElement to the next value of deleted node
	// (3) if index value is invalid no action is taken
	// (4) prints to console
	public void deleteElement(int index)
	{
		if( index >= numNodes)
		{
			System.out.println("Invalid index, ListElement " + index + " does not exist.");
			return;
		}
		else if(index == 0)
		{
			System.out.println("Removing ListElement number " + index + " from LinkedList.");
			head = head.getNext();
		}			
		else
		{
			System.out.println("Removing ListElement number " + index + " from LinkedList.");
			ListElement temp = this.head;
			int i = 0;
			while(i < index - 1)
			{
				temp = temp.getNext();
				i++;
			} 
			// temp is now the ListElement before the indexed ListElement
			temp.setNext(temp.getNext().getNext());
			numNodes--;
			return;
		}
		
	}
	
	// Purpose: 
	// Parameter(s): 
	// (1) 
	// Precondition(s): 
	// (1) 
	// Returns:
	// Side effect(s): 
	// (1) 
	public void printLinkedListTail()
	{
		
	}
	
	// Purpose: Print the ListElement data values of the entire LinkedList in order from head
	// Parameter(s): N/A
	// Precondition(s): 
	// (1) LinkedList must not be empty
	// Returns: void
	// Side effect(s): 
	// (1) Prints data values of ListElement to console
	public void printLinkedListHead()
	{
		ListElement temp = this.head;
		int i = 0;
		while(i < numNodes)
		{
			System.out.print(temp.getData() + "  ");
			temp = temp.getNext();
			i++;
		}
		System.out.println(" ");
	}


	public static void main(String[] args)
	{
		LinkedList myList = new LinkedList();
		ListElement le = new ListElement();

		le.setData(5);
		
		myList.addElement(le);

		myList.printLinkedListHead();
		myList.deleteElement(3);
		myList.printLinkedListHead();
		
		char userIn = ' ';
		Scanner UserInput = new Scanner(System.in);
		while(true)
		{
			userIn = ' ';
			System.out.println("Linked List operations:");
			System.out.println("a - add a new ListElement to the linked list.");
			System.out.println("d - delete a ListElement from the linked list.");
			System.out.println("p - print the linked list.");
			userIn = UserInput.nextLine().charAt(0);
		}
	}
}