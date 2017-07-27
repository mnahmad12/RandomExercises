

/*
Author: Noor Ahmad
Date:   07/27

Creating a Stack from a Queue

Refresher:
What is a stack? A stack is a data structure with 
FILO characteristics. Items are *pushed* onto the 
top of the stack and *popped* from the top.

 __
|__| <--Top of Stack (Items placed here)
|__| 
|__| 
|__|
|__| <-- Bottom of Stack 

Necessary functions of a stack:
push(item): given an item place it on the stack
pop():      remove top  item from stack  

What makes this exercise interesting? Implementing a stack with a Queue,
which  is an inherently a very different data structure (FIFO).

Approach: 
Use 2 queues (Q1,Q2).Insert item onto Q2. 
dequeue everything from Q1 and enqueue to Q2. Rename Q1->Q2, Q2->Q1
pop from q1

Example:
Step 1:
push(1)
Q2: [1]
Q1: 
-------------
Q1: [1]
Q2: 

Step 2:
push(2)
Q2: [2]
Q1: [1]
-------------
Q2: [1][2]
Q1: 
-------------
Q1: [1][2]
Q2: 
*/

import java.util.*;

public class QueueStack
{
	Queue<Integer> Q1=new LinkedList<Integer>();
	Queue<Integer> Q2=new LinkedList<Integer>();

	private void clearToQ2(Queue<Integer> q1,Queue<Integer> q2)
	{
		//Dequeue Q1, Enqueue Q2
		while(!q1.isEmpty())
		{
			
			Integer poppedItem=q1.remove();
			q2.add(poppedItem);
		}

	}

	private Queue<Integer> getQ1() {return this.Q1;}
	private Queue<Integer> getQ2() {return this.Q2;}

	private Queue setQ1(Queue<Integer> q) 
	{
		this.Q1=q;
		return this.Q1;
	}
	
	private Queue setQ2(Queue<Integer> q) 
	{
		this.Q2=q;
		return this.Q2;
	}

	public void push(Integer item)
	{
		//Push an item onto the QueueStack
		//Following the approach given above
		this.getQ2().add(item);

		this.clearToQ2(this.getQ1(),this.getQ2());
		
		//rename
		Queue<Integer> holder=this.getQ1();
		this.setQ1(this.getQ2());
		this.setQ2(holder);

	}

	public Integer pop()
	{
		return this.getQ1().remove();
	}

	public void printQueueStack()
	{
		System.out.println(this.getQ1());
	}

	public static void main(String[]args)
	{
		QueueStack test=new QueueStack();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.printQueueStack();
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
		test.printQueueStack();
	}

} 





