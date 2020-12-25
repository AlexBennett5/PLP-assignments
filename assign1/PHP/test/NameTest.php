<?php

include_once 'src/Name.php';

echo "Canary test\n";
assert(true);

echo "IMPERATIVE TESTS\n";
echo "Average number of letters per name, empty list\n";
assert(imperativeAverageNumberOfLetters(array()) == 0.0);
echo "Average number of letters per name, one name in list\n";
assert(imperativeAverageNumberOfLetters(array("Derrick")) == 7.0);
echo "Average number of letters per name, two names in list, same length\n";
assert(imperativeAverageNumberOfLetters(array("Omar", "Hiep")) == 4.0);
echo "Average number of letters per name, two names in list, different length\n";
assert(imperativeAverageNumberOfLetters(array("Derrick", "Al")) == 9.0/2.0);
echo "Average number of letters per name, three names in list, different length\n";
assert(imperativeAverageNumberOfLetters(array("Derrick", "Alexander", "Ira")) == 19.0/3.0);
echo "Group Names By First Letter, Empty List\n";
assert(imperativeGroupNamesByFirstLetter(array()) === []);
echo "Group Names By First Letter, One Name\n";
assert(imperativeGroupNamesByFirstLetter(array("Jim")) === array("J" => ["Jim"]));
echo "Group Names By First Letter, Two Names, Same Starting Letter\n";
assert(imperativeGroupNamesByFirstLetter(array("Jim", "Jack")) === array("J" => ["Jim", "Jack"]));
echo "Group Names By First Letter, Three Names, Different Starting Letters\n";
assert(imperativeGroupNamesByFirstLetter(array("Jim", "Jack", "Sara")) === array("J" => ["Jim", "Jack"], "S" => ["Sara"]));
echo "Count Names By First Letter, Empty List\n";
assert(imperativeCountNamesByFirstLetter(array()) === array());
echo "Count Names By First Letter, One Name\n";
assert(imperativeCountNamesByFirstLetter(array("Jim")) === array("J" => 1));
echo "Count Names By First Letter, Two Names, Same Starting Letter\n";
assert(imperativeCountNamesByFirstLetter(array("Jim", "Jack")) === array("J" => 2)); 
echo "Count Names By First Letter, Three Names, Different Starting Letter\n";
assert(imperativeCountNamesByFirstLetter(array("Jim", "Jack", "Sara")) === array("J" => 2, "S" => 1)); 

echo "FUNCTIONAL TESTS\n";
echo "Average number of letters per name, empty list\n";
assert(functionalAverageNumberOfLetters(array()) == 0.0);
echo "Average number of letters per name, one name in list\n";
assert(functionalAverageNumberOfLetters(array("Derrick")) == 7.0);
echo "Average number of letters per name, two names in list, same length\n";
assert(functionalAverageNumberOfLetters(array("Omar", "Hiep")) == 4.0);
echo "Average number of letters per name, two names in list, different length\n";
assert(functionalAverageNumberOfLetters(array("Derrick", "Al")) == 9.0/2.0);
echo "Average number of letters per name, three names in list, different length\n";
assert(functionalAverageNumberOfLetters(array("Derrick", "Alexander", "Ira")) == 19.0/3.0);
echo "Group Names By First Letter, Empty List\n";
assert(functionalGroupNamesByFirstLetter(array()) === []);
echo "Group Names By First Letter, One Name\n";
assert(functionalGroupNamesByFirstLetter(array("Jim")) === array("J" => ["Jim"]));
echo "Group Names By First Letter, Two Names, Same Starting Letter\n";
assert(functionalGroupNamesByFirstLetter(array("Jim", "Jack")) === array("J" => ["Jim", "Jack"]));
echo "Group Names By First Letter, Three Names, Different Starting Letters\n";
assert(functionalGroupNamesByFirstLetter(array("Jim", "Jack", "Sara")) === array("J" => ["Jim", "Jack"], "S" => ["Sara"]));
echo "Count Names By First Letter, Empty List\n";
assert(functionalCountNamesByFirstLetter(array()) === array());
echo "Count Names By First Letter, One Name\n";
assert(functionalCountNamesByFirstLetter(array("Jim")) === array("J" => 1));
echo "Count Names By First Letter, Two Names, Same Starting Letter\n";
assert(functionalCountNamesByFirstLetter(array("Jim", "Jack")) === array("J" => 2));
echo "Count Names By First Letter, Three Names, Different Starting Letter\n";
assert(functionalCountNamesByFirstLetter(array("Jim", "Jack", "Sara")) === array("J" => 2, "S" => 1));

echo "Testing complete\n"; 
?>
