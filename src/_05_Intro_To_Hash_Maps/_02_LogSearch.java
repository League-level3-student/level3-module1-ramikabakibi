package _05_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	
	
	HashMap<Integer, String> search=new HashMap<Integer, String>();
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton addEntry=new JButton("Add Entry");
	JButton searchID=new JButton("Search ID");
	JButton viewList=new JButton("View List");
	JButton removeEntry=new JButton("Remove Entry");
	public static void main(String[] args) {
		_02_LogSearch logSearch=new _02_LogSearch();
		logSearch.doingStuff();
	}
	void doingStuff(){
		
		frame.add(panel);
		panel.add(addEntry);
		panel.add(searchID);
		panel.add(viewList);
		panel.add(removeEntry);
		frame.setVisible(true);
		addEntry.addActionListener(this);
		searchID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		frame.pack();
	}
    /* 
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * 
     
     * Create a GUI with three buttons. 
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list. 
     */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==addEntry) {
			String input=JOptionPane.showInputDialog("Enter an ID");
			int id=Integer.parseInt(input);
			String name=JOptionPane.showInputDialog("Enter your Name");
			
			search.put(id, name);
		}
		if(e.getSource()==searchID) {
			String input=JOptionPane.showInputDialog("Enter your ID");
			int id=Integer.parseInt(input);
			if(search.keySet().contains(id)) {
				JOptionPane.showMessageDialog(null, "Your Name is: "+ search.get(id));
			}
			else {
				System.out.println("That ID does not exist");
			}
		}
		if(e.getSource()==viewList) {
			for(int i: search.keySet()) {
				System.out.println("ID: "+i+ " Name: "+search.get(i));
			}
		}
		if(e.getSource()==removeEntry) {
			String input=JOptionPane.showInputDialog("Enter an ID");
			int i=Integer.parseInt(input);
			if(search.keySet().contains(i)) {
				search.remove(i);
			}
			else {
				JOptionPane.showMessageDialog(null, "That ID does not exist.");
			}
		}
	}

}
