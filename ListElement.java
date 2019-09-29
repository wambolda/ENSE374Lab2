public class ListElement
{
	private ListElement next;
	private ListElement prev;
	private int data;
	
	public ListElement()
	{
		this.next = null;
		this.prev = null;
		this.data = 0;
	}
	
	public void setNext(ListElement NEXT)
	{
		this.next = NEXT;
		return;
	}
	
	public void setPrev(ListElement PREV)
	{
		this.prev = PREV;
		return;
	}
	
	public void setData(int DATA)
	{
		this.data = DATA;
	}
	
	public ListElement getNext()
	{
		return this.next;
	}
	
	public ListElement getPrev()
	{
		return this.prev;
	}
	
	public int getData()
	{
		return this.data;
	}
}