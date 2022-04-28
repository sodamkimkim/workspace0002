package Jlist_pr;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JList_pr extends JFrame {
	private JList list;
	private static String[] colorNames = { "blue", "green", "yellow", "orange", "red", "black", "gray", "white" };
	private static Color[] colors = { Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.BLACK,
			Color.GRAY, Color.WHITE };

	public JList_pr() {
		super("JList Demo Example");
		setLayout(new FlowLayout());
		list = new JList(colorNames);
		list.setVisibleRowCount(5); // number of elements to visible as row in list
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				getContentPane().setBackground(colors[list.getSelectedIndex()]);
			}

		});

	}
	public static void main(String [] args) {
		JList_pr jList_pr = new JList_pr();
		jList_pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jList_pr.setSize(500,500);
		jList_pr.setVisible(true);
		
	}
} // end of class

//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.swing.event.*;
//
//public class JListExample extends JFrame {
//	private JList list;
//	private static String[] colorNames = { "blue", "green", "yellow", "orange", "red", "black", "grey", "white" };
//	private static Color[] colors = { Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.BLACK,
//			Color.GRAY, Color.WHITE };
//
//	public JListExample() {
//		super("JList Demo Example");
//		setLayout(new FlowLayout());
//		list = new JList(colorNames);
//		list.setVisibleRowCount(5);// number of elements to visible as row in list
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////choose the selection mode in list
//		add(new JScrollPane(list));
////adding event listener on JList
//		list.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				getContentPane().setBackground(colors[list.getSelectedIndex()]);
//			}
//		});
//	}
//
//	public static void main(String[] args) {
//		JListExample jl = new JListExample();
//		jl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jl.setSize(300, 300);
//		jl.setVisible(true);
//	}
//}