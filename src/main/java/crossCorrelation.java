
public class crossCorrelation {

	public static void main(String[] args) {
		int width 		= 5;
		double x 		= 2.5;
		double y 		= 2.5;
		double sigma 	= 0.6;
		int[] set 		= dataGeneration.newSet(width, x, y, sigma); 
		int[] set2 		= dataGeneration.newSet(width, x, y, sigma); 
		double varianceSet1 = 0;
;
		double meanSet1 = 0;
		double meanSet2 = 0;
		for (int i = 0; i < set.length; i++){
				System.out.print(set[i] + " " );
				if ( i % 5 == 4)
					System.out.println("");
				meanSet1 += set[i];
				meanSet2 += set2[i];
		}
		meanSet1 /= set.length;
		meanSet2 /= set2.length;
		for (int i = 0; i < set.length; i++){
			varianceSet1 += (set[i]-meanSet1)*(set[i]-meanSet1);
		}
		
		System.out.println(crossCorr(set, set2, 0,0,meanSet1,meanSet2,varianceSet1));
	}
	public static double crossCorr(int[] dataSet, int[] referenceSet, double a, double b, double meanDataSet, double meanReferenceSet, double varianceReference) // calculate correlation between two datasets, second one shifted by a,b.
	{
		double R = 0;
		// translate x-y shift to linear shift.
		int shift = 0;
		double varianceData = 0;
		for (int i = 0; i < dataSet.length; i++)
		{
			double dataIntensity = dataSet[i+shift]; // change this to allow for partial shifts, taking fractions from each covered pixel based on area.
			R += (dataIntensity - meanDataSet)*(referenceSet[i] - meanReferenceSet);
			varianceData += (dataIntensity-meanDataSet)*(dataIntensity-meanDataSet);
		}
		R /= Math.sqrt(varianceData*varianceReference);
		return R;
	}

}
