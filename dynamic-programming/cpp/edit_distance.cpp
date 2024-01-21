/**
    * @author 	Luca Cortinovis	luca1cortinovis@gmail.com
    * @since	21/01/2024
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


int edit_distance(string s1, string s2);


int main(void) {

    string s1, s2;

    cout << "Insert the first string \n";
    getline(cin, s1);

    cout << "Insert the first string \n";
    getline(cin, s2);

    int edit_dist = edit_distance(s1, s2);
    cout << "Edit distance of \n" + s1 + " and " + s2 + "\n" << edit_dist;

    return 0;
}


int edit_distance(string s1, string s2) {

    int m = s1.size();
    int n = s2.size();
    
    vector< vector<int> > edit_distance_table(m + 1, vector<int>(n + 1, 0));


    for (int i = 0; i <= m; ++i) {

        for (int j = 0; j <= n; ++j) {

            // base case i==0
            if (i == 0) {
                edit_distance_table[i][j] = j;
            }
            // base case j==0
            else if (j == 0) {
                edit_distance_table[i][j] = i;
            }
            else {
                if (s1.at(i-1) == s2.at(j-1)) {
                    edit_distance_table[i][j] = edit_distance_table[i - 1][j - 1];
                }
                else {
                    edit_distance_table[i][j] = 1 + std::min({edit_distance_table[i - 1][j],
                                                              edit_distance_table[i][j - 1],
                                                              edit_distance_table[i - 1][j - 1]});
                }
            }
        }
    }

    return edit_distance_table[m][n];
}