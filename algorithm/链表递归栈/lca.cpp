struct Node{
	int value;
	Node *left;
	Node *right;
};

Node* getLCA(Node* root,Node* node1,Node* node2){
	if(root == nullptr){
		return nullptr;
	}else if(root == node1 || root == node2){
		return root;
	}
	Node* left = getLCA(root->left,node1,node2);
	Node* right = getLCA(root->right,node1,node2);
	if(left != nullptr && right != nullptr)
		return root;
	else if(left != nullptr)
		return left;
	else if(right != nullptr)
		return right;
	else 
		return nullptr;
}