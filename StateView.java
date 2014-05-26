package combinationLock;

import java.awt.*;
import javax.swing.*;

public class StateView extends JComponent implements IView{
	private LockModel model;
	
	public StateView(LockModel model_){
		this.model = model_;
		this.model.addView(this);
		this.setBorder(BorderFactory.createTitledBorder("STATE"));
		this.setMinimumSize(new Dimension(270,50));
		this.setPreferredSize(new Dimension(270,50));
		
	}

	// override the paintComponent method to shows the state of the lock graphically.
	public void paintComponent(Graphics g){
		int h = this.getHeight();
		int w = this.getWidth();
		super.paintComponent(g);
		if(this.model.isLocked()){
			g.setColor(Color.RED);
			g.drawString("LOCKED", w / 2 - 30, h / 2 + 9);
		} else {
			g.setColor(Color.BLUE);
			g.drawString("UNLOCKED", w / 2 - 30, h / 2 + 9);
		}
	}
	
	public void updateView(){
		if(this.model.isLocked() == true){
			this.repaint();
		}
		else if(this.model.isLocked() == false){
			this.repaint();
		}
	}
}
