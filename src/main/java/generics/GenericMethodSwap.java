package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodSwap {

	public static void main(String[] args) {
		Integer[] intArray = new Integer[4];
		intArray[0] = 1;
		intArray[1] = 2;
		System.out.println("Before swap:::"+intArray[0]+","+intArray[1]);
		swap(intArray, 0, 1);
		System.out.println("After swap:::"+intArray[0]+","+intArray[1]);
		System.out.println("----WithOutGenerics----");
		
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		swapWithOutGenerics(l1, l2);
	}
	static private <T> void swap(T[] t, int t1, int t2) {
		T temp = t[t1];
		t[t1] = t[t2];
		t[t2] = temp;
	}
	
	static private <E> void swap_UnboundedTypeParameter(List<E> list, int i1, int i2) {
		E element = list.get(i1);
		list.add(i1, list.get(i2));
		list.add(i2, element);
	}
	
	static private void swap_UnboundedWildCardParameter(List<?> list, int i1, int i2) {
		E element = list.get(i1);
		list.add(i1, list.get(i2));
		list.add(i2, element);
	}

}

