package aplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import util.*;

	public class Program extends JFrame{
		
		
		private static final long serialVersionUID = 1L;
		private JLabel lblFile , lblResultado;
		private	JButton btnEncrypt , btnDecrypt;
		
		public Program(){	
			
			lblFile = new JLabel("Selecione um arquivo ...");
			lblFile.setBounds(50,50,500,40);
			lblFile.setFont(new Font("Arial", Font.BOLD | Font.ITALIC , 16));
			lblFile.setOpaque(true);
			lblFile.setBackground(Color.WHITE);
			add(lblFile);
			lblFile.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						JFileChooser fileChooser = new JFileChooser();
						int result = fileChooser.showOpenDialog(null);
						
						if(result == JFileChooser.APPROVE_OPTION){
							lblFile.setText(fileChooser.getSelectedFile().getAbsolutePath());
						}
					}
				}
			);
			
			lblResultado = new JLabel();
			lblResultado.setBounds(50,150,500,40);
			lblResultado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC , 16));
			add(lblResultado);
			
			btnEncrypt = new JButton("Criptografar");
			btnEncrypt.setBounds(50,100,245,40);
			btnEncrypt.setFont(new Font("Arial", Font.BOLD , 18));
			add(btnEncrypt);
			btnEncrypt.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(Criptografia.encrypt(lblFile.getText())){
							
							lblResultado.setText("Arquivo criptografado com sucesso !!!");
							lblResultado.setForeground(Color.BLUE);
							
						}else{
							
							lblResultado.setText("Arquivo não criptografado ");
							lblResultado.setForeground(Color.RED);
						}
					}
				}
			);
			
			btnDecrypt = new JButton("Descriptografar");
			btnDecrypt.setBounds(305,100,245,40);
			btnDecrypt.setFont(new Font("Arial", Font.BOLD , 18));
			add(btnDecrypt);
			btnDecrypt.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(Criptografia.decrypt(lblFile.getText())){
							
							lblResultado.setText("Arquivo descritografado com sucesso !!!");
							lblResultado.setForeground(Color.BLUE);
							
						}else{
							
							lblResultado.setText("Arquivo não descritografado ");
							lblResultado.setForeground(Color.RED);
						}
					}
				}
			);
			
		}
		
		public void main(String args[]){
			
			Program form = new Program();
			form.setLayout(null);
			form.setBounds(0,0,600,300);
			form.setVisible(true);
			form.setResizable(false);
			form.setLocationRelativeTo(null);
			form.setDefaultCloseOperation(EXIT_ON_CLOSE);
			form.setTitle("Criptografia de arquivos");
			
		}

	}

