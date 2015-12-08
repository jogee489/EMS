package views;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.*;

/*
 * This is the main window, consisting of a JFrame with an upper panel and drop menu.
 * The views are panels that are added to the frame and are instantiated here. 
 * The contoller for the views is attached to the drop menu. When the selected view is changed, 
 * the selected view should be displayed.
 */
public class Window extends JFrame {
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 600;
	// strings
	private static final String WINDOW_TITLE = "EMS";
	private static final String[] VIEW_NAMES = new String[]{"Dispatch", "Responder", "Administrator"};
	// instantiate the three views
	private static final DispatchView DISPATCH_VIEW = new DispatchView();
	private static final ResponderView RESPONDER_VIEW = new ResponderView();
	private static final AdminView ADMIN_VIEW = new AdminView();
	
	private JPanel mainPanel;
	
	/*
	 * constructor
	 */
	public Window() {
		// window
		super(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		
		// drop menu 	
		ViewMenuListener listener = (new ViewMenuListener());
		JMenu viewMenu = new JMenu("View");
		for(String viewName : VIEW_NAMES) {
			JMenuItem menuItem = new JMenuItem(viewName);
			menuItem.addActionListener(listener);
			viewMenu.add(menuItem);
		}
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(viewMenu);
		setJMenuBar(menuBar);
		
		// views
		mainPanel = new JPanel(new CardLayout());
		mainPanel.add(DISPATCH_VIEW, VIEW_NAMES[0]);
		mainPanel.add(RESPONDER_VIEW, VIEW_NAMES[1]);
		mainPanel.add(ADMIN_VIEW, VIEW_NAMES[2]);
		add(mainPanel);
		
		// show the window
		setVisible(true);
	}
	
	/*
	 * listener on the view menu
	 */
	private class ViewMenuListener implements ActionListener {
		
		@Override
		// switch views
		public void actionPerformed(ActionEvent e) {	
			JMenuItem source = (JMenuItem) e.getSource();
			String selectedView = (String) source.getText();
			
			CardLayout layout = (CardLayout) mainPanel.getLayout();
			
			layout.show(mainPanel, selectedView);	
		}	
		
	}
	
	public static void main(String[] args) {
		new Window();
	}

	/*
	 * END CLASS
	 */
}
