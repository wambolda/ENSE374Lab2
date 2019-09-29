public class LinkedList
{
	ListElement head = new ListElement();
	int numNodes = 0;
	
	// Purpose: add an element to the linked list
	// Parameter(s): 
	// (1) ListElement le - ListElemenet to be added to the list
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
	// (1) Returns a blank ListElement if the provided index number is invalid
	public ListElement getElement(int index)
	{
		if(index > numNodes)
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
	
	public ListElement deleteElement(int index)
	{
		
	}
	
	public void printLinkedListTail()
	{
		
	}
	
	public void printLinkedListHead()
	{
		
	}


	public static void main(String[] args)
	{
		LinkedList myList = new LinkedList();
		ListElement le = new ListElement();
		ListElement le_two = new ListElement();
		le.setData(5);
		le_two.setData(9);
		
		myList.addElement(le);
		myList.addElement(le_two);
		System.out.println(myList.getElement(0).getData());
	}
}