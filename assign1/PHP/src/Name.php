<?php

function imperativeAverageNumberOfLetters(array $names) {
  if (count($names) == 0) {
    return 0.0;
  }

  $sum = 0;
	
  foreach ($names as $name) {
    $sum = $sum + strlen($name);
  }
	
  return $sum / count($names);	    
}

function imperativeGroupNamesByFirstLetter(array $names) {
  $groupedNames = [];

  foreach($names as $name) {
    $firstLetter = substr($name, 0, 1);

    if (array_key_exists($firstLetter, $groupedNames)) {
      array_push($groupedNames[$firstLetter], $name);
    } else {
      $groupedNames[$firstLetter] = array($name);
    }
  }
  return $groupedNames;
}

function imperativeCountNamesByFirstLetter(array $names) {
  $countedNames = [];

  foreach($names as $name) {
    $firstLetter = substr($name, 0, 1);

    if (array_key_exists($firstLetter, $countedNames)) {
      $countedNames[$firstLetter]++;
    } else {
      $countedNames[$firstLetter] = 1;
    }
  }
  return $countedNames;
}

function functionalAverageNumberOfLetters(array $names){
  if (empty($names)){
    return 0.0;
  }

  return array_sum(array_map(function($name) { return strlen($name); }, $names)) / count($names);
    
}

function functionalGroupNamesByFirstLetter(array $names){
  if (empty($names)){
    return [];
  }
    
  return array_map(function($nameList) {
    return (array) $nameList;
    }, array_merge_recursive(...array_map(function($name) {
      return array(substr($name, 0, 1) => $name);
    }, $names)));
}

function functionalCountNamesByFirstLetter(array $names){
  if (empty($names)){
    return [];
  }
  
  return array_count_values(array_map(function($name) { return(substr($name, 0, 1)); }, $names));
}


function givenList() {
  $names = ["Fadi", "Timothy", "Derrick", "Omar", "Hiep", "Alexander", "Daniel", "Isela", 
    "Jackqueline", "Bryan", "Nguyen", "Maxim", "Edgar", "Ahson", "Abdulkadir", "En-Kai", "Karla", 
    "Panpan", "You", "Andrew", "Trevor", "Hoang", "Johnson", "Janelle", "Moujie", "MD", "Albert", 
    "Jiahui", "Alejandro", "Venkat"];

  echo "GIVEN LIST\n";
  echo "IMPERATIVE IMPLEMENTATION\n";	
  echo "Average Number of Letters: \n";
  echo imperativeAverageNumberOfLetters($names) . "\n";
  echo "Group Names By First Letter: \n";
  print_r(imperativeGroupNamesByFirstLetter($names));
  echo "\nCount Names By First Letter: \n";
  print_r(imperativeCountNamesByFirstLetter($names));
  echo "\n";
  
  echo "FUNCTIONAL IMPLEMENTATION\n";
  echo "Average Number of Letters: \n"; 
  echo functionalAverageNumberOfLetters($names) . "\n";
  echo "Group Names By First Letter: \n";
  print_r(functionalGroupNamesByFirstLetter($names));
  echo "\nCount Names By First Letter: \n";
  print_r(functionalCountNamesByFirstLetter($names));
  echo "\n";
}

?>
