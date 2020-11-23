package testngPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngExample2
{
	@BeforeSuite
    public void BeforeSuite(){
        System.out.println("testngExample2 - Executing BeforeSuite");
    }
    
    @AfterSuite
    public void AfterSuite(){
        System.out.println("testngExample2 - Executing AfterSuite");
    }
    
    @BeforeTest
    public void BeforeTest(){
        System.out.println("testngExample2 - Executing BeforeTest");
    }
    
    @AfterTest
    public void AfterTest(){
        System.out.println("testngExample2 - Executing AfterTest");
    }
    
    @BeforeClass
    public void BeforeClass(){
        System.out.println("testngExample2 - Executing BeforeClass");
    }
    
    @AfterClass
    public void AfterClass(){
        System.out.println("testngExample2 - Executing AfterClass");
    }
    
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("testngExample2 - Executing BeforeMethod");
    }
    
    @AfterMethod
    public void AfterMethod(){
        System.out.println("testngExample2 - Executing AfterMethod");
    }    
    
    @Test
    public void Test1(){
        System.out.println("testngExample2 - Test1");
        
    }
    @Test
    public void Test2(){
        System.out.println("testngExample2 - Test2");
        
    }
}
