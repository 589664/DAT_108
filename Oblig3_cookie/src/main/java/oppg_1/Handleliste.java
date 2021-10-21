package oppg_1;

import java.util.ArrayList;
import java.util.List;

public class Handleliste {
	
private List<Ting> tinga = new ArrayList<>();

	public void addTing(Ting ting) {
	    tinga.add(ting);
	}
	
	public void removeTing(Ting ting) {
		tinga.remove(ting);
	}
	
	public List<Ting> getTinga() {
	    return tinga;
}
    
}
