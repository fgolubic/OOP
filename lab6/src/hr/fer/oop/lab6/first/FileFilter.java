/**
 * 
 */
package hr.fer.oop.lab6.first;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import hr.fer.oop.lab6.first.TaxiRecord;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import hr.fer.oop.generictable.GenericTablePanel;

/**
 * @author Filip
 *
 */
public class FileFilter extends JFrame {

	private JButton exit;
	private JButton define;
	private JButton apply;
	private JButton load;
	private JTextField pathField;
	private JToolBar toolbar;
	private static JTextArea area;
	private static final long serialVersionUID = 1L;
	private Uvjeti uvjetiFiltera;
	private Filter fil;
	private GenericTablePanel<TaxiRecord> panel;
	
	/**
	 * Constructor for FiltriranjeZapisa
	 * setting size and location of the frame.Initializes GUI.
	 */
	public FileFilter(){
		uvjetiFiltera=new Uvjeti();
		setSize(1000, 600);
		setLocation(200, 100);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		initGUI();

	}

	/**
	 * initializes GUI and adds action listeners to buttons on Panel
	 */
	private void initGUI() {
		toolbar= new JToolBar(SwingConstants.HORIZONTAL);
		exit=new JButton("Exit");
		pathField= new JTextField();
		load=new JButton("Load");
		define=new JButton("Define Filter");
		apply=new JButton("Apply Filter");

		toolbar.add(exit);
		toolbar.add(pathField);
		toolbar.add(load);
		toolbar.add(define);
		toolbar.add(apply);


		panel= new GenericTablePanel<>(TaxiRecord.class);

		Container cp=getContentPane();
		cp.add(toolbar, BorderLayout.NORTH);
		cp.add(panel, BorderLayout.CENTER);

		area= new JTextArea();

		cp.add(area, BorderLayout.SOUTH);

		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				area.setText("Izlazim iz aplikacije.");
				System.exit(0);
			}

		});

		define.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				fil=new Filter();
				SwingUtilities.invokeLater(() -> {
					fil.setVisible(true);
				});
	
				
			}
		});

		load.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				area.setText("Učtavam iz datoteke.");
				apply.setEnabled(false);
				new Thread(()->{
					
					Path path=Paths.get(pathField.getText());
					try {
						Stream<String> pipe=lines(path);
						if(pipe==null) return;
						List<TaxiRecord> list=pipe.map(s->new TaxiRecord(s)).collect(Collectors.toList());
						panel.update(list);

					} catch (IOException e1) {

						area.setText(e1.toString());
					}
					SwingUtilities.invokeLater(()->apply.setEnabled(true));
					area.setText("Učitavanje gotovo.");
					
				}).start();
			}
		});

		apply.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				uvjetiFiltera=fil.getUvjeti();
				fil.setUvjetiFiltriranja(null);
				
			new Thread(()->{
					load.setEnabled(false);
					area.setText("Filtriram.");
					Stream<TaxiRecord> stream=panel.getRecords().stream();
					if(uvjetiFiltera.isSkip() && !uvjetiFiltera.isLeave()){
						int n=uvjetiFiltera.getSkipN();
						List<TaxiRecord> list = stream.collect(Collectors.toList());
						int size=list.size();
						stream=list.subList(n, size).stream();
					}
					if(uvjetiFiltera.isLeave() && !uvjetiFiltera.isSkip()){
						List<TaxiRecord> list=stream.collect(Collectors.toList());
						int size=list.size();
						for(int i=size-1;i>=uvjetiFiltera.getLeaveN();i--){
							list.remove(i);
						}
						
						stream=list.stream();
					}

					if(uvjetiFiltera.isLeave()&&uvjetiFiltera.isSkip()){
						int n=uvjetiFiltera.getSkipN();
						List<TaxiRecord> list = stream.collect(Collectors.toList());
						List<TaxiRecord> temp=new LinkedList<>();
						for(int i=n;i<list.size();i++){
							temp.add(list.get(i));
						}
						list=temp;
						for(int i=uvjetiFiltera.getLeaveN()-n;i<list.size();i++){
							if(i<0) i=0;
							list.remove(i);
						}
						if(list.isEmpty()){
							area.setText("Lista je prazna!");
							return;
						}
						stream=list.stream();
					}

					if(uvjetiFiltera.ispFilter()){
						stream=stream.filter(s->s.getPayment_type().equals(uvjetiFiltera.getpType()));
					}

					if(uvjetiFiltera.isDistLimit()){
						if(uvjetiFiltera.getDistLimitMod().equals("<")){
							stream=stream.filter(s->Double.parseDouble(s.getTrip_distance())<uvjetiFiltera.getDistLimitValue());
						}
						if(uvjetiFiltera.getDistLimitMod().equals(">=")){
							stream=stream.filter(s->Double.parseDouble(s.getTrip_distance())>=uvjetiFiltera.getDistLimitValue());
						}
					}
					List<TaxiRecord> list=stream.collect(Collectors.toList());
					panel.update(list);
					area.setText("Filtriranje gotovo.");
					SwingUtilities.invokeLater(()->load.setEnabled(true));
				}).start();

			}

		});



	}

	/**
	 * Main method. Starts Swing.
	 * @param args
	 */
	public static void main(String[] args) {
	SwingUtilities.invokeLater(() -> {
			new FileFilter().setVisible(true);
		});
	
	}

	/**
	 * Creates stream of strings from a file.
	 * @param path
	 * @return stream
	 * @throws IOException
	 */
	public static Stream<String> lines(Path path) throws  IOException{
		LinkedList<String> list=new LinkedList<>();

		if(!Files.exists(path)) {
			area.setText("Path je krivi. Takav File ne postoji!");
			return null;
			
		}


		try(BufferedReader data=new BufferedReader(new InputStreamReader(new FileInputStream(path.toString())))){
			String line;
			while((line=data.readLine())!=null){
				list.add(line);
			}

		}
		catch(IOException ex){
			area.setText(ex.toString());;

		}


		return list.stream();

	}

	



}
