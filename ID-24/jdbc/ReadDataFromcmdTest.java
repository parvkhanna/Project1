package jdbc;

import org.testng.annotations.Test;

public class ReadDataFromcmdTest {
	
	@Test
	public void ReadDataFromcmd()
	{
		String URL=System.getProperty("url");
		System.out.println(URL);
		
		String BROWSER = System.getProperty("browser");
				System.out.println(BROWSER);
	}

}