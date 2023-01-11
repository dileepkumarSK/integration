package com.inner.classes;

import com.inner.classes.InnerClasses.protectedInner2;

public class AnotherClass {

	public static void main(String[] args) {
		InnerClasses incl=new InnerClasses();
		incl.me();
		InnerClasses.protectedInner2  prtc=new protectedInner2();
		prtc.innerclasse();
	}
}
