package java8;

import java.util.Arrays;
import java.util.List;

public class TotalElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Given a list of integers, find the total number of elements present in the list using Stream functions?
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		 
		 long a = myList.stream().count();
		 System.out.println(a);
		 
		 /* or can also try below line code */
		 /* When numbers are given as Array int[] arr = {10,15,8,49,25,98,98,32,15}; */
		 int[] arr = {10,15,8,49,25,98,98,32,15};
		 long h = Arrays.stream(arr).boxed().count();
		 System.out.println(h);
	}

}
