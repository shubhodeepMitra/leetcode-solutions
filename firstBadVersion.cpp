//https://leetcode.com/problems/first-bad-version/
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        unsigned long long int l=1,h=n,m;
        
        if(isBadVersion(l))
            return l;

        while(l<=h) {
            m = (l+h)/2;
            if(isBadVersion(m) && !isBadVersion(m-1))
                return m;
            else if(isBadVersion(m))
                h = m-1;
            else
                l = m+1;
        }
        return h;
    }
};