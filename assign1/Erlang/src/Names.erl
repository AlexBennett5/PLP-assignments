-module(names).
-export([start/0, avgNumberOfLetters/1, groupNameByFirstLetter/1, countNamesByFirstLetter/1]).

avgNumberOfLetters([]) ->
    0.0;
avgNumberOfLetters(NameList) ->
    NameLengthList = lists:map(fun(Name) -> string:length(Name) end, NameList), 
    lists:sum(NameLengthList) / length(NameList). 

groupNameByFirstLetter([]) ->
  dict:new();
groupNameByFirstLetter(NameList) ->
  lists:foldl(fun({FirstLetter, Names}, GroupedNames) -> dict:append(FirstLetter, Names, GroupedNames) end, dict:new(), [{string:sub_string(Name, 1, 1), Name} || Name <- NameList]). 

countNamesByFirstLetter([]) ->
  dict:new();
countNamesByFirstLetter(L) ->
  GroupedNames = dict:to_list(groupNameByFirstLetter(L)), 
  FirstNameList = lists:map(fun({FirstLetter, Names}) -> {FirstLetter, length(Names)} end, GroupedNames), 
  dict:from_list(FirstNameList). 

start() ->
	Names = ["Fadi", "Timothy", "Derrick", "Omar", "Hiep", "Alexander", "Daniel", "Isela", "Jackqueline", "Bryan", "Nguyen", "Maxim", "Edgar", "Ahson", "Abdulkadir", "En-Kai", "Karla", "Panpan", "You", "Andrew", "Trevor", "Hoang", "Johnson", "Janelle", "Moujie", "MD", "Albert", "Jiahui", "Alejandro", "Venkat"], 
	io:fwrite("Average Number of letters for given list~n"), 
	AvgNum = avgNumberOfLetters(Names), 
	io:fwrite("~w~n", [AvgNum]), 
	io:fwrite("Group Names by First letter for given list~n"), 
	GroupName = dict:to_list(groupNameByFirstLetter(Names)), 
	io:fwrite("~p~n", [GroupName]), 
	io:fwrite("Count Names by First letter for given list~n"), 
	CountName = dict:to_list(countNamesByFirstLetter(Names)), 
	io:fwrite("~p~n", [CountName]). 
