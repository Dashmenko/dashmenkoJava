package task1;

import task1.myCollections.MyCollection;

public class Seamstress {
    private int downtime;
    private int workingTime;
    private Clothes currentClothes;
    private final MyCollection<Clothes> start;
    private final MyCollection<Clothes> finish;

    public Seamstress(MyCollection<Clothes> start,
                      MyCollection<Clothes> finish) {
        this.start = start;
        this.finish = finish;
        downtime = 0;
        workingTime = 0;
    }

    public int getDowntime() {
        return downtime;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public Clothes getCurrentClothes() {
        return currentClothes;
    }

    public void increaseDownTime() {
        downtime++;
    }

    public void increaseWorkingTime() {
        workingTime++;
    }

    public void addCurrentClothes(Clothes clothes) {
        currentClothes = clothes;
    }

    public Clothes removeCurrentClothes() {
        Clothes tmp = currentClothes;
        currentClothes = null;
        return tmp;
    }

    public boolean isBusy() {
        return currentClothes != null;
    }
}
