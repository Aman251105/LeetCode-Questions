/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *arr;
 int k;
 void fun(struct TreeNode* root)
 {
    if(root!=NULL)
    {
        arr[k++]=root->val;
        fun(root->left);
        fun(root->right);
    }
 }
int* preorderTraversal(struct TreeNode* root, int* returnSize) {
      k=0;
   arr=(int*)malloc(sizeof(int)*101);
   fun(root);
   *returnSize=k;
   return arr; 
}
