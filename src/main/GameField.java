package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameField extends JPanel implements MouseListener
{
	private final int panelHeight = 450;
	private final int panelWidth = 450;
	
	private String wonMessage;
	private String wonMessage2;
	private String tie;
	private String endMessage;
	
	private int counter;
	private int counter2;
	
	private boolean gameWon = false;
	
	private boolean[] inGame;
	private boolean[] cross;
	private boolean[] compareArray;
	
	private String[] buttonsNumber;
	
	private String[][] winner;
	
	private SingleField[] singleField;
	
	public GameField ()
	{
		setLayout(new GridLayout(3, 3, 10, 10));
		setSize(panelWidth, panelHeight);
		setPreferredSize(new Dimension(panelWidth, panelHeight));

		wonMessage = "<html><body><center> Congratulations! <br> First player won! </center></body></html>";
		wonMessage2 = "<html><body><center> Congratulations! <br> Second player won! </center></body></html>";
		tie = "<html><body><center> Tie! </center></body></html>";
		endMessage = "Game over!";
		
		counter = 0;
		counter2 = 0;

		inGame = new boolean[9];
		cross = new boolean[9];
		compareArray = new boolean[9];
		buttonsNumber = new String[81];
		winner = new String[3][3];

		singleField = new SingleField[9];
		
		Arrays.fill(inGame, true);
		Arrays.fill(cross, true);
		Arrays.fill(compareArray, false);
		Arrays.fill(winner[0], "");
		Arrays.fill(winner[1], "");
		Arrays.fill(winner[2], "");
		
		addMouseListener(this);
		
		for(int i = 0; i < singleField.length; i++)
		{
			singleField[i] = new SingleField();
			
			for(int j = 0; j < singleField.length; j++)
			{
				singleField[i].getComponent(j).addMouseListener(this);
				singleField[i].getComponent(j).setName(String.valueOf(counter2++));
			}
			
			add(singleField[i]);
		}
		counter2 = 0;
	}
	
	//manages all button clicks
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(((JButton)e.getSource()).isEnabled())
		{
			if(counter2 >= 1)
			{
				changePreviousIconToBlack();
			}
			
			manageFields(e);
			completeArray();
			changeMark();
			lookForTie();
			lookForWin();
			buttonsNumber[counter2] = ((JButton)e.getSource()).getName();
			blockFields();
			counter2++;
			e.getComponent().setEnabled(false);
			startOver();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}

	@Override
	public void mousePressed(MouseEvent e){}

	@Override
	public void mouseReleased(MouseEvent e){}
	
	/**
	 * checks if there is a win or a tie
	 * <br>if so disables given singleField
	 */
	public void manageFields (MouseEvent e)
	{
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 9)
		{
			singleField[0].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[0].checkWhichButton(e);
			singleField[0].lookForTie();
			singleField[0].lookForWin();
			singleField[0].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 18 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 9)
		{
			singleField[1].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[1].checkWhichButton(e);
			singleField[1].lookForTie();
			singleField[1].lookForWin();
			singleField[1].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 27 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 18)
		{
			singleField[2].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[2].checkWhichButton(e);
			singleField[2].lookForTie();
			singleField[2].lookForWin();
			singleField[2].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 36 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 27)
		{
			singleField[3].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[3].checkWhichButton(e);
			singleField[3].lookForTie();
			singleField[3].lookForWin();
			singleField[3].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 45 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 36)
		{
			singleField[4].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[4].checkWhichButton(e);
			singleField[4].lookForTie();
			singleField[4].lookForWin();
			singleField[4].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 54 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 45)
		{
			singleField[5].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[5].checkWhichButton(e);
			singleField[5].lookForTie();
			singleField[5].lookForWin();
			singleField[5].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 63 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 54)
		{
			singleField[6].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[6].checkWhichButton(e);
			singleField[6].lookForTie();
			singleField[6].lookForWin();
			singleField[6].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 72 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 63)
		{
			singleField[7].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[7].checkWhichButton(e);
			singleField[7].lookForTie();
			singleField[7].lookForWin();
			singleField[7].disableField();
		}
		if(Integer.valueOf(((JButton)e.getSource()).getName()) < 81 && Integer.valueOf(((JButton)e.getSource()).getName()) >= 72)
		{
			singleField[8].changeButtonsState(false, Integer.valueOf(((JButton)e.getSource()).getActionCommand()));
			singleField[8].checkWhichButton(e);
			singleField[8].lookForTie();
			singleField[8].lookForWin();
			singleField[8].disableField();
		}
	}	
	
	/**
	 * blocks singleFields to indicate where player has to put his move
	 */
	public void blockFields ()
	{
		if(! gameWon)
		{
			for(int i = 0; i < singleField.length; i++)
			{
				for(int j = 0; j < singleField.length; j++)
				{
					if(Integer.valueOf(buttonsNumber[counter2]) % 9 == i)
					{
						if(singleField[i].isInGame())
						{
							if(!singleField[i].isButtonsIconChanged(j))
							{
								singleField[i].changeButtonsState(true, j);
							}
							
							for(int k = i + 1; k < singleField.length; k++)
							{
								singleField[k].changeButtonsState(false, j);
							}
							for(int k = i - 1; k >= 0; k--)
							{
								singleField[k].changeButtonsState(false, j);
							}
						}
						else
						{
							for(int k = i + 1; k < singleField.length; k++)
							{
								if(singleField[k].isInGame())
								{
									if(!singleField[k].isButtonsIconChanged(j))
									{
										singleField[k].changeButtonsState(true, j);
									}
								}
							}
							for(int k = i - 1; k >= 0; k--)
							{
								if(singleField[k].isInGame())
								{
									if(!singleField[k].isButtonsIconChanged(j))
									{
										singleField[k].changeButtonsState(true, j);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * changes icon of previous mark to black 
	 */
	public void changePreviousIconToBlack ()
	{
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 9)
		{
			if(singleField[0].isInGame())
			{
				singleField[0].changeButtonsIcon(!singleField[0].isCross(), buttonsNumber[counter2 - 1]);
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 18 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 9)
		{
			if(singleField[1].isInGame())
			{
				singleField[1].changeButtonsIcon(!singleField[1].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 9));
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 27 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 18)
		{
			if(singleField[2].isInGame())
			{
				singleField[2].changeButtonsIcon(!singleField[2].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 18));
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 36 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 27)
		{
			if(singleField[3].isInGame())
			{
				singleField[3].changeButtonsIcon(!singleField[3].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 27));
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 45 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 36)
		{
			if(singleField[4].isInGame())
			{
				singleField[4].changeButtonsIcon(!singleField[4].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 36));
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 54 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 45)
		{
			if(singleField[5].isInGame())
			{
				singleField[5].changeButtonsIcon(!singleField[5].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 45));
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 63 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 54)
		{
			if(singleField[6].isInGame())
			{
				singleField[6].changeButtonsIcon(!singleField[6].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 54));
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 72 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 63)
		{
			if(singleField[7].isInGame())
			{
				singleField[7].changeButtonsIcon(!singleField[7].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 63));
			}
		}
		
		if(Integer.valueOf(buttonsNumber[counter2 - 1]) < 81 && Integer.valueOf(buttonsNumber[counter2 - 1]) >= 72)
		{
			if(singleField[8].isInGame())
			{
				singleField[8].changeButtonsIcon(!singleField[8].isCross(), String.valueOf(Integer.valueOf(buttonsNumber[counter2 - 1]) % 72));
			}
		}
	}
	
	/**
	 * completes winner array
	 */
	public void completeArray ()
	{
		counter = 0;
		
		for(int i = 0; i < inGame.length; i++)
		{
			inGame[i] = singleField[i].isInGame();
			cross[i] = singleField[i].isCross();
			
			for(int j = 0; j < winner.length; j++)
			{
				if(i < winner.length && counter < singleField.length)
				{
					winner[i][j] = singleField[counter].getWinner();
					counter++;
				}
			}
		}
	}
	
	/**
	 * changes every other mark to circle
	 */
	public void changeMark ()
	{
		for(int i = 0; i < singleField.length; i++)
		{
			singleField[i].setCross(!singleField[i].isCross());
		}
	}
	/**
	 * check if there is a tie
	 */
	public void lookForTie ()
	{
		if(! gameWon)
		{
			if(Arrays.equals(inGame, compareArray))
			{
				gameWon = true;
				JOptionPane.showMessageDialog(this, tie, endMessage, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	/**
	 * checks if anybody won
	 */
	public void lookForWin ()
	{
		if(! gameWon)
		{
			for(int i = 0; i < winner.length; i++)
			{
				if(winner[i][0].equals(winner[i][1]) && winner[i][1].equals(winner[i][2]))
				{
					if(winner[i][0] == "cross")
					{

						JOptionPane.showMessageDialog(this, wonMessage, endMessage, JOptionPane.INFORMATION_MESSAGE);
						gameWon = true;
					}
					else if (winner[i][0] == "circle")
					{
						JOptionPane.showMessageDialog(this, wonMessage2, endMessage, JOptionPane.INFORMATION_MESSAGE);
						gameWon = true;
					}
				}

				if(winner[0][i].equals(winner[1][i]) && winner[1][i].equals(winner[2][i]))
				{
					if( winner[0][i] == "cross")
					{
						JOptionPane.showMessageDialog(this, wonMessage, endMessage, JOptionPane.INFORMATION_MESSAGE);
						gameWon = true;
					}
					else if ( winner[0][i] == "circle")
					{
						JOptionPane.showMessageDialog(this, wonMessage2, endMessage, JOptionPane.INFORMATION_MESSAGE);
						gameWon = true;
					}
				}
			}

			if(winner[0][0].equals(winner[1][1]) && winner[1][1].equals(winner[2][2]))
			{
				if( winner[0][0] == "cross")
				{
					JOptionPane.showMessageDialog(this, wonMessage, endMessage, JOptionPane.INFORMATION_MESSAGE);
					gameWon = true;
				}
				else if ( winner[0][0] == "circle")
				{
					JOptionPane.showMessageDialog(this, wonMessage2, endMessage, JOptionPane.INFORMATION_MESSAGE);
					gameWon = true;
				}
			}

			else if(winner[0][2].equals(winner[1][1]) && winner[1][1].equals(winner[2][0]))
			{
				if( winner[0][2] == "cross")
				{
					JOptionPane.showMessageDialog(this, wonMessage, endMessage, JOptionPane.INFORMATION_MESSAGE);
					gameWon = true;
				}
				else if ( winner[0][2] == "circle")
				{
					JOptionPane.showMessageDialog(this, wonMessage2, endMessage, JOptionPane.INFORMATION_MESSAGE);
					gameWon = true;
				}
			}
		}
	}
	
	/**
	 * resets the game
	 */
	public void startOver ()
	{
		if(gameWon)
		{
			Arrays.fill(inGame, true);
			Arrays.fill(cross, true);
			Arrays.fill(compareArray, false);
			Arrays.fill(winner[0], "");
			Arrays.fill(winner[1], "");
			Arrays.fill(winner[2], "");
			Arrays.fill(buttonsNumber, "");
			
			counter2 = 0;
			
			for(int i = 0; i < singleField.length; i++)
			{
				for(int j = 0; j < singleField.length; j++)
				{
					singleField[i].getComponent(j).setEnabled(true);
					singleField[i].changeButtonsState(true, j);
					singleField[i].changeButtonsIconToNull(String.valueOf(j));
				}
				singleField[i].reset();
			}
			
			gameWon = ! gameWon; 
		}
	}
}