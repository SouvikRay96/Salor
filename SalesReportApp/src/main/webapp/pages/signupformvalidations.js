function validate(frm){
	/*Emptying the Error messages */
	document.getElementById("orgnameError").innerHTML = "";
	document.getElementById("emailError").innerHTML = "";
	document.getElementById("addressError").innerHTML = "";
	document.getElementById("noshopsError").innerHTML = "";
	document.getElementById("orgsizeError").innerHTML = "";
	document.getElementById("ownernameError").innerHTML = "";
	document.getElementById("passwordError").innerHTML = "";
	document.getElementById("cnfpasswordError").innerHTML = "";
	
	// Getting values of the form
	let orgName = frm.orgname.value;
	let emailid = frm.email.value;
	let address = frm.address.value;
	let noshops = frm.noshops.value;
	let orgSize = frm.orgsize.value;
	let ownerName = frm.ownername.value;
	let pwd = frm.password.value;
	let cnfpwd = frm.cnfpassword.value;
	
	let flag = true;
	
	// Validations Check Logics
	if(orgName == ""){
		document.getElementById("orgnameError").innerHTML = "Organization name is required";
		frm.orgname.focus;
		flag = false;
	}
	else if(orgName.length < 5 || orgName.length > 26){
		document.getElementById("orgnameError").innerHTML = "Organization name should have atleast 5 characters and atmost 26 characters";
		frm.orgname.focus;
		flag = false;
	}
	if(emailid == ""){
		document.getElementById("emailError").innerHTML = "Organization / Owner Email-ID is Required";
		frm.email.focus;
		flag = false;
	}
	else if(emailid.length < 8 || emailid.length > 26){
		document.getElementById("emailError").innerHTML = "Organization / Owner Email-ID should contain atleast 8 and atmost 26 characters";
		frm.email.focus;
		flag = false;
	}
	else if(!(emailid.includes('@'))){
		document.getElementById("emailError").innerHTML = "Organization / Owner Email-ID should contain @";
		frm.email.focus;
		flag = false;
	}
	if(address == ""){
		document.getElementById("addressError").innerHTML = "Organization Address is Required";
		frm.address.focus;
		flag = false;
	}
	else if(address.length < 10 || address.length > 100){
		document.getElementById("addressError").innerHTML = "Organization Address should contain atleast 10 characters and atmost 100 characters";
		frm.address.focus;
		flag = false;
	}
	if(noshops == ""){
		document.getElementById("noshopsError").innerHTML = "The Organization must have some number of shops";
		frm.noshops.focus;
		flag = false;
	}
	else if(isNaN(noshops)){
		document.getElementById("noshopsError").innerHTML = "Please enter a valid number of shops";
		frm.noshops.focus;
		flag = false;
	}
	else if(noshops < 1){
		document.getElementById("noshopsError").innerHTML = "An Organization must have atleast one shop";
		frm.noshops.focus;
		flag = false;
	}
	if(orgSize == ""){
		document.getElementById("orgsizeError").innerHTML = "Organization Size is Required";
		frm.orgsize.focus;
		flag = false;
	}
	if(ownerName == ""){
		document.getElementById("ownernameError").innerHTML = "Owner Name of the Organization is Required";
		frm.ownername.focus;
		flag = false;
	}
	else if(ownerName.includes('@') || ownerName.includes('$') || ownerName.includes('&')
	|| ownerName.includes('#') || ownerName.includes('%') || ownerName.includes('!') || 
	ownerName.includes('^') || ownerName.includes('*') || ownerName.includes('(') ||
	ownerName.includes(')')){
		document.getElementById("ownernameError").innerHTML = "Please enter a valid Owner name of the Organization";
		frm.ownername.focus;
		flag = false;
	}
	else if(!isNaN(ownerName)){
		document.getElementById("ownernameError").innerHTML = "Owner Name should not contain any digit";
		frm.ownername.focus;
		flag = false;
	}
	if(pwd == ""){
		document.getElementById("passwordError").innerHTML = "Password is Required";
		frm.password.focus;
		flag = false;
	}
	else if(pwd.length < 8 || pwd.length > 15){
		document.getElementById("passwordError").innerHTML = "Password must be atleast 8 characters and atmost 15 characters";
		frm.password.focus;
		flag = false;
	}
	else if(!(pwd.includes('@'))){
		document.getElementById("passwordError").innerHTML = "Password must contain @ symbol";
		frm.password.focus;
		flag = false;
	}
	if(cnfpwd == ""){
		document.getElementById("cnfpasswordError").innerHTML = "Confirm Password is Required";
		frm.cnfpassword.focus;
		flag = false;
	}
	else if(pwd != cnfpwd){
		document.getElementById("cnfpasswordError").innerHTML = "Confirm Password didn't Matched";
		frm.cnfpassword.focus;
		flag = false;
	}
	return flag;
	
	
	
	
	
	
	
	
	
	
	
	
}