package com.github.budwing.pattern.octree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScenarioIterator implements Iterator<Scenario> {
	private Scenario scenario;
	private List<Scenario> nodes;
	private Iterator<Scenario> it;
	
	ScenarioIterator(Scenario scenario) {
		super();
		this.scenario = scenario;
		this.nodes = new ArrayList<Scenario>();
		this.populateNodes(scenario);
		it = nodes.iterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return it.hasNext();
	}

	@Override
	public Scenario next() {
		// TODO Auto-generated method stub
		return it.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	private void populateNodes(Scenario s) {
		if (s!=null) {
			nodes.add(s);
			populateNodes(s.getTopFrontLeft());
			populateNodes(s.getTopFrontRight());
			populateNodes(s.getTopBehindLeft());
			populateNodes(s.getTopBehindRight());
			populateNodes(s.getBottomFrontLeft());
			populateNodes(s.getBottomFrontRight());
			populateNodes(s.getBottomBehindLeft());
			populateNodes(s.getBottomBehindRight());
		}
	}

}
