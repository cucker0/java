package test.com.java.www; 

import com.java.www.Singleton;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Singleton Tester. 
* 
* @author <Authors name> 
* @since <pre>06/20/2019</pre> 
* @version 1.0 
*/ 
public class SingletonTest { 

    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: getInstance() 
    * 
    */ 
    @Test
    public void testGetInstance() throws Exception { 
    //TODO: Test goes here...
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    } 


} 
