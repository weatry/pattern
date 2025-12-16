package com.github.budwing.pattern.builder;

public class Report {
    private StringBuilder content = new StringBuilder();

    public void addPart(String part) {
        content.append(part).append("\n");
    }

    public String getContent() {
        return content.toString();
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
