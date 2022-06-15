package src.panels;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class EastPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ParticlePanel partPan;
	private static MillerPanel mp;
	private JPanel tmpPan;
	public static DiffractionPanel diffp;
	
	public EastPanel() {
		DataPanel dp = new DataPanel(new FlowLayout());
		
		tmpPan = new JPanel();
		
		tmpPan.add(dp);
		
		partPan = new ParticlePanel();
		tmpPan.add(partPan);
				
		mp = new MillerPanel();
		tmpPan.add(mp);

		diffp = new DiffractionPanel(); 
		tmpPan.add(diffp);
		
		tmpPan.setLayout(new BoxLayout(tmpPan, BoxLayout.Y_AXIS));
		this.add(tmpPan);
	}
	
	public static void generatePanels(Particle[] PartTab) {
		EastPanel.partPan.generatePanel(PartTab);
		EastPanel.mp.generatePanel();
		EastPanel.diffp.generatePanel();
	}

}
