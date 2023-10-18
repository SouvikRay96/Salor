function validate(frm){
	
	/*Emptying the Error Message */
	document.getElementById("pdtNameError").innerHTML = "";
	document.getElementById("cpError").innerHTML = "";
	document.getElementById("spError").innerHTML = "";
	document.getElementById("quantityManError").innerHTML = "";
	document.getElementById("quantitySoldError").innerHTML = "";
	
	/*Getting Values from the form */
	let productName = frm.pdtName.value;
	let costPrice = frm.productcp.value;
	let sellingPrice = frm.productsp.value;
	let pdtManufactured = frm.quantityManufactured.value;
	let pdtSold = frm.quantitySold.value;
	
	let flag = true;
	
	//Validation check Logics
	if(productName == ""){
		document.getElementById("pdtNameError").innerHTML = "Product Name is Required";
		frm.pdtName.focus;
		flag = false;
	}
	else if(productName.length > 26){
		document.getElementById("pdtNameError").innerHTML = "Product Name must have atmost 26 Characters";
		frm.pdtName.focus;
		flag = false;
	}
	else if(!isNaN(productName)){
		document.getElementById("pdtNameError").innerHTML = "Please enter a valid Product Name";
		frm.pdtName.focus;
		flag = false;
	}
	if(costPrice == ""){
		document.getElementById("cpError").innerHTML = "Cost Price of the Product is Required";
		frm.productcp.focus;
		flag = false;
	}
	else if(!costPrice.includes('.')){
		document.getElementById("cpError").innerHTML = "Cost Price of the Product should be Given in decimals (.00)";
		frm.productcp.focus;
		flag = false;
	}
	if(sellingPrice == ""){
		document.getElementById("spError").innerHTML = "Selling Price of the Product is Required";
		frm.productsp.focus;
		flag = false;
	}
	else if(!sellingPrice.includes('.')){
		document.getElementById("spError").innerHTML = "Selling Price of the Product should be Given in decimals (.00)";
		frm.productsp.focus;
		flag = false;
	}
	if(pdtManufactured == ""){
		document.getElementById("quantityManError").innerHTML = "Number of Products Manufactured is a Required Field";
		frm.quantityManufactured.focus;
		flag = false;
	}
	else if(isNan(pdtManufactured)){
		document.getElementById("quantityManError").innerHTML = "Please enter a valid Integer Number";
		frm.quantityManufactured.focus;
		flag = false;
	}
	if(pdtSold == ""){
		document.getElementById("quantitySoldError").innerHTML = "Number of Products Sold is Required";
		frm.quantitySold.focus;
		flag = false;
	}
	else if(isNan(pdtSold)){
		document.getElementById("quantitySoldError").innerHTML = "Please enter a valid Integer Number";
		frm.quantitySold.focus;
		flag = false;
	}
	
	return flag;
	
}