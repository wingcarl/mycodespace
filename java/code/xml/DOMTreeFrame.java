package dom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DOMTreeFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	private DocumentBuilder builder;
	
	public DOMTreeFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				openFile();
			}
		});
		fileMenu.add(openItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		fileMenu.add(exitItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}
	
	public void openFile(){
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("dom"));
		
		chooser.setFileFilter(new FileFilter(){
			public boolean accept(File f){
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
			}

			@Override
			public String getDescription() {
				
				return "XML files";
			}
		});
		
		int r = chooser.showOpenDialog(this);
		if(r!=JFileChooser.APPROVE_OPTION) return;
		final File file = chooser.getSelectedFile();
		
		new SwingWorker<Document,Void>(){

			@Override
			protected Document doInBackground() throws Exception {
				if(builder == null){
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					builder = factory.newDocumentBuilder();
				}
				return builder.parse(file);
			}
			protected void done(){
				try{
					Document doc = get();
					JTree tree = new JTree(new DOMTreeModel(doc));
					tree.setCellRenderer(new DOMTreeCellRenderer());
					
					setContentPane(new JScrollPane(tree));
					validate();
				}catch(Exception e){
					JOptionPane.showMessageDialog(DOMTreeFrame.this,e);
				}
			}
		}.execute();
	}
}
