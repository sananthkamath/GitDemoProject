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

 

public class testngExample1 {    
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("Executing BeforeSuite");
    }
    
    @AfterSuite
    public void AfterSuite(){
        System.out.println("Executing AfterSuite");
    }
    
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Executing BeforeTest");
    }
    
    @AfterTest
    public void AfterTest(){
        System.out.println("Executing AfterTest");
    }
    
    @BeforeClass
    public void BeforeClass(){
        System.out.println("Executing BeforeClass");
    }
    
    @AfterClass
    public void AfterClass(){
        System.out.println("Executing AfterClass");
    }
    
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Executing BeforeMethod");
    }
    
    @AfterMethod
    public void AfterMethod(){
        System.out.println("Executing AfterMethod");
    }    
    
    @Test
    public void Test1(){
        System.out.println("Test1");
        
    }
    @Test
    public void Test2(){
        System.out.println("Test2");
        
    }
}