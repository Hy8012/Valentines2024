package gift;
import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setResizable(false);
		window.setUndecorated(true);
		
		VideoPanel panel = new VideoPanel();
		
		window.add(panel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
