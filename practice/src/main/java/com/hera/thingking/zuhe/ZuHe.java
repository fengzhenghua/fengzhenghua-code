package com.hera.thingking.zuhe;

/**
 *@authur fengzhenghua 2017年11月7日 下午10:07:54
 *@ClassName ZuHe
 *@Describtion
 */
public class ZuHe {
	
	private String x;
	private int y;
	private Inner in;
	
	public class Inner {
		private String a;
		private int b;
		
		
		public Inner(String a, int b) {
			this.a = a;
			this.b= b;
		}
		
		public Object[] getArr() {
			Object[] obj = new Object[] {a,b};
			return obj;
		}

		@Override
		public String toString() {
			return "Inner [a=" + a + ", b=" + b + "]";
		}
		
		
	}
	
	public ZuHe(String x, int y) {
		this.x = x;
		this.y = y;
		in = new Inner(x,y);
	}
	
	
	
	@Override
	public String toString() {
		return "ZuHe [x=" + x + ", y=" + y + "]";
	}



	public static void main(String[] args) {
		ZuHe z = new ZuHe("组合测试", 123);
		System.out.println(z);
		System.out.println(z.getIn());
		System.out.println(z.getIn().getArr().toString());
	}



	public String getX() {
		return x;
	}



	public void setX(String x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public Inner getIn() {
		return in;
	}



	public void setIn(Inner in) {
		this.in = in;
	}
	
	
}
