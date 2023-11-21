package math_;

public class MathMethod {
    public static void main(String[] args) {
        // 开方和平方
        double sqrtNum = Math.sqrt(9);
        System.out.println(sqrtNum);
        System.out.println(Math.pow(3, 2));
        // 取整
        double ceilNum = Math.ceil(9.1);
        System.out.println(ceilNum);
        System.out.println(Math.floor(9.1));
        System.out.println(Math.round(9.1));
        // 随机数
        for (int i = 0; i < 3; i++) {
            double randomNum = Math.random();
            System.out.println(randomNum);
        }
        // 返回a-b之间的随机整数,例如50 - 100
        int randomN = (int)(50 + Math.random() * (100 - 50 + 1));
        System.out.println(randomN);


    }
}
