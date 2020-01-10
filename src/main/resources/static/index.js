$(document).ready(function(){
$.getJSON('/projects/employees',function(data){
console.log(data);
})
})