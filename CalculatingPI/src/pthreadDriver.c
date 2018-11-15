#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include "pi.h"


struct piT
{
        int numIter;
        double sum;
        int thread_count;
        int max_threads;
};





/**********************************************
* main()
* handles command line arguments and passes
* for pThreads
**********************************************/

int main(int argc, char** argv){
	
	clock_t start;
	double total;
	int numIter = 1000000000;
	int pthread = 4;
	printf("pthreads\n");	
	//Handle command line args
	if(argc != 3)
	{
		printf("Default:Number of threads being set to 4.\n");
		printf("Default:Number of iterations set to 100000000.\n");
	
		printf("Format for running:( executable   iterations    threads)\n");
	}
	
	if(argc == 3)
	{
		//Assign args
		numIter = atoi(argv[1]);
		
		//Assign threads
		pthread = atoi(argv[2]);
		
		if(pthread > 28)
		{
			printf("Default:Number of threads being set to 4\n");
			printf("Max threads possible 28\n");
			pthread = 4;
			
		}
	}		

	//creating and handling pthreads
	pthread_t *tids = (pthread_t*) malloc(sizeof(pthread_t) * pthread);
		
	struct piT *threader = (struct piT*) malloc(sizeof(struct piT) * pthread);

	int loop = 0;

	start = clock();

	//filling in values for pthreads and creating each thread
	for(loop = 0;loop < pthread;loop++)
	{
		threader[loop].numIter = numIter;
		threader[loop].thread_count = loop;
		threader[loop].max_threads = pthread;
		pthread_create(&tids[loop],NULL,PiThreadSum,&threader[loop]);
	}

	 double answer = 0;
	
	for(loop = 0;loop < pthread; loop++)
	{
		pthread_join(tids[loop],NULL);
		answer = answer + threader[loop].sum;
	}

	answer = answer/pthread;
	
	total = (double)(clock()-start);
	printf("\nanswer is %f using %d iterations\n\n",answer,numIter);		
	printf("time it took:%f\n",total/ CLOCKS_PER_SEC);
	printf("Number of threads: %d\n",pthread);

	free(tids);
	free(threader);	

	return 0;
}

