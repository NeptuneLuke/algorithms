/**
    * @author 	Luca Cortinovis	luca1cortinovis@gmail.com
    * @since	28/10/2023
    *
    * You can find me here:
    * GitHub	Luca Cortinovis (NeptuneLuke)
*/

#include <iostream>
#include <string>
#include <vector>


using
std::string,
std::vector,
std::cout,
std::cin;


bool is_interleaving(string s1, string s2, string interleaving);


int main(void) {

    string s1, s2, s3;
    cout << "Insert the first string \n";
    getline(cin, s1);

    cout << "Insert the second string \n";
    getline(cin, s2);

    cout << "Insert the interleaving string \n";
    getline(cin, s3);

    bool result = is_interleaving(s1, s2, s3);
    cout << "Is " << s3 << " interleaving? \n";
    cout << std::boolalpha << result;


    return 0;
}

bool is_interleaving(string s1, string s2, string interleaving) {

    int m = s1.size();
    int n = s2.size();
    vector< vector<bool> > interleaving_table (m + 1, vector<bool>(n + 1, false) );


    if (m + n != interleaving.size()) {
        return false;
    }

    for (int i = 0; i <= m; ++i) {

        for (int j = 0; j <= n; ++j) {

            // base case i==0 and j==0
            if (i == 0 && j == 0) {
                interleaving_table[i][j] = true;
            }
            // S1 is empty
            else if (i == 0) {
                if (s2[j-1] == interleaving[j-1])
                    interleaving_table[i][j] = interleaving_table[i][j-1];
            }
            // S2 is empty
            else if (j == 0) {
                if (s1[i-1] == interleaving[i-1])
                    interleaving_table[i][j] = interleaving_table[i-1][j];
            }
            // S1[i] == interleaving[i] and S2[i] != interleaving[i]
            else if (s1[i-1] == interleaving[i+j-1] && 
                     s2[j-1] != interleaving[i+j-1]) {
                interleaving_table[i][j] = interleaving_table[i-1][j];
            }
            // S1[i] != interleaving[i] and S2[i] == interleaving[i]
            else if (s1[i-1] != interleaving[i+j-1] &&
                s2[j-1] == interleaving[i+j-1]) {
                interleaving_table[i][j] = interleaving_table[i][j-1];
            }
            // S1[i] == S2[i] == interleaving[i]
            else if (s1[i-1] == interleaving[i+j-1] && 
                     s2[j-1] == interleaving[i+j-1]) {
                interleaving_table[i][j] = (interleaving_table[i-1][j] || interleaving_table[i][j-1]);
            }
        }
    }

    return interleaving_table[m][n];
}