package KeywordDrivenFramework;

import KeywordDriven.KeywordExecutorSauceDemo;
import KeywordDriven.KeywordExecutors;

public class KeywordSauceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordExecutorSauceDemo e=new KeywordExecutorSauceDemo();
	    e.executor("OPEN_BROWSER");
	    e.executor("OPEN_URL");
	    e.executor("USERNAME");
	    e.executor("PASSWORD");
	    e.executor("LOGIN");
	    e.executor("CLOSE_BROWSER");
	}

}
