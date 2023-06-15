
public class MethodsDemo2 {
	
	public String getUserData() // if you change the method from "public" to "private", than you can't access to this method from another class.
	{
		System.out.println("Just a method from another file");
		return "Method to return from outer file.";
	}

}
