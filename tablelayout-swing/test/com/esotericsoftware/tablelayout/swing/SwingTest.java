
package com.esotericsoftware.tablelayout.swing;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class SwingTest extends JFrame {

	public SwingTest () {
		setTitle("SwingTest");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		 
		Table table1 = new Table();
		getContentPane().add(table1);
		table1.top().left();
		
		
		Table table = new Table();
		table.columnDefaults(0).width(50).right();
		table.columnDefaults(1).expandX().left();
		table.columnDefaults(2).expandX().left();
		table.columnDefaults(3).expandX().left();
		table.columnDefaults(4).expandX().left();
		table.addCell(new JLabel("xxx"));
		table.addCell(new JLabel("111"));
		table.addCell(new JLabel("3324.3"));
		table.addCell(new JLabel("232.44"));
		
		table.row();
		table.addCell(new JLabel("xxx"));
		table.addCell(new JLabel("111"));
		table.addCell(new JLabel("3324.3"));
		table.addCell(new JLabel("232.44"));
		
		
		
		
		Table table2  = new Table();
		table2.addCell(new JLabel("232.44dd"));
		table2.row();
		table2.addCell(new JLabel("232.44dd"));
		
		table1.addCell(table).expandX().prefWidth(10000).top();
		table1.addCell(table2).width(200).top();
		table1.row();
		Table dd = new Table();
		dd.defaults().width(100).pad(10);
		dd.addCell("dfdf").expand();
		dd.addCell("dfdf");
		dd.addCell("dfdf");
		dd.addCell("dfdf");
		table1.addCell(dd).colspan(2).prefWidth(5515);
		table1.row();
		
		
		Table caozuoqu = new Table();
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED ));
		p.add(new JButton("buy"));
		p.add(new JButton("buy"));
		p.add(new JButton("buy"));
		p.add(new JButton("buy"));
		p.setPreferredSize(new Dimension(200, 200));
		caozuoqu.addCell(p);
		caozuoqu.addCell(new JButton("fdfd")).expand();
		
		table1.addCell(caozuoqu).colspan(2).prefWidth(5515);
		
		table1.row().height(200);
		Table tt = new Table();
		tt.addCell("33");
		tt.addCell(new JButton("fdfd")).expand();
		
		tt.addCell("33");
		
		table1.addCell(tt).colspan(2).prefWidth(5515);
		table1.debug();
	}

	public static void main (String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				new SwingTest();
			}
		});
	}
}
