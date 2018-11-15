#include "pi.h"
#include <time.h>

/**********************************************
* main()
* handles command line arguments and passes
* computation to piDriver()
**********************************************/
int main(int argc, char** argv){
	int numIter = 100000000;
	clock_t start;
	double total;
	int threads = 1;
	printf("MP\n");
	
	//Handle command line args
	if(argc != 3){
		printf("Default: Iterations being set to 100000000\n");
		printf("To run: ( executable  iterations threads)\n");
		printf("threads: %d\n",threads);
	}
	
	if(argc == 3)
		numIter = atoi(argv[1]);
		threads = atoi(argv[2]);

	start = clock();
	printf("final pi is: %f\n", calcPi(numIter,threads));
	total = (double)(clock()-start);
	printf("time it took:%f\n",total/ CLOCKS_PER_SEC);
	printf("number of threads: %d\n",threads);
	return 0;
}
