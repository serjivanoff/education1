package com.education.patterns.decorator;

public class RegularPrinter extends Printer
{
	@Override
	public void print(final String s)
	{
		System.out.println(s);
	}
}
