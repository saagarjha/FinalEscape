import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWonPanel extends JPanel implements ActionListener {

	private FinalEscape mainPanel;
	private JButton continueButton;

	public GameWonPanel(FinalEscape mainPanel) {
		this.mainPanel = mainPanel;
		setLayout(null);
	}

	private void addContinueButton(int stringHeight) {
		continueButton = new JButton("Continue?");
		continueButton.setActionCommand("continue");
		continueButton.addActionListener(this);
		continueButton.setSize(getWidth() / 4, getWidth() / 16);
		continueButton.setLocation(getWidth() / 2 - getWidth() / 8,
			getHeight() / 2 + stringHeight);
		add(continueButton);
	}

	@Override
	public void paintComponent(Graphics g) {
		drawWhiteRectangle(g);
		int stringHeight = drawGameOverMessage(g);
		if (continueButton == null)
			addContinueButton(stringHeight);
	}

	private void drawWhiteRectangle(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	private int drawGameOverMessage(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 80));
		g.setColor(Color.GREEN);
		String text = "Victory!";
		int width = g.getFontMetrics().stringWidth(text);
		int height = g.getFontMetrics().getHeight();
		g.drawString(text, getWidth() / 2 - width / 2,
			getHeight() / 2 - g.getFontMetrics().getAscent() + height / 2);
		return height;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
			case "continue":
				mainPanel.nextLevel();
				break;
		}
	}
}