package devil.angel;


public class StringTest {
	
	/*
	 * 判断一个数字是否为素数
	 */
	public static boolean isShuSu(int num) {
		
		boolean flag = true;
		if(num==1|| num==2) {
			return true;
		}
		for(int i=2;i<Math.sqrt(num);i++) {
			if((num%i) == 0) {
				flag = false;//一旦取余为等于0，则不为素数
				break;
			}
		}
		//不为素数时返回false,当为素数时返回true;
		return flag;
		
	}
	
	public static void main(String[] args) {
		
		for(int j=20000;j<21000;j++) {
			if(isShuSu(j)) {
				System.out.print(j + " ");
			}
		}
	}
	
}
