#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <omp.h>
#include "pi.h"

/**********************************************
* calcPi()
* Calculates pi given either an iteration count
* or a decimal number to be precise to
**********************************************/
double calcPi(int numIter,int threads){
	double sum = 0;
	double step = 1/(double) numIter;
	int i;
	double x;
	double start,end;
	
	omp_set_dynamic(0);
	
	omp_set_num_threads(threads);
	
	#pragma omp parallel private(x)
	{
	 #pragma omp for reduction(+:sum)
	 for(i = 0; i < numIter; i++) 
	 {
		x = (i+0.5)*step;
		sum += 4.0/(1.0+x*x);
	 }
	}

	//sum = numIter*sum;

	return sum/numIter;
}

