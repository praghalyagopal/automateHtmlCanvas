package main.java.pageEvents;

import main.java.pageObjects.canvasElements;
import main.java.utils.ElementFetch;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.java.BaseTest;

import java.io.File;
import java.io.IOException;

import static test.java.BaseTest.driver;

public class DrawActions {
    ElementFetch elementFetch = new ElementFetch();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public Object getCanvas()
    {
        String id = canvasElements.canvasElement;
        return  js.executeScript("canvas = document.getElementById('"+id+"');" +
                "context = canvas.getContext('2d');");
    }
    public void clickOnLineButton() {
        elementFetch.getWebElement("XPATH", canvasElements.lineButton).click();
    }

    public void clickOnRectangleButton() {
        elementFetch.getWebElement("XPATH", canvasElements.rectangleButton).click();
    }
    public void clickOnEraseButton() {
        elementFetch.getWebElement("XPATH", canvasElements.eraserButton).click();
    }

    public void drawHorizontalLine(Object context, int xPosition,int yPosition,int length,int thickness,String color)  {
        int xEndPosition = xPosition + length;
        js.executeScript(
                "context.lineWidth = "+thickness+";" +
                "context.strokeStyle = '"+color+"';" +
                "context.beginPath();" +
                "context.moveTo("+xPosition+","+ yPosition+");" +
                "context.lineTo("+xEndPosition+","+ yPosition+");" +
                "context.stroke();" +
                "context.closePath();", context);
    }
    public void drawVerticalLine(Object context,int xPosition,int yPosition,int length,int thickness,String color)  {
        int yEndPosition = yPosition + length;
        js.executeScript(
                "context.lineWidth = "+thickness+";" +
                        "context.strokeStyle = '"+color+"';" +
                "context.beginPath();" +
                        "context.moveTo("+xPosition+","+ yPosition+");" +
                        "context.lineTo("+xPosition+","+ yEndPosition+");" +
                "context.stroke();" +
                "context.closePath();",context);

    }
    public void drawRectangle(Object context,int xPosition,int yPosition,int width,int height,int thickness,String color) {

        js.executeScript(
                "context.lineWidth = "+thickness+";" +
                        "context.strokeStyle = '"+color+"';" +
                "context.strokeRect("+xPosition+","+yPosition+","+width+","+height+");",context);
    }
    public void eraseHorizontalLine(Object context,int xPosition,int yPosition,int length)  {
        int xEndPosition = xPosition + length;
        js.executeScript(
                "context.lineWidth = 7;" +
                "context.strokeStyle = '#FFFFFF';" +
                "context.beginPath();" +
                        "context.moveTo("+xPosition+","+ yPosition+");" +
                        "context.lineTo("+xEndPosition+","+ yPosition+");" +
                "context.stroke();" +
                "context.closePath();",context);

    }
    public void TakeScreenShot()
    {
        File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "FinalImage.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

