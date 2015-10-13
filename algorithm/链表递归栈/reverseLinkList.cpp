#include<iostream>
using namespace std;
struct ListNode{
	int val;
	ListNode *next;
	ListNode(int x):val(x),next(nullptr){
	}
};

class Sloution{
public:
	/*物理层
	数据链路层
	网络层
	传输层
	会话层
	表示层
	应用层*/

	//部分翻转链表
	ListNode* reverseBetween(ListNode *head,int m,int n){
		ListNode dummy(-1);
		dummy.next = head;

		ListNode *prev = &dummy;
		for(int i=0; i<m-1; i++){
			prev = prev->next;
		}
		ListNode* const head2 = prev;
		prev = head2->next;
		ListNode* cur = prev->next;
		for(int i=m;i<n;++i){
			prev->next = cur->next;
			cur->next = head2->next;
			head2->next = cur;
			cur = prev->next;
		}
		return dummy.next;
	}
	ListNode* partition(ListNode *head,int x){
		ListNode left_dummy(-1);
		ListNode right_dummy(-1);
		auto left_cur = &left_dummy;
		auto right_cur = &right_dummy;
		for(ListNode *cur = head;cur;cur=cur->next){
			if(cur->val < x){
				left_cur->next = cur;
				left_cur = cur;
			}else {
				right_cur->next = cur;
				right_cur = cur;
			}
		}
		left_cur->next = right_dummy.next;
		right_cur->next = nullptr;

		return left_dummy.next;
	}
	ListNode* deleteDuplitcate(ListNode *head){
		for(ListNode *prev = head,*cur = head->next;cur;cur = cur->next){
			if(prev->val == cur->val){
				prev->next = cur->next;
				delete cur;
			}else{
				prev = cur;
			}
		}
		return head;
	}
	ListNode* deleteDuplicate2(ListNode *head){
		bool flag = false;
		for(ListNode *prev = head,*cur = head->next;cur;cur = cur->next){
			if(prev->val == cur->val){
				prev->next = cur->next;
				delete cur;
				flag = true;
			}else{
				if(flag){
					
				}else{
					prev = cur;
				}

			}
		}
	}
};