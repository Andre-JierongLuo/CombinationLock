package combinationLock;

import java.util.ArrayList;
import java.util.Arrays;

interface IView {
	public void updateView();
}

public class LockModel {
	public static final int MAX_COM = 50;
	private int state;
	private int[] password;
	private ArrayList<IView> views = new ArrayList<IView>();
	
	public LockModel(int[] init){
		this.password = new int[MAX_COM];
		System.arraycopy(init, 0, password, 0, init.length);
		this.state = 0;
	}
	
	public void addView(IView view){
		views.add(view);
		view.updateView();
	}
	
	public void removeView(IView view){
		views.remove(view);
	}
	
	public void updateAllViews(){
		for(IView v : views){
			v.updateView();
		}
	}
	
	public boolean isLocked(){
		if(this.state == 0) return false;
		else return true;
	}
	
	public void lock(){
		if(!isLocked()){
			this.state = 1;
			updateAllViews();
		}
	}
	
	public void unlock(int[] combo){
		if(combo.length > MAX_COM ) throw new IllegalArgumentException();
		
		int[] temp_ = new int[MAX_COM];
		System.arraycopy(combo, 0, temp_, 0, combo.length);
		
		if(Arrays.equals(this.password, temp_)){
			this.state = 0;
			updateAllViews();
		}
	}
}
