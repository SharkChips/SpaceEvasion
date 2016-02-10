package com.albertzhang.javagame;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {

    public Main(int width, int height, int difficulty, boolean graphicsDebug, boolean logicDebug, boolean keyDebug) {
	super("Window"); // prints title in title bar of window
	setSize(width, height);

	// Instantiates LogicEngine
	LogicEngine logic = new LogicEngine();
	logic.start();

	// Makes new RenderEngine and gives tells it to render a LogicEngine
	RenderEngine render = new RenderEngine(logic);
	render.start();

	getContentPane().add(render); // Add render to frame

	// Instantiates KeyHandlingEngine and activates it
	KeyHandling keyHandlingEngine = new KeyHandling(logic);
	keyHandlingEngine.start();
	addKeyListener(keyHandlingEngine);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
    }

}