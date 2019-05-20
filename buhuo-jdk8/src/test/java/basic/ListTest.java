package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(2);
		al.add(1);
		al.add(3);
		
		LinkedList ll = new LinkedList<>();
		ll.add(2);
		ll.add(1);
		ll.add(3);
		
		System.out.println(ll.equals(al));

        ListIterator e1 = al.listIterator();
        ListIterator e2 = ll.listIterator();
//        while (e1.hasNext() && e2.hasNext()) {
//        	Object o1 = e1.next();
//            Object o2 = e2.next();
//            if (!(o1==null ? o2==null : o1.equals(o2)))
//                System.out.println(false);
//        }
//        System.out.println(!(e1.hasNext() || e2.hasNext()));
    
	}

}
