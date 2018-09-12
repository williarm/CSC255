/*
 * VectorUtilities.cpp
 *
 *  Created on: Jan 28, 2018
 *
 */

#include <iostream>
#include <cassert>

#include "VectorUtilities.h"

using namespace std;

void fillVector(istream& io, std::vector<int> &a)
{
	a.clear();
	int temp;

	while (io>>temp)
	{
	   a.push_back(temp);
	}
}

void outputVector(
	std::ostream& 		os,
	std::vector<int>    &a,
	const std::string& 	info
)
{
	os<<info<<"\n";
	for (unsigned int i=0;i<a.size();++i)
	{
		os<<a[i]<<" ";
	}
	os<<"\n";
}
