
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodsDemo my_demo_method = new MethodsDemo();
		String my_return = my_demo_method.getData();
		System.out.println(my_return);
		
		MethodsDemo2 my_demo_2 = new MethodsDemo2();
		my_demo_2.getUserData();
		
		getData2();
	}
	
	public String getData() // this method belongs to object, because there is no "static". So to run it you must use "my_demo_method.getData();"
	{
		System.out.println("Just a method to call");
		return "Another method to return.";
	}
	
	public static String getData2() // this method belongs to class "MethodsDemo", because there is "static". So to run it you can just call "getData2();"
	{
		System.out.println("Just a method from getData2");
		return "Return string from getData2.";
	}

}
