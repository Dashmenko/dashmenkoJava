package task3;

import by.vsu.mf.ai.ssd.strings.Job;

import static task2.Main.parseString;

public class MyJob implements Job {
    @Override
    public void perform(StringBuilder str) {
        StringBuilder result = new StringBuilder();
        result.append(parseString(str.toString()));
        str.delete(0, str.length());
        str.append(result);
    }
}
