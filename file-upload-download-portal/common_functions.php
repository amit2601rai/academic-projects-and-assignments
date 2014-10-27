<?php

/** This file is used to define common functions which will get
	used by many different scripts.

	@author Amit Kumar Rai
	@file   common_function.php
	@version 1.0
*/




/** This function returns value of SESSION variable whose name is
	given as argument. If variable is not set it returns empty
	string "" as variable value.
	
	@param var1	Name of variable whose value should be searched in
				SESSION array
	@returns 	Value of variable in SESSION array. It returns empty
				string if variable is not present in SESSION array.
*/


function get_session($var1)
{
	if(isset($_SESSION[$var1]))
		return $_SESSION[$var1];
	else
		return "";
}





  /** Following function is used to get post variable. If 
    * it does not exist then it returns empty string. But 
    * no warning or error is generated. @param $variable 
    * Name of the variable to be retrieved. It must be
    * passed as string.@returns Value of POST variable 
    * with given name. It returns blank if no variable 
    * with given name was submitted.
    */

 function get_post($var1)
         {
              if(isset($_POST[$var1]))
                    return $_POST[$var1];
              else
                    return "";
         }

 


/** It is used to redirect user to another page using HTTP META-REFRESH. It
  * also prints session_id() in front of new page automatically. It should
  * be noted that printing of sesssion ID is not required in any new code.
  *
  * @returns Nothing 
  */

function redirect($page)
{
	?>
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
			<title>HTTP redirect</title>
			<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
			<?php
				echo "<meta http-equiv=\"refresh\" content=\"0;url=$page?" . session_id() . "\">";
			?>
		</head>
		<body>
		</body>
		</html>
	<?php	
}


?>
