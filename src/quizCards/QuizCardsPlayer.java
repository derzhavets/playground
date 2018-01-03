package quizCards;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class QuizCardsPlayer {
	private JFrame frame;
	private JTextArea display;
	private ArrayList<QuizCard> cardList = new ArrayList<QuizCard>();
	private JButton nextButton;
	private QuizCard currentCard;
	private boolean isShowAnswer;
	private int cardIndex;
	JLabel dLabel;
	
	public static void main(String[] args) {
		QuizCardsPlayer player = new QuizCardsPlayer();
		player.go();
	}
	
	public void go() {
		frame = new JFrame("Quiz Cards Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		
		display = new JTextArea(10, 20);
		display.setLineWrap(true);
		display.setEditable(false);
		display.setFont(bigFont);
		
		JScrollPane scroller = new JScrollPane(display);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		dLabel = new JLabel("Question");
		
		nextButton = new JButton("Show question");
		nextButton.addActionListener(new NextButtonListener());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new LoadMenuItemListener());
		fileMenu.add(loadMenuItem);
		JMenuItem clearMenuItem = new JMenuItem("Clear card set");
		fileMenu.add(clearMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		
		mainPanel.add(dLabel);
		mainPanel.add(display);
		mainPanel.add(nextButton);
		
		frame.add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	private class NextButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isShowAnswer) {
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next card");
				isShowAnswer = false;
			} else {
				if (cardIndex < cardList.size()) {
					showNextCard();
				} else {
					display.setText("No cards left!");
					nextButton.setEnabled(false);
				}
			}
		}		
	}
	
	private void showNextCard() {
		currentCard = cardList.get(cardIndex);
		cardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show answer");
		isShowAnswer = true;
	}
	
	private class LoadMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser openFile = new JFileChooser();
			openFile.showOpenDialog(frame);
			openFile(openFile.getSelectedFile());
		}
	}
	
	private void openFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				makeCard(line);
			}
			reader.close();
			showNextCard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void makeCard(String line) {
		String[] result = line.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
	}
}
