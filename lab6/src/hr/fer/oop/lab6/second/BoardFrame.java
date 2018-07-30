/**
 * 
 */
package hr.fer.oop.lab6.second;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

/**
 * @author Filip
 *
 */
public class BoardFrame extends JFrame implements BoardListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int noRows=30;
	private final int noCol=30;

	private JPanel toolbar;
	private JToggleButton start;
	private JButton stop;
	private JButton iteration;
	private JToggleButton[][]  panel;
	private Board board;
	private JRadioButton dead;
	private JRadioButton alive;
	private JButton reset;


	private  class StartRoutine implements Runnable{

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			while(start.isSelected()){
				try{
					board.playOneIteration();
					Thread.sleep(500);
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}

			}

		}

	}





	/**
	 *
	 * Constructor using:
	 * @throws HeadlessException
	 */
	public BoardFrame() throws HeadlessException {
		board=new Board(noRows,noCol);
		board.addListener(this);
		setSize(600,700);
		setTitle("Game Of Life");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		initGUI();
	}



	/**
	 * Initializes GUI creating array of toggle buttons 'panel' that simulates the board for the game.
	 * Initializes tool bar with start, stop and one iteration buttons.
	 * Adds listeners for all buttons on grid as well as the tool bar.
	 */
	private void initGUI() {
		Container cp=getContentPane();

		toolbar=new JPanel(new FlowLayout());
		stop=new JButton("Zaustavi");
		start=new JToggleButton("Pokreni");
		iteration=new JButton("Jedna Iteracija");
		toolbar.add(stop);
		toolbar.add(start);
		toolbar.add(iteration);

		reset=new JButton("Reset");
		toolbar.add(reset);

		ButtonGroup radio=new ButtonGroup();
		dead= new JRadioButton("Dead");
		alive= new JRadioButton("Alive");
		radio.add(dead);
		toolbar.add(dead);
		radio.add(alive);
		toolbar.add(alive);

		alive.setSelected(true);



		panel=new JToggleButton[noRows][noCol];
		for(int i=0;i<noRows;i++){
			for(int j=0;j<noCol;j++){
				panel[i][j]=new JToggleButton();
			}
		}


		JPanel field=new JPanel();
		field.setLayout(new GridLayout(noRows, noCol));
		for(int i=0;i<noRows;i++){
			for(int j=0;j<noCol;j++){
				field.add(panel[i][j]);
				int x=i,y=j;
				panel[i][j].addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						board.setCell(x, y, panel[x][y].isSelected());

					}

				});
			}
		}

		cp.add(toolbar,BorderLayout.NORTH);
		cp.add(field,BorderLayout.CENTER);



		iteration.addActionListener(l->{
			board.playOneIteration();
		});

		start.addActionListener(l->{
			StartRoutine routine=new StartRoutine();
			Thread game=new Thread(routine);

			iteration.setEnabled(false);
			stop.setEnabled(true);
			start.setEnabled(false);
			reset.setEnabled(false);
			game.start();
		});

		stop.addActionListener(l->{
			stop.setEnabled(false);
			iteration.setEnabled(true);
			start.setEnabled(true);
			reset.setEnabled(true);
			if(start.isSelected()){
				start.setSelected(false);
			}
		});

		reset.addActionListener(l->{
			stop.setEnabled(false);
			start.setEnabled(false);
			iteration.setEnabled(false);

			board.clear();

			stop.setEnabled(true);
			start.setEnabled(true);
			iteration.setEnabled(true);
		});


	}





	/**
	 * Changes the state of all buttons accordingly.
	 * @param board
	 */
	@Override
	public void boardChanged(Board board) {
		for(int i=0;i<noRows;i++){
			for(int j=0;j<noCol;j++){
				String aliveNo=Integer.toString(board.getBoard()[i][j].getAliveNo());
				String deadNo=Integer.toString(board.getBoard()[i][j].getDeadNo());
				boolean check=board.isCellAlive(i, j);

				if(dead.isSelected()){
					panel[i][j].setText(deadNo);
				}
				else{
					panel[i][j].setText(aliveNo);
				}

				panel[i][j].setSelected(check);


			}
		}


	}



}
