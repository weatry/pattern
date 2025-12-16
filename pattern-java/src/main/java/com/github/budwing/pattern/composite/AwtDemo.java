package com.github.budwing.pattern.composite;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AwtDemo {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setVisible(true);
		f.setSize(500, 400);
		f.setLocation(300, 300);
		Panel p = new Panel();
		p.setVisible(true);
		p.setSize(300, 300);
		p.setBackground(Color.blue);
		Button b = new Button();
		b.setVisible(true);
		b.setLocation(100, 100);
		b.setSize(100, 20);
		b.setLabel("sdfd");
		p.add(b);
		f.add(p);
		f.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent arg0) {

			}

			public void windowClosed(WindowEvent arg0) {

			}

			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

			public void windowDeactivated(WindowEvent arg0) {

			}

			public void windowDeiconified(WindowEvent arg0) {

			}

			public void windowIconified(WindowEvent arg0) {

			}

			public void windowOpened(WindowEvent arg0) {

			}
			
		});
	}

}
