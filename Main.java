package combinationLock;

import java.awt.Dimension;
import javax.swing.*;


public class Main {
	public static void main(String[] args) {
		// set up the JFrame.
		JFrame f = new JFrame("Combination Lock");
		JPanel p = new JPanel();
		
		LockModel lock = new LockModel(new int[]{1,2,3});
		UiModel uimodel = new UiModel();
		lock.lock();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		f.setMinimumSize(new Dimension(280,420));
		f.setMaximumSize(new Dimension(400,480));
		f.setContentPane(p);
		StateView view = new StateView(lock);
		TextView view1 = new TextView(lock, uimodel);
		ButtonView view2 = new ButtonView(lock,uimodel);
		
		p.add(view);
		p.add(view1);
		p.add(view2);
		
		f.setSize(330, 440);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
