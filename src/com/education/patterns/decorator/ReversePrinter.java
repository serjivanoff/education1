package com.education.patterns.decorator;

public class ReversePrinter extends PrinterDecorator
{
	public ReversePrinter(final Printer printer)
	{
		super(printer);
	}

	@Override
	public void print(final String s)
	{
		getPrinter().print(new StringBuilder(s).reverse().toString());
	}
}
