package com.education.patterns.decorator;

public class PrinterDecorator extends Printer
{
	private final Printer printer;

	public PrinterDecorator(final Printer printer)
	{
		this.printer = printer;
	}

	@Override
	public void print(String s)
	{
		printer.print(s);
	}

	public Printer getPrinter()
	{
		return printer;
	}
}
