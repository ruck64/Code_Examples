#include <time.h>
#include <stdlib.h>
#include <stdio.h>

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

/**********************************************
* main()
* handles command line arguments and passes
* computation to piDriver()
**********************************************/
int main(int argc, char** argv){

	clock_t start;
	int numIter = 1000000;
	//Handle command line args
	if(argc != 2){
		printf("Default: Iterations set to 1000000\n");
		printf("Format to run: ( executable   iterations )\n");
	}
	
	if(argc == 2)
	{
	//Assign args
	int numIter = atoi(argv[1]);
	}
	start = clock();
	printf("start: %f\n",(double)start);
	printf("Pi = %f\n",calcPiSerial(numIter));
	printf("end: %f\n",(double)(clock()-start));
	printf("time: %f\n",(double)clock());
	printf("time it took %f\n",(double)(clock()-start)/CLOCKS_PER_SEC);
	return 0;
}
