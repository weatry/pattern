package com.github.budwing.pattern.visitors;

import com.github.budwing.pattern.octree.Scenario;

public interface ScenarioVisitor {
	public void visit(Scenario scenario);
}
