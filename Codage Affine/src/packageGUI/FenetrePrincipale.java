package packageGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import packageChiffre.Chiffre ;


public class FenetrePrincipale extends JFrame {
	
	/*
	 * NB : Cette UI a été réalisée à l'aide d'un plugin Eclipse : WindowsBuilder Core.
	 */

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldB;
	
	public static FenetrePrincipale frame ;
	
	public JTextPane textPaneMessageSortie ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FenetrePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		setTitle("Chiffrement Affine");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{545, 0};
		gbl_contentPane.rowHeights = new int[] {150, 40, 150, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTextPane textPaneMessageEntre = new JTextPane();
		textPaneMessageEntre.setFont(new Font("Consolas", Font.PLAIN, 14));
		textPaneMessageEntre.setText("Texte d'entree");
		GridBagConstraints gbc_textPaneMessageEntre = new GridBagConstraints();
		gbc_textPaneMessageEntre.fill = GridBagConstraints.BOTH;
		gbc_textPaneMessageEntre.insets = new Insets(0, 0, 5, 0);
		gbc_textPaneMessageEntre.gridx = 0;
		gbc_textPaneMessageEntre.gridy = 0;
		contentPane.add(textPaneMessageEntre, gbc_textPaneMessageEntre);
		
		JPanel panelControle = new JPanel();
		GridBagConstraints gbc_panelControle = new GridBagConstraints();
		gbc_panelControle.fill = GridBagConstraints.VERTICAL;
		gbc_panelControle.insets = new Insets(5, 0, 5, 0);
		gbc_panelControle.gridx = 0;
		gbc_panelControle.gridy = 1;
		contentPane.add(panelControle, gbc_panelControle);
		GridBagLayout gbl_panelControle = new GridBagLayout();
		gbl_panelControle.columnWidths = new int[] {50, 50, 50, 50, 0, 0, 0};
		gbl_panelControle.rowHeights = new int[] {30, 0};
		gbl_panelControle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panelControle.rowWeights = new double[]{0.0, 0.0};
		panelControle.setLayout(gbl_panelControle);
		
		JLabel labelA = new JLabel("a = ");
		labelA.setHorizontalAlignment(SwingConstants.RIGHT);
		labelA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_labelA = new GridBagConstraints();
		gbc_labelA.fill = GridBagConstraints.BOTH;
		gbc_labelA.insets = new Insets(0, 0, 0, 5);
		gbc_labelA.gridx = 0;
		gbc_labelA.gridy = 0;
		panelControle.add(labelA, gbc_labelA);
		
		textFieldA = new JTextField();
		textFieldA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldA.setText("1");
		GridBagConstraints gbc_textFieldA = new GridBagConstraints();
		gbc_textFieldA.fill = GridBagConstraints.BOTH;
		gbc_textFieldA.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldA.gridx = 1;
		gbc_textFieldA.gridy = 0;
		panelControle.add(textFieldA, gbc_textFieldA);
		textFieldA.setColumns(10);
		
		JLabel labelB = new JLabel("b = ");
		labelB.setHorizontalAlignment(SwingConstants.RIGHT);
		labelB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_labelB = new GridBagConstraints();
		gbc_labelB.fill = GridBagConstraints.BOTH;
		gbc_labelB.insets = new Insets(0, 0, 0, 5);
		gbc_labelB.gridx = 2;
		gbc_labelB.gridy = 0;
		panelControle.add(labelB, gbc_labelB);
		
		textFieldB = new JTextField();
		textFieldB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldB.setText("0");
		GridBagConstraints gbc_textFieldB = new GridBagConstraints();
		gbc_textFieldB.fill = GridBagConstraints.BOTH;
		gbc_textFieldB.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldB.gridx = 3;
		gbc_textFieldB.gridy = 0;
		panelControle.add(textFieldB, gbc_textFieldB);
		textFieldB.setColumns(10);
		
		JButton btnNewButtonCodage = new JButton("Coder le message");
		btnNewButtonCodage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonCodage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String message = new String() ;
					String messageDecode = new String() ;
					int a,b ;
					
					message = textPaneMessageEntre.getText() ;
					a = Integer.parseInt(textFieldA.getText());
					b = Integer.parseInt(textFieldB.getText());
					
					messageDecode = Chiffre.codage(message, a , b) ;
					
					textPaneMessageSortie.setText(messageDecode) ;
					
					
				} catch (Exception err) {

					JOptionPane.showMessageDialog(frame, "Erreur : Impossible de modifier l'objectif.\n"+ err.toString());
					
				}
				
				
			}
		});
		GridBagConstraints gbc_btnNewButtonCodage = new GridBagConstraints();
		gbc_btnNewButtonCodage.fill = GridBagConstraints.BOTH;
		gbc_btnNewButtonCodage.insets = new Insets(0, 20, 0, 5);
		gbc_btnNewButtonCodage.gridx = 4;
		gbc_btnNewButtonCodage.gridy = 0;
		panelControle.add(btnNewButtonCodage, gbc_btnNewButtonCodage);
		
		JButton btnNewButtonDecodage = new JButton("Decoder le message");
		btnNewButtonDecodage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String message = new String() ;
					String messageDecode = new String() ;
					int a,b ;
					
					message = textPaneMessageEntre.getText() ;
					a = Integer.parseInt(textFieldA.getText());
					b = Integer.parseInt(textFieldB.getText());
					
					messageDecode = Chiffre.decodage(message, a , b) ;
					
					textPaneMessageSortie.setText(messageDecode) ;
					
					
				} catch (Exception err) {

					JOptionPane.showMessageDialog(frame, "Erreur : Impossible de modifier l'objectif.\n"+ err.toString());
					
				}
				
				
			}
		});
		btnNewButtonDecodage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButtonDecodage = new GridBagConstraints();
		gbc_btnNewButtonDecodage.fill = GridBagConstraints.BOTH;
		gbc_btnNewButtonDecodage.gridx = 5;
		gbc_btnNewButtonDecodage.gridy = 0;
		panelControle.add(btnNewButtonDecodage, gbc_btnNewButtonDecodage);
		
		JLabel labelC = new JLabel("");
		GridBagConstraints gbc_labelC = new GridBagConstraints();
		gbc_labelC.fill = GridBagConstraints.BOTH;
		gbc_labelC.insets = new Insets(0, 0, 0, 5);
		gbc_labelC.gridx = 3;
		gbc_labelC.gridy = 1;
		panelControle.add(labelC, gbc_labelC);
		
		JLabel labelD = new JLabel("");
		GridBagConstraints gbc_labelD = new GridBagConstraints();
		gbc_labelD.fill = GridBagConstraints.BOTH;
		gbc_labelD.gridx = 6;
		gbc_labelD.gridy = 1;
		panelControle.add(labelD, gbc_labelD);
		
		textPaneMessageSortie = new JTextPane();
		textPaneMessageSortie.setFont(new Font("Consolas", Font.PLAIN, 14));
		textPaneMessageSortie.setText("Texte en sortie");
		GridBagConstraints gbc_textPaneMessageSortie = new GridBagConstraints();
		gbc_textPaneMessageSortie.insets = new Insets(5, 0, 0, 0);
		gbc_textPaneMessageSortie.fill = GridBagConstraints.BOTH;
		gbc_textPaneMessageSortie.gridx = 0;
		gbc_textPaneMessageSortie.gridy = 2;
		contentPane.add(textPaneMessageSortie, gbc_textPaneMessageSortie);
	}

}
