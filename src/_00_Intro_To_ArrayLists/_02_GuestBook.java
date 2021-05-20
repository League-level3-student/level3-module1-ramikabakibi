package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     * 
     * 
     */
	
	JFrame frame=new JFrame();
	 JPanel panel= new JPanel();
	 JButton addName=new JButton("Add Name");
	 JButton viewName=new JButton("View Names");
	 ArrayList <String> names=new ArrayList<String>();
	 
	 
	 public static void main(String[] args) {
		_02_GuestBook book=new _02_GuestBook();
		book.addingStuff();
		

}
	 
	 public void addingStuff() {
		 
		 frame.add(panel);
		 panel.add(addName);
		 panel.add(viewName);
		 frame.setVisible(true);
		 frame.pack();
		 addName.addActionListener(this);
		 viewName.addActionListener(this);
		 
		 
		 
		 
	 }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==addName) {
			String inputName=JOptionPane.showInputDialog("Enter A Name");
			names.add(inputName);
			
		}
		if(arg0.getSource()==viewName) {
			for(int i=0; i<names.size(); i++) {
				
				JOptionPane.showMessageDialog(null, "Guest #"+(i+1)+":"+ names.get(i));
			}
		}
	}
}
