package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainWindow
{
	private final int windowHeight = 500;
	private final int windowWidth = 450;
	
	public MainWindow ()
	{
		JFrame mainFrame = new JFrame("Tic Tac Toe");
		mainFrame.setPreferredSize(new Dimension(windowWidth, windowHeight));
	
		GameField gameField = new GameField();
		
		mainFrame.add(gameField);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}