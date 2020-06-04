package netflix;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class OneriPanel {

	private JFrame frame;
	private JCheckBox turbox[] = new JCheckBox[12];
	private ArrayList<String[][]> onerilenler = new ArrayList<>();
	private int turID, sayac;
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OneriPanel window = new OneriPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OneriPanel() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 426, 181);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label_5 = new JLabel("Merhaba sizi yakýndan tanýmak için lütfen 3 farklý tür seçiniz.");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(7, 0, 357, 14);
		panel.add(label_5);

		String turler[] = { "Aksiyon", "Belgesel", "Bilim Kurgu ve Fantastik Yapýmlar", "Bilim ve Doða",
				"Çocuk ve Aile", "Dramalar", "Gerilim", "Komedi", "Korku", "Romantizm", "Anime", "Reality Programs" };

		for (int x = 0, i = 0; x < 233 & i < 12; x += 232)
			for (int y = 21, j = 0; j < turler.length / 2; y += 26, j++, i++) {
				turbox[i] = new JCheckBox(turler[i]);
				turbox[i].setBounds(x, y, 125, 23);
				panel.add(turbox[i]);
			}
		turbox[2].setBounds(0, 73, 230, 23);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 199, 426, 199);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSetiinizTrlerdeEn = new JLabel(
				"Se\u00E7ti\u011Finiz t\u00FCrlerden en y\u00FCksek puanl\u0131 2'\u015Fer film a\u015Fa\u011F\u0131da g\u00F6sterilmektedir.");
		lblSetiinizTrlerdeEn.setHorizontalAlignment(SwingConstants.LEFT);
		lblSetiinizTrlerdeEn.setBounds(7, 11, 419, 14);
		panel_1.add(lblSetiinizTrlerdeEn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 36, 409, 163);
		panel_1.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JButton btnTamam = new JButton("Tamam");
		btnTamam.setBounds(157, 409, 112, 23);
		frame.getContentPane().add(btnTamam);
		btnTamam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		String sorgu = "SELECT `program`.`Ad`,`kullanici_program`.`Puan` FROM `program`,kullanici_program,program_tur"
				+ " WHERE `program`.`ID`=`kullanici_program`.`PID` AND `program`.`ID`=program_tur.PID AND program.Tip='film' AND program_tur.TID=tmp"
				+ " ORDER BY kullanici_program.Puan DESC LIMIT 2";
		
		for (turID = 0; turID < turbox.length; turID++) {
			
			turbox[turID].addActionListener(new ActionListener() {
				
				int türID = turID;
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (turbox[türID].isSelected()) {
						
						String onerilen[][] = Baglanti.sorgula(sorgu.replace("tmp", String.valueOf(türID + 1)));
						onerilenler.add(onerilen);
						
						sayac++;
						if (sayac == 3) {	
							for (JCheckBox combo : turbox)
								combo.setEnabled(false);
							
							for (String string[][] : onerilenler) {
								for (String string2[] : string) {
									for (String string3 : string2) {
										textArea.setText(textArea.getText() + "  " + string3);
									}
									textArea.setText(textArea.getText() + "\n");
								}
								textArea.setText(textArea.getText() + "\n");
							}
						}
					} else
						sayac--;
				}
			});
		}
	}
}