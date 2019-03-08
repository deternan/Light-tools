<!--
Author: Chao-Hsuan Ke
E-mail: chke [at] iir dot csie dot ncku dot edu dot tw

Last revision: May 17, 2015	11:42 AM (GMT+8)                           
-->

<?
session_start();
ob_start();
//require_once "./autocomplete/config.php";
//require_once "./include/Update_data.php";

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Condensedly: a text- and visual-based web application for discovering emphasis of the biomedical literature</title>
<link rel="shortcut icon" href="./images/Preview.png">
<link rel="stylesheet" href="./CSS/index.css" type="text/css"/>
<script src="JS/jquery-1.8.3.js"></script>
<script type="text/javascript" src="./autocomplete/jquery.js"></script>
<script type='text/javascript' src="./autocomplete/jquery.autocomplete.js"></script>
<link rel="stylesheet" href="./autocomplete/jquery.autocomplete.css"/>

<script type="text/javascript">
	// IE (Check)
	var isIE7 = navigator.userAgent.search("MSIE 7") > -1;
	var isIE8 = navigator.userAgent.search("MSIE 8") > -1;

	if(isIE7 || isIE8){
		location.href= ('Sorry_IE.php');
	}

$(document).ready(function() {	
	var $All_query_textfield;
	
	// ---------------------- Advanced Search ----------------------
	$("#search_advanced_box_inner").hide();
	
	var abstract_check = false;
		
	$("#search_advanced_box").click(function(){
		if(abstract_check == false){
			// search_advanced_box_inner (Box)
			$("#search_advanced_box_inner").slideDown(300);
			$("#search_advanced_box_inner").css("height","80px");
			abstract_check = true;
			// Example_box_inner (Example)
			$('#Example_box_inner').hide();
		}else{
			// search_advanced_box_inner (Box)
			$("#search_advanced_box_inner").slideUp(200);
			abstract_check = false;
			// Example_box_inner (Example)
			$("#Example_box_inner").show();
		}
	});
	
	$("#search_advanced_box p").mouseover(function(){
		$("#search_advanced_box p").css("text-decoration", "underline");
	});
	
	$("#search_advanced_box p").mouseout(function(){
   	    $("#search_advanced_box p").css("text-decoration", "none");
	});
	
	// ---------------------- Auto-Complete ----------------------
	var bioterm = $('#Bio_Terms').val();
	var Query_file = "autocomplete/get_course_list_1.php";
	//Query_file = "./autocomplete/get_course_list.php";
	AC();	
	$("#Bio_Terms").change(function(){
		bioterm = $('#Bio_Terms').val();
		//alert(bioterm);
		if(bioterm == 1){
			$('#Bio_textfield').val('');
			Query_file = "autocomplete/get_course_list_1.php"
		}else if(bioterm == 2){
			$('#Bio_textfield').val('');
			Query_file = "autocomplete/get_course_list_2.php"
		}else if(bioterm == 3){
			$('#Bio_textfield').val('');
			Query_file = "autocomplete/get_course_list_3.php"
		}else if(bioterm == 4){
			$('#Bio_textfield').val('');
			Query_file = "autocomplete/get_course_list_4.php"
		}else if(bioterm == 5){
			$('#Bio_textfield').val('');
			Query_file = "autocomplete/get_course_list_5.php"
		}else if(bioterm == 6){
			$('#Bio_textfield').val('');
			Query_file = "autocomplete/get_course_list_6.php"
		}
		
		AC();
	});
	
	function AC()
	{
		$("#Bio_textfield").autocomplete(Query_file, {
			  matchContains: true,
			  selectFirst: false
		});
	}
	
	
	
	// ------------------- Progress Bar -------------------
	$('#search_button').click(function(){
		ShowProgressBar();
	});
	

	// 顯示讀取遮罩
	function ShowProgressBar() {
    	displayProgress();
    	displayMaskFrame();
	}
 
	// 隱藏讀取遮罩
	function HideProgressBar() {
    	var progress = $('#divProgress');
    	var maskFrame = $("#divMaskFrame");
    	progress.hide();
    	maskFrame.hide();
	}

	// 顯示讀取畫面
	function displayProgress() {
    	var w = $(document).width();
    	var h = $(window).height();
    	var progress = $('#divProgress');
    	progress.css({ "z-index": 999999, "top": (h / 2) - (progress.height() / 2), "left": (w / 2) - (progress.width() / 2) });
    	progress.show();
	}

	// 顯示遮罩畫面
	function displayMaskFrame() {
    	var w = $(window).width();
    	var h = $(document).height();
    	var maskFrame = $("#divMaskFrame");
    	maskFrame.css({ "z-index": 999998, "opacity": 0.7, "width": w, "height": h });
    	maskFrame.show();
	}
	
});

</script>

</head>

<body>
<div id="container">

<div id="divProgress" style="text-align:center; display: none; position: fixed; top: 50%;  left: 50%;" >
	<img src="images/Progress.gif" /> <br />
    <font color="#1B3563" size="3px">Data Processing ...</font>
</div>
<div id="divMaskFrame" style="background-color: #F2F4F7; display: none; left: 0px; position: absolute; top: 0px;">
</div>

<div id="search_field">
<div id="search_field_Left">
  <div align="right"><img src="images/Preview.png" width="100" height="100" /></div>
</div>
<div id="search_field_Right">
  <div id="search_word">
<div id="search_word_L"><h1>&nbsp;</h1>
  <h1>Search Engine</h1>
</div>
  </div>	<!-- end of search_word -->

<div id="search_box">
<form action="./lucene/list_raw.php" method="POST">
  	<input type="text" name="textfield" id="textfield"/>
  	<button name="Search" type="submit" id="search_button">Search</button>
    <button name="Clear" type="reset" id="clear_button">Clear</button>
  </form> 
</div>	<!-- end of search_box -->
</div>	<!-- end of search_Right -->
</div>	<!-- end of search_field -->


<!-- -------------------------------------------------------------------- -->

<div id="information">
<br/>
<p>
<ul>
<li>To provide ...</li>
</ul>
</p>
</div>	<!-- end #information -->
<br/><br/><br/>
<!-- -------------------------------------------------------------------- -->
<div id="footer_top">
Last Updated date: <?echo $Updated_date?><br />
For a better experience with <? echo $System_name ?>, we recommend using <a target="_blank" href="http://www.chrome.com">Chrome</a> browser</div>	
<!-- end #footer_top -->

<div id="footer">
Copyright &copy;  <a target="_blank" href="http://www.deltaww.com">Delta Electronics Inc.</a>, All rights reserved
<!-- end #footer --></div>
</div>	<!-- end of container -->
</body>
</html>
