package grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.grid.selenium.GridLauncherV3;

import static utils.DataPropLoader.getNodeCapabilityProperty;

public class Node {
    // linux java -Dwebdriver.gecko.driver="/home/linuxnode/Downloads/geckodriver" -Dwebdriver.chrome.driver="/home/linuxnode/Downloads/chromedriver" -jar selenium-server-standalone.jar -role node -port 5555 -hub http://192.168.0.105:4444/grid/register
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.iedriver().setup();
        GridLauncherV3.main(new String[]{"-role", "node", "-hub",
                getNodeCapabilityProperty("node.url") + "/grid/register",
                "-port", "5555"});
    }
}