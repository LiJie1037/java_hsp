package bignum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 16:32
 */
public class BigInteger_ {
    public static void main(String[] args) {
//        long l = 2333333333333333333333333333333333333;
//        System.out.println(l);

        BigInteger bigInteger = new BigInteger("2333333333333333333333333333333333333");
        System.out.println(bigInteger);

        BigInteger bigInteger1 = new BigInteger("100");
        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add);


        BigDecimal bigDecimal = new BigDecimal("1999.11111111111999999999999977788");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal.divide(bigDecimal2, RoundingMode.CEILING));
    }
}
