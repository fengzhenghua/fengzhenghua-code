package com.devil.SpEL;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpelHello {
	public static void main(String[] args) {
		ExpressionParser ep = new SpelExpressionParser();
		Expression exp = ep.parseExpression("'hello'+'word'");
		String message = (String) exp.getValue();
		System.out.println(message);
	}
}
