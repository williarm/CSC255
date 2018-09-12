/*
 * SearchUtilities.h
 *
 *  Created on: Jan 28, 2018
 *      Author: kamilla
 */

#ifndef SORTUTILITIES_H_
#define SORTUTILITIES_H_


#include <vector>
using namespace std;

//Heap sort.
void buildHeap(vector<int> &list, int length);
void heapify(vector<int> &list, int low, int high);
void heapSort(vector<int> &list, int length );


#endif /* SORTUTILITIES_H_ */
