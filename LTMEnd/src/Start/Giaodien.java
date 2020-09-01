package Start;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class Giaodien extends JFrame implements ActionListener{
	private JLabel l1;
	private JTextField txt_ma;
	private JLabel l2;
	private JTextField txt_ten;
	private JLabel l3;
	private JTextField txt_namsinh;
	private JLabel l4;
	
	private JLabel l6;
	private JTextField txt_phong;
	private JButton btn_them;
	private JButton btn_luu;
	private JButton btn_xoa;
	private JButton btn_suar;
	private JButton btn_thoat;
	private DefaultTableModel model;
	private JTable tablel;
	private Database database;
	private DanhsachSV ds;
	private JTextField txt_lop;
	private JButton btn_sua;
	public Giaodien() {
		super("quan ly sinh vien");
		database= new Database();
		ds= new DanhsachSV();
		gui();
		try {
			loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dong();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				dong();
			}
			public void dong() {
				try {
					database.writeSV("data.txt", ds);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(1);
			}
		});
	}
	public void loadData() throws Exception{
		ds=database.readSV("data.txt");
		for(Sinhvien sv:ds.getDs()) {
			String[] row = {sv.getMssv()+"",sv.getHoten(),sv.getNamsinh()+"",sv.getLop(),sv.getKtx()};
			model.addRow(row);
		}
	}
	public void gui() {
		Box box= Box.createVerticalBox();
		Box box1= Box.createHorizontalBox();
		Box box2= Box.createHorizontalBox();
		Box box3= Box.createHorizontalBox();
		Box box4= Box.createHorizontalBox();
		Box box5= Box.createHorizontalBox();
		Box box6= Box.createHorizontalBox();
		box.add(box1);
		box.add(Box.createVerticalStrut(5));
		box.add(box2);
		box.add(Box.createVerticalStrut(5));
		box.add(box3);
		box.add(Box.createVerticalStrut(5));
		box.add(box4);
		box.add(Box.createVerticalStrut(5));
		box.add(box6);
		box.add(Box.createVerticalStrut(10));
		box.add(box5);
		this.add(box,BorderLayout.NORTH);
		box1.add(l1=new JLabel("MaSV"));
		box1.add(txt_ma=new JTextField(20)); 
		box2.add(l2=new JLabel("Ho ten"));
		box2.add(txt_ten = new JTextField(20));
		box3.add(l3=new JLabel("nam sinh"));
		box3.add(txt_namsinh =  new JTextField(20));
		box4.add(l4=new JLabel("Lop"));
		box4.add(txt_lop=new JTextField(20));
		box6.add(l6=new JLabel("KTX_Phong"));
		box6.add(txt_phong=new JTextField(20));
		l1.setPreferredSize(l6.getPreferredSize());
		l2.setPreferredSize(l6.getPreferredSize());
		l3.setPreferredSize(l6.getPreferredSize());
		l4.setPreferredSize(l6.getPreferredSize());
		JPanel panel= new JPanel();
		box5.add(panel);
		panel.add(btn_them= new JButton("Them"));
		panel.add(btn_luu=new JButton("Luu"));
		panel.add(btn_xoa=new JButton("Xoa"));
		panel.add(btn_sua=new JButton("Sua"));
		panel.add(btn_thoat=new JButton("Thoat"));
		taotable();
		btn_them.addActionListener(this);
		btn_luu.addActionListener(this);
		btn_xoa.addActionListener(this);
		btn_sua.addActionListener(this);
		btn_thoat.addActionListener(this);
	}
	public void taotable() {
		model = new DefaultTableModel();
		tablel= new JTable(model);
		model.addColumn("MaSV");
		model.addColumn("Ho ten");
		model.addColumn("Nam sinh");
		model.addColumn("Lop");
		model.addColumn("KTX_Phong");
		JScrollPane sc= new JScrollPane(tablel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(sc,BorderLayout.CENTER);
		tablel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = tablel.getSelectedRow();
				txt_ma.setText(model.getValueAt(row, 0).toString());
				txt_ten.setText(model.getValueAt(row, 1).toString());
				txt_namsinh.setText(model.getValueAt(row, 2).toString());
				txt_lop.setText(model.getValueAt(row, 3).toString());
				txt_phong.setText(model.getValueAt(row, 4).toString());
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn_them)) {
			if(btn_them.getText().equals("Them")) {
				txt_ma.setEnabled(true);
				Suatext(true);
				btn_them.setText("Huy");
				btn_them.setEnabled(true);
				btn_luu.setEnabled(true);
				btn_sua.setEnabled(false);
				btn_xoa.setEnabled(false);
				btn_thoat.setEnabled(false);
			}
			else if(btn_them.getText().equalsIgnoreCase("Huy")) {
				txt_ma.setEnabled(false);
				Suatext(false);
				btn_them.setText("Them");
				btn_them.setEnabled(true);
				btn_luu.setEnabled(false);
				btn_sua.setEnabled(true);
				btn_xoa.setEnabled(true);
				btn_thoat.setEnabled(true);
			}
		}
		if(e.getSource().equals(btn_thoat)) {
			dispose();
		}
		if(e.getSource().equals(btn_luu)) {
			if(ds.Kiemtra(Long.parseLong(txt_ma.getText()))) {
				luu();
			}else {
				ds.SuaSV(Long.parseLong(txt_ma.getText()), txt_ten.getText(), Integer.parseInt(txt_namsinh.getText()), txt_lop.getText(), txt_phong.getText());
				model.setValueAt(txt_ten.getText(), tablel.getSelectedRow(), 1);
				model.setValueAt(txt_namsinh.getText(), tablel.getSelectedRow(), 2);
				model.setValueAt(txt_lop.getText(), tablel.getSelectedRow(), 3);
				model.setValueAt(txt_phong.getText(), tablel.getSelectedRow(), 4);
			}
			 
		}
		if(e.getSource().equals(btn_sua)) {
			if(btn_sua.getText().equalsIgnoreCase("Sua")) {
				Suatext(true);
				txt_ma.setEnabled(false);
				btn_sua.setText("Huy");
				btn_sua.setEnabled(true);
				btn_xoa.setEnabled(false);
				btn_thoat.setEnabled(false);
				btn_them.setEnabled(false);
				btn_luu.setEnabled(true);
			}
			else if(btn_sua.getText().equalsIgnoreCase("Huy")) {
				Suatext(false);
				btn_sua.setText("Sua");
				txt_ma.setEnabled(false);
				btn_sua.setEnabled(true);
				btn_luu.setEnabled(false);
				btn_them.setEnabled(true);
				btn_xoa.setEnabled(true);
				btn_thoat.setEnabled(true);
			}
		}
	}
	public void luu() {
		String ms = txt_ma.getText();
		String ho=txt_ten.getText();
		String tuoi= txt_namsinh.getText();
		String lop=txt_lop.getText();
		String phong=txt_phong.getText();
		Sinhvien sv= new Sinhvien(Long.parseLong(ms),ho,Integer.parseInt(tuoi),lop,phong);
		ds.themSV(sv);
		String[] row= {ms,ho,tuoi,lop,phong};
		model.addRow(row);
	}
	public void Suatext(boolean trangthai) {
		txt_ten.setEnabled(trangthai);
		txt_namsinh.setEnabled(trangthai);
		txt_lop.setEnabled(trangthai);
		txt_phong.setEnabled(trangthai);
	}
}
