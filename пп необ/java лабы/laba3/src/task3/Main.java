package task3;

import by.vsu.mf.ai.ssd.strings.*;

public class Main {
    public static void main(String[] args) {
        Job job = new MyJob();
        Manager manager = new Manager();

        Manager.createWindow(job);
    }
}
