public class TypeConvert{
	public static void main(String[] args) {
		int a = 'c';
		double d = 80;

		System.out.println(a);
		System.out.println(d);

		// float d1 = a + 1.1;	// 1.1是double, a是int, 结果自动转换为double,因此错误
		double d1 = a + 1.1;

		// 强制类型转换
		int i = (int)1.9;
		System.out.println(i);

		// int x = (int)10 * 3.5 + 6 * 1.5;// 错误doule -> int
		int x = (int)(10 * 3.5 + 6 * 1.5);

		System.out.println(x); 
	}
}