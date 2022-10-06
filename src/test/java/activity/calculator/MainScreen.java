package activity.calculator;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button fiveButton = new Button(By.id("com.android.calculator2:id/digit_5"));
    public Button threeButton = new Button(By.id("com.android.calculator2:id/digit_3"));
    public Button equalButton = new Button(By.xpath("//android.widget.Button[@content-desc=\"equals\"]"));
    public Button addButton = new Button(By.id("com.android.calculator2:id/op_add"));
    public Label resultLabel = new Label(By.id("com.android.calculator2:id/result"));

}
