package DoublyLinkedList;

import java.util.Scanner;
import java.util.Random ;

public class DoublyLinkedListFunctionCalling
{
	Scanner sc ;
	Random rn ;
	DoublyLinkedListFunction dllf ;
	
	DoublyLinkedListFunctionCalling()
	{
		sc = new Scanner( System.in ) ;
		rn = new Random() ;
		dllf = new DoublyLinkedListFunction() ;
		
		while( true )
		{
			System.out.print("1.Insert, 2. Delete, 3. Print, 4. Update, ") ;
			System.out.println("5. Length of Doubly Linked List, 6.Find Node, ") ;
			System.out.println("7. Exit :- ") ;
			
			int op = sc.nextInt() ;
			System.out.println();
			
			if( op == 1)
			{
				System.out.print("How many numbers, you want to insert ? :-  ") ;
				int opinsert = sc.nextInt() ;
				System.out.println();
				
				while( true)
				{
					System.out.print("1.Front Side Adding, 2. Back Side Adding, 3. Exit :- ") ;
					int opinserttype = sc.nextInt() ;
					System.out.println();
					
					if( opinserttype == 1 || opinserttype == 2)
					{
						for( int i = opinsert ; i>0 ; i--)
						{
							dllf.insert( (rn.nextInt(50) + 1 ), opinserttype) ;
						}
						break ;
					}
					else if( opinserttype == 3)
						break ;
					else
						System.out.println("Wrong Input, Please Try Again");
				}
			}
			else if( op == 2)
			{
				while( true )
				{
					System.out.print("Direction from, 1. Head to Last or 2. Last to Head :- ") ;
					int deletedirection = sc.nextInt() ;
					System.out.println();
					if( deletedirection == 1 || deletedirection == 2)
					{
						dllf.passdeletedirection( deletedirection ) ;
						break ;
					}
					else
						System.out.print("Wrong Input, Please Try Again") ;
				}
				while( true )
				{
					System.out.print("Delete by, 1.Position or 2.By Data, 3.Exit :- ") ;
					int opdelete = sc.nextInt() ;
					System.out.println();
					if( opdelete == 1)
					{
						System.out.print("Which position ? :- ") ;
						int pos = sc.nextInt() ;
						System.out.println();
						dllf.deletebyposition( pos ) ;
					}
					else if( opdelete == 2)
					{
						System.out.print("Which Data ? :- ") ;
						int data = sc.nextInt() ;
						System.out.println();
						dllf.deletebydata( data ) ;
					}
					else if( opdelete == 3)
						break ;
					else
						System.out.println("Wrong Input, Try Again") ;
				}
			}
			else if ( op == 3)
			{
				while( true)
				{
					System.out.print("1. Head to Last, 2. Last to Head ?, 3. Exit :- ") ;
					int opprinttype = sc.nextInt() ;
					System.out.println();
					if( opprinttype == 1 || opprinttype == 2)
						dllf.print( opprinttype ) ;
					
					else if( opprinttype == 3 )
						break ;
					else
						System.out.println("Wrong Input, Please Try Again") ;
				}
			}
			
			else if( op == 4)
			{
				while( true )
				{
					System.out.print("Direction from, 1. Head to Last or 2. Last to Head :- ") ;
					int updatedirection = sc.nextInt() ;
					System.out.println();
					if( updatedirection == 1 || updatedirection == 2)
					{
						dllf.passupdatedirection( updatedirection ) ;
						break ;
					}
					else
						System.out.print("Wrong Input, Please Try Again") ;
				}
				while( true )
				{
					System.out.print("Delete by, 1.Position or 2.By Data, 3.Exit :- ") ;
					int opdelete = sc.nextInt() ;
					System.out.println();
					if( opdelete == 1)
					{
						System.out.print("Which position ? :- ") ;
						int pos = sc.nextInt() ;
						System.out.println();
						dllf.updatebyposition( pos ) ;
					}
					else if( opdelete == 2)
					{
						System.out.print("Which Data ? :- ") ;
						int data = sc.nextInt() ;
						System.out.println();
						dllf.updatebydata( data ) ;
					}
					else if( opdelete == 3)
						break ;
					else
						System.out.println("Wrong Input, Try Again") ;
				}
			}
			else if( op == 5)
				dllf.length() ;
			else if( op == 6)
			{
				while( true)
				{
					System.out.println("Find by, 1. Position or 2. Data, 3. Exit") ;
					int opfind = sc.nextInt() ;
					
					if( opfind == 1)
					{
						System.out.print("Enter the position :- ") ;
						dllf.findbyposition( sc.nextInt() ) ;
					}
					else if( opfind == 2)
					{
						System.out.print("Enter the data :- ") ;
						dllf.findbydata( sc.nextInt() ) ;
					}
					else if( opfind == 3)
						break ;
					else
						System.out.println("Wrong Input, Please Try Again") ;
				}
			}
			else if( op == 7)
				break ;
			else
				System.out.println("Wrong Input, Please Try Again") ;
		}
	}
}