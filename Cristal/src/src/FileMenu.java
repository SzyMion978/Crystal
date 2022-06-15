package src;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class FileMenu extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu menu;
	ReadingManager readMan;
	boolean loaded = false;
	
	public FileMenu() {
		menu = new JMenu("File");
		readMan = new ReadingManager();
		
		JMenuItem load = new JMenuItem("Load file");
		load.setToolTipText("Choose to load a file with data");
		
		ActionListener loadListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!loaded) {
					JFileChooser fC = new JFileChooser();
					fC.setDialogTitle("Wybierz plik");
					int f = fC.showOpenDialog(null);
				
					if (f == JFileChooser.APPROVE_OPTION) {
						readMan.setInputFile(fC.getSelectedFile());
						readMan.start();
					}
					if(ReadingManager.success)
						loaded = true;
				}
				else {
					JOptionPane.showMessageDialog(null, "You can't load a file again. Please start a new session to do this.", 
							"You can't load a file again", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		};
		load.addActionListener(loadListener);
		
		menu.add(load);
		
		JMenuItem example = new JMenuItem("Correct example file");
		example.setToolTipText("Choose to see example data file");
		
		ActionListener nikielListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame nikielFrame = new JFrame("Example data sample...");
				JLabel nikielData = new JLabel();
				nikielData.setText("<html>"
						+ "    types_number 1<br />"
						+ "    type 1 Ni<br />"
						+ "    lattice_constant_a 3.52<br />"
						+ "    lattice_constant_b 3.52<br />"
						+ "    lattice_constant_c 3.52<br />"
						+ "    particles_number 14<br />"
						+ "    Coodrdinates:	<br />"
						+ "    1 Ni	0.0		0.0		0.0<br />"
						+ "    2 Ni	1.76	1.76	0.0<br />"
						+ "    3 Ni	3.52	0.0		0.0<br />"
						+ "    4 Ni	0.0		3.52	0.0<br />"
						+ "    5 Ni	3.52	3.52	0.0<br />"
						+ "    6 Ni	0.0		0.0		3.52<br />"
						+ "    7 Ni	0.0		3.52	3.52<br />"
						+ "    8 Ni	3.52	0.0		3.52<br />"
						+ "    9 Ni	3.52	3.52	3.52<br />"
						+ "    10 Ni	1.76	1.76	3.52<br />"
						+ "    11 Ni	1.76	0.0		1.76<br />"
						+ "    12 Ni	1.76	3.52	1.76<br />"
						+ "    13 Ni	0.0		1.76	1.76<br />"
						+ "    14 Ni	3.52	1.76	1.76<br />"
						+ "</html>");
				nikielData.setFont(new Font("Cambria", Font.BOLD, 14));
				nikielFrame.add(nikielData);
				nikielFrame.setSize(320, 500);
				nikielFrame.setDefaultCloseOperation(WHEN_IN_FOCUSED_WINDOW);
				nikielFrame.setVisible(true);
			}
		};
		
		example.addActionListener(nikielListener);
		
		menu.add(example);
		
		this.add(menu);
	}

}
