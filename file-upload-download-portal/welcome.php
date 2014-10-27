<?php
        
     /** This file is used to provide user to a desk where
       * he can perform his all work like upload,download, 
       * share and logout also.
       * 
       *
       *@file welcome.php
       * @author Amit Kumar Rai
       * @version 1.0
       */


     /*Starting the session*/
              
              session_start();
              session_register('logged_in');


              require('common_functions.php');

    
    /** Following function show the 
      * user desk.Where all links 
      * are given to him to perform
      * all works.
      */
 
 function show_welcome_page()
  { ?>
  <html>
                  <head>
                     <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
                       <title>Welcome</title>
                     <link rel="stylesheet" type="text/css" href="welcome.css"/>
                  </head>
          <body>
                  
                   <div id="header">
                         <i> <b> welcome <?php echo htmlspecialchars(get_session('logged_in')); ?> !!</b></i>
                     </div>
                  
                   <div id="next">
                      <a href="logout.php"><img src="images.jpg"/></a>  
                   </div>
                
                <div id="next_1">
	               <b>your desk:</b>
	         </div>
                  
               <div id="mid">
                 
                   <div id="mid_1">
                           <a href="download.php">  <img src="20.png"/></a>
                           <i><b> for download the files click on the icon</b></i>
                   </div>
                
                  <div id="mid_2">
                         <a href="upload.php">  <img src="11.png"/></a>
                         <i>  <b> for upload the files click on the icon</b></i>
                  </div>
               
                  <div id="mid_3">   
                          <a href="share.php">  <img src="21.jpg"/></a>
                          <i>  <b> for share the files click on the icon</b></i>
                  </div>
            
             </div>
       </body>
 </html>  

<?php
}

    /** Execution starts from here
      * in this function session 
      * value is checked for preventing
      * unauthorize access and after passing
      * test it calls "show_welcome_page()".
      */
function main()
    {
         	//Check for logged in user.
        	$username1=get_session('logged_in');
        	if($username1=="")
        	{
		//If no one is logged in then redirect to index.php page
		redirect('login.php');
         	}
         	else
         	{
		//If some user is logged in show welcome page.
		show_welcome_page();
         	}
   }
main();
?>
