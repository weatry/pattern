package com.github.budwing.pattern.builder.evolved;

public class Demo {

	public static void main(String[] args) {
		Query query = Query.newBuilder()
				.buildSelect("select * ")
				.buildFrom("from atable ")
				.buildWhere("where a condition ")
				.buildOrderby("order by column asc")
				.build();
		query.execute();
	}

}
