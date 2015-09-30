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
	ListNode *addTwoNumbers(ListNode *l1,ListNode *l2){
		ListNode dummy(-1);
		int carry = 0;
		ListNode *prev = &dummy;
		for(ListNode *pa = l1,*pb = l2;pa != nullptr || pb !=nullptr;
			pa = pa==nullptr?nullptr:pa->next,
			pb = pb==nullptr?nullptr:pb->next,
			prev = prev->next){
				const int ai = pa == nullptr?0:pa->val;
				const int bi = pb == nullptr?0:pb->val;
				const int value = (ai + bi + carry) % 10;
				carry = (ai + bi + carry)/10;
				prev->next = new ListNode(value); 
		}
		if(carry > 0){
			prev->next = new ListNode(carry);
		}
		return dummy.next;
	}
};

int main(){
	ListNode *l1 = new ListNode(3);
	l1->next = new ListNode(5);
	l1->next->next = new ListNode(7);
	ListNode *l2 = new ListNode(3);
	l2->next = new ListNode(6);
	l2->next->next = new ListNode(8);
	Sloution* s1 = new Sloution();
	ListNode *result ;	
	result = s1->addTwoNumbers(l1,l2);
	while(result != nullptr){
		cout<<result->val;
		result = result->next;
	}
	system("pause");
}