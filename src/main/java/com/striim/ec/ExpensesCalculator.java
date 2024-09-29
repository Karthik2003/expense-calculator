package com.striim.ec;

public class ExpensesCalculator {
    public static final String XML_FILE = "src/main/resources/expenses.xml";
    public static final String SCHEMA_FILE = "src/main/resources/expenses.xsd";

    public static void main(String[] args) {
        ExpensesXMLValidator expensesXMLValidator = new ExpensesXMLValidator();
        expensesXMLValidator.validate(XML_FILE, SCHEMA_FILE);
    }
}