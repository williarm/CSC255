/*
 * Driver.cpp
 *  Created on: Feb 18, 2013
 *      Author: kamilla
 */


#include <iostream>
#include <fstream>
#include <cassert>
#include <string>
#include <vector>
#include "VectorUtilities.h"
#include "SortUtilities.h"

using namespace std;

int main()
{
	string fileName;
	string info;

	vector<int> a;
	cout << "Enter the input file name ";
	cin  >> fileName;
	ifstream inData;
	ofstream outData;
	inData.open(fileName.c_str());
	outData.open("out.txt");

	//Test heap sort.
	inData>>info;
	fillVector  (inData,  a);
	cout    << "Before heap sort\n";
	outData << "Before heap sort\n";
	outputVector(outData, a, info);
	outputVector(cout,    a, info);

	buildHeap(a, a.size());
	cout << "After build heap\n";
	outData << "After build heap\n";
	outputVector(outData, a, info);
	outputVector(cout,    a, info);

	heapSort(a, a.size());

	cout    << "After heap sort\n";
	outData << "After heap sort\n";
	outputVector(outData, a, info);
	outputVector(cout,    a, info);

	inData.close();
	outData.close();
}


