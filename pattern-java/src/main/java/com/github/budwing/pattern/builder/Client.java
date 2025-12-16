package com.github.budwing.pattern.builder;

// Client
public class Client {
    public static void main(String[] args) {
        // Build PDF report
        ReportBuilder pdfBuilder = new PdfReportBuilder();
        ReportDirector director = new ReportDirector(pdfBuilder);
        director.constructReport();
        Report pdfReport = pdfBuilder.getReport();
        System.out.println("=== PDF Report ===");
        System.out.println(pdfReport);

        // Build HTML report
        ReportBuilder htmlBuilder = new HtmlReportBuilder();
        director.setBuilder(htmlBuilder);
        director.constructReport();
        Report htmlReport = htmlBuilder.getReport();
        System.out.println("=== HTML Report ===");
        System.out.println(htmlReport);
    }
}
