public class LinkedList
{
	ListElement head = new ListElement();
	int numNodes = 0;
	
	public void addNode(ListElement le)
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
	
	public ListElement getElement(int index)
	{
		
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
		ListElement le = new ListElement();
		le.setData(5);
		//LinkedList myList = new LinkedList();
	}
}