<?php
	$json = $_POST['json'];
	
	if(json_decode($json) != null){
		$file = fopen('planData.json', 'w+');
		fwrite($file, $json);
		fclose($file);
	}


?>