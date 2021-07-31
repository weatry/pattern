package com.github.budwing.pattern.octree;

import com.github.budwing.pattern.visitors.ScenarioVisitor;

import java.util.Iterator;

public class Scenario {
	private double x;
	private double y;
	private double z;
	
	private Scenario topFrontLeft;
	private Scenario topFrontRight;
	private Scenario topBehindLeft;
	private Scenario topBehindRight;
	private Scenario bottomFrontLeft;
	private Scenario bottomFrontRight;
	private Scenario bottomBehindLeft;
	private Scenario bottomBehindRight;
	
	public Scenario(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public Scenario getTopFrontLeft() {
		return topFrontLeft;
	}

	public void setTopFrontLeft(Scenario topFrontLeft) {
		this.topFrontLeft = topFrontLeft;
	}

	public Scenario getTopFrontRight() {
		return topFrontRight;
	}

	public void setTopFrontRight(Scenario topFrontRight) {
		this.topFrontRight = topFrontRight;
	}

	public Scenario getTopBehindLeft() {
		return topBehindLeft;
	}

	public void setTopBehindLeft(Scenario topBehindLeft) {
		this.topBehindLeft = topBehindLeft;
	}

	public Scenario getTopBehindRight() {
		return topBehindRight;
	}

	public void setTopBehindRight(Scenario topBehindRight) {
		this.topBehindRight = topBehindRight;
	}

	public Scenario getBottomFrontLeft() {
		return bottomFrontLeft;
	}

	public void setBottomFrontLeft(Scenario bottomFrontLeft) {
		this.bottomFrontLeft = bottomFrontLeft;
	}

	public Scenario getBottomFrontRight() {
		return bottomFrontRight;
	}

	public void setBottomFrontRight(Scenario bottomFrontRight) {
		this.bottomFrontRight = bottomFrontRight;
	}

	public Scenario getBottomBehindLeft() {
		return bottomBehindLeft;
	}

	public void setBottomBehindLeft(Scenario bottomBehindLeft) {
		this.bottomBehindLeft = bottomBehindLeft;
	}

	public Scenario getBottomBehindRight() {
		return bottomBehindRight;
	}

	public void setBottomBehindRight(Scenario bottomBehindRight) {
		this.bottomBehindRight = bottomBehindRight;
	}
	
	public void sub(double x, double y, double z) {
		this.x = this.x - x;
		this.y = this.y - y;
		this.z = this.z - z;
	}
	
	public Iterator<Scenario> iterator() {
		return new ScenarioIterator(this);
	}
	
	public void accept(ScenarioVisitor visitor) {
		visitor.visit(this);
		if (topFrontLeft!=null) {
			topFrontLeft.accept(visitor);
		}
		if (topFrontRight!=null) {
			topFrontRight.accept(visitor);
		}
		if (topBehindLeft!=null) {
			topBehindLeft.accept(visitor);
		}
		if (topBehindRight!=null) {
			topBehindRight.accept(visitor);
		}
		if (bottomFrontLeft!=null) {
			bottomFrontLeft.accept(visitor);
		}
		if (bottomFrontRight!=null) {
			bottomFrontRight.accept(visitor);
		}
		if (bottomBehindLeft!=null) {
			bottomBehindLeft.accept(visitor);
		}
		if (bottomBehindRight!=null) {
			bottomBehindRight.accept(visitor);
		}
	}

	public String toString() {
		return "Scenario [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
