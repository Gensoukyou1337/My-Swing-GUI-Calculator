package com.g1337.calculator.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc extends JFrame
{
	private static final int WIN_WIDTH = 350;
	private static final int WIN_HEIGHT = 400;
	private Font buttonFont = new Font("Arial", Font.PLAIN, 24);
	
	private double varAlpha = 0;
	private boolean alphaFill = false;
	private double varBeta = 0;
	/*
	private boolean betaFill = false;
	private boolean recipro = false;
	*/
	private char opType;
	
	private String toParse = "";
	private String dispText = "";
	
	public Calc()
	{
		initUI();
	}
	
	public void initUI()
	{
		JPanel base = new JPanel();
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
		add(base);
		
		//Display panel
		JPanel display = new JPanel();
		
		JLabel textArea = new JLabel("0");
		textArea.setPreferredSize(new Dimension(300,15));
		
		JLabel result = new JLabel("0");
		result.setPreferredSize(new Dimension(300,35));
		result.setFont(new Font("Arial", Font.PLAIN, 30));
		
		display.add(textArea);
		display.add(result);
		base.add(display);
		//End display panel
		
		//Buttons panel
		JPanel buttons = new JPanel();
		buttons.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		buttons.setLayout(new GridLayout(4,4,5,5));
		
		JButton buttonOne = new JButton("1");
		buttonOne.setFont(buttonFont);
		buttonOne.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "1";}
				else{toParse = "1";}
				dispText += "1";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonOne);
		//
		JButton buttonTwo = new JButton("2");
		buttonTwo.setFont(buttonFont);
		buttonTwo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "2";}
				else{toParse = "2";}
				dispText += "2";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonTwo);
		//
		JButton buttonThree = new JButton("3");
		buttonThree.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "3";}
				else{toParse = "3";}
				dispText += "3";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttonThree.setFont(buttonFont);
		buttons.add(buttonThree);
		//
		JButton buttonDiv = new JButton("/");
		buttonDiv.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(alphaFill == false)
				{
					varAlpha = Double.parseDouble(toParse);
					toParse = "";
					opType = '/';
					alphaFill = true;
					System.out.println("varAlpha = " + varAlpha);
				}
				else
				{
					varAlpha = Operation(varAlpha, Double.parseDouble(toParse), opType);
					varBeta = 0;
					toParse = "";
					opType = '/';
					System.out.println("varAlpha = " + varAlpha);
				}
				dispText += " / ";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttonDiv.setFont(buttonFont);
		buttons.add(buttonDiv);
		/*
		JButton buttonPercent = new JButton("%");
		buttonPercent.setFont(buttonFont);
		buttons.add(buttonPercent);
		*/
		JButton buttonFour = new JButton("4");
		buttonFour.setFont(buttonFont);
		buttonFour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "4";}
				else{toParse = "4";}
				dispText += "4";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonFour);
		//
		JButton buttonFive = new JButton("5");
		buttonFive.setFont(buttonFont);
		buttonFive.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "5";}
				else{toParse = "5";}
				dispText += "5";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonFive);
		//
		JButton buttonSix = new JButton("6");
		buttonSix.setFont(buttonFont);
		buttonSix.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "6";}
				else{toParse = "6";}
				dispText += "6";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonSix);
		//
		JButton buttonMultiply = new JButton("*");
		buttonMultiply.setFont(buttonFont);
		buttonMultiply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(alphaFill == false)
				{
					varAlpha = Double.parseDouble(toParse);
					toParse = "";
					opType = '*';
					alphaFill = true;
					System.out.println("varAlpha = " + varAlpha);
				}
				else
				{
					varAlpha = Operation(varAlpha, Double.parseDouble(toParse), opType);
					varBeta = 0;
					toParse = "";
					opType = '*';
					System.out.println("varAlpha = " + varAlpha);
				}
				dispText += " * ";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonMultiply);
		/*
		JButton buttonReciprocal = new JButton("1/x");
		buttonReciprocal.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonReciprocal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(alphaFill == false)
				{
					varAlpha = (1/Double.parseDouble(toParse));
					toParse = "";
					recipro = true;
					System.out.println("varAlpha = " + varAlpha);
				}
				else
				{
					varBeta = (1/Double.parseDouble(toParse));
					toParse = "";
					recipro = true;
					System.out.println("varBeta = " + varBeta);
				}
				System.out.println(toParse);
			}
		});
		buttons.add(buttonReciprocal);
		*/
		JButton buttonSeven = new JButton("7");
		buttonSeven.setFont(buttonFont);
		buttonSeven.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "7";}
				else{toParse = "7";}
				dispText += "7";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonSeven);
		//
		JButton buttonEight = new JButton("8");
		buttonEight.setFont(buttonFont);
		buttonEight.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "8";}
				else{toParse = "8";}
				dispText += "8";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonEight);
		//
		JButton buttonNine = new JButton("9");
		buttonNine.setFont(buttonFont);
		buttonNine.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse != "0")
				{toParse += "9";}
				else{toParse = "9";}
				dispText += "9";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonNine);
		//
		JButton buttonSub = new JButton("-");
		buttonSub.setFont(buttonFont);
		buttonSub.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(alphaFill == false)
				{
					varAlpha = Double.parseDouble(toParse);
					toParse = "";
					opType = '-';
					alphaFill = true;
					System.out.println("varAlpha = " + varAlpha);
				}
				else
				{
					varAlpha = Operation(varAlpha, Double.parseDouble(toParse), opType);
					varBeta = 0;
					toParse = "";
					opType = '-';
					System.out.println("varAlpha = " + varAlpha);
				}
				dispText += " + ";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonSub);
		//
		
		JButton buttonZero = new JButton("0");
		buttonZero.setFont(buttonFont);
		buttonZero.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse.length() != 0)
				{
					if(toParse != "0")
					{
						toParse += "0";
					}
				}
				else
				{
					toParse = "0";
				}
				if(dispText.length() != 0)
				{dispText += "0";}
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonZero);
		//
		JButton buttonEqual = new JButton("=");
		buttonEqual.setFont(new Font("Arial", Font.BOLD, 24));
		buttonEqual.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(alphaFill == true)
				{
					varBeta = Double.parseDouble(toParse);
					toParse = "";
					result.setText(Double.toString(Operation(varAlpha, varBeta, opType)));
					System.out.println(Operation(varAlpha, varBeta, opType));
					varAlpha = 0;
					varBeta = 0;
					alphaFill = false;
				}
				dispText = "";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonEqual);
		//
		JButton buttonDecimal = new JButton(".");
		buttonDecimal.setFont(buttonFont);
		buttonDecimal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(toParse.length() != 0)
				{
					if(toParse.charAt(toParse.length()-1) != '.')
					{toParse += ".";}
				}
				else
				{
					toParse = "0.";
				}
				dispText += ".";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonDecimal);
		//
		JButton buttonAdd = new JButton("+");
		buttonAdd.setFont(buttonFont);
		buttonAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(alphaFill == false)
				{
					varAlpha = Double.parseDouble(toParse);
					toParse = "";
					opType = '+';
					alphaFill = true;
					System.out.println("varAlpha = " + varAlpha);
				}
				else
				{
					varAlpha = Operation(varAlpha, Double.parseDouble(toParse), opType);
					varBeta = 0;
					toParse = "";
					opType = '+';
					System.out.println("varAlpha = " + varAlpha);
				}
				dispText += " + ";
				textArea.setText(dispText);
				System.out.println(toParse);
			}
		});
		buttons.add(buttonAdd);
		
		base.add(buttons);
		//End buttons panel
		
		setTitle("Calculator Test");
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public double Operation(double varA, double varB, char operation)
	{
		double result = 0;
		switch(operation)
		{
		case '+' :
			result = varA + varB;
			break;
		case '-' :
			result = varA - varB;
			break;
		case '*' :
			result = varA * varB;
			break;
		case '/' :
			result = varA / varB;
			break;
		default:
			break;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				Calc calc = new Calc();
				calc.setVisible(true);
			}
		});
	}

}
