package codeblock_;

public class CodeBlock1 {
    public static void main(String[] args) {
        Movie movie = new Movie("白日梦想家");
        System.out.println();
        Movie inception = new Movie("Inception", 30);
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    {
        System.out.println("电影屏幕打开");
        System.out.println("广告开始");
        System.out.println("电影正式开始");
    }

    public Movie(String name) {
        this.name = name;
        System.out.println("Movie(String name)被调用");
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("Movie(String name, double price) is called.");
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}