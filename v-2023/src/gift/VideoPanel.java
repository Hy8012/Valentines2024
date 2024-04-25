package gift;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class VideoPanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	BufferedImage icon;
	Font vFont;
	static Clip musicClip;
	
	public VideoPanel() {
		this.setPreferredSize(new Dimension(600, 300));
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		
		
		try {
			icon = ImageIO.read(getClass().getResourceAsStream("imgVday.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		startMusic("ILYSong.wav");
		
	}

	@Override
	public void run() {
		repaint();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Graphics2D g2 = (Graphics2D) graphics;
		
		InputStream is = getClass().getResourceAsStream("Valentine.ttf");
		try {
			vFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		g2.setFont(vFont);
		
		g2.drawImage(icon, 0, 0, null);
		
		//DRAWING TEXT
		
		/*
		 * Frame size = 600 x 300
		 */
		
		Color pink =  new Color(124,43,83);
		
		g2.setColor(pink);
		g2.setFont(g2.getFont().deriveFont(65F));
		g2.drawString("Will you", 230 + 1, 110 + 1);
		
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(65F));
		g2.drawString("Will you", 230, 110);
		
		
		
		g2.setColor(pink);
		g2.setFont(g2.getFont().deriveFont(40F));
		g2.drawString("Be My", 270 + 1, 160 + 1);
		
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(40F));
		g2.drawString("Be My", 270, 160);
		
		
		
		g2.setColor(pink);
		g2.setFont(g2.getFont().deriveFont(110F));
		g2.drawString("Valentine", 185 + 2, 240 + 2);
		
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(110F));
		g2.drawString("Valentine", 185, 240);
	}
	
	public static void startMusic(String str) {
		// https://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
		//& From RPG Game
		try {
			File music = new File(str);
			AudioInputStream audio = AudioSystem.getAudioInputStream(music);
			musicClip = AudioSystem.getClip();
			musicClip.open(audio);
			musicClip.start();
			musicClip.loop(Clip.LOOP_CONTINUOUSLY);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
