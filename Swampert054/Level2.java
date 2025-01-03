package Swampert054;

public class Level2 {
	public static Node<Integer> merge(Node<Integer> a, Node<Integer> b) //1
	{
		Node<Integer> c = new Node<Integer>(-1);
		Node<Integer> d = c;
		while(a != null || b != null)
		{
			if(a == null)
			{
				d.setNext(b);
				d = d.getNext();
				b = b.getNext();
			}
			else if(b == null)
			{
				d.setNext(a);
				d = d.getNext();
				a = a.getNext();
			}
			else if(a.getValue() <= b.getValue())
			{
				d.setNext(a);
				d = d.getNext();
				a = a.getNext();
			}
			else
			{
				d.setNext(b);
				d = d.getNext();
				b = b.getNext();
			}
		}
		return c.getNext();
	}
	public static int findMin(Node<Integer> a) // 2
	{
	    int min = a.getValue();
	    a = a.getNext();
	    while (a != null) 
	    {
	        if (a.getValue() < min) 
	        {
	            min = a.getValue();
	        }
	        a = a.getNext();
	    }
	    return min;
	}
	public static Node<Integer> Delete(Node<Integer> a, int num) //5
	{
		if (a == null)
		{
			return a;
		}
		if (a.getValue() == num) 
	        return a.getNext();
		Node<Integer> p = a;
		boolean flag = false;
		while(p != null && p.getNext() != null) 
		{
			if(p.getNext().getValue() == num && !flag) 
			{
				p.setNext(p.getNext().getNext());
				flag = true;
			}
			p = p.getNext();
		}
		return a;
	}
	public static Node<Integer> order(Node<Integer> a) // 2
	{
	    Node<Integer> c = new Node<Integer>(-1);
	    Node<Integer> d = c;
	    if(a == null || a.getNext() == null)
	    {
	        return a;
	    }
	    while(a != null) 
	    {
	        int min = findMin(a);
	        Node<Integer> b = null;
	        Node<Integer> current = a;
	        Node<Integer> minNode = null;
	        boolean found = false;
	        while(current != null)
	        {
	            if(current.getValue() == min && !found)
	            {
	                minNode = current;
	                if(b == null) 
	                {
	                    a = a.getNext();
	                } 
	                else 
	                {
	                    b.setNext(current.getNext());
	                }
	                found = true;
	            } 
	            else 
	            {
	                b = current;
	            }
	            current = current.getNext();
	        }
	        if(minNode != null) 
	        {
	            d.setNext(minNode);
	            d = d.getNext();
	            d.setNext(null);
	        }
	    }
	    return c.getNext();
	}
	public static int counter(Node<Integer> a, int num) //3
	{
		int count = 0;
		int index = 0;
		int finalindex = -1;
		Node<Integer> b = a;
		while(b != null)
		{
			if(b.getValue() == num)
			{
				finalindex = index;
			}
			b = b.getNext();
			index++;
		}
		if(finalindex == -1)
		{
			return -1;
		}
		b = a;
		index = 0;
		while(b != null)
		{
			if(b.getValue() != num && index < finalindex)
			{
				count++;
			}
			b = b.getNext();
			index++;
		}
		return count;
	}
	public static boolean copy(Node<Integer> a) //4
	{
		Node<Integer> b = a;
		while(b != null)
		{
			Node<Integer> c = b.getNext();
			while(c != null)
			{
				if(c.getValue().equals(b.getValue()))
				{
					return false;
				}
				c = c.getNext();
			}
			b = b.getNext();
		}
		return true;
	}
	public static Node<Integer> deleteExtra(Node<Integer> a) //5
	{
		Node<Integer> b = a;
		Node<Integer> d = a;
		while(b != null && b.getNext() != null)
		{
			Node<Integer> c = b.getNext();
			while(c != null)
			{
				if(c.getValue().equals(b.getValue()))
				{
					d = Delete(b, b.getValue());
				}
				c = c.getNext();
			}
			b = b.getNext();
		}
		return d;
	}
	public static void main(String[] args) {
		Node<Integer> a = new Node<Integer>(4);
		Node<Integer> b = new  Node<Integer>(7);
		Node<Integer> c = new Node<Integer>(11);
		Node<Integer> d = new Node<Integer>(16);
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		Node<Integer> e = new Node<Integer>(3);
		Node<Integer> f = new  Node<Integer>(5);
		Node<Integer> g = new Node<Integer>(9);
		Node<Integer> h = new Node<Integer>(20);
		e.setNext(f);
		f.setNext(g);
		g.setNext(h);
		System.out.println(a);
		System.out.println(order(a));

	}

}
