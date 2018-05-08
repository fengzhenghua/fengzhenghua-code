package com.hera.effective.obj.enums;

/**
 *@authur fengzhenghua 2018年1月9日 上午12:35:36
 *@ClassName BasicOperation
 *@Describtion
 */
public enum BasicOperation implements IOperation{
	PLUS("+"){
		public double apply(double x, double y) {
			return x + y;
		}
	}
	;
	
	private final String type;
	
	private BasicOperation(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}
