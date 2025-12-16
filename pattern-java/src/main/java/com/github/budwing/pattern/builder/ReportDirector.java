package com.github.budwing.pattern.builder;

// Director
public class ReportDirector {
    private ReportBuilder builder;

    public ReportDirector(ReportBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    public void constructReport() {
        builder.buildHeader();
        builder.buildBody();
        builder.buildFooter();
    }
}
