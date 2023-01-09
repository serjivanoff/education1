package com.education.patterns.decorator;

public class CapitalizedPrinter extends PrinterDecorator
{
	public CapitalizedPrinter(final Printer printer)
	{
		super(printer);
	}

	@Override
	public void print(String s)
	{
		getPrinter().print(s.toUpperCase());
	}
}
