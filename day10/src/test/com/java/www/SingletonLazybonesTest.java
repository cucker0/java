package test.com.java.www; 

import com.java.www.SingletonLazybones;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SingletonLazybones Tester. 
* 
* @author <Authors name> 
* @since <pre>06/20/2019</pre> 
* @version 1.0 
*/ 
public class SingletonLazybonesTest { 

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
        SingletonLazybones s1 = SingletonLazybones.getInstance();
        SingletonLazybones s2 = SingletonLazybones.getInstance();
        SingletonLazybones s3 = SingletonLazybones.getInstance();

        System.out.println(s1 == s2 && s1 == s2);
    }


} 
