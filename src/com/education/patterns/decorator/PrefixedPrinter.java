package com.education.patterns.decorator;

public class PrefixedPrinter extends PrinterDecorator
{
	public PrefixedPrinter(final Printer printer)
	{
		super(printer);
	}

	@Override
	public void print(final String s)
	{
		getPrinter().print("Prefix" + s);
	}
}
