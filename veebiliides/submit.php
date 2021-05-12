<?php 
  
	header("Content-Type: application/json; charset = utf-8"); 
	  
	$data = json_decode(file_get_contents("php://input")); 
	
	//$json_data = json_encode($data);
	//file_put_contents('json/planData.json', $data);
	file_put_contents('../planData.json', $data);
	
	  
	echo "Hello $data"; 
  
?> 