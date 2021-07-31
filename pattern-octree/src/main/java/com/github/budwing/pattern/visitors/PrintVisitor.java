package com.github.budwing.pattern.visitors;

import com.github.budwing.pattern.octree.Scenario;

public class PrintVisitor implements ScenarioVisitor {

	@Override
	public void visit(Scenario scenario) {
		System.out.println(scenario);
	}
	
}
