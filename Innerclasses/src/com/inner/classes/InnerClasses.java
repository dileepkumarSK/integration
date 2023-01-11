package com.inner.classes;



public class InnerClasses {

	public InnerClasses() {
		super();
		System.err.println("main inner claess");
	}

	public void mwthod() {
		System.out.println("InnerClasses.meth()");
	}

	void me() {
		System.out.println("InnerClasses.me()");
	}
	public static void main(String[] args) {
		
		InnerClasses cl=new InnerClasses();
		cl.me();
		cl.mwthod();
		
		
		InnerClasses.PrivateInner icl= cl.new PrivateInner();
		
		InnerClasses.protectedInner2 icl2= new protectedInner2();
		icl2.innerclasse();
		
		icl.innerclasse();
		
	}
	
	
	
	private class PrivateInner{
		public PrivateInner() {
			System.err.println("InnerClasses.Inner.Inner()");
		}
		public void innerclasse()
		{
			System.out.println("InnerClasses.Inner.innerclasse()");
		}
	}
	

	protected static class protectedInner2{
		
		public protectedInner2() {
			System.err.println("InnerClasses.Inner2.Inner2()");
			
		}

		public void innerclasse()
		{
			
			System.out.println("InnerClasses.Inner.innerclasse()2222222");
		}
	}
	
	
	
	
	
}
