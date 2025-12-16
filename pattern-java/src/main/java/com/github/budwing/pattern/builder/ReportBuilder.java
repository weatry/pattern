package com.github.budwing.pattern.builder;

public interface ReportBuilder {
    void buildHeader();
    void buildBody();
    void buildFooter();
    Report getReport();
}
