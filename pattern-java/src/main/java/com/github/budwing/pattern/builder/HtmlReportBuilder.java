package com.github.budwing.pattern.builder;

// ConcreteBuilder: HTML
public class HtmlReportBuilder implements ReportBuilder {
    private Report report = new Report();

    @Override
    public void buildHeader() {
        report.addPart("<!DOCTYPE html>\n<html><head><title>Report</title></head>");
    }

    @Override
    public void buildBody() {
        report.addPart("<body><h1>Monthly Summary</h1><p>Data goes here...</p></body>");
    }

    @Override
    public void buildFooter() {
        report.addPart("</html><!-- End of HTML Report -->");
    }

    @Override
    public Report getReport() {
        return report;
    }
}
