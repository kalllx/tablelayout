package com.esotericsoftware.tablelayout.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.esotericsoftware.tablelayout.swing.ui.ColorLabel;
import com.esotericsoftware.tablelayout.swing.util.FileUtil;

public class EditorTest extends JFrame
{
    public EditorTest()
    {
	setSize(200, 300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	final JTextField nameEdit = new JTextField();
	JTextField addressEdit = new JTextField();
	JButton btn = new JButton();
	Table table = new Table();
	TableLayout layout = table.getTableLayout();
	layout.register("nameEdit", nameEdit);
	layout.register("addressEdit", addressEdit);
	layout.register("btn", btn);
	final StringBuffer sb = new StringBuffer();
	FileUtil.readData("c:\\a.txt", new FileUtil.LineProcessor()
	{
	    
	    @Override
	    public void readLine(String line)
	    {
		sb.append(line);
		
	    }
	});
	table.parse(sb.toString());
	//ColorLabel l = (ColorLabel)table.getWidget("aa");
	//l.setColor(Color.red);
	setContentPane(table);
	setVisible(true);
	btn.addActionListener(new ActionListener()
	{
	    
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		nameEdit.setText(e.toString());
		
	    }
	});
    }

    public static void main(String[] args)
    {
	new EditorTest();
    }
}
