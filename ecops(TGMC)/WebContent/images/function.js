function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}


function settab(){
		frmEmail.Name.focus();
}

function chksubmit(){

	if(frmEmail.Name.value == "")
	{
		alert('Please enter your name');
		frmEmail.Name.focus();
		return false;
	}
   		if(frmEmail.Email.value == "")
	{
		alert('Please enter your email address ');
		frmEmail.Email.focus();
		return false;
	}
     else  if(frmEmail.Email.value.length <7)
	  {
		alert('Email Address incorrect');
		frmEmail.Email.focus();
		return false;
	  }

	else if(frmEmail.Email.value)
	{
		var i,at = 0, dot = 0, ext = 0, str, chr1;
		for(i = 0; i < frmEmail.Email.value.length; i++)
		{
			str = frmEmail.Email.value.charAt(i);
			if(str == '@') at = 1;
			else if(str == '.') dot = 1;
			else if( str == '~' || str == '`' || str == '!' ||
				str == '#' ||	str == '$' || str == '%' ||
				str == '^' || str == '&' || str == '*' ||
				str == '(' || str == ')' || 
				str == '+' || str == '=' || str == '}' ||
				str == '{' || str == '[' || str == ']' ||
				str == '|' || str == '/' || str == ':' ||
				str == ';' || str == '"' || str == '<' ||
				str == ',' || str == '?' || str == '>' ||
				str == ' ' || str == '\'' || str == '\\' )
				ext = 1;
		}
		if(at == 0)
		{
			alert('Invalid e-mail address: "@" missing');
			frmEmail.Email.select();
			frmEmail.Email.focus();
			return false;
		}
		if(dot == 0)
		{
			alert('Invalid e-mail address: "." missing');
			frmEmail.Email.select();
			frmEmail.Email.focus();
			return false;
		}
		if(ext == 1)
		{
			alert('E-mail address contains invalid characters, please check');
			frmEmail.Email.select();
			frmEmail.Email.focus();
			return false;
		}

		chr1 = frmEmail.Email.value.charAt(0);
		if(chr1 == '@' || chr1 == '.')
		{
			alert('(@.) Enter a valid e-mail address');
			frmEmail.Email.select();
			frmEmail.Email.focus();
			return false;
		}

		at  = frmEmail.Email.value.indexOf('@');
		dot = frmEmail.Email.value.indexOf('.');

		if((parseInt(at) - parseInt(dot) == 1) || (parseInt(dot) - parseInt(at) == 1))
		{
			alert('(at-dot) Enter a valid e-mail address');
			frmEmail.Email.select();
			frmEmail.Email.focus();
			return false;
		}
	}

  	if(frmEmail.comments.value == "")
	{
		alert('Please enter your comments');
		frmEmail.comments.focus();
		return false;
	}
	
	
	if(frmEmail.tphone.value.length != 5){
        alert("Enter the number");
         frmEmail.tphone.focus();
        return false;
	}

}


function chksub(){

///// check on radio button ////////

myOption = -1;
for (i=form1.newsletter.length-1; i > -1; i--) {
if (form1.newsletter[i].checked) {
myOption = i;
}
}
if (myOption == -1) {
alert("You must select atleast one option of newsletter");
return false;
}

//alert("You selected button number " + myOption + " which has a value of " + form1.newsletter[myOption].value);


if(form1.email.value == "")
	{
		alert('Please enter your email address ');
		form1.email.focus();
		return false;
	}
     else  if(form1.email.value.length <7)
	  {
		alert('Email Address incorrect');
		form1.email.focus();
		return false;
	  }

	else if(form1.email.value)
	{
		var i,at = 0, dot = 0, ext = 0, str, chr1;
		for(i = 0; i < form1.email.value.length; i++)
		{
			str = form1.email.value.charAt(i);
			if(str == '@') at = 1;
			else if(str == '.') dot = 1;
			else if( str == '~' || str == '`' || str == '!' ||
				str == '#' ||	str == '$' || str == '%' ||
				str == '^' || str == '&' || str == '*' ||
				str == '(' || str == ')' || 
				str == '+' || str == '=' || str == '}' ||
				str == '{' || str == '[' || str == ']' ||
				str == '|' || str == '/' || str == ':' ||
				str == ';' || str == '"' || str == '<' ||
				str == ',' || str == '?' || str == '>' ||
				str == ' ' || str == '\'' || str == '\\' )
				ext = 1;
		}
		if(at == 0)
		{
			alert('Invalid e-mail address: "@" missing');
			form1.email.select();
			form1.email.focus();
			return false;
		}
		if(dot == 0)
		{
			alert('Invalid e-mail address: "." missing');
			form1.email.select();
			form1.email.focus();
			return false;
		}
		if(ext == 1)
		{
			alert('E-mail address contains invalid characters, please check');
			form1.email.select();
			form1.email.focus();
			return false;
		}

		chr1 = form1.email.value.charAt(0);
		if(chr1 == '@' || chr1 == '.')
		{
			alert('(@.) Enter a valid e-mail address');
			form1.email.select();
			form1.email.focus();
			return false;
		}

		at  = form1.email.value.indexOf('@');
		dot = form1.email.value.indexOf('.');

		if((parseInt(at) - parseInt(dot) == 1) || (parseInt(dot) - parseInt(at) == 1))
		{
			alert('(at-dot) Enter a valid e-mail address');
			form1.email.select();
			form1.email.focus();
			return false;
		}
	}


}

