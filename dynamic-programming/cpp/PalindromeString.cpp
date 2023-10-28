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


using
std::string,
std::vector,
std::cout,
std::cin;


int palindrome_strings(string s);


int main(void) {

	string s = "anna";

	int length = palindrome_strings(s);
	cout << "The minimum numbers of characters to add to " << s << " to make it palindrome: " << length;


	return 0;
}


int palindrome_strings(string s) {

	int n = s.size();
	vector< vector<int> > length (n, vector<int>(n, 0) );

	if (n == 0) {
		return 0;
	}

	for (int len = 2; len <= n; ++len) {
		
		for (int i = 0; i <= n-len; ++i) {
			
			int j = i + len - 1;
			if (s[i] == s[j]) {
				length[i][j] = length[i + 1][j - 1];
			}
			else {
				length[i][j] = 1 + std::min(length[i+1][j] , length[i][j-1]);
			}
		}
	}

	return length[0][n-1];
}