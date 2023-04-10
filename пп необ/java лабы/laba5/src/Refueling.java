/**
 * Класс показывает в каких городах есть заправка,
 * и по какой цене там бензин за 1 литр
 */
public class Refueling {
    private int cityNumber;
    private int price;

    public int getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(int cityNumber) {
        this.cityNumber = cityNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
