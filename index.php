<?

	$filename = "counter.txt";

	$fp = fopen($filename, "r");
	$count = fread($fp, filesize($filename));
	fclose($fp);
	//counter.txt��� ������ ���� �о� $count�� �������ش�.

	if(!$_COOKIE["ip"]) {
		setcookie("ip", $_SERVER["REMOTE_ADDR"]);
		$count++;
	}
	//��Ű�� ����ִ� ��� ��Ű�� ���� �������ָ�, $count�� ���� 1 ���������ش�.
	
	echo("�湮�� �� : ");
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
	//$count�� ����� ���� �ѱ��ھ� ���� �ش��ϴ� �̹����� ������ش�.
	//����� ������ $count�� ���� 1 ������Ų��.

	$fp = fopen($filename, "w");
	fwrite($fp, (string)$count, strlen($count));
	fclose($fp);

	//�ٲ� $count�� ���� �ٽ� counter.txt�� �����Ѵ�.
?>