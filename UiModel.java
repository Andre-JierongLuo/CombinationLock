package combinationLock;

import java.util.ArrayList;

public class UiModel {
	public static final int MAX_COM = 50;
	private ArrayList<IView> views = new ArrayList<IView>();
	
	private int[] temp;
	private int tempLength;
	
	private int df;
	
	public UiModel(){
		this.temp = new int[MAX_COM];
		this.tempLength = 0;
		this.df = 0;
	}
	
	public void addView(IView view){
		views.add(view);
	}
	
	public void removeView(IView view){
		views.remove(view);
	}
	
	public void updateAllViews(){
		for(IView v : views){
			v.updateView();
		}
	}
	
	public int[] getTemp(){
		return this.temp;
	}
	
	
	public int getCount(){
		return this.tempLength;
	}
	
	public int getDF(){
		return this.df;
	}
	
	public void setDF(int x){
		if(df * 10 <= 99){
			df = df * 10 + x;
		} else {
			int m = df % 10;
			df = m * 10 + x;
		}
		updateAllViews();
	}
	
	// 
	public void enterNum(int x){
		if(this.tempLength < MAX_COM){
			if(isLegalNum(x)){
				this.temp[this.tempLength] = x;
				this.tempLength++;
				this.df = 0;
				updateAllViews();
			}
		}
	}
	
	public void clearTemp(){
		this.temp = new int[MAX_COM];
		this.tempLength = 0;
		this.df = 0;
		updateAllViews();
	}
	
	// the number should be between 1 and 99.
	public boolean isLegalNum(int x){
		return x >= 1 && x <= 99;
	}
	
	public void emptyTemp(){
		this.temp = new int[MAX_COM];
		this.tempLength = 0;
	}
}
