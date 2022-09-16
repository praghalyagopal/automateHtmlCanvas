package test.java;

import main.java.pageEvents.DrawActions;
import org.testng.annotations.Test;

import java.io.IOException;

public class SampleTest extends BaseTest {
    Object canvasInstance;

    @Test
    public void drawOnHtmlCanvas() throws IOException {
        DrawActions drawActions = new DrawActions();
        canvasInstance = drawActions.getCanvas();
        drawActions.clickOnLineButton();
        drawActions.drawHorizontalLine(canvasInstance, 200, 175, 200, 5, "#000000");
        drawActions.drawVerticalLine(canvasInstance, 300, 75, 200, 5, "#000000");
        drawActions.clickOnRectangleButton();
        drawActions.drawRectangle(canvasInstance, 200, 300, 200, 150, 5, "#000000");
        drawActions.clickOnEraseButton();
        drawActions.eraseHorizontalLine(canvasInstance, 200, 175, 200);
        drawActions.TakeScreenShot();
    }
}
