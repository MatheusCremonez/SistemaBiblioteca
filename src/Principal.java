import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Principal {
	public static void main(String args[]) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
		interfaceGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interfaceGrafica.setSize(350, 350);
		interfaceGrafica.setResizable(false);
		interfaceGrafica.setVisible(true);
		interfaceGrafica.setLocation(dim.width/2-interfaceGrafica.getSize().width/2, dim.height/2-interfaceGrafica.getSize().height/2);
		
	}
}
