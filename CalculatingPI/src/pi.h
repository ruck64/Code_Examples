#ifndef __PI_TEST_H
#define __PI_TEST_H

#include <stdio.h>
#include <stdlib.h>

double calcPi(int numIter,int threads);
void *piPthreads(void *info);
void *PiThreadSum(void *rank);

#endif

