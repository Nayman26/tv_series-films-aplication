package netflix;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Sing_In_Out_GUI {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnGiris;
	private JButton btnKayitOl;
	private JLabel lblNetflixE;
	private JLabel lblHesabnzYokMu;

	public static String currentUser;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sing_In_Out_GUI window = new Sing_In_Out_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sing_In_Out_GUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(176, 70, 170, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				Matcher matcher = Pattern.compile("[a-z0-9][a-z0-9._]*\\@[a-z0-9][a-z0-9]*\\.[a-z0-9]+\\.?[a-z0-9]*").matcher(textField.getText());
				if (matcher.find())
					textField.setBorder(new LineBorder(Color.GREEN));
				else
					textField.setBorder(new LineBorder(Color.RED));
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		JLabel lblNewLabel = new JLabel("Kullanýcý Adý :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(80, 73, 86, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Parola :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(80, 116, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(176, 113, 170, 20);
		frame.getContentPane().add(passwordField);

		btnGiris = new JButton("Giriþ");
		btnGiris.setBounds(257, 144, 89, 23);
		frame.getContentPane().add(btnGiris);

		btnKayitOl = new JButton("Kayýt ol");
		btnKayitOl.setBounds(176, 216, 89, 23);
		frame.getContentPane().add(btnKayitOl);

		lblNetflixE = new JLabel(
				"Netflix ' e Hoþgeldiniz!  Devam etmek için lütfen giriþ yapýnýz.");
		lblNetflixE.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetflixE.setBounds(10, 26, 414, 14);
		frame.getContentPane().add(lblNetflixE);

		lblHesabnzYokMu = new JLabel("Hesabýnýz yok mu? Buradan Kayýt olabilirsiniz.");
		lblHesabnzYokMu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHesabnzYokMu.setBounds(10, 191, 414, 14);
		frame.getContentPane().add(lblHesabnzYokMu);

		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String sorgu1 = "SELECT Email FROM `kullanici` WHERE `Email` = '" + textField.getText() + "'";
				String sorgu2 = "SELECT Parola FROM `kullanici` WHERE `Parola` = '"
						+ String.valueOf(passwordField.getPassword()) + "'";

				if (Baglanti.kontrol(sorgu1))
					if (Baglanti.kontrol(sorgu2)) {
						System.out.println("giriþ baþarýlý");
						currentUser =Baglanti.sorgula2("Select ID From kullanici where Email='"+textField.getText()+"'");
						IcerikPanel.main();
					}
					else
						System.out.println("parola hatalý");
				else
					System.out.println("kullanýcý adý hatalý");
			}
		});

		btnKayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KayýtPanel();
			}
		});
	}
}