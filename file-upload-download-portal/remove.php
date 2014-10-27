<?php
          

          /** This file is used to provide user to remove own
            *file from server.
            *
            * @file remove.php
            * @author Amit Kumar Rai
            * @version 1.0
            */


         /*starting session*/

                  session_start();
                  session_register('logged_in');
                  require('common_functions.php');


          /** In this function file entry is removed
            * from the database.
            */

function remove()
{?>

    <html>
       <head>
         <link rel="stylesheet" type="text/css" href="remove.css" />
</head>
<body>
<div id="print">
<?php
if(isset($_GET['name']))
{
$con=mysql_connect("localhost","test_user","12345");
$name    = $_GET['name'];
$original=$name;
$query = "delete from test_database.upload where name='$name'";
mysql_query($query);
$query = "delete from test_database.share where filename='$name'";
mysql_query($query);
echo "file $original successfully removed";
mysql_close($con);
}
?>
</div>
<div id="link"><a href="download.php">&lt--back to remove</a></div>
<div id="link"><a href="welcome.php">&lt--back to desk</a></div>
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
                 remove();
             }
}

main();
?>

