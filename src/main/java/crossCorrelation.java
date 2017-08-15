
public class crossCorrelation {

	public static void main(String[] args) {
		int[] set = dataGeneration.newSet(10,4,4);
		
		for (int i = 0; i < set.length; i++){
				System.out.print(set[i] + " " );
				if ( i % 10 == 9)
					System.out.println("");
		}
		
	}

}
