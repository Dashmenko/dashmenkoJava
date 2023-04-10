package task1;

import task1.myCollections.Queue;
import task1.myCollections.Stack;

import java.util.Scanner;

public class Main {
    public static Queue<Clothes> inputClothesQueue() {
        Queue<Clothes> clothesQueue = new Queue<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько предметов одежды: ");
        int clothesAmount = sc.nextInt();
        for (int i = 0; i < clothesAmount; ++i) {
            System.out.println("\n" + (i + 1) + "-ая вещь");
            System.out.print("Количество пуговиц, которые необходимо пришить: ");
            int buttonAmount = sc.nextInt();
            System.out.print("Время на штопку (целое число в секундах): ");
            int buttonDarningTime = sc.nextInt();
            System.out.print("Время поступления на обработку: ");
            int processingTime = sc.nextInt();

            clothesQueue.push(new Clothes(buttonAmount, buttonDarningTime, processingTime));
        }

        return clothesQueue;
    }

    public static void main(String[] args) {
        Queue<Clothes> clothesQueue = inputClothesQueue();
        Stack<Clothes> startStack = new Stack<>();
        Stack<Clothes> bufferedStack = new Stack<>();
        Stack<Clothes> finishStack = new Stack<>();
        Seamstress first = new Seamstress(startStack, bufferedStack);
        Seamstress second = new Seamstress(bufferedStack, finishStack);

        while (!clothesQueue.isEmpty()) {
            // 0
            if (first.isBusy()) {
                first.increaseWorkingTime();
            } else {
                first.increaseDownTime();
            }
            if (second.isBusy()) {
                second.increaseWorkingTime();
            } else {
                second.increaseDownTime();
            }

            // 1
            clothesQueue.peek().decreaseProcessingTime();

            // 2
            if (clothesQueue.peek().getProcessingTime() == 0) {
                startStack.push(clothesQueue.pop());
            }

            // 3
            if (!startStack.isEmpty() && !first.isBusy()) {
                first.addCurrentClothes(startStack.pop());
            }
            if (!bufferedStack.isEmpty() && !second.isBusy()) {
                second.addCurrentClothes(bufferedStack.pop());
            }

            // 4
            if (first.isBusy() && first.getCurrentClothes().getDarningTime() == 0) {
                bufferedStack.push(first.removeCurrentClothes());
            } else if (first.isBusy()) {
                first.getCurrentClothes().decreaseDarningTime();
            }
            if (second.isBusy() && second.getCurrentClothes().getDarningTime() == 0) {
                finishStack.push(second.removeCurrentClothes());
            } else if (second.isBusy()) {
                second.getCurrentClothes().decreaseDarningTime();
            }
        }
        System.out.println("Working time 1-st: " + first.getWorkingTime());
        System.out.println("Downtime time 1-st: " + first.getDowntime());
        System.out.println("Working time 2-nd: " + first.getWorkingTime());
        System.out.println("Downtime time 2-nd: " + first.getDowntime());
    }
}
