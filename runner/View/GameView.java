package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*;
import Model.*;

/**
 * The GameView class is the main visual class that is in charge of everything
 * being displayed
 * 
 * @author
 *
 */
public class GameView extends JFrame {
	/**
	 * The class Panel2 is used as a panel for generating the levels as well as
	 * doing all the drawing
	 * 
	 * @author Max Crookshanks
	 *
	 */

	private class Panel2 extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setBackground(Color.WHITE);
			CharacterModel chMod = model.getCharModel();
			// resets the canvas
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, model.getMaxX(), model.getMaxY());
			// starts drawing the line
			g.setColor(Color.BLACK);
			// testing this out and it works
			// need to implement the random generator
			Image img = Toolkit.getDefaultToolkit().getImage("runner1.png");
			Image img1 = Toolkit.getDefaultToolkit().getImage("runner2.png");
			Image img2 = Toolkit.getDefaultToolkit().getImage("city.jpg");
			Image img3 = Toolkit.getDefaultToolkit().getImage("rectangle.jpg");
			// background
			g.drawImage(img2, 0, 0, 800, 500, this);
			for (Platform platform : (model.getPlatModel()).getPlatforms()) {
				if (platform.getStartX() < model.getMaxX()) {
					if (platform.getStartX() + platform.getLength() <= model.getMaxX()) {
						g.drawImage(img3, platform.getStartX(), platform.getStartY(), platform.getLength(),
								model.getMaxY(), this);
					}
				}
			}

			// update character

			if (!model.isPaused()) {
				model.getCharModel().updateTimer();
			} else {
				g.setColor(Color.WHITE);
				g.drawString("Paused!", 300, 200);
				g.setColor(Color.BLACK);
			}
			if (model.getCharModel().getTimer() < 30) {

				g.drawImage(img, chMod.getX(), (int) chMod.getY(), chMod.getWidth() + 16, (int) chMod.getWidth() + 32,
						this);
			} else if (model.getCharModel().getTimer() > 60) {
				g.drawImage(img1, chMod.getX(), (int) chMod.getY(), chMod.getWidth() + 16, (int) chMod.getWidth() + 32,
						this);
				model.getCharModel().setTimer();
			} else {
				g.drawImage(img1, chMod.getX(), (int) chMod.getY(), chMod.getWidth() + 16, (int) chMod.getWidth() + 32,
						this);
			}

			g.setColor(Color.WHITE);
			g.drawString("Score:" + Integer.toString(model.getCurrentScore().getScore() + 1), 600, 10);
			g.setColor(Color.BLACK);
			(controller.getLevelController()).updateLevel();
		}
	}

	private GameModel model;
	private OverallController controller;
	private Panel2 panel2;
	private JPanel mainMenuPanel, menuButtons, optionMenuPanel, optionButtons, panel3, gameOverButtons, panel4,
			leaderBoardHolder, leaderBoard;
	private Font font;

	/**
	 * Constructor for the GameView class
	 * 
	 * @param model
	 */
	public GameView(GameModel model) {
		super("Jumper");
		this.model = model;
		paintMainMenu();
		setIconImage(Toolkit.getDefaultToolkit().getImage("j.png"));
	}

	/**
	 * paints the panel for the menus
	 */
	public void paintMainMenu() {
		// --------------------------------mainMenuPanel------------------------------------//
		mainMenuPanel = new JPanel(new BorderLayout());
		// this may be confusing but I put class Panel2 inside of this class and
		// this class will draw the level
		panel2 = new Panel2();
		// displays the title of the game
		JLabel title = new JLabel("Jumper");
		title.setBorder(new EmptyBorder(0, 130, 0, 0));
		title.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 90));
		title.setOpaque(true);
		title.setBackground(Color.WHITE);
		title.setForeground(Color.BLACK);
		mainMenuPanel.add(title, BorderLayout.NORTH);

		JPanel pane1 = new JPanel(); // contains menuButtons and Image
		pane1.setLayout(new GridLayout(1, 2, 90, 5));
		pane1.setForeground(Color.WHITE);
		pane1.setBackground(Color.WHITE);
		pane1.setBorder(new EmptyBorder(30, 190, 30, 90));

		// ------------------Menu Buttons--------------------//
		menuButtons = new JPanel();
		menuButtons.setLayout(new GridLayout(4, 1, 20, 30));
		menuButtons.setBackground(Color.WHITE);

		JButton startButton = new JButton("Start");
		startButton.setBackground(Color.WHITE);
		menuButtons.add(startButton);

		JButton optionsButton = new JButton("Options");
		optionsButton.setBackground(Color.WHITE);
		menuButtons.add(optionsButton);

		JButton helpButton = new JButton("Help");
		helpButton.setBackground(Color.WHITE);
		menuButtons.add(helpButton);

		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.WHITE);
		menuButtons.add(exitButton);
		// --------------------------------------------------//
		// ------------------- Image ------------------------//
		ImageIcon img = new ImageIcon("runner1.png");
		JLabel tester = new JLabel("", img, JLabel.CENTER);
		tester.setOpaque(false);
		tester.setBackground(Color.WHITE);
		// --------------------------------------------------//

		pane1.add(menuButtons);
		pane1.add(tester);
		mainMenuPanel.add(pane1);
		// ------------------------------------------------------------------------//
		// ----------------------- Option Menu Panel
		// Stuff-------------------------//

		optionMenuPanel = new JPanel(new BorderLayout());
		optionMenuPanel.setBackground(Color.WHITE);
		optionButtons = new JPanel(new GridLayout());
		JButton back = new JButton("Back");
		back.setBackground(Color.WHITE);
		optionButtons.add(back);
		optionMenuPanel.add(optionButtons);
		// ------------------------------------------------------------------------//
		// ---------------------------- Game Over
		// Screen---------------------------//
		panel3 = new JPanel(new BorderLayout());
		panel3.setBackground(Color.WHITE);
		panel3.setForeground(Color.WHITE);
		JLabel gameOver = new JLabel("Game Over");
		gameOver.setBorder(new EmptyBorder(0, 140, 100, 0));
		gameOver.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 90));
		gameOver.setOpaque(true);
		gameOver.setBackground(Color.white);
		panel3.add(gameOver, BorderLayout.NORTH);

		JPanel fillPanel = new JPanel();
		fillPanel.setBackground(Color.white);
		fillPanel.setBorder(new EmptyBorder(10, 0, 0, 10));

		JButton playAgain = new JButton("Play Again");
		playAgain.setBackground(Color.white);

		JButton leaderBoardButton = new JButton("Leaderboard");
		leaderBoardButton.setBackground(Color.white);

		JButton menu = new JButton("Main Menu");
		menu.setBackground(Color.white);

		FlowLayout fl = new FlowLayout();
		// fl.setVgap(0);
		gameOverButtons = new JPanel(fl);
		gameOverButtons.setBackground(Color.WHITE);
		gameOverButtons.add(playAgain);
		gameOverButtons.add(leaderBoardButton);
		gameOverButtons.add(menu);
		fillPanel.add(gameOverButtons);
		panel3.add(fillPanel, BorderLayout.CENTER);

		leaderBoardHolder = new JPanel();
		leaderBoardHolder.setBorder(new EmptyBorder(20, 20, 20, 20));

		JPanel lbFillPanel = new JPanel();

		add(mainMenuPanel, BorderLayout.CENTER);
	}

	/**
	 * registers the listeners
	 * 
	 * @param c
	 *            the overall controller
	 */
	public void registerListener(OverallController c) {
		controller = c;

		panel2.addKeyListener(c.getKeyController());
		// panel2.addMouseListener(controller2);
		// exitButton.addActionListener(controller4);
		// helpButton.addActionListener(controller4);
		for (Component component : menuButtons.getComponents()) {
			if (component instanceof AbstractButton) {

				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller.getMenuButtonController());
			}
		}

		for (Component component : optionButtons.getComponents()) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller.getMenuButtonController());
			}
		}

		for (Component component : gameOverButtons.getComponents()) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller.getGameOverController());
			}
		}

	}

	/**
	 * displays the panel based on the game state
	 * 
	 * @param whichPanel
	 */
	public void displayPanel(int whichPanel) {
		remove(mainMenuPanel);
		remove(optionMenuPanel);
		remove(panel2);
		remove(panel3);
		/*
		 * remove(panel2); remove(panel3); remove(panel4); //
		 */
		switch (whichPanel) {
		case 0:
			switch (model.getMenuState()) {
			case 0:
				add(mainMenuPanel, BorderLayout.CENTER);
				break;
			case 1:
				add(optionMenuPanel, BorderLayout.CENTER);
				break;
			}
			break;

		case 1:// updates the level
			add(panel2, BorderLayout.CENTER);
			panel2.requestFocusInWindow();
			break;

		case 2:
			break;

		case 3:
			add(panel3, BorderLayout.CENTER);
			break;
		}
		validate();
		repaint();
	}

	/**
	 * gets the model that the GameView is using
	 * 
	 * @return
	 */
	public GameModel getModel() {
		return model;
	}

	public void showLeaderboard() {
		remove(mainMenuPanel);
		remove(optionMenuPanel);
		remove(panel2);
		remove(panel3);
		for (Component component : leaderBoardHolder.getComponents()) {
			leaderBoardHolder.remove(component);
		}
		leaderBoard = new JPanel(new GridLayout(10, 2, 0, 0));
		for (Score score : model.getScoreBoard().getscores()) {
			leaderBoard.add(new JLabel(score.getName()));
			leaderBoard.add(new JLabel(Integer.toString(score.getScore())));
		}
		leaderBoardHolder.add(leaderBoard);
		this.add(leaderBoardHolder);
		validate();
		repaint();
	}
}
