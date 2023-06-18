import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJava2 {

	public static void main(String[] args) {
		
		// if ... else statement
		int[] num_array = {1, 2, 3, 5, 4 ,6 ,88 ,8 ,97 ,122};
		
		for (int i=0; i<num_array.length; i++)
		{
			if (num_array[i] % 2 == 0)
			{
				System.out.println(num_array[i]);
			}
			else
			{
				System.out.println(num_array[i] + " is not multiple of 2");
			}
		}
		
		System.out.println("***********************");
		
		// ArrayList
		// - let us dynamically change the size
		ArrayList<String> my_arraylist = new ArrayList<String>();
		my_arraylist.add("Java"); // add an element to ArrayList
		my_arraylist.add("Python");
		my_arraylist.add("JavaScript");
		my_arraylist.add("C++");
		System.out.println(my_arraylist.get(2)); // return the value of the element number 2
		
		// for loop for ArrayList
		for (int i = 0; i < my_arraylist.size(); i++)
		{
			System.out.println(my_arraylist.get(i));
		}
		
		System.out.println("***********************");
		
		// the short form of the ArrayList for loop
		for (String my_val :my_arraylist)
		{
			System.out.println(my_val);
		}
		
		System.out.println("***********************");
		
		System.out.println(my_arraylist.contains("Ruby")); // check if the ArrayList has the element with this value
		System.out.println(my_arraylist.contains("Python"));
		
		System.out.println("***********************");
		
		// transform the Array into ArrayList
		String[] city_array = {"London", "Berlin", "Madrid", "Warsaw"};
		List<String> city_arraylist = Arrays.asList(city_array);
		System.out.println(city_arraylist.contains("London"));

	}

}
