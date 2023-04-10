package task2;

public class BooksInfo {
    private String name;
    private String book;
    private String author;
    private Date startDate;
    private Date finishDate;

    public BooksInfo(String[] strings)
            throws ArrayIndexOutOfBoundsException {
        name = strings[0];
        book = strings[1];
        author = strings[2];
        startDate = new Date(strings[3]);
        if (strings[4].equals("-")) {
            finishDate = null;
        } else {
            finishDate = new Date(strings[4]);
        }
    }

    public BooksInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "BooksInfo{" +
                "name='" + name + '\'' +
                ", book='" + book + '\'' +
                ", author='" + author + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
