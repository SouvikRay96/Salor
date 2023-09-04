function validate(frm){
	//Emptying the Error message
	document.getElementById("orgNameError").innerHTML = "";
	document.getElementById("emailidError").innerHTML = "";
	document.getElementById("useridError").innerHTML = "";
	document.getElementById("pwdError").innerHTML = "";
	
	//Getting values from the form
	let orgName = frm.orgname.value;
	let emailId = frm.emailid.value;
	let userId = frm.userid.value;
	let password = frm.pwd.value;
	let flag = true;
	
	//Validations Check Logics
	if(orgName == ""){
		document.getElementById("orgNameError").innerHTML = "Organization name is required";
		frm.orgname.focus;
		flag = false;
	}
	else if(orgName.length < 5 || orgName.length > 26){
		document.getElementById("orgNameError").innerHTML = "Organization name should have atleast 5 characters and atmost 26 characters";
		frm.orgname.focus;
		flag = false;
	}
	if(emailId == ""){
		document.getElementById("emailidError").innerHTML = "Organization / Owner Email-ID is Required";
		frm.emailid.focus;
		flag = false;
	}
	else if(emailId.length < 8 || emailid.length > 26){
		document.getElementById("emailidError").innerHTML = "Organization / Owner Email-ID should contain atleast 8 and atmost 26 characters";
		frm.emailid.focus;
		flag = false;
	}
	else if(!(emailId.includes('@'))){
		document.getElementById("emailidError").innerHTML = "Organization / Owner Email-ID should contain @";
		frm.emailid.focus;
		flag = false;
	}
	if(userId == ""){
		document.getElementById("useridError").innerHTML = "User-Id is a Required field";
		frm.userid.focus;
		flag = false;
	}
	else if(userId.includes(' ')){
		document.getElementById("useridError").innerHTML = "Please Provide a Valid User-Id";
		frm.userid.focus;
		flag = false;
	}
	else if(!(isNaN(userId))){
		document.getElementById("useridError").innerHTML = "Please Provide a Valid User-Id";
		frm.userid.focus;
		flag = false;
	}
	if(password == ""){
		document.getElementById("pwdError").innerHTML = "Account Password is Required";
		frm.pwd.focus;
		flag = false;
	}
	else if(password.length < 8 || password.length > 15){
		document.getElementById("pwdError").innerHTML = "Password must be atleast 8 characters and atmost 15 characters";
		frm.pwd.focus;
		flag = false;
	}
	return flag;
}