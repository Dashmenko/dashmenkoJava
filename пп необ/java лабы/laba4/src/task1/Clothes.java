package task1;

public class Clothes {
    private final int buttonsAmount;
    private final int buttonDarningTime;
    private int processingTime;
    private int darningTime;

    public Clothes(int buttonsAmount,
                   int buttonDarningTime,
                   int processingTime) {
        this.buttonsAmount = buttonsAmount;
        this.buttonDarningTime = buttonDarningTime;
        this.processingTime = processingTime;
        darningTime = buttonsAmount * buttonDarningTime;
    }

    public int getButtonsAmount() {
        return buttonsAmount;
    }

    public int getDarningTime() {
        return darningTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void decreaseDarningTime() {
        darningTime--;
    }

    public void decreaseProcessingTime() {
        processingTime--;
    }
}
