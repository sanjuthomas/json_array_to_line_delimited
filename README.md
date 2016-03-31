# json_array_to_line_delimited

A simple utity to convert an array of JSON objects into line delimited jsons. While a was using MarkLogic Content Pump (MLCP) I realized that the MLCP insert an array of JSON objects as one document instead of a collection of documents. However, MLCP takes a line delimited JSON file and insert every line as separate document in MarkLogic. This utlity class will help you to convert the JSON array to line delimited JSON.

Usage : 

org.sanju.util.JsonArrayToLineDelimited "input file name argument" "output file name argument"

argument 1 - json array file
argument 2 - the file name that you would like to have for line delimited JSON file.

input file format - 
[
  {"id" : "1", "name" : "sanju"}, 
  {"id" : "2", "name" : "thomas"}
]
 
output file format - 

{"id" : "1", "name" : "sanju"}<br\>
{"id" : "2", "name" : "thomas"}
