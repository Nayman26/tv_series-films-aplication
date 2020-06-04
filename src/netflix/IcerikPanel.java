package netflix;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class IcerikPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String donen;

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IcerikPanel frame = new IcerikPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IcerikPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 36, 255, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblFilmAdGirin = new JLabel("Film ad\u0131 girin");
		lblFilmAdGirin.setBounds(10, 11, 86, 14);
		contentPane.add(lblFilmAdGirin);

		JLabel lblFilmTrGirin = new JLabel("Film t\u00FCr\u00FC girin");
		lblFilmTrGirin.setBounds(275, 11, 86, 14);
		contentPane.add(lblFilmTrGirin);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(275, 36, 86, 20);
		contentPane.add(textField_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 67, 453, 107);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 185, 351, 20);
		comboBox.addItem("izlemek istediðiniz filmi seçiniz");
		contentPane.add(comboBox);

		JButton btnSorgula = new JButton("Sorgula");
		btnSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				textArea.setText("");
				comboBox.removeAllItems();

				String turegore = "SELECT `program`.`Ad`,tur.Ad FROM `program`,program_tur,tur "
						+ "WHERE `program`.`ID`=program_tur.PID AND `tur`.`ID`=program_tur.TID AND tur.Ad LIKE'%"
						+ textField_1.getText() + "%'";

				String adagore = "SELECT `program`.`Ad`FROM `program` WHERE `program`.`Ad` LIKE '%"
						+ textField.getText() + "%'";

				if (!textField.getText().isEmpty())
					donen = Baglanti.sorgula2(adagore);
				if (!textField_1.getText().isEmpty())
					donen = Baglanti.sorgula2(turegore);
				if (!textField_1.getText().isEmpty() && !textField.getText().isEmpty()) {
					textField.setText("");
					textField_1.setText("");
					System.out.println("hata");
				}
				String donenler[] = donen.split("\n");
				for (String string : donenler) {
					textArea.setText(textArea.getText() + string + "\n");
					comboBox.addItem(string);
				}
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnSorgula.setBounds(371, 35, 89, 23);
		contentPane.add(btnSorgula);

		JButton btnIzle = new JButton("izle");
		btnIzle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				 try {
				 TimeUnit.SECONDS.sleep(60);
				 } catch (InterruptedException e1) {
				 e1.printStackTrace();
				 }

				String pid = Baglanti
						.sorgula2("SELECT ID FROM `program` WHERE `Ad` = '" + comboBox.getSelectedItem() + "'");

				String varmi = "SELECT PID FROM `kullanici_program` WHERE `KID`='" + Sing_In_Out_GUI.currentUser
						+ "' AND `PID` = '" + pid + "'";

				String insert = "INSERT INTO `kullanici_program` (`KID`, `PID`, `IzlenmeTarihi`, `IzlenmeSuresi`, `KaldigiBolum`, `Puan`) "
						+ "VALUES ('" + Sing_In_Out_GUI.currentUser + "', '" + pid
						+ "', '30.05.2010', '60', '1', '6');";

				if (Baglanti.kontrol(varmi)) {

					String izlenmeS = Baglanti.sorgula2("SELECT IzlenmeSuresi FROM `kullanici_program` WHERE `KID`='"
							+ Sing_In_Out_GUI.currentUser + "' AND `PID` = '" + pid + "'");
					
					int izlenme = Integer.parseInt(izlenmeS.trim());
					
					String update = "UPDATE `kullanici_program` SET `IzlenmeSuresi`=" + (izlenme + 60)
							+ " WHERE `KID`='" + Sing_In_Out_GUI.currentUser + "' AND `PID` = '" + pid + "'";
					
					Baglanti.ekleCikar(update);
					
				} else
					Baglanti.ekleCikar(insert);
			}
		});
		btnIzle.setBounds(371, 185, 89, 23);
		contentPane.add(btnIzle);
	}
}