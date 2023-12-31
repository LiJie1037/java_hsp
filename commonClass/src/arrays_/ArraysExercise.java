package arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 15:49
 */
public class ArraysExercise {
    public static void main(String[] args) {


        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘 20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);

        sortCustom(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double res =  b1.getPrice() - b2.getPrice();
                if (res > 0) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });

        sortCustom(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b1.getName().length() - b2.getName().length();
            }
        });

        System.out.println("排序后：");
        System.out.println(Arrays.toString(books));
    }

    public static void sortCustom(Book[] books, Comparator c) {
        Book tmp = null;
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j], books[j + 1]) > 0) {
                    tmp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = tmp;
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}