package src.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import xrd.XrdManager;


public class DiffractionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel titleLabel;
	JPanel lambdaPanel;
	JPanel anglePanel;
	JButton generateButton;
	JTextField minText;
	JTextField maxText;
	JTextField wavetext;
	XrdManager xrd;

	public DiffractionPanel() {
		titleLabel = new JLabel("DIFFRACTION PATTERN");
		titleLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		
		anglePanel = new JPanel(new GridLayout(5,1));
		
		anglePanel.add(titleLabel);
		
		lambdaPanel = new JPanel(new FlowLayout());		
		JLabel lambdaLabel = new JLabel("<html>set &#955 wavelength:  &#955 = </html>");
		lambdaLabel.setFont(new Font("Cambria", Font.BOLD, 12));
		wavetext = new JTextField("1.4767", 8);
		JLabel angstrom = new JLabel("<html>[&#8491]</html>");
		angstrom.setFont(new Font("Cambria", Font.BOLD, 12));
		lambdaPanel.add(lambdaLabel);
		lambdaPanel.add(wavetext);
		lambdaPanel.add(angstrom);
		
		
		anglePanel.add(lambdaPanel);
		JLabel angleLabel = new JLabel("<html>set 2&#x0398 angle scattering range: </html>");
		angleLabel.setFont(new Font("Cambria", Font.BOLD, 12));
		anglePanel.add(angleLabel);
		
		JPanel minMax = new JPanel(new FlowLayout());
		JLabel degree1 = new JLabel("<html>[&#176]</html>");
		JLabel degree2 = new JLabel("<html>[&#176]</html>");
		JLabel minLab = new JLabel("<html>2&#x0398 min = </html>");
		minLab.setFont(new Font("Cambria", Font.BOLD, 12));
		JLabel maxLab = new JLabel("<html>2&#x0398 max = </html>");
		maxLab.setFont(new Font("Cambria", Font.BOLD, 12));
		
		minText = new JTextField("20", 4);
		maxText = new JTextField("90", 4);
		
		minMax.add(minLab);
		minMax.add(minText);
		minMax.add(degree1);
		minMax.add(maxLab);
		minMax.add(maxText);
		minMax.add(degree2);
		
		anglePanel.add(minMax);	
		
		generateButton = new JButton("Generate");
		generateButton.setFont(new Font("Cambria", Font.BOLD, 14));
		generateButton.setBackground(Color.DARK_GRAY);
		generateButton.setForeground(Color.LIGHT_GRAY);
		
		anglePanel.add(generateButton);
		this.add(anglePanel, BorderLayout.CENTER);
		this.setBorder(new SoftBevelBorder(WIDTH, Color.black, Color.black));
	}
	
	public void generatePanel() {
		
		
		
		
		ActionListener genButList = new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				xrd = new XrdManager();
				
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Wybierz plik");
				int f = chooser.showSaveDialog(null);
				
				if(f == JFileChooser.APPROVE_OPTION) {
					XrdManager.xrdFile = chooser.getSelectedFile();
					xrd.start();
				}				
			}
		};		
		generateButton.addActionListener(genButList);		
	}
	

	public JTextField getMinText() {
		return minText;
	}

	public void setMinText(JTextField minText) {
		this.minText = minText;
	}

	public JTextField getMaxText() {
		return maxText;
	}

	public void setMaxText(JTextField maxText) {
		this.maxText = maxText;
	}

	public JTextField getWaveText() {
		return wavetext;
	}

	public void setWavetext(JTextField wavetext) {
		this.wavetext = wavetext;
	}
	

}
