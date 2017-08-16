
/* Copyright 2017 Kristoffer Bernhem.
 * This file is part of crossCorrelationFitting.
 *
 *  crossCorrelationFitting is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SMLocalizer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SMLocalizer.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 *
 * @author kristoffer.bernhem@gmail.com
 */
/*
 * Particle is a object that hold all fitting information.
 */
public class dataGeneration {

	// generate gaussian dataset with center at x0,y0
	public static int[] newSet(int dataSize, double x0, double y0, double sigma){
		int[] newDataSet = new int[dataSize*dataSize];
		int pixelSize = 100;
		double gWidth = pixelSize*sigma;
		double sigmaSquare = 2*gWidth*gWidth;
		x0 *= pixelSize;
		y0 *= pixelSize;
		for (int yi = 0; yi < dataSize*pixelSize; yi++)
		{
			for (int xi = 0; xi < dataSize*pixelSize; xi++)
			{
				int value =  (int) (10 * Math.exp(-(
						(xi-x0)*(xi-x0)/sigmaSquare + 
						(yi-y0)*(yi-y0)/sigmaSquare
						)));
				
				int index = (xi / pixelSize) + (yi/pixelSize)*dataSize;
				
							
				newDataSet[index] += value;
			
			}
		}		
  
		return newDataSet;
	}
	
}