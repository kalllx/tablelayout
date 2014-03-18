package com.esotericsoftware.tablelayout.swing.ui;

import java.awt.Color;

import javax.swing.JLabel;

public class ColorLabel extends JLabel
{
    public void setColor(Color color)
    {
	 
	this.setForeground(Color.red);
    }

    public void setFrontSize(int size)
    {
	this.setFont(new   java.awt.Font("Dialog",   1,   size));
    }
}
