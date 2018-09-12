/*
 * VectorUtilities.h
 *
 *  Created on: Jan 28, 2018
 */

#ifndef VECTORUTILITIES_H_
#define VECTORUTILITIES_H_

#include <string>
#include <iosfwd>
#include <vector>

void fillVector(
	std::istream& 	  io,
	std::vector<int>  &a
);

void outputVector(
	std::ostream& 		os,
	std::vector<int>    &a,
	const std::string& 	info
);


#endif /* VECTORUTILITIES_H_ */
