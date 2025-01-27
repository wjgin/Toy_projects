package gui.seohyun.teamProject;

import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import dao.seungJoon.teamProject.InexDao;
import vo.seungJoon.teamProject.InexVo;

@SuppressWarnings("serial")
public class SelectDivisionGui extends javax.swing.JFrame {

	public SelectDivisionGui(String id, String division) {
		initComponents(id, division);
	}

	private void initComponents(String id, String division) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SelectDivisionGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SelectDivisionGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SelectDivisionGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SelectDivisionGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		jScrollPane1 = new javax.swing.JScrollPane();

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

		vo = new InexVo();
		vo.setUserinfo_id(id);

		InexDao dao = InexDao.getInstance();

		rows = dao.getListByDivision(id, division);
		data = rows.stream().toArray(String[][]::new);
		columns = new String[] { "수입|지출", "날짜", "금액", "분류", "메모", "계좌번호", "IDX" };

		// jTable1 생성
		model = new DefaultTableModel(data, columns);
		jTable1 = new javax.swing.JTable(model);
		// jTable1 sort
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable1.getModel());
		jTable1.setRowSorter(sorter);

		jScrollPane1.setViewportView(jTable1);

		jButton1.setText("등록");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.setText("닫기");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 24)); // NOI18N
		jLabel1.setText("수입/지출별 조회");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(221)
							.addComponent(jButton1)
							.addGap(54)
							.addComponent(jButton2))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
							.addGap(0, 12, Short.MAX_VALUE)
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(jLabel1)
					.addGap(35)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton1)
						.addComponent(jButton2))
					.addGap(27))
		);
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);

	}// </editor-fold>

	// "닫기" 이벤트
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	// "가계등록" 이벤트
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		new RegistGui(vo);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	List<String[]> rows;
	String[][] data;
	private DefaultTableModel model;
	private String[] columns;
	private InexVo vo;
}
