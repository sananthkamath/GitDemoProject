package JavaPack;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadFromTheFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		try
		{
			Object obj = parser.parse(new FileReader("./src/com/project/testdata/course.json"));
			JSONObject jsonObject = (JSONObject)obj;
			String name = (String)jsonObject.get("Name");
			String course = (String)jsonObject.get("Course");
			JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
			System.out.println("Name: " + name);
			System.out.println("Course: " + course);
			System.out.println("Subjects: ");
			Iterator i = subjects.iterator();
			while(i.hasNext())
			{
				System.out.println(i.next());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
