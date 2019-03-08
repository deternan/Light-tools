<?php
//header("Content-Type:text/html; charset=utf-8");
header('Content-Type: application/json; charset=utf-8');
//session_start();
$Query = $_GET['query'];

//echo "Query ".$Query;
$exc_string = "java -Dfile.encoding=UTF-8 -Xmx4G -cp \".:lucene-core-5.1.0.jar:lucene-analyzers-common-5.1.0.jar:lucene-queryparser-5.1.0.jar:lucene-backward-codecs-5.1.0.jar:org.json.jar\" Lucene_BooleanQuery_Parser ".$Query."";

$output = shell_exec($exc_string);
//$output = "'".$output."'";
echo $output;
//echo shell_exec($exc_string);
//$manage = urldecode(json_encode($output));
//echo json_decode($output);
//$manage = utf8_encode($output);
//$manage = utf8_decode($output);
//$manage = json_decode($output, true);
echo $manage;
//print $manage;

//$_SESSION['Search'] = $output;

//echo count($output)."</p>";
//echo count($all)."</p>";
//echo strlen($output);

?>
