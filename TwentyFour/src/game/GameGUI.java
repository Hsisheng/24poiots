package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import game.logic.Logic;
import game.table.MyJTable;
import game.table.MyTableModel;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton numBtn1;
	private JButton numBtn2;
	private JButton numBtn3;
	private JButton numBtn4;
	private MyTableModel model;
	private Logic lg;
	private boolean finishFlag=false;
	private Stack<String> strStack=new Stack<String>();

	

	/**
	 * Create the frame.
	 */
	public GameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("24点");
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);
		
		JPanel selectPanel = new JPanel();
		selectPanel.setBackground(Color.WHITE);
		selectPanel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		contentPane.add(selectPanel, BorderLayout.CENTER);
		selectPanel.setLayout(new GridLayout(2, 1, 0, 10));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		selectPanel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 6, 5, 0));
		
		JButton opBtnAdd = new JButton("+");
		opBtnAdd.setBackground(new Color(248, 248, 255));
		opBtnAdd.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(opBtnAdd);
		opBtnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				s+="+";
				textField.setText(s);
				strStack.push("+");
				
			}
			
		});
		
		JButton opBtnMinus = new JButton("-");
		opBtnMinus.setBackground(new Color(248, 248, 255));
		opBtnMinus.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(opBtnMinus);
		opBtnMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				s+="-";
				textField.setText(s);
				strStack.push("+");
				
			}
			
		});
		
		JButton opBtnMuti = new JButton("*");
		opBtnMuti.setBackground(new Color(248, 248, 255));
		opBtnMuti.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(opBtnMuti);
		opBtnMuti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				s+="*";
				textField.setText(s);
				strStack.push("+");
			}
			
		});
		
		JButton opBtnDiv = new JButton("/");
		opBtnDiv.setBackground(new Color(248, 248, 255));
		opBtnDiv.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(opBtnDiv);
		opBtnDiv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				s+="/";
				textField.setText(s);
				strStack.push("+");
				
			}
			
		});
		
		JButton opBtnLeft = new JButton("(");
		opBtnLeft.setBackground(new Color(248, 248, 255));
		opBtnLeft.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(opBtnLeft);
		opBtnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				s+="(";
				textField.setText(s);
				strStack.push("+");
			}
			
		});
		
		JButton opBtnRight = new JButton(")");
		opBtnRight.setBackground(new Color(248, 248, 255));
		opBtnRight.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(opBtnRight);
		opBtnRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				s+=")";
				textField.setText(s);
				strStack.push("+");
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		selectPanel.add(panel);
		panel.setLayout(new GridLayout(1, 6, 5, 0));
		
		 numBtn1 = new JButton("1");
		numBtn1.setBackground(new Color(255, 255, 240));
		numBtn1.setFont(new Font("Arial", Font.BOLD, 40));
		panel.add(numBtn1);
		
		
		 numBtn2 = new JButton("2");
		numBtn2.setBackground(new Color(255, 255, 240));
		numBtn2.setFont(new Font("Arial", Font.BOLD, 40));
		panel.add(numBtn2);
		
		 numBtn3 = new JButton("3");
		numBtn3.setBackground(new Color(255, 255, 240));
		numBtn3.setFont(new Font("Arial", Font.BOLD, 40));
		panel.add(numBtn3);
		
		 numBtn4 = new JButton("4");
		numBtn4.setBackground(new Color(255, 255, 240));
		numBtn4.setFont(new Font("Arial", Font.BOLD, 40));
		panel.add(numBtn4);
		numBtn1.addActionListener(new InputListener());
		numBtn2.addActionListener(new InputListener());
		numBtn3.addActionListener(new InputListener());
		numBtn4.addActionListener(new InputListener());
		
		JButton btnNewButton_2 = new JButton("退格");
		btnNewButton_2.setBackground(new Color(240, 128, 128));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				if(!s.equals("")) {
					if(strStack.pop().equals("+")) {
						textField.setText(s.substring(0, s.length()-1));
					}else {
						JButton b=bStack.pop();
						b.setEnabled(true);
						int len=b.getText().length();
						textField.setText(s.substring(0, s.length()-len));
					}
				}
				
			}
			
		});
		
		
		
		
		//ansPanel.add(table, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		contentPane.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("请点击按钮输入解法：");
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_4.add(textField);
		textField.setFont(new Font("Arial", Font.PLAIN, 40));
		textField.setColumns(20);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 255, 255));
		panel_5.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 120, 5));
		
		btnNewButton = new JButton("提交");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel_6.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lg.check(textField.getText());
				
				
			}
			
		});
		
	 btnNewButton_1 = new JButton("放弃");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel_6.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lg.finish();
			}
			
		});
		
		btnNewButton_3 = new JButton("再来一局");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel_6.add(btnNewButton_3);
		btnNewButton_3.setEnabled(false);
		
		Vector<String> title=new Vector<String>();
		title.add("    答案     ");
		model = new MyTableModel(new ArrayList<String>(),title);
		table=new MyJTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 31));
		table.setBackground(new Color(255, 255, 255));
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 31));
		TableColumn tc=table.getColumnModel().getColumn(0);
		tc.setPreferredWidth(200);
		table.setBackground(Color.white);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.white);
		contentPane.add(scrollPane, BorderLayout.WEST);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lg.start();
				
			}
			
		});
	}
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	public void setLogic(Logic g) {
		this.lg=g;
	}
	
	public void changeNums(int[] nums) {
		this.numBtn1.setText(String.valueOf(nums[0]));
		this.numBtn2.setText(String.valueOf(nums[1]));
		this.numBtn3.setText(String.valueOf(nums[2]));
		this.numBtn4.setText(String.valueOf(nums[3]));
		
	}
	
	public void showAns(List<String> ans) {
		model.setValue(ans);
		btnNewButton_3.setEnabled(true);
		btnNewButton_1.setEnabled(false);
		btnNewButton.setEnabled(false);
	}

	public void hideAns() {
		model.setValue(new ArrayList<String>());
		btnNewButton_1.setEnabled(true);
		btnNewButton.setEnabled(true);
		btnNewButton_3.setEnabled(false);
		while(!bStack.isEmpty()) {
			JButton b=bStack.pop();
			b.setEnabled(true);
		}
		strStack.clear();
	
		
	}
	
	public void clearInput() {
		this.textField.setText("");
	}
	
	
	private Stack<JButton> bStack=new Stack<JButton>();
	class InputListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b=(JButton)e.getSource();
			bStack.push(b);
			b.setEnabled(false);
			String in=b.getText();
			String s=textField.getText();
			s+=in;
			strStack.add(in);
			textField.setText(s);
			
		}
		
	}

}
