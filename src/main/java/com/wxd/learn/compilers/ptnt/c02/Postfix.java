package com.wxd.learn.compilers.ptnt.c02;
import java.io.*;

public class Postfix {
	public static void main(String[] args) throws IOException {
		Parser parse = new Parser();
		parse.expr(); System.out.write('\n');
	}
}

class Parser {
	static int lookhead;
	public Parser() throws IOException {
		lookhead = System.in.read();
	}
	void expr() throws IOException {
		term();
		while(true) {
			if(lookhead == '+') {
				match('+'); term(); System.out.write('+');
			}
			else if(lookhead == '-') {
				match('-'); term();  System.out.write('-');
			}
			else return;
		}
	}
	void term() throws IOException {
		if(Character.isDigit((char)lookhead)) {
			System.out.write((char)lookhead); match(lookhead);
		}
		else throw new Error("syntax error");
	}
	void match(int t) throws IOException {
		if(lookhead == t) lookhead = System.in.read();
		else throw new Error("syntax error");
	}
	
}

