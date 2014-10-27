<?php


          /** This file is used to show share failure.
            *
            * @file sharefail.php
            * @author Amit Kumar Rai
            * @version 1.0
            */

             /*starting session*/

                  session_start();
                  session_register('logged_in');
                  require('common_functions.php');


          /** show file share failure
            */


function sharefail()
{?>

<html>
<head>
<link rel="stylesheet" type="text/css" href="success.css" />
</head>
<body>
<div id="container">
<span class="star1">Please select the user and file both</span>
<br/><br/> <a href="share.php"> &lt--  back to share</a>
<br/><br/> <a href="welcome.php">&lt-- back to desk</a>
</div>
</body>
</html>
<?php
}

  /**  Execution start from here its check
     *  session and control the execuion of
     *  other function.
     */

function main()
  {
     $username1=get_session('logged_in');

         if($username1=="")
               {
                 redirect('login.php');
               }
        else {
                 sharefail();
             }
}
main();
?>




