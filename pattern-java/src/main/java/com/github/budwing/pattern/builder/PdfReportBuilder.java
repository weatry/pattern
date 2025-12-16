package com.github.budwing.pattern.builder;

// ConcreteBuilder: PDF
public class PdfReportBuilder implements ReportBuilder {
    private Report report = new Report();

    @Override
    public void buildHeader() {
        report.addPart("%PDF-1.4\n%% Header: Confidential Report");
    }

    @Override
    public void buildBody() {
        report.addPart("<< /Type /Page /Contents ... >>\n% Body content in PDF syntax");
    }

    @Override
    public void buildFooter() {
        report.addPart("% End of PDF Report");
    }

    @Override
    public Report getReport() {
        return report;
    }
}
