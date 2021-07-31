package cn.budwing.stock.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public class ViewUtil {
	public static Point getScreenCentral(int initWidth, int initHeight) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		return new Point((int)(screen.getWidth()-initWidth)/2, (int)(screen.getHeight()-initHeight)/2);
	}
}
