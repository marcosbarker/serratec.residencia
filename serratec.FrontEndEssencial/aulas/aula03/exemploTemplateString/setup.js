function getDate(){
  var today = new Date();
  var month = today.getMonth() + 1;
  var day = today.getDate();
  var year = today.getFullYear();

  formattedDate = `${day}/${month}/${year}`; //template literal - template String

  document.getElementById("date-container").innerHTML = formattedDate
}