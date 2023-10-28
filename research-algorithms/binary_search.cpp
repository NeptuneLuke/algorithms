/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @since	28/10/2023
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


using
std::string,
std::vector,
std::cout,
std::cin;


bool binary_search_iter(vector<int> array, int k);
bool binary_search_rec(vector<int> array, int k, int start, int end);


int main(void) {

	int k = 0;
	vector<int> array = {5, 10, 11, 6, 23, 20, 18, 9};
	std::sort(array.begin(), array.end() );

	cout << "Insert the number to search: \n";
	cin >> k;

	bool found = binary_search_iter(array, k);
	if (found == false) {
		cout << "Number not found!";
	}
	else {
		cout << "Number found!";
	}

	return 0;
}

bool binary_search_iter(vector<int> array, int k) {
	
	int start = 0;
	int end = array.size() - 1;
	int mid = (start + end) / 2;

	while (array[mid] != k && start < end) {
		
		if (array[mid] > k) {
			end = mid - 1;
		}
		else {
			start = mid + 1;
		}

		mid = (start + end) / 2;
	}

	if (array[mid] == k) {
		return true;
	}
	else {
		return false;
	}

}

bool binary_search_rec(vector<int> array, int k, int start, int end) {

	// base case = array is empty
	if (start > end) {
		return false;
	}

	int mid = (start + end) / 2;

	// final step = found k
	if (array[mid] == k) {
		return true;
	}

	// recursive step on the two halves of the array
	if (array[mid] > k) {
		return binary_search_rec(array, k, start, mid - 1);
	}
	else {
		return binary_search_rec(array, k, mid + 1, end);
	}
}
