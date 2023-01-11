package com.inner.methodrefrence;

public class MethodRefrence {

	public static void main(String[] args) {
		
		//PrintMyname my=  (x) ->	System.out.print(x);
				
	//	PrintMyname my=new MethodRefrence()::myname;
		
		PrintMyname my=MethodRefrence::new;

		
		my.print("hello");
			
			
			
		
	}
	
	
	/*
	 * public static void myname(Object ob) { System.out.println(ob); }
	 */
	public void myname(Object ob)
	{
		System.out.println(ob);
	}


	public MethodRefrence(Object ob) {
		System.out.println(ob);
	}


	public MethodRefrence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

