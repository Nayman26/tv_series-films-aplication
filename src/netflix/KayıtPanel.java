package netflix;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class KayýtPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel = new JPanel();

	private JTextField Kayit_Ad_Text;
	private JTextField Kayit_Parola_Text;
	private JTextField Kayit_Email_Text;
	private JComboBox<Integer> comboGün;
	private JComboBox<Integer> comboAy;
	private JComboBox<Integer> comboYil;

	public KayýtPanel() {
		setTitle("Kayýt Ekraný");
		setBounds(150, 150, 450, 300);
		setVisible(true);
		setContentPane(panel);
		panel.setLayout(null);

		girdiler();
		etiketler();

		JButton btnKaytOl = new JButton("Kayýt ol");
		btnKaytOl.setBounds(250, 183, 89, 23);
		panel.add(btnKaytOl);

		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullanici = "INSERT INTO `kullanici` (`Ad`, `Email`, `Parola`, `DogumTarihi`)VALUES" + "(" + "'"
						+ Kayit_Ad_Text.getText() + "'" + "," + "'" + Kayit_Email_Text.getText() + "'" + "," + "'"
						+ Kayit_Parola_Text.getText() + "'" + "," + "'" + comboGün.getSelectedItem() + "/"
						+ comboAy.getSelectedItem() + "/" + comboYil.getSelectedItem() + "'" + ");";
				if (Baglanti.ekleCikar(kullanici))
					OneriPanel.main();
			}
		});
	}

	private void girdiler() {
		Kayit_Ad_Text = new JTextField();
		Kayit_Ad_Text.setBounds(173, 59, 166, 20);
		panel.add(Kayit_Ad_Text);
		Kayit_Ad_Text.setColumns(10);

		Kayit_Parola_Text = new JPasswordField();
		Kayit_Parola_Text.setColumns(10);
		Kayit_Parola_Text.setBounds(173, 90, 166, 20);
		panel.add(Kayit_Parola_Text);

		Kayit_Email_Text = new JTextField();
		Kayit_Email_Text.setColumns(10);
		Kayit_Email_Text.setBounds(173, 121, 166, 20);
		panel.add(Kayit_Email_Text);
		Kayit_Email_Text.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				Matcher matcher = Pattern.compile("[a-z0-9][a-z0-9._]*\\@[a-z0-9][a-z0-9]*\\.[a-z0-9]+\\.?[a-z0-9]*")
						.matcher(Kayit_Email_Text.getText());
				if (matcher.find())
					Kayit_Email_Text.setBorder(new LineBorder(Color.GREEN));
				else
					Kayit_Email_Text.setBorder(new LineBorder(Color.RED));
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		comboGün = new JComboBox<Integer>();
		comboGün.setBounds(173, 152, 45, 20);
		panel.add(comboGün);
		for (int i = 0; i <= 31; i++)
			comboGün.addItem(i);

		comboAy = new JComboBox<Integer>();
		comboAy.setBounds(228, 152, 45, 20);
		panel.add(comboAy);
		for (int i = 0; i <= 12; i++)
			comboAy.addItem(i);

		comboYil = new JComboBox<Integer>();
		comboYil.setBounds(283, 152, 56, 20);
		panel.add(comboYil);
		for (int i = 2020; i >= 1900; i--)
			comboYil.addItem(i);
	}

	private void etiketler() {
		JLabel Kayit_Email_lbl = new JLabel("E-mail :");
		Kayit_Email_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Kayit_Email_lbl.setBounds(77, 124, 86, 14);
		panel.add(Kayit_Email_lbl);

		JLabel Kayit_Dtarih_lbl = new JLabel("Do\u011Fum Tarihi :");
		Kayit_Dtarih_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Kayit_Dtarih_lbl.setBounds(77, 155, 86, 14);
		panel.add(Kayit_Dtarih_lbl);

		JLabel Kayit_Ad_lbl = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		Kayit_Ad_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Kayit_Ad_lbl.setBounds(77, 65, 86, 14);
		panel.add(Kayit_Ad_lbl);

		JLabel Kayit_Parola_lbl = new JLabel("Parola :");
		Kayit_Parola_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Kayit_Parola_lbl.setBounds(77, 93, 86, 14);
		panel.add(Kayit_Parola_lbl);
	}
}