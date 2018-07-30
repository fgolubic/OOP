/**
 * 
 */
package hr.fer.oop.lab6.first;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import hr.fer.oop.lab6.first.Uvjeti.PaymentMethod;


/**
 * @author Filip
 *
 */
public class Filter extends JFrame {
	private JCheckBox skip;
	private JTextField skipFilter, dValue;
	private JCheckBox leave;
	private JTextField leaveFilter;
	private ButtonGroup grupa;
	private JCheckBox pType;
	private JCheckBox dLimit;
	private JComboBox<String> box;
	private JRadioButton ukn,cash,card;
	private Uvjeti uvjetiFiltriranja;



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor 
	 * Setting size and location of secondary panel from Define button.
	 * Sets what actions will perform after closing a window.
	 * Initializes GUI.
	 * @throws HeadlessException
	 */
	public Filter() throws HeadlessException {
		uvjetiFiltriranja=new Uvjeti();
		setSize(500, 250);
		setLocation(200, 100);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		initGUI();
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				if(skip.isSelected()){
					if(!skipFilter.getText().isEmpty()){
						uvjetiFiltriranja.setSkip(true);
						uvjetiFiltriranja.setSkipN(Integer.parseInt(skipFilter.getText()));
					}
				}
				if(leave.isSelected()){
					if(!leaveFilter.getText().isEmpty()){
						uvjetiFiltriranja.setLeave(true);
						uvjetiFiltriranja.setLeaveN(Integer.parseInt(leaveFilter.getText()));
					}
				}

				if(pType.isSelected()){
					
					JRadioButton temp=null;
					if(ukn.isSelected()) temp=ukn;
					if(card.isSelected()) temp=card;
					if(cash.isSelected()) temp=cash;
					
					if(temp.equals(ukn)){
						uvjetiFiltriranja.setpFilter(true);
						uvjetiFiltriranja.setpType(PaymentMethod.UNK);
					}
					else if(temp.equals(card)){
						uvjetiFiltriranja.setpFilter(true);
						uvjetiFiltriranja.setpType(PaymentMethod.CRD);
					}
					else if(temp.equals(cash)){
						uvjetiFiltriranja.setpFilter(true);
						uvjetiFiltriranja.setpType(PaymentMethod.CSH);
					}
				}

				if(dLimit.isSelected()){
					if(box.getSelectedItem().equals("<")){
						if(dValue.getText()!=null){
							uvjetiFiltriranja.setDistLimit(true);
							uvjetiFiltriranja.setDistLimitMod("<");
							uvjetiFiltriranja.setDistLimitValue(Double.parseDouble(dValue.getText()));
							
						}

					}
					else if(box.getSelectedItem().equals(">=")){
						if(dValue.getText()!=null){
							uvjetiFiltriranja.setDistLimit(true);
							uvjetiFiltriranja.setDistLimitMod(">=");
							uvjetiFiltriranja.setDistLimitValue(Double.parseDouble(dValue.getText()));
						}
					}
				}
				
				
			}
		});


	}

	/**
	 * Constructs GUI of the secondary frame and defines button and check box actions.
	 */
	private void initGUI() {
		Container cp= getContentPane();
		Container prvi=new Container();
		prvi.setLayout(new FlowLayout());
		skip=new JCheckBox(" Skip records ?");
		prvi.add(skip);
		prvi.add(new JLabel("Number of records to skip:"));
		skipFilter=new JTextField(10);
		prvi.add(skipFilter);


		Container drugi= new Container();
		drugi.setLayout(new FlowLayout());
		leave = new JCheckBox("Leave records?");
		drugi.add(leave);
		drugi.add(new JLabel("Number of records to leave:"));
		leaveFilter=new JTextField(10);
		drugi.add(leaveFilter);

		Container treci=new Container();
		treci.setLayout(new GridLayout(3, 2));
		treci.add(prvi);
		treci.add(drugi);

		cp.add(treci, BorderLayout.NORTH);

		Container gumbi= new Container();
		gumbi.setLayout(new GridLayout(4,1));
		gumbi.add(new JLabel("Choose payment option:"));
		grupa=new ButtonGroup();
		cash=new JRadioButton("Cash(CSH)");
		grupa.add(cash);
		gumbi.add(cash);
		card=new JRadioButton("Card(CRD)");
		grupa.add(card);
		gumbi.add(card);
		ukn=new JRadioButton("Unknown(UNK)");
		grupa.add(ukn);
		gumbi.add(ukn);



		cp.add(gumbi, BorderLayout.EAST);

		pType=new JCheckBox("Filter by payment type?");
		cp.add(pType,BorderLayout.WEST);


		Container cetvrti =new Container();
		cetvrti.setLayout(new FlowLayout());
		dLimit=new JCheckBox("Limit distance?");
		cetvrti.add(dLimit);
		box=new JComboBox<String>();
		box.addItem("<");
		box.addItem(">=");
		cetvrti.add(box);
		dValue=new JTextField(10);
		cetvrti.add(dValue);

		cp.add(cetvrti,BorderLayout.SOUTH);



	}

	/**
	 * Getter
	 * @return uvjetiFiltriranja
	 */
	public Uvjeti getUvjeti(){

		return uvjetiFiltriranja;
	}

	/**
	 * Setter
	 * @param uvjetiFiltriranja the uvjetiFiltriranja to set
	 */
	public void setUvjetiFiltriranja(Uvjeti uvjetiFiltriranja) {
		this.uvjetiFiltriranja = uvjetiFiltriranja;
	}
	

}
