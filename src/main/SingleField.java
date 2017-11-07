package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SingleField extends JPanel implements ActionListener
{
	private final int panelHeight = 150;
	private final int panelWidth = 150;
	
	private boolean cross = true;
	private boolean inGame = true;
	private boolean tie = false;
	
	private String winner;
	private String currentMark;
	private String[][] placedMarks;
	
	private int i;
	private int j;
	private int counter;
	
	private JButton[][] fieldButtons;
	
	private ImageIcon emptyIcon;
	private ImageIcon crossIcon;
	private ImageIcon circleIcon;
	private ImageIcon crossActiveIcon;
	private ImageIcon circleActiveIcon;
	private ImageIcon crossLeftIcon;
	private ImageIcon crossRightIcon;
	private ImageIcon crossMiddleIcon;
	private ImageIcon circle00Icon;
	private ImageIcon circle01Icon;
	private ImageIcon circle02Icon;
	private ImageIcon circle10Icon;
	private ImageIcon circle12Icon;
	private ImageIcon circle20Icon;
	private ImageIcon circle21Icon;
	private ImageIcon circle22Icon;
	
	public SingleField()
	{
		setLayout(new GridLayout(3, 3));
		setSize(panelWidth, panelHeight);
		setPreferredSize(new Dimension(panelWidth, panelHeight));

		currentMark = "";
		winner = "";
		placedMarks = new String[3][3];
		Arrays.fill(placedMarks[0], "");
		Arrays.fill(placedMarks[1], "");
		Arrays.fill(placedMarks[2], "");

		emptyIcon = new ImageIcon(SingleField.class.getResource("/images/empty.jpg"));
		crossIcon = new ImageIcon(SingleField.class.getResource("/images/cross.jpg"));
		circleIcon = new ImageIcon(SingleField.class.getResource("/images/circle.jpg"));
		crossActiveIcon = new ImageIcon(SingleField.class.getResource("/images/crossActive.jpg"));
		circleActiveIcon = new ImageIcon(SingleField.class.getResource("/images/circleActive.jpg"));
		crossLeftIcon = new ImageIcon(SingleField.class.getResource("/images/crossLeft.jpg"));
		crossRightIcon = new ImageIcon(SingleField.class.getResource("/images/crossRight.jpg"));
		crossMiddleIcon = new ImageIcon(SingleField.class.getResource("/images/crossMiddle.jpg"));
		circle00Icon = new ImageIcon(SingleField.class.getResource("/images/circle00.jpg"));
		circle01Icon = new ImageIcon(SingleField.class.getResource("/images/circle01.jpg"));
		circle02Icon = new ImageIcon(SingleField.class.getResource("/images/circle02.jpg"));
		circle10Icon = new ImageIcon(SingleField.class.getResource("/images/circle10.jpg"));
		circle12Icon = new ImageIcon(SingleField.class.getResource("/images/circle12.jpg"));
		circle20Icon = new ImageIcon(SingleField.class.getResource("/images/circle20.jpg"));
		circle21Icon = new ImageIcon(SingleField.class.getResource("/images/circle21.jpg"));
		circle22Icon = new ImageIcon(SingleField.class.getResource("/images/circle22.jpg"));

		counter = 0;
		
		//creates all fieldButtons
		fieldButtons = new JButton[3][3];
		for (i = 0; i < fieldButtons.length; i++)
		{
			for(j = 0; j < fieldButtons.length; j++)
			{
				fieldButtons[i][j] = new JButton();
				fieldButtons[i][j].setFocusable(false);
				fieldButtons[i][j].setMargin(new Insets(0, 0, 0, 0));
				fieldButtons[i][j].setContentAreaFilled(false);
				fieldButtons[i][j].setActionCommand(String.valueOf(counter++));
				fieldButtons[i][j].setIcon(emptyIcon);
				fieldButtons[i][j].addActionListener(this);
				add(fieldButtons[i][j]);
			}
		}
	}

	//after clicking on any button turns given button off and gives it appropriate icon
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(inGame)
		{
			if(cross)
			{
				((JButton)e.getSource()).setDisabledIcon(crossActiveIcon);
				currentMark = "cross";
			}
			else
			{
				((JButton)e.getSource()).setDisabledIcon(circleActiveIcon);
				currentMark = "circle";
			}
		}
	}

	/**
	 * writes appropriate mark's name to string array, which will be used later to determine winner
	 */
	public void checkWhichButton(MouseEvent e)
	{
		if(((JButton)e.getSource()).getActionCommand().equals("0"))
		{
			if(currentMark == "cross")
			{
				placedMarks[0][0] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[0][0] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("1"))
		{
			if(currentMark == "cross")
			{
				placedMarks[0][1] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[0][1] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("2"))
		{
			if(currentMark == "cross")
			{
				placedMarks[0][2] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[0][2] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("3"))
		{
			if(currentMark == "cross")
			{
				placedMarks[1][0] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[1][0] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("4"))
		{
			if(currentMark == "cross")
			{
				placedMarks[1][1] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[1][1] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("5"))
		{
			if(currentMark == "cross")
			{
				placedMarks[1][2] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[1][2] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("6"))
		{
			if(currentMark == "cross")
			{
				placedMarks[2][0] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[2][0] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("7"))
		{
			if(currentMark == "cross")
			{
				placedMarks[2][1] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[2][1] = "circle";
			}
		}
		
		if(((JButton)e.getSource()).getActionCommand().equals("8"))
		{
			if(currentMark == "cross")
			{
				placedMarks[2][2] = "cross";
			}
			if(currentMark == "circle")
			{
				placedMarks[2][2] = "circle";
			}
		}
	}
	
	/**
	 * checks if there is a tie meaning it checks if all buttons are disabled
	 */
	public void lookForTie()
	{
		if(!fieldButtons[0][0].isEnabled() && !fieldButtons[0][1].isEnabled() && !fieldButtons[0][2].isEnabled() && !fieldButtons[1][0].isEnabled() && !fieldButtons[1][1].isEnabled() && 
				!fieldButtons[1][2].isEnabled() && !fieldButtons[2][0].isEnabled() && !fieldButtons[2][1].isEnabled() && !fieldButtons[2][2].isEnabled())
		{
			tie = true;
			inGame = false;
		}
	}
	
	/**
	 * checks if any player won
	 */
	public void lookForWin()
	{
		for(i = 0; i < fieldButtons.length; i++)
		{
			//looks for horizontal win
			if(placedMarks[i][0] == placedMarks[i][1] && placedMarks[i][1]== placedMarks[i][2] && placedMarks[i][0] != "")
			{
				if(placedMarks[i][0] == "cross")
				{
					winner = "cross";
					inGame = false;
				}
				else if(placedMarks[i][0] == "circle")
				{
					winner = "circle";
					inGame = false;
				}
			}
			//looks for vertical win
			else if(placedMarks[0][i] == placedMarks[1][i] && placedMarks[1][i]== placedMarks[2][i] && placedMarks[0][i] != "")
			{
				if(placedMarks[0][i] == "cross")
				{
					winner = "cross";
					inGame = false;
				}
				else if(placedMarks[0][i] == "circle")
				{
					winner = "circle";
					inGame = false;
				}
			}
		}
		//looks for win from left to right
		if(placedMarks[0][0] == placedMarks[1][1] && placedMarks[1][1]== placedMarks[2][2] && placedMarks[0][0] != "")
		{
			if(placedMarks[0][0] == "cross")
			{
				winner = "cross";
				inGame = false;
			}
			else if(placedMarks[0][0] == "circle")
			{
				winner = "circle";
				inGame = false;
			}
		}
		//looks for win from right to left
		if(placedMarks[0][2] == placedMarks[1][1] && placedMarks[1][1]== placedMarks[2][0] && placedMarks[0][2] != "")
		{
			if(placedMarks[0][2] == "cross")
			{
				winner = "cross";
				inGame = false;
			}
			else if(placedMarks[0][2] == "circle")
			{
				winner = "circle";
				inGame = false;
			}
		}
	}
	
	/**
	 * if somebody won disables all buttons and sets their icons to match X or O
	 */
	public void disableField()
	{
		if(winner != "")
		{
			for(i = 0; i < fieldButtons.length; i++)
			{
				for(j = 0; j < fieldButtons.length; j++)
				{
					fieldButtons[i][j].setEnabled(false);
				}
			}
		}
		if(winner == "cross")
		{
			fieldButtons[0][0].setDisabledIcon(crossRightIcon);
			fieldButtons[0][1].setDisabledIcon(emptyIcon);
			fieldButtons[0][2].setDisabledIcon(crossLeftIcon);
			fieldButtons[1][0].setDisabledIcon(emptyIcon);
			fieldButtons[1][1].setDisabledIcon(crossMiddleIcon);
			fieldButtons[1][2].setDisabledIcon(emptyIcon);
			fieldButtons[2][0].setDisabledIcon(crossLeftIcon);
			fieldButtons[2][1].setDisabledIcon(emptyIcon);
			fieldButtons[2][2].setDisabledIcon(crossRightIcon);
		}
		else if (winner == "circle")
		{
			fieldButtons[0][0].setDisabledIcon(circle00Icon);
			fieldButtons[0][1].setDisabledIcon(circle01Icon);
			fieldButtons[0][2].setDisabledIcon(circle02Icon);
			fieldButtons[1][0].setDisabledIcon(circle10Icon);
			fieldButtons[1][1].setDisabledIcon(emptyIcon);
			fieldButtons[1][2].setDisabledIcon(circle12Icon);
			fieldButtons[2][0].setDisabledIcon(circle20Icon);
			fieldButtons[2][1].setDisabledIcon(circle21Icon);
			fieldButtons[2][2].setDisabledIcon(circle22Icon);
		}
	}
	
	/**
	 * returns true if icon of fieldButton of given buttonNumber is changed
	 */
	public boolean isButtonsIconChanged(int buttonNumber)
	{
		switch (buttonNumber)
		{
			case 0:
				if(fieldButtons[0][0].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[0][0].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[0][0].getDisabledIcon().equals(circleIcon) || fieldButtons[0][0].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 1:
				if(fieldButtons[0][1].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[0][1].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[0][1].getDisabledIcon().equals(circleIcon) || fieldButtons[0][1].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 2:
				if(fieldButtons[0][2].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[0][2].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[0][2].getDisabledIcon().equals(circleIcon) || fieldButtons[0][2].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 3:
				if(fieldButtons[1][0].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[1][0].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[1][0].getDisabledIcon().equals(circleIcon) || fieldButtons[1][0].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 4:
				if(fieldButtons[1][1].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[1][1].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[1][1].getDisabledIcon().equals(circleIcon) || fieldButtons[1][1].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 5:
				if(fieldButtons[1][2].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[1][2].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[1][2].getDisabledIcon().equals(circleIcon) || fieldButtons[1][2].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 6:
				if(fieldButtons[2][0].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[2][0].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[2][0].getDisabledIcon().equals(circleIcon) || fieldButtons[2][0].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 7:
				if(fieldButtons[2][1].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[2][1].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[2][1].getDisabledIcon().equals(circleIcon) || fieldButtons[2][1].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 8:
				if(fieldButtons[2][2].getDisabledIcon().equals(circleActiveIcon) || fieldButtons[2][2].getDisabledIcon().equals(crossActiveIcon) ||
						fieldButtons[2][2].getDisabledIcon().equals(circleIcon) || fieldButtons[2][2].getDisabledIcon().equals(crossIcon))
				{
					return true;
				}
				else
				{
					return false;
				}
			default:
				return true;
		}
	}
	
	/**
	 *  resets the panel.
	 *  <br>has to be called in order to start a new game
	 */
	public void reset()
	{
		inGame = true;
		cross = true;
		winner = "";
		currentMark = "";
		Arrays.fill(placedMarks[0], "");
		Arrays.fill(placedMarks[1], "");
		Arrays.fill(placedMarks[2], "");
		for(i = 0; i < fieldButtons.length; i++)
		{
			for(j = 0; j < fieldButtons.length; j++)
			{
				fieldButtons[i][j].setEnabled(true);
			}
		}
	}

	/**
	 * changes icon of given button
	 * @param cross if true sets given buttons disabled icon to cross
	 * @param buttonName specifies which button's icon has to be changed
	 */
	public void changeButtonsIcon (boolean cross, String buttonName)
	{
		switch (buttonName)
		{
			case "0":
				if(cross)
				{
					fieldButtons[0][0].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[0][0].setDisabledIcon(circleIcon);
				}
				break;
			case "1":
				if(cross)
				{
					fieldButtons[0][1].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[0][1].setDisabledIcon(circleIcon);
				}
				break;
			case "2":
				if(cross)
				{
					fieldButtons[0][2].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[0][2].setDisabledIcon(circleIcon);
				}
				break;
			case "3":
				if(cross)
				{
					fieldButtons[1][0].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[1][0].setDisabledIcon(circleIcon);
				}
				break;
			case "4":
				if(cross)
				{
					fieldButtons[1][1].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[1][1].setDisabledIcon(circleIcon);
				}
				break;
			case "5":
				if(cross)
				{
					fieldButtons[1][2].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[1][2].setDisabledIcon(circleIcon);
				}
				break;
			case "6":
				if(cross)
				{
					fieldButtons[2][0].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[2][0].setDisabledIcon(circleIcon);
				}
				break;
			case "7":
				if(cross)
				{
					fieldButtons[2][1].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[2][1].setDisabledIcon(circleIcon);
				}
				break;
			case "8":
				if(cross)
				{
					fieldButtons[2][2].setDisabledIcon(crossIcon);
				}
				else
				{
					fieldButtons[2][2].setDisabledIcon(circleIcon);
				}
				break;
			default:
				break;
		}
	}	
	
	/**
	 * changes icon of given button to null
	 * @param buttonName specifies which button's icon has to be changed
	 */
	public void changeButtonsIconToNull (String buttonName)
	{
		switch (buttonName)
		{
			case "0":
				fieldButtons[0][0].setDisabledIcon(null);
				break;
			case "1":
				fieldButtons[0][1].setDisabledIcon(null);
				break;
			case "2":
				fieldButtons[0][2].setDisabledIcon(null);
				break;
			case "3":
				fieldButtons[1][0].setDisabledIcon(null);
				break;
			case "4":
				fieldButtons[1][1].setDisabledIcon(null);
				break;
			case "5":
				fieldButtons[1][2].setDisabledIcon(null);
				break;
			case "6":
				fieldButtons[2][0].setDisabledIcon(null);
				break;
			case "7":
				fieldButtons[2][1].setDisabledIcon(null);
				break;
			case "8":
				fieldButtons[2][2].setDisabledIcon(null);
				break;
			default:
				break;
		}
	}	
		
	/**
	 * changes given buttons state (enabled or disabled) based on parameters
	 * @param enable true to enable
	 * @param buttonNumber specifies which button's state has to be changed
	 */
	public void changeButtonsState (boolean enable, int buttonNumber)
	{
		switch (buttonNumber)
		{
			case 0:
				fieldButtons[0][0].setEnabled(enable);
				break;
			case 1:
				fieldButtons[0][1].setEnabled(enable);
				break;
			case 2:
				fieldButtons[0][2].setEnabled(enable);
				break;
			case 3:
				fieldButtons[1][0].setEnabled(enable);
				break;
			case 4:
				fieldButtons[1][1].setEnabled(enable);
				break;
			case 5:
				fieldButtons[1][2].setEnabled(enable);
				break;
			case 6:
				fieldButtons[2][0].setEnabled(enable);
				break;
			case 7:
				fieldButtons[2][1].setEnabled(enable);
				break;
			case 8:
				fieldButtons[2][2].setEnabled(enable);
				break;
			default:
				break;
		}
	}

	public boolean isCross()
	{
		return cross;
	}

	public boolean isTie()
	{
		return tie;
	}

	public String getWinner ()
	{
		return winner;
	}

	public boolean isInGame()
	{
		return inGame;
	}

	public void setCross(boolean cross)
	{
		this.cross = cross;
	}
}