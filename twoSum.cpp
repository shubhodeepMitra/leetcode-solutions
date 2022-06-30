//https://leetcode.com/problems/two-sum/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> umap;
        unordered_map<int, int>::iterator itr;
        vector<int> res;
        for(int i=0;i<nums.size();i++){
            umap[nums[i]] = i;
        }
        
        for (int i=0;i<nums.size();i++) {
            itr = umap.find(target - nums[i]);
            if(itr == umap.end() || itr->second == i)
                continue;
            res.push_back(i);
            res.push_back(umap[target - nums[i]]);
            break;
            
        }
        return res;
    }
};