package combinationLock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TextView extends JPanel implements IView{
	private LockModel model;
	private UiModel uimodel;
	private JTextField pass = new JTextField(5);
	private JButton enterButton = new JButton("ENTER");
	private JLabel show = new JLabel();
	private JButton unlock = new JButton("unlock");
	private JButton clear = new JButton("CLEAR ALL");
	
	public TextView(LockModel model_,UiModel uimodel_){
		this.model = model_;
		this.uimodel = uimodel_;
		this.model.addView(this);
		this.uimodel.addView(this);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();
		p1.add(show);
		p1.add(clear);
		this.add(p1);
		unlock.setAlignmentX(0.5f);
		this.add(unlock);
		JPanel p2 = new JPanel();
		p2.add(pass);
		p2.add(enterButton);
		this.add(p2);
		p2.setBorder(BorderFactory.createTitledBorder("TypeIN"));
		this.unlock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(model.isLocked()){
					model.unlock(uimodel.getTemp());
					uimodel.emptyTemp();
				} else {
					model.lock();
				}
			}
		});
		this.clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				uimodel.clearTemp();
			}
		});
		this.pass.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					int num = Integer.parseInt(pass.getText());
					uimodel.enterNum(num);
				} catch (NumberFormatException ex){
					pass.selectAll();
				}
			}
		});
		
		this.enterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					int num = Integer.parseInt(pass.getText());
					uimodel.enterNum(num);
				} catch (NumberFormatException ex){
					pass.selectAll();
				}
			}
		});
	}
	
	public void updateView(){
		this.pass.setText("");
		if(this.model.isLocked()){
			this.pass.setEnabled(true);
			this.enterButton.setEnabled(true);
			this.unlock.setText("click here to unlock");
		} else {
			this.pass.setEnabled(false);
			this.enterButton.setEnabled(false);
			this.unlock.setText("click here to lock");
		}
		this.show.setText("You have entered " + uimodel.getCount() + " numbers.");
	}

}
