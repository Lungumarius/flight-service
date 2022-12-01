package com.example.flightservice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void proceedToFlights() throws InterruptedException {
        driver.get("http://localhost:3000/");

        //Wait for the page to load
        Thread.sleep(10000);
            //adding a team
            WebElement input = driver.findElement(By.xpath("//div[@id='origin']"));
            input.click();
        Thread.sleep(3000);
        WebElement input2 = driver.findElement(By.xpath("//li[@id='ath']"));
        input2.click();
        Thread.sleep(3000);
        WebElement input3 = driver.findElement(By.xpath("//div[@id='destination']"));
        input3.click();
        Thread.sleep(3000);
        WebElement input4 = driver.findElement(By.xpath("//li[@id='mad2']"));
        input4.click();
        Thread.sleep(3000);
        WebElement input5 = driver.findElement(By.xpath("//a[@id='search']"));
        input5.click();
        Thread.sleep(3000);

        driver.get("http://localhost:3000/results/");

        Thread.sleep(10000);
        //Results page
        WebElement input6 = driver.findElement(By.xpath("//div[@id='airlineFilter']"));
        input6.click();
        Thread.sleep(3000);

        //Airline Filter
        WebElement input7 = driver.findElement(By.xpath("//li[@id='aegean']"));
        input7.click();
        Thread.sleep(200);
        input6.click();
        Thread.sleep(3000);
        WebElement input8 = driver.findElement(By.xpath("//li[@id='iberia']"));
        input8.click();
        Thread.sleep(200);
        input6.click();
        Thread.sleep(3000);
        WebElement input9 = driver.findElement(By.xpath("//li[@id='ryanair']"));
        input9.click();
        Thread.sleep(200);
        input6.click();
        Thread.sleep(3000);
        WebElement input10 = driver.findElement(By.xpath("//li[@id='allAir']"));
        input10.click();

        //Luggage Filter
        Thread.sleep(3000);
        WebElement input11 = driver.findElement(By.xpath("//div[@id='luggageFilter']"));
        input11.click();
        Thread.sleep(3000);
        WebElement input12 = driver.findElement(By.xpath("//li[@id='allowL']"));
        input12.click();

        Thread.sleep(3000);
        input11.click();
        Thread.sleep(3000);
        WebElement input13 = driver.findElement(By.xpath("//li[@id='notAllowedL']"));
        input13.click();
        Thread.sleep(3000);

        //Scales Filter
        Thread.sleep(3000);
        WebElement input14 = driver.findElement(By.xpath("//div[@id='scalesFilter']"));
        input14.click();
        Thread.sleep(3000);
        WebElement input15 = driver.findElement(By.xpath("//li[@id='descendScales']"));
        input15.click();

        Thread.sleep(3000);
        input14.click();
        Thread.sleep(3000);
        WebElement input16 = driver.findElement(By.xpath("//li[@id='ascendScales']"));
        input16.click();
        Thread.sleep(3000);

        input14.click();
        Thread.sleep(3000);
        WebElement input17 = driver.findElement(By.xpath("//li[@id='noScales']"));
        input17.click();
        Thread.sleep(3000);

        //Schedule Filter
        Thread.sleep(3000);
        WebElement input18 = driver.findElement(By.xpath("//div[@id='scheduleFilter']"));
        input18.click();
        Thread.sleep(3000);
        WebElement input19 = driver.findElement(By.xpath("//li[@id='descendSchedule']"));
        input19.click();

        Thread.sleep(3000);
        input18.click();
        Thread.sleep(3000);
        WebElement input20 = driver.findElement(By.xpath("//li[@id='ascendSchedule']"));
        input20.click();
        Thread.sleep(3000);

        input18.click();
        Thread.sleep(3000);
        WebElement input21 = driver.findElement(By.xpath("//li[@id='noSchedule']"));
        input21.click();
        Thread.sleep(3000);

//            System.out.println(rowCount2);
//            assertEquals(rowCount, rowCount2);

            //checking if the new team was added
        }
}
