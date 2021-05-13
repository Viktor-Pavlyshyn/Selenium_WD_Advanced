package grid;

import org.openqa.grid.selenium.GridLauncherV3;

public class Hub {

    public static void main(String[] args) {
        GridLauncherV3.main(new String[]{"-role", "hub", "-port", "4444"});
    }
}