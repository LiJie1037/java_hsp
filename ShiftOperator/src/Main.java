public class Main {
    public static void main(String[] args) {
        int a = 1>>2;
        int b = 1<<2;
        System.out.println(a);
        System.out.println(b);

        int minusa = -1>>2;
        int minusb = -1<<2;
        System.out.println(minusa);
        System.out.println(minusb);

        int i = 66;
//        System.out.println(++i+i);
        System.out.println((i++)+i);

        int j = 1;
        j = ++j;
        System.out.println(j);

        String str = "123";
        int num = Integer.parseInt(str);
    }
}