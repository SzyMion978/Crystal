package src.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

public class DataPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	JLabel dataLabel;
	public static JLabel nameLabel;
	public static String fileName;

	public DataPanel(LayoutManager layout) {
		super(layout);
		dataLabel = new JLabel("Data source: ");
		dataLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		fileName = "none";
		nameLabel = new JLabel(fileName);
		nameLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		this.add(dataLabel);
		this.add(nameLabel);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new SoftBevelBorder(WIDTH, Color.black, Color.black));
	}

	public static String getFileName() {
		return fileName;
		
	}

	public static void setFileName(String fileName) {
		DataPanel.fileName = fileName;
		DataPanel.nameLabel.setText(DataPanel.fileName);
	}
	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		DataPanel.nameLabel = nameLabel;
	}


}
