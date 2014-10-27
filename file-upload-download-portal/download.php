<?php
                
          /** This file is used to provide user to download and
            * remove file option as well download other file on
            * which he got permission.
            *
            * @file download.php
            * @author Amit Kumar Rai
            * @version 1.0
            */
    


          
          /*starting session*/      
                  
                  session_start();
                  session_register('logged_in');
                  require('common_functions.php');

   
   /** Following function redirect to three different php 
     * according to its option(download,remove and other's download)
     */

function download()
   {?>
      <html>
                    <head>
                            <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
                            <title>Downloads</title>
                            <link rel="stylesheet" type="text/css" href="download.css" />
                   </head>
           <?php
               
                  $con = mysql_connect("localhost","test_user","12345");
                  $username=get_session('logged_in');
                  $query1 = "SELECT id, name FROM test_database.upload where username='$username'";
                  $query2 = "SELECT filename,owner FROM test_database.share where user='$username'";
         ?>
           <body>
                      <div id="header_1">
                      <span class="x">My Uploads</span>
                      </div>
          <table  class="table_1" cellpadding="5" cellspacing="5">
           <?php
                  $result=mysql_query($query1);
                  while($row=mysql_fetch_array($result)) { ?>         
                     <tr>
                      <td width="650px"><?php echo "{$row['name']}";?></td>
                      <td width="100px"><a href="download_1.php?id=<?php echo "{$row['id']}"; ?>">Download</a></td>
                      <td><a href="remove.php?name=<?php echo "{$row['name']}"; ?>">remove</a></td>
                      </tr> <?php } ?> 
          </table>
 
                     </div>
                      <div id="header_2">Other's upload
                      </div> 
        
         <table  class="table_2" cellpadding="5" cellspacing="5">
                      <tr>
                      <td width="650px">file</td>
                      <td width="100px">Owner</td>
                      <td>download</td>
                      </tr> 
          </table>
       
          <table  class="table_1" cellpadding="5" cellspacing="5">
                     <?php
                           $result=mysql_query($query2);
                        while($row=mysql_fetch_array($result)) { ?>
                      <tr>
                      <td width="650px"><?php echo "{$row['filename']}";?></td>
                      <td width="100px"><?php echo "{$row['owner']}";?></td>
                      <td><a href="download_2.php?name=<?php echo "{$row['filename']}"; ?>">Download</a></td>
                      </tr> <?php } ?>

          </table>
         </div>
                      <div id="header_3"><a href="welcome.php">&lt-- back to desk</a>
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
                 download();
             }
}

main();
?>
 
