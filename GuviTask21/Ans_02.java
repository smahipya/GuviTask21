package GuviTask21;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ans_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		String homewindow = driver.getWindowHandle();
		System.out.println("HomeWindow is: " + homewindow);
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

		
		Set<String> totalwindow = driver.getWindowHandles();
		System.out.println("TotalWindow are :" + totalwindow);

		List<String> list = new ArrayList<String>(totalwindow);
		driver.switchTo().window(list.get(1));
		String text = driver.findElement(By.xpath("//div/h3[contains(.,'New Window')]")).getText();
		System.out.println(text);
		System.out.println("FirstWindow url is: " + driver.getCurrentUrl());
		driver.close();

		Set<String> totalwindow1 = driver.getWindowHandles();
		list.clear();
		list.addAll(totalwindow1);
		driver.switchTo().window(list.get(0));

		System.out.println("HomeWindow url is: " + driver.getCurrentUrl());

	}

}
/*
Output :
	
	HomeWindow is: 251AF890C00FC67D73D0C6ACF3DF39A4
	TotalWindow are :[251AF890C00FC67D73D0C6ACF3DF39A4, AE5648FB4C5B4A74C30D3D10AC39E1B5]
	New Window
	FirstWindow url is: https://the-internet.herokuapp.com/windows/new
	HomeWindow url is: https://the-internet.herokuapp.com/windows
*/	
