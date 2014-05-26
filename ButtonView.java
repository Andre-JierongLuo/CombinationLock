package combinationLock;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class ButtonView extends JPanel implements IView{
	private JButton[] numButtons = new JButton[] {
			new JButton("0"),
			new JButton("1"),
			new JButton("2"),
			new JButton("3"),
			new JButton("4"),
			new JButton("5"),
			new JButton("6"),
			new JButton("7"),
			new JButton("8"),
			new JButton("9")
	};
	private JButton enterButton = new JButton("ENTER");
	private JLabel draft = new JLabel("?",JLabel.CENTER);
	
	private LockModel model;
	private UiModel uimodel;
	
	public ButtonView(LockModel model_, UiModel uimodel_){
		this.model = model_;
		this.uimodel = uimodel_;
		this.model.addView(this);
		this.uimodel.addView(this);
		this.setBorder(BorderFactory.createTitledBorder("ClickIN"));
		this.setLayout(new GridLayout(4,3));
		this.add(draft);
		for(JButton x : numButtons){
			this.add(x);
		}
		this.add(enterButton);
		for(int i = 0; i < this.numButtons.length; i++){
			final int m = i;
			this.numButtons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					uimodel.setDF(m);
				}
			});
		}
		this.enterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				uimodel.enterNum(uimodel.getDF());
			}
		});
	}
	
	public void updateView(){
		this.draft.setText("" + this.uimodel.getDF());
		if(this.model.isLocked()){
			this.enterButton.setEnabled(true);
		} else {
			this.enterButton.setEnabled(false);
		}
	}
}
