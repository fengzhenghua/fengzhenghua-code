package com.hera.effective.obj.enums;

/**
 *@authur fengzhenghua 2018年1月7日 上午1:05:33
 *@ClassName Operation
 *@Describtion
 */
public enum Operation {
	
	ADD("+"){
		public int oper(int a, int b) {
			return a + b;
		}

		@Override
		public String stringAppend(String... a) {
			StringBuilder sb = new StringBuilder();
			for(String s : a) {
				sb.append(s);
			}
			return sb.toString();
		}
	},
	DEL("-"){
		public int oper(int a, int b) {
			return a - b;
		}
		@Override
		public String stringAppend(String... a) {
			StringBuilder sb = new StringBuilder();
			for(String s : a) {
				sb.append(s);
			}
			return sb.toString();
		}
	},
	CHENG("*"){
		public int oper(int a, int b) {
			return a * b;
		}
		@Override
		public String stringAppend(String... a) {
			StringBuilder sb = new StringBuilder();
			for(String s : a) {
				sb.append(s);
			}
			return sb.toString();
		}
	},
	CHU("/"){
		public int oper(int a, int b) {
			return a / b;
		}
		@Override
		public String stringAppend(String... a) {
			StringBuilder sb = new StringBuilder();
			for(String s : a) {
				sb.append(s);
			}
			return sb.toString();
		}
	};
	
	
	
	private String operation;

	private Operation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public int oper(int a, int b) {
		throw new AbstractMethodError();
	}
	
	public abstract String stringAppend(String... a);
}
