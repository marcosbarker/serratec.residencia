function getDate(){
  var today = new Date();
  var month = today.getMonth() + 1;
  var day = today.getDate();
  var year = today.getFullYear();

  var formattedDate = day + "/" + month + "/" + year;

  document.getElementById("date-container").innerHTML = formattedDate
}