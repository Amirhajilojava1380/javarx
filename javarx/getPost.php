<?php 

include'connect.php';

$a = "SELECT * FROM post";
$b = $conn->prepare($a);
$b->execute();

$slider = array();
while($row = $b->fetch(PDO::FETCH_ASSOC)){

$ros = array();

$ros['id']               = $row['id'];
$ros['name']             = $row['name'];
$ros['loc']              = $row['loc'];
$ros['img_link_profile'] = $row['img_link_profile'];
$ros['img_link_post']    = $row['img_link_post'];
$ros['deckrption']       = $row['deckrption'];
$ros['coment']           = $row['coment'];
$ros['fevrit']           = $row['fevrit'];

$slider[]=$ros;

}

echo json_encode($slider);

?>