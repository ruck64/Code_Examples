#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <pthread.h>
#include "pi.h"

/**********************************************
* calcPi()
* Calculates pi given either an iteration count
* or a decimal number to be precise to
**********************************************/
double calcPiSerial(int numIter){
	double sum = 0;
	double step = 1/(double) numIter;
	int i;
	double x;
	double start,end;
	for(i = 0; i < numIter; i++) 
	{
		x = (i+0.5)*step;
		sum += 4.0/(1.0+x*x);
	 
	}

	return sum/numIter;
}

struct piT
{
	int numIter;
	double sum;
	int thread_count;
	int max_threads;
	double x;
	double step;
};

void  *PiThreadSum(void *rank)
{
	double i;
	double sum = 0;
	double x = 0; 

	struct piT *thread = (struct piT*) rank;

	int numIter = thread->numIter;
	double thread_count = thread->thread_count; 
	double max_threads = thread->max_threads;
	int elements = (numIter/max_threads);
	int start = elements * thread_count;
 	int end = start + elements -1;
	double step = 1/(double) numIter;
	
	for(i = start;i < end;i++)
	{
		x = (i+0.5)*step;
		sum =+ 4.0/(1.0+x*x);
	}

	thread->sum = sum;


	return NULL;

}
	  

