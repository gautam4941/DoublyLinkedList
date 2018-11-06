package DoublyLinkedList;

import java.util.Scanner ;

public class DoublyLinkedListFunction
{
	int deletedirection, updatedirection, len ;
	
	Scanner sc = new Scanner( System.in ) ;
	
	NodeForDoublyLinkedList head = null ;
	NodeForDoublyLinkedList Last = new NodeForDoublyLinkedList() ;
	
	void insert( int data, int insertype)
	{
		if( head == null)
		{
			head = new NodeForDoublyLinkedList() ;
			
			head.data = data ;
			
			Last = head ; 
		}
		else
		{
			NodeForDoublyLinkedList temp = new NodeForDoublyLinkedList() ;
			
			temp.data = data ;
			
			if( insertype == 1)			//Front Side
			{
				temp.next = head ;
				head.prev = temp ;
				
				head = temp ;
			}
			else						//Back Side
			{
				NodeForDoublyLinkedList ptr = head ;
				
				while( ptr.next != null)
				{
					ptr = ptr.next ;
				}
				ptr.next = temp ;
				Last = temp ;
				temp.prev = ptr ;
				temp.next = null ;		//Can be deleted
			}
		}
	}
	void passdeletedirection( int direction )
	{
		deletedirection = direction ;
	}
	void passupdatedirection( int direction )
	{
		updatedirection = direction ;
	}
	void deletebyposition( int pos )
	{
		int count = 0 ;
		
		if( head == null)
		{
			System.out.println("Sorry, There is no Doubly Linked List");
		}
		else
		{
			count = 1 ;
			
			if( deletedirection == 1 )			//Head to Last
			{
				if( pos == 1)
				{
					int headdata = head.data ;
					NodeForDoublyLinkedList temp = head.next ;
					head = null ;
					temp.prev = null ;
					head = temp ;
					
					System.out.println(headdata +" Deleted At Node "+pos ) ;
				}
				else
				{
					int data ;
					
					NodeForDoublyLinkedList temp = head ;
					
					while(pos != count && temp.next != null)
					{
						temp = temp.next ;
						count++ ;
					}
					if( pos == count )
					{
						data = temp.data ;
						NodeForDoublyLinkedList ptr = temp.prev ;
						
						NodeForDoublyLinkedList q = temp.next ;
						if( q != null)
						{
							ptr.next = q ;
							q.prev = ptr ;
						}
						temp = null ;
						
						System.out.println(data+ " Deleted At Node " +pos);
					}
					else
						System.out.println("Position not available in Doubly Linked List") ;
				}
			}
			else if( deletedirection == 2)					//Last to Head
			{
				if( pos < 1)
				{
					System.out.println("Position Can't be Negative") ;
				}
				else if( pos == 1)
				{
					int lastdata = Last.data ;
					
					NodeForDoublyLinkedList temp = Last.prev ;
					
					temp.next = null ;
					
					Last = temp ;
					System.out.println(lastdata +" Deleted from Last At Node "+pos ) ;
				}
				else
				{
					int data ;
					
					NodeForDoublyLinkedList temp = Last ;
					
					while( pos != count && temp.prev != null)
					{
						temp = temp.prev ;
						count++ ;
					}
					if( pos <= count )
					{
						data = temp.data ;
						
						if( temp.prev != null )
						{
							temp.prev.next = temp.next ;			//can be deleted
							temp.next.prev = temp.prev ;			//can be deleted
							
							temp = null ;
						}
						else
						{
							NodeForDoublyLinkedList ptr = temp.next ;
							head = ptr ;
							
							ptr.prev = null ;
							temp = null ;
						}
						System.out.println(data +" Deleted from Last At Node "+pos ) ;
					}
					else
					{
						System.out.println("Position not available in Doubly Linked List") ;
					}
				}
			}
			
		}
	}
	void deletebydata( int data )
	{
		if( head == null)
		{
			System.out.println("Sorry, There is no Doubly Linked List");
		}
		else
		{
			boolean flag = false ;
			
			int count = 1 ;
			
			if( deletedirection == 1 )			//Head to Last
			{	
				NodeForDoublyLinkedList temp = head ;
				
				while( temp.data != data && temp.next != null )
				{
					temp = temp.next ;
					count++ ;
				}
				if( count == 1)
				{
					temp = head.next ;
					head = null ;
					temp.prev = null ;
					head = temp ;
					
					flag = true ;
					System.out.println(data+ " Deleted At Node "+count) ;
				}
				else if( count > 1 && temp.data == data )
				{
					NodeForDoublyLinkedList ptr = temp.prev ;
					
					NodeForDoublyLinkedList q = temp.next ;
					
					if( q != null)
					{
						ptr.next = q ;
						q.prev = ptr ;
					}
					else
					{
						temp = null ;
						ptr.next = null ;
						Last = ptr ;
					}
					flag = true ;
					System.out.println(data+ " Deleted At Node "+count) ;
				}
				else if(flag != true )
					System.out.println("Data not available in Doubly Linked List") ;
			}
			else
			{
				NodeForDoublyLinkedList temp = Last ;
				
				if( temp != null)
				{
					while( temp.data != data && temp.prev != null)
					{
						temp = temp.prev ;
						count++ ;
					}
					if( temp.data == data)
					{
						if( count == 1)
						{
							temp = Last.prev ;
							
							temp.next = null ;
							
							Last = temp ;
							flag = true ;
							System.out.println(data+ " Deleted From Last At Node "+count) ;
						}
						else
						{	
							if( temp.prev != null )
							{
								temp.prev.next = temp.next ;			//can be deleted
								temp.next.prev = temp.prev ;			//can be deleted
								
								temp = null ;
							}
							else
							{
								NodeForDoublyLinkedList ptr = temp.next ;
								head = ptr ;
								
								ptr.prev = null ;
								temp = null ;
							}
							flag = true ;
							System.out.println(data+ " Deleted From Last At Node "+count) ;
						}
					}
				}
				else if( flag != true )
					System.out.println("Data not available in Doubly Linked List") ;
			}
		}
	}
	void updatebyposition( int pos)
	{
		int count = 0 ;
		
		if( head == null)
		{
			System.out.println("Sorry, There is no Doubly Linked List");
		}
		else
		{
			count = 1 ;
			
			if( updatedirection == 1 )			//Head to Last
			{
				if( pos == 1)
				{
					System.out.print("Enter New Data :- ");
					head.data = sc.nextInt() ;
				}
				else
				{	
					NodeForDoublyLinkedList temp = head ;
					
					while(pos != count && temp.next != null)
					{
						temp = temp.next ;
						count++ ;
					}
					if( pos == count )
					{
						System.out.print("Enter New Data :- ");
						temp.data = sc.nextInt() ;
					}
					else
						System.out.println("Position not available in Doubly Linked List") ;
				}
			}
			else					//Last to Head
			{
				if( pos < 1)
				{
					System.out.println("Position Can't be Negative") ;
				}
				else if( pos == 1)
				{
					System.out.print("Enter New Data :- ");
					Last.data = sc.nextInt() ;
				}
				else
				{
					NodeForDoublyLinkedList temp = Last ;
					
					while( pos != count && temp.prev != null)
					{
						temp = temp.prev ;
						count++ ;
					}
					if( pos <= count )
					{
						System.out.print("Enter New Data :- ");
						temp.data = sc.nextInt() ;
					}
					else
					{
						System.out.println("Position not available in Doubly Linked List") ;
					}
				}
			}
			System.out.println("Data Updated") ;
		}
	}
	void updatebydata( int data)
	{
		if( head == null)
		{
			System.out.println("Sorry, There is no Doubly Linked List");
		}
		else
		{
			boolean flag = false ;
			
			int count = 1 ;
			
			if( deletedirection == 1 )			//Head to Last
			{	
				NodeForDoublyLinkedList temp = head ;
				
				while( temp.data != data && temp.next != null )
				{
					temp = temp.next ;
					count++ ;
				}
				if( temp.data == data)
				{
					flag = true ;
					System.out.print("Enter New Data :- ");
					temp.data = sc.nextInt() ;
					System.out.println("Data Updated") ;
				}
				if(flag != true )
					System.out.println("Data not available in Doubly Linked List") ;
			}
			else
			{
				NodeForDoublyLinkedList temp = Last ;			//Last to Head
				
				if( temp != null)
				{
					while( temp.data != data && temp.prev != null)
					{
						temp = temp.prev ;
						count++ ;
					}
					if( temp.data == data)
					{
						flag = true ;
						System.out.print("Enter New Data :- ");
						temp.data = sc.nextInt() ;
						System.out.println("Data Updated") ;
					}
				}
				if( flag != true )
					System.out.println("Data not available in Doubly Linked List") ;
			}
		}
	}
	void print( int opprinttype )
	{
		if( head == null)
		{
			System.out.println("Sorry, There is no Doubly Linked List");
		}
		else
		{
			if( opprinttype == 1 )				//Head to Last
			{
				NodeForDoublyLinkedList ptr = head ;
				
				while( ptr != null )
				{
					System.out.print(ptr.data +" ") ;
					ptr = ptr.next ;
				}
			}
			else								//Last to Head
			{
				NodeForDoublyLinkedList ptr = Last ;
				
				while( ptr!= null )
				{
					System.out.print(ptr.data + " ") ;
					ptr = ptr.prev ;
				} 
			}
			System.out.println();
		}
	}
	void length()
	{
		int startcount = 0, backcount = 0 ;
		NodeForDoublyLinkedList temp = null ;
		NodeForDoublyLinkedList ptr = null ;
		
		if( head != null)
		{
			ptr = Last ;
			temp = head ;
		}
		else
			System.out.println("There is no Doubly Linked List");
		
		while( temp != null)
		{
			temp = temp.next ;
			startcount++ ;
		}
		while( ptr != null)
		{
			ptr = ptr.prev ;
			backcount++ ;
		}
		if( startcount == backcount)
		{
			len = startcount ;
			System.out.println("Length :- "+startcount+" Nodes. ") ;
		}
		else
			System.out.println("Error");
	}
	void findbyposition( int pos)
	{
		int count = 0 ;
		if( head == null)
			System.out.println("No Doubly Linked list Available") ;
		
		else
		{
			count = 1 ;
			
			if( pos == 1)
			{
				System.out.println("Yes, "+head.data+" is available in Doubly Linked List") ;
			}
			else
			{
				NodeForDoublyLinkedList temp = head ;
				
				while(pos != count && temp.next != null)
				{
					temp = temp.next ;
					count++ ;
				}
				if( pos == count )
				{
					System.out.println(temp.data+" is available at position :- "+pos);
				}
				else
					System.out.println("Position not available in Doubly Linked List") ;
			}
		}
	}
	void findbydata( int data)
	{
		int count = 0 ;
		
		if( head == null)
		{
			System.out.println("Sorry, There is no Doubly Linked List");
		}
		else
		{
			count = 1 ;
			NodeForDoublyLinkedList temp = head ;
			int i = 1 ;
			while( temp.next != null)
			{
				i++ ;
				temp = temp.next ;
			}
			len = i ;
			String spos ="" ;
			
			temp = head ;
			for( i = 0 ; i< len; i++)
			{
				if( temp.data == data)
				{
					spos = spos + count +", " ;
				}
				temp = temp.next ;
				count++ ;
			}
			if( spos != "")
			{
				String pos[] = spos.split(", ") ;
				
				for( i = 0 ; i<pos.length ; i++)
				{
					System.out.println(data +" at position :- "+pos[i] );
				}
			}
			else
				System.out.println("Sorry, Data not Available.");
			
			System.out.println();
		}
	}
}