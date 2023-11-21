package customException;

public class CustomException {
    public static void main(String[] args) {
        int age = 10;
        if (!(age >= 18 && age <= 120)) {
            throw new AgeException("年龄需要再18-120之间");
        }
        System.out.println("你的年龄范围正确");
    }
}

// 自定义一个异常
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}