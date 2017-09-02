package reddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		String[] ar1 = {"sasi" ,"indu", "aruna"};
		int[] ar2 = {1,2,4,5,7,9};
		System.out.println("String array size :"+ar1.length);
		System.out.println("Integer array size : "+ar2.length);
	
		
		List<String> x = Arrays.asList("xyz", "abc");
		System.out.println(x.size());
		System.out.println(x);
		
		
	}

	
}
