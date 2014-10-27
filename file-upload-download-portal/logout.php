<?php
/** This page logs out any user who is logged in and then redirects
	to login page, that is index.php
	
	@author Amit Kumar Rai
	@file logout.php
       	@version 1.0
*/
//When using sessions we must start session as early in program
//as possible, preferably first line.

session_start();

/** This is used to store username of user who logged in to keep
	track of logged in user */

session_register('logged_in');

//including file which has common functions like redirect
//and get_session which will be reused in many scripts

require('common_functions.php');

//Remove current user login

$_SESSION['logged_in']="";

//Redirec to index page

redirect('login.php');
?>
