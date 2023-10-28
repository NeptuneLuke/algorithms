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


int lcs_length(string s1, string s2, vector< vector<int> > &lcs_table);
vector<char> lcs_build(string s1, string s2, vector <vector<int> > lcs_table);
string lcs_backtrack(string s1, string s2, int i, int j, vector< vector<int> > lcs_table);


int main(void) {

    string s1, s2;
    cout << "Insert the first string \n";
    getline(cin, s1);
    int m = s1.size();

    cout << "Insert the second string \n";
    getline(cin, s2);
    int n = s2.size();

    vector< vector<int> > lcs_table(m + 1, vector<int>(n + 1));


    // Calculate the length of the LCS
    int l = lcs_length(s1, s2, lcs_table);
    cout << "\n\n" << "Length of the LCS between " << s1 << " and " << s2 << " : " << l << "\n\n";


    // Build the actual LCS (method 1)
    vector<char> lcs = lcs_build(s1, s2, lcs_table);
    cout << "LCS length: " << lcs.size()-1 << "\n";
    cout << "The LCS between " << s1 << " and " << s2 << " : ";
    for (auto elem : lcs) {
        cout << elem << "";
    }
    cout << "\n\n";


    // Build the actual LCS (method 2)
    string s3 = lcs_backtrack(s1, s2, m, n, lcs_table);
    cout << "LCS length: " << s3.size() << "\n";
    cout << "The LCS between " << s1 << " and " << s2 << " : " << s3 << "\n\n";


    return 0;
}


int lcs_length(string s1, string s2, vector< vector<int> > &lcs_table) {

    int m = s1.size();
    int n = s2.size();

    for (int i = 0; i <= m; ++i) {

        for (int j = 0; j <= n; ++j) {

            // base case S1[i]==0 or S2[j]==0
            if (i == 0 || j == 0) {
                lcs_table[i][j] = 0;
            }

            // recursive step S1[i] == S2[j]
            else if (s1[i-1] == s2[j-1]) {
                lcs_table[i][j] = 1 + lcs_table[i-1][j-1];
            }

            // recursive step S1[i] != S2[j]
            else {
                lcs_table[i][j] = std::max(lcs_table[i-1][j], lcs_table[i][j-1]);
            }
        }
    }

    return lcs_table[m][n];
}


vector<char> lcs_build(string s1, string s2, vector <vector<int> > lcs_table) {

    int m = s1.size();
    int n = s2.size();

    int index = lcs_table[m][n];
    vector<char> lcs(index + 1);
    lcs[index] = '\0';

    int i = m, j = n;
    while (i > 0 && j > 0) {

        if (s1[i-1] == s2[j-1]) {
            lcs[index-1] = s1[i-1];
            i--;
            j--;
            index--;
        }
        else if (lcs_table[i-1][j] >= lcs_table[i][j-1])
            i--;
        else
            j--;
    }

    return lcs;
}


string lcs_backtrack(string s1, string s2, int i, int j, vector< vector<int> > length) {

    if (i == 0 || j == 0) {
        return "";
    }
    else {

        // if S1,S2 end with the same symbol go diagonal
        if (s1[i-1] == s2[j-1]) {
            return lcs_backtrack(s1, s2, i - 1, j - 1, length) += (s1[i-1]);
        }
        else {
            // if top > left then go top
            if (length[i-1][j] >= length[i][j-1])
                return lcs_backtrack(s1, s2, i - 1, j, length);

            else	// else go left 
                return lcs_backtrack(s1, s2, i, j - 1, length);
        }
    }
}
