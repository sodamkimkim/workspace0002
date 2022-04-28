package ch03;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class JTable_h extends JFrame {

	private JTable table;
	JScrollPane jScrollPane;
	private String[] header = { "이름", "나이", "사는 곳" };
	private String[][] info = { { "홍길동", "30", "서울" }, { "김소담", "20", "포항" } };

	public JTable_h() {
		initData();
		setInitLayout();

	}

	private void initData() {
		setTitle("JTable 만들기");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(info, header);
		jScrollPane = new JScrollPane(table);
		add(jScrollPane);

//	    public JTable(TableModel dm, TableColumnModel cm) {
//	        this(dm, cm, null);
//	    }
	}

	private void setInitLayout() {
		setVisible(true);
	}

	public static void main(String[] args) {

		new JTable_h();

	} // end of main

} // end of outer class
