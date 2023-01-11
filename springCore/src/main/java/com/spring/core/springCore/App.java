package com.spring.core.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ap=new AnnotationConfigApplicationContext(JavaConfig.class);
        Student st=ap.getBean(Student.class);
        st.setNo(12);
        st.setStname("Dileep");
        MarksList ma=ap.getBean(MarksList.class);
        ma.setStno(12);
        ma.setTotalMarks(2343);
        st.setMarsk(ma);
        System.out.println(st);
        
        
        
    }
}
