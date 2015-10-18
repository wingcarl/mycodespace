//Manacher算法 
//最大回文子串
function manacher(str){
	var nstr = '$';
	for(var i=0;i<str.length;i++){
		nstr += '#';
		nstr += str[i];
	}
	nstr += '#';
	var mx = 1;
	var id = 0;
	var p = new Array(nstr.length);
	p[0] = 1;
	for(var i=1;i<nstr.length;i++){
		if(mx > i)
			p[i] = Math.min(p[2*id-i],mx-i);
		else
			p[i] = 1;
		for(;nstr[i+p[i]]==nstr[i-p[i]];p[i]++);
		if(mx < i+p[i]){
			mx = i+p[i];
			id = i;
		}
	}
	var maxLength = 0;
	var maxIndex = 0;
	for(var i=0;i<nstr.length;i++){
		if(p[i] > maxLength){
			maxLength = p[i];
			maxIndex = i;
		}
	}
	var rstr = nstr.substring(maxIndex-maxLength+1,maxIndex+maxLength);
	rstr = rstr.replace(/#/g,'');
	console.log(rstr);
	
}

function manacherTest(){
	manacher('acbbcacda');
}