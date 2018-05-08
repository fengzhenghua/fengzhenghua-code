package devil.angel;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
//		StringTest str = new StringTest();
//		str.changeStr="333";
//		System.out.println(StringTest.changeStr);
//		StringTest str1 = new StringTest();
//		System.out.println(str1.changeStr);
//		System.out.println(new Random().nextLong()*200);
//		int[] arr ={1,2,3,4,5,6};
//		for(int i=0;i<arr.length;i++){
//			Random random = new Random();
//			int a = random.nextInt(i+1);
//			int temp = arr[a];
//			arr[a] = arr[i];
//			arr[i] = temp;
//			
//		}
//		for(int j=0;j<arr.length;j++){
//			System.out.print(" "+arr[j]);
//		}
		//System.out.println(new Random().nextInt(2));
//		int cpuNum = Runtime.getRuntime().availableProcessors();
//		System.out.println(cpuNum);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("k", "val");
		System.out.println(map.keySet().hashCode());
		Set<String> set1 = map.keySet();
		set1.clear();
		Set<String> set2 = map.keySet();
		System.out.println(set1 == set2);
		System.out.println(set1.toString());
		System.out.println(set2.toString());
		int a = 1;
		System.out.println(a++);
		System.out.println(a++);
	}
}
