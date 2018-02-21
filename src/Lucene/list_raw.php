<?
//session_start();
$textfield = $_POST['textfield'];
//$textfield = "'".$textfield."'";

$exc_string = "java -Xmx4G -cp \".:lucene-core-5.1.0.jar:lucene-analyzers-common-5.1.0.jar:lucene-queryparser-5.1.0.jar:lucene-backward-codecs-5.1.0.jar:mysql-connector-java-5.1.22-bin.jar:org.json.jar\" Lucene_BooleanQuery_Parser ".$textfield."";
echo $exc_string;
$output = shell_exec($exc_string);
//echo $output."</p>";

$_SESSION['Search'] = $output;
//header("Location: ../list.php");

//$all = split("\n", $output);
//echo count($output)."</p>";
//echo count($all)."</p>";
echo strlen($output);
echo $output;

//for($i=0;$i<count($all);$i++)
{
  //$individual = split("{L}", $all[$i]);
  //echo $individual[0]."\t".$individual[1]."\t"."</p>";
  //echo $all[$i]."</p>";
}

//echo strlen($output);
	


?>
