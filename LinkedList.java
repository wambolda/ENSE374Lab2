import java.util.Scanner;  // Import the Scanner class for user input

public class LinkedList
{
	ListElement head = null;
	ListElement tail = null;
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
			tail = head;
			head.setPrev(null);
			head.setNext(null);
			numNodes++;
		}
		else
		{
			ListElement temp = tail; // temp is last ListElement
			temp.setNext(le); // tail.next = le
			temp = temp.getNext(); 
			temp.setPrev(tail);
			temp.setNext(null);
			tail = temp;
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
			ListElement temp = head;
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
			System.out.println("Removed ListElement number " + index + " from LinkedList.");
			head = head.getNext();
			head.setPrev(null);
		}			
		else
		{
			System.out.println("Removed ListElement number " + index + " from LinkedList.");
			ListElement temp = head;
			int i = 0;
			while(i < index - 1)
			{
				temp = temp.getNext();
				i++;
			} 
			// temp is now the ListElement before the indexed ListElement
			ListElement tempo = temp.getNext().getNext();
			tempo.setPrev(temp);
			temp.setNext(tempo);
			numNodes--;
			return;
		}
		
	}
	
	// Purpose: Print the ListElement data values of the entire LinkedList in reverse order from tail
	// Parameter(s): N/A
	// Precondition(s): 
	// (1) LinkedList must not be empty
	// Returns: void
	// Side effect(s): 
	// (1) Prints data values of ListElement to console
	public void printLinkedListTail()
	{
		ListElement temp = tail;
		int i = numNodes;
		while(i > 0)
		{
			System.out.print(temp.getData() + "  ");
			temp = temp.getPrev();
			i--;
		}
		System.out.println(" ");
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
		ListElement temp = head;
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
			
		char userIn = ' ';
		char QUIT = ' ';
		Scanner UserInput = new Scanner(System.in);
		while(QUIT == ' ')
		{
			userIn = ' ';
			System.out.println("\nLinked List operations:");
			System.out.println("a - add a new ListElement to the linked list.");
			System.out.println("d - delete a ListElement from the linked list.");
			System.out.println("r - retrieve a ListElement from the linked list.");
			System.out.println("p - print the linked list.");
			System.out.println("q - quit. \n");
			
			userIn = UserInput.nextLine().charAt(0);
			
			switch(userIn)
			{
				case 'a':case 'A':
				{
					System.out.println("Enter a value to be put into the LinkedList:");
					int toAdd = 0;
					try
					{	
						toAdd = Integer.parseInt(UserInput.nextLine());
					}
					catch (NumberFormatException e)
					{
						System.out.println("Invalid input, data must be an integer.");
						break;
					}
					ListElement le = new ListElement();
					le.setData(toAdd);
					myList.addElement(le);
					break;
				}
				case 'd':case 'D':
				{
					System.out.println("Enter the index value of the ListElement to be deleted:");
					int toRemove = 0;
					try
					{	
						toRemove = Integer.parseInt(UserInput.nextLine());
					}
					catch (NumberFormatException e)
					{
						System.out.println("Invalid input, data must be an integer.");
						break;
					}
					myList.deleteElement(toRemove);
					break;
				}
				case 'r':case 'R':
				{
					
					System.out.println("Enter the index value of the ListElement to be retrieved:");
					int toRetrieve = 0;
					try
					{	
						toRetrieve = Integer.parseInt(UserInput.nextLine());
					}
					catch (NumberFormatException e)
					{
						System.out.println("Invalid input, data must be an integer.");
						break;
					}
					System.out.println(myList.getElement(toRetrieve).getData());
					break;
				}
				case 'p':case 'P':
				{
					System.out.println("h - print list from head");
					System.out.println("t - print list from tail");
					userIn = UserInput.nextLine().charAt(0);
					switch(userIn)
					{
						case 'h': case'H':
						{
							myList.printLinkedListHead();
							break;
						}
						case 't': case'T':
						{
							myList.printLinkedListTail();
							break;
						}
						default:
						{
							System.out.println("Invalid input, try one of the listed options.");
							break;
						}
						
					}					
					break;
				}
				case 'q': case 'Q':
				{
					QUIT = 'y';
					break;
				}				
				default:
				{
					System.out.println("Invalid input, try one of the listed options.");
					break;
				}
				
			}
		}
	}
}