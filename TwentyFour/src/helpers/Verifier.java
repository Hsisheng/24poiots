package helpers;

import java.util.List;

public interface Verifier {

	public boolean isValid(Problem p);
	
	public List<String> getAnswers(int nums[]);
}
