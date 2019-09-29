public class LinkedList
{
	ListElement head = new ListElement();
	int numNodes = 0;
	
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
	
	//public ListElement deleteElement(int index)
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