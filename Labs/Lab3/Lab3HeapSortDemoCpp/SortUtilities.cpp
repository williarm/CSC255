/*
 * SortUtilities.cpp
 *
 *  Created on: Jan 28, 2018
 *      Author: kamilla
 */

#include <vector>
using namespace std;

void heapify(vector<int> &list, int low, int high)
{
	int largeIndex;
	int temp = list[low];

	largeIndex = 2 * low + 1;

	while(largeIndex <= high)
	{
		if(largeIndex < high)
			if(list[largeIndex] < list[largeIndex + 1])
				largeIndex = largeIndex+1;

		if(temp > list[largeIndex])
			break;
		else
		{
			list[low] = list[largeIndex];

			low = largeIndex;
			largeIndex = 2 * low + 1;
		}
	}

	list[low] = temp;
}

void buildHeap(vector<int> &list, int length)
{
	for(int i = length/2 - 1; i >= 0; i--)
	{
		heapify(list, i, length - 1);
	}
}


void heapSort(vector<int> &list, int length )
{
	int temp;
	buildHeap(list, length);

	for(int i = length - 1; i >= 0; i --)
	{
		temp 	= list[i];
		list[i]	= list[0];
		list[0]	= temp;
		heapify(list, 0, i - 1);
	}
}
