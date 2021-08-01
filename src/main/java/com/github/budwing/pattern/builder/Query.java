package com.github.budwing.pattern.builder;

public class Query {
    private String sql;

    public static Builder newBuilder() {
        return new Builder(new Query());
    }

    private Query(){}

    public Result execute() {
        System.out.println("execute sql: "+sql);

        return new Result() {
        };
    }
    public static class Builder {
        private Query query;
        private String select;
        private String from;
        private String where;
        private String orderby;

        private Builder(Query query) {
            this.query = query;
        }

        public Builder buildSelect(String select) {
            this.select = select;
            return this;
        }

        public Builder buildFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder buildWhere(String where) {
            this.where = where;
            return this;
        }

        public Builder buildOrderby(String orderby) {
            this.orderby = orderby;
            return this;
        }

        public Query build() {
            StringBuilder sb = new StringBuilder()
                    .append(select)
                    .append(from)
                    .append(where)
                    .append(orderby);
            query.sql = sb.toString();

            return query;
        }
    }
}
