package com.github.budwing.pattern.visitors;

import com.github.budwing.pattern.octree.Scenario;

public class SubVisitor implements ScenarioVisitor {
	private double x;
	private double y;
	private double z;
	
	public SubVisitor(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void visit(Scenario scenario) {
		scenario.setX(scenario.getX()-x);
		scenario.setY(scenario.getY()-y);
		scenario.setZ(scenario.getZ()-z);
	}
	
}
