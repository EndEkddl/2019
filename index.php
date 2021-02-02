<?

	$filename = "counter.txt";

	$fp = fopen($filename, "r");
	$count = fread($fp, filesize($filename));
	fclose($fp);
	//counter.txt라는 파일의 수를 읽어 $count에 저장해준다.

	if(!$_COOKIE["ip"]) {
		setcookie("ip", $_SERVER["REMOTE_ADDR"]);
		$count++;
	}
	//쿠키가 비어있는 경우 쿠키를 새로 설정해주며, $count의 값을 1 증가시켜준다.
	
	echo("방문자 수 : ");
	$string = (string) $count;
	for($i = 0; $i < strlen($string); $i++) {
		
		$ch = substr($string, $i, 1);
		
		switch($ch){
			case 0 : echo("<IMG SRC='0.gif'>"); break;
			case 1 : echo("<IMG SRC='1.gif'>"); break;
			case 2 : echo("<IMG SRC='2.gif'>"); break;
			case 3 : echo("<IMG SRC='3.gif'>"); break;
			case 4 : echo("<IMG SRC='4.gif'>"); break;
			case 5 : echo("<IMG SRC='5.gif'>"); break;
			case 6 : echo("<IMG SRC='6.gif'>"); break;
			case 7 : echo("<IMG SRC='7.gif'>"); break;
			case 8 : echo("<IMG SRC='8.gif'>"); break;
			case 9 : echo("<IMG SRC='9.gif'>"); break;
			$count++;
		}
	
	}
	//$count에 저장된 수를 한글자씩 끊어 해당하는 이미지를 출력해준다.
	//출력이 끝나면 $count의 값을 1 증가시킨다.

	$fp = fopen($filename, "w");
	fwrite($fp, (string)$count, strlen($count));
	fclose($fp);

	//바뀐 $count의 값을 다시 counter.txt에 저장한다.
?>